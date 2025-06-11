// src/main/java/com/andreamurillo/api/dto/UploadResponse.java
package com.andreamurillo.api.dto;

public class UploadResponse {
    private String nombre;

    public UploadResponse() { }

    public UploadResponse(String nombre) {
        this.nombre = nombre;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
}
