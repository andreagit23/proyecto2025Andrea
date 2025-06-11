package com.andreamurillo.api.model;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "comprobantes")
public class Comprobante {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToOne
    @JoinColumn(name = "id_producto")
    private Producto producto;

    @Column(name = "url_subida")
    private String urlSubida;

    @Column(name = "subido_en")
    private LocalDateTime subidoEn = LocalDateTime.now();

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Producto getProducto() {
		return producto;
	}

	public void setProducto(Producto producto) {
		this.producto = producto;
	}

	public String getUrlSubida() {
		return urlSubida;
	}

	public void setUrlSubida(String urlSubida) {
		this.urlSubida = urlSubida;
	}

	public LocalDateTime getSubidoEn() {
		return subidoEn;
	}

	public void setSubidoEn(LocalDateTime subidoEn) {
		this.subidoEn = subidoEn;
	}
}

