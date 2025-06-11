package com.andrea_murillo.involucrate.model;

@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u001e\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001BO\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\t\u0012\u0006\u0010\n\u001a\u00020\u000b\u0012\u0006\u0010\f\u001a\u00020\u000b\u0012\u0006\u0010\r\u001a\u00020\u000b\u0012\u0006\u0010\u000e\u001a\u00020\u000f\u0012\u0006\u0010\u0010\u001a\u00020\u0011\u00a2\u0006\u0002\u0010\u0012J\u0010\u0010$\u001a\u0004\u0018\u00010\u0003H\u00c6\u0003\u00a2\u0006\u0002\u0010\u001dJ\t\u0010%\u001a\u00020\u0005H\u00c6\u0003J\t\u0010&\u001a\u00020\u0007H\u00c6\u0003J\t\u0010\'\u001a\u00020\tH\u00c6\u0003J\t\u0010(\u001a\u00020\u000bH\u00c6\u0003J\t\u0010)\u001a\u00020\u000bH\u00c6\u0003J\t\u0010*\u001a\u00020\u000bH\u00c6\u0003J\t\u0010+\u001a\u00020\u000fH\u00c6\u0003J\t\u0010,\u001a\u00020\u0011H\u00c6\u0003Jj\u0010-\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\t2\b\b\u0002\u0010\n\u001a\u00020\u000b2\b\b\u0002\u0010\f\u001a\u00020\u000b2\b\b\u0002\u0010\r\u001a\u00020\u000b2\b\b\u0002\u0010\u000e\u001a\u00020\u000f2\b\b\u0002\u0010\u0010\u001a\u00020\u0011H\u00c6\u0001\u00a2\u0006\u0002\u0010.J\u0013\u0010/\u001a\u0002002\b\u00101\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003J\t\u00102\u001a\u000203H\u00d6\u0001J\t\u00104\u001a\u00020\u0011H\u00d6\u0001R\u0011\u0010\f\u001a\u00020\u000b\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014R\u0011\u0010\r\u001a\u00020\u000b\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0014R\u0011\u0010\u0006\u001a\u00020\u0007\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0017R\u0011\u0010\u0010\u001a\u00020\u0011\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0019R\u0011\u0010\u000e\u001a\u00020\u000f\u00a2\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\u001bR\u0015\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u00a2\u0006\n\n\u0002\u0010\u001e\u001a\u0004\b\u001c\u0010\u001dR\u0011\u0010\b\u001a\u00020\t\u00a2\u0006\b\n\u0000\u001a\u0004\b\u001f\u0010 R\u0011\u0010\n\u001a\u00020\u000b\u00a2\u0006\b\n\u0000\u001a\u0004\b!\u0010\u0014R\u0011\u0010\u0004\u001a\u00020\u0005\u00a2\u0006\b\n\u0000\u001a\u0004\b\"\u0010#\u00a8\u00065"}, d2 = {"Lcom/andrea_murillo/involucrate/model/Pedido;", "", "id", "", "producto", "Lcom/andrea_murillo/involucrate/model/Producto;", "comprador", "Lcom/andrea_murillo/involucrate/model/Usuario;", "ong", "Lcom/andrea_murillo/involucrate/model/Ong;", "precioTotal", "Ljava/math/BigDecimal;", "cantidadDonada", "cantidadVendedor", "estado", "Lcom/andrea_murillo/involucrate/model/EstadoPedido;", "creadoEn", "", "(Ljava/lang/Long;Lcom/andrea_murillo/involucrate/model/Producto;Lcom/andrea_murillo/involucrate/model/Usuario;Lcom/andrea_murillo/involucrate/model/Ong;Ljava/math/BigDecimal;Ljava/math/BigDecimal;Ljava/math/BigDecimal;Lcom/andrea_murillo/involucrate/model/EstadoPedido;Ljava/lang/String;)V", "getCantidadDonada", "()Ljava/math/BigDecimal;", "getCantidadVendedor", "getComprador", "()Lcom/andrea_murillo/involucrate/model/Usuario;", "getCreadoEn", "()Ljava/lang/String;", "getEstado", "()Lcom/andrea_murillo/involucrate/model/EstadoPedido;", "getId", "()Ljava/lang/Long;", "Ljava/lang/Long;", "getOng", "()Lcom/andrea_murillo/involucrate/model/Ong;", "getPrecioTotal", "getProducto", "()Lcom/andrea_murillo/involucrate/model/Producto;", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "copy", "(Ljava/lang/Long;Lcom/andrea_murillo/involucrate/model/Producto;Lcom/andrea_murillo/involucrate/model/Usuario;Lcom/andrea_murillo/involucrate/model/Ong;Ljava/math/BigDecimal;Ljava/math/BigDecimal;Ljava/math/BigDecimal;Lcom/andrea_murillo/involucrate/model/EstadoPedido;Ljava/lang/String;)Lcom/andrea_murillo/involucrate/model/Pedido;", "equals", "", "other", "hashCode", "", "toString", "app_debug"})
public final class Pedido {
    @org.jetbrains.annotations.Nullable()
    private final java.lang.Long id = null;
    @org.jetbrains.annotations.NotNull()
    private final com.andrea_murillo.involucrate.model.Producto producto = null;
    @org.jetbrains.annotations.NotNull()
    private final com.andrea_murillo.involucrate.model.Usuario comprador = null;
    @org.jetbrains.annotations.NotNull()
    private final com.andrea_murillo.involucrate.model.Ong ong = null;
    @org.jetbrains.annotations.NotNull()
    private final java.math.BigDecimal precioTotal = null;
    @org.jetbrains.annotations.NotNull()
    private final java.math.BigDecimal cantidadDonada = null;
    @org.jetbrains.annotations.NotNull()
    private final java.math.BigDecimal cantidadVendedor = null;
    @org.jetbrains.annotations.NotNull()
    private final com.andrea_murillo.involucrate.model.EstadoPedido estado = null;
    @org.jetbrains.annotations.NotNull()
    private final java.lang.String creadoEn = null;
    
    public Pedido(@org.jetbrains.annotations.Nullable()
    java.lang.Long id, @org.jetbrains.annotations.NotNull()
    com.andrea_murillo.involucrate.model.Producto producto, @org.jetbrains.annotations.NotNull()
    com.andrea_murillo.involucrate.model.Usuario comprador, @org.jetbrains.annotations.NotNull()
    com.andrea_murillo.involucrate.model.Ong ong, @org.jetbrains.annotations.NotNull()
    java.math.BigDecimal precioTotal, @org.jetbrains.annotations.NotNull()
    java.math.BigDecimal cantidadDonada, @org.jetbrains.annotations.NotNull()
    java.math.BigDecimal cantidadVendedor, @org.jetbrains.annotations.NotNull()
    com.andrea_murillo.involucrate.model.EstadoPedido estado, @org.jetbrains.annotations.NotNull()
    java.lang.String creadoEn) {
        super();
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.Long getId() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final com.andrea_murillo.involucrate.model.Producto getProducto() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final com.andrea_murillo.involucrate.model.Usuario getComprador() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final com.andrea_murillo.involucrate.model.Ong getOng() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.math.BigDecimal getPrecioTotal() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.math.BigDecimal getCantidadDonada() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.math.BigDecimal getCantidadVendedor() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final com.andrea_murillo.involucrate.model.EstadoPedido getEstado() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String getCreadoEn() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.Long component1() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final com.andrea_murillo.involucrate.model.Producto component2() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final com.andrea_murillo.involucrate.model.Usuario component3() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final com.andrea_murillo.involucrate.model.Ong component4() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.math.BigDecimal component5() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.math.BigDecimal component6() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.math.BigDecimal component7() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final com.andrea_murillo.involucrate.model.EstadoPedido component8() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String component9() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final com.andrea_murillo.involucrate.model.Pedido copy(@org.jetbrains.annotations.Nullable()
    java.lang.Long id, @org.jetbrains.annotations.NotNull()
    com.andrea_murillo.involucrate.model.Producto producto, @org.jetbrains.annotations.NotNull()
    com.andrea_murillo.involucrate.model.Usuario comprador, @org.jetbrains.annotations.NotNull()
    com.andrea_murillo.involucrate.model.Ong ong, @org.jetbrains.annotations.NotNull()
    java.math.BigDecimal precioTotal, @org.jetbrains.annotations.NotNull()
    java.math.BigDecimal cantidadDonada, @org.jetbrains.annotations.NotNull()
    java.math.BigDecimal cantidadVendedor, @org.jetbrains.annotations.NotNull()
    com.andrea_murillo.involucrate.model.EstadoPedido estado, @org.jetbrains.annotations.NotNull()
    java.lang.String creadoEn) {
        return null;
    }
    
    @java.lang.Override()
    public boolean equals(@org.jetbrains.annotations.Nullable()
    java.lang.Object other) {
        return false;
    }
    
    @java.lang.Override()
    public int hashCode() {
        return 0;
    }
    
    @java.lang.Override()
    @org.jetbrains.annotations.NotNull()
    public java.lang.String toString() {
        return null;
    }
}