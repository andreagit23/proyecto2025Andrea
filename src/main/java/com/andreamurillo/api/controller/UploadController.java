package com.andreamurillo.api.controller;

import jakarta.annotation.PostConstruct;
import jakarta.servlet.http.HttpServletRequest;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.io.FileSystemResource;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import com.andreamurillo.api.dto.UploadResponse;

import java.io.File;
import java.io.IOException;
import java.nio.file.*;

@RestController
@RequestMapping("/api/uploads")
public class UploadController {

    private static final Logger log = LoggerFactory.getLogger(UploadController.class);

    /** Carpeta uploads/ en el working-dir (donde lances el JAR) */
    private final Path uploadPath = Paths
            .get(System.getProperty("user.dir"), "uploads")
            .toAbsolutePath()
            .normalize();

    @PostConstruct
    public void init() {
        try {
            Files.createDirectories(uploadPath);
            log.info("Carpeta de uploads inicializada en: {}", uploadPath);
        } catch (IOException e) {
            log.error("No se pudo crear la carpeta de uploads en {}: {}", uploadPath, e.getMessage(), e);
            // opcional: lanzar RuntimeException para que la app no siga si uploads falla
            throw new RuntimeException("No se pudo inicializar carpeta de uploads", e);
        }
    }

    @PostMapping(
        value = "/imagen",
        consumes = MediaType.MULTIPART_FORM_DATA_VALUE,
        produces = MediaType.APPLICATION_JSON_VALUE
    )
    public ResponseEntity<?> subirImagen(@RequestParam("file") MultipartFile file) {
        if (file.isEmpty()) {
            return ResponseEntity
                    .badRequest()
                    .body("El archivo está vacío");
        }

        // Limpia el nombre para evitar rutas “../”
        String original = StringUtils.cleanPath(file.getOriginalFilename());
        String fileName = System.currentTimeMillis() + "_" + original;

        try {
            Path destino = uploadPath.resolve(fileName);
            log.debug("Guardando imagen en: {}", destino);
            file.transferTo(destino.toFile());
            // Devolvemos solo el nombre para que Android lo use en la URL
            return ResponseEntity.ok(new UploadResponse(fileName));

        } catch (IOException e) {
            log.error("Error al escribir imagen en {}: {}", uploadPath, e.getMessage(), e);
            // Devolvemos un JSON consistente con tu DTO
            return ResponseEntity
                    .status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body(new UploadResponse("Error interno al guardar la imagen"));
        }
    }

    @GetMapping("/files/{filename:.+}")
    public ResponseEntity<Resource> verImagen(
            @PathVariable String filename,
            HttpServletRequest request
    ) {
        try {
            Path filePath = uploadPath.resolve(filename).normalize();
            if (!Files.exists(filePath)) {
                return ResponseEntity.notFound().build();
            }

            Resource resource = new FileSystemResource(filePath.toFile());
            // Determinar content-type
            String contentType = request.getServletContext()
                    .getMimeType(resource.getFile().getAbsolutePath());
            if (contentType == null) {
                contentType = "application/octet-stream";
            }

            return ResponseEntity.ok()
                    .contentType(MediaType.parseMediaType(contentType))
                    .header(HttpHeaders.CONTENT_DISPOSITION, "inline; filename=\"" + resource.getFilename() + "\"")
                    .body(resource);

        } catch (IOException ex) {
            log.error("Error al leer archivo {}: {}", filename, ex.getMessage(), ex);
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }
}
