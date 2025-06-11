// src/main/java/com/andreamurillo/api/dto/ProductoRequest.java
package com.andreamurillo.api.dto;

import java.math.BigDecimal;
import com.andreamurillo.api.model.EstadoProducto;

public class ProductoRequest {
    private String nombre;
    private String descripcion;
    private BigDecimal precio;
    private Integer porcentajeDonacion;
    private String imagen;
    private EstadoProducto estado;
    private Long vendedorId;
    private Long categoriaId;

    public String getNombre() { return nombre; }
    public void setNombre(String nombre) { this.nombre = nombre; }

    public String getDescripcion() { return descripcion; }
    public void setDescripcion(String descripcion) { this.descripcion = descripcion; }

    public BigDecimal getPrecio() { return precio; }
    public void setPrecio(BigDecimal precio) { this.precio = precio; }

    public Integer getPorcentajeDonacion() { return porcentajeDonacion; }
    public void setPorcentajeDonacion(Integer porcentajeDonacion) { this.porcentajeDonacion = porcentajeDonacion; }

    public String getImagen() { return imagen; }
    public void setImagen(String imagen) { this.imagen = imagen; }

    public EstadoProducto getEstado() { return estado; }
    public void setEstado(EstadoProducto estado) { this.estado = estado; }

    public Long getVendedorId() { return vendedorId; }
    public void setVendedorId(Long vendedorId) { this.vendedorId = vendedorId; }

    public Long getCategoriaId() { return categoriaId; }
    public void setCategoriaId(Long categoriaId) { this.categoriaId = categoriaId; }
}
