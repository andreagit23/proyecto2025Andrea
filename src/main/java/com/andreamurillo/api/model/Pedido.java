package com.andreamurillo.api.model;

import jakarta.persistence.*;
import java.time.LocalDateTime;
import java.math.BigDecimal;

@Entity
@Table(name = "pedidos")
public class Pedido {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToOne
    @JoinColumn(name = "id_producto")
    private Producto producto;

    @ManyToOne
    @JoinColumn(name = "id_usuario")
    private Usuario comprador;

    @ManyToOne
    @JoinColumn(name = "id_ong")
    private Ong ong;

    @Column(name = "precio_total")
    private BigDecimal precioTotal;

    @Column(name = "cantidad_donada")
    private BigDecimal cantidadDonada;

    @Column(name = "cantidad_vendedor")
    private BigDecimal cantidadVendedor;

    @Enumerated(EnumType.STRING)
    private EstadoPedido estado = EstadoPedido.PENDIENTE;

    @Column(name = "creado_en")
    private LocalDateTime creadoEn = LocalDateTime.now();

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

	public Usuario getComprador() {
		return comprador;
	}

	public void setComprador(Usuario comprador) {
		this.comprador = comprador;
	}

	public Ong getOng() {
		return ong;
	}

	public void setOng(Ong ong) {
		this.ong = ong;
	}

	public BigDecimal getPrecioTotal() {
		return precioTotal;
	}

	public void setPrecioTotal(BigDecimal precioTotal) {
		this.precioTotal = precioTotal;
	}

	public BigDecimal getCantidadDonada() {
		return cantidadDonada;
	}

	public void setCantidadDonada(BigDecimal cantidadDonada) {
		this.cantidadDonada = cantidadDonada;
	}

	public BigDecimal getCantidadVendedor() {
		return cantidadVendedor;
	}

	public void setCantidadVendedor(BigDecimal cantidadVendedor) {
		this.cantidadVendedor = cantidadVendedor;
	}

	public EstadoPedido getEstado() {
		return estado;
	}

	public void setEstado(EstadoPedido estado) {
		this.estado = estado;
	}

	public LocalDateTime getCreadoEn() {
		return creadoEn;
	}

	public void setCreadoEn(LocalDateTime creadoEn) {
		this.creadoEn = creadoEn;
	}
}
