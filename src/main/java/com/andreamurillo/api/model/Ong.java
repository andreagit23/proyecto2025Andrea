package com.andreamurillo.api.model;

import jakarta.persistence.*;

@Entity
@Table(name = "ongs")
public class Ong {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToOne
    @JoinColumn(name = "usuario_id")
    private Usuario usuario;

    @Column(name = "nombre_ong")
    private String nombreOng;

    private String descripcion;
    private String direccion;
    private String telefono;
    private String imagen;

    @Column(name = "correo_electronico")
    private String correoElectronico;

    private String url;
    private Boolean verificada = false;
	public String getDescripcion() {
		return descripcion;
	}
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	public String getDireccion() {
		return direccion;
	}
	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}
	public String getTelefono() {
		return telefono;
	}
	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}
	public Boolean getVerificada() {
		return verificada;
	}
	public void setVerificada(Boolean verificada) {
		this.verificada = verificada;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public Usuario getUsuario() {
		return usuario;
	}
	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}
	public String getNombreOng() {
		return nombreOng;
	}
	public void setNombreOng(String nombreOng) {
		this.nombreOng = nombreOng;
	}
	public String getCorreoElectronico() {
		return correoElectronico;
	}
	public void setCorreoElectronico(String correoElectronico) {
		this.correoElectronico = correoElectronico;
	}
	public String getImagen() { 
		return imagen; 
	}
	public void setImagen(String imagen) { 
		this.imagen = imagen; 
	}
}
