package com.andrea_murillo.involucrate.model;

@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u001d\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u0086\b\u0018\u00002\u00020\u0001BQ\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0005\u0012\u0006\u0010\u0007\u001a\u00020\b\u0012\u0006\u0010\t\u001a\u00020\n\u0012\b\u0010\u000b\u001a\u0004\u0018\u00010\u0005\u0012\u0006\u0010\f\u001a\u00020\u0005\u0012\u0006\u0010\r\u001a\u00020\u000e\u0012\u0006\u0010\u000f\u001a\u00020\u0010\u00a2\u0006\u0002\u0010\u0011J\u0010\u0010\"\u001a\u0004\u0018\u00010\u0003H\u00c6\u0003\u00a2\u0006\u0002\u0010\u0018J\t\u0010#\u001a\u00020\u0005H\u00c6\u0003J\t\u0010$\u001a\u00020\u0005H\u00c6\u0003J\t\u0010%\u001a\u00020\bH\u00c6\u0003J\t\u0010&\u001a\u00020\nH\u00c6\u0003J\u000b\u0010\'\u001a\u0004\u0018\u00010\u0005H\u00c6\u0003J\t\u0010(\u001a\u00020\u0005H\u00c6\u0003J\t\u0010)\u001a\u00020\u000eH\u00c6\u0003J\t\u0010*\u001a\u00020\u0010H\u00c6\u0003Jl\u0010+\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00052\b\b\u0002\u0010\u0007\u001a\u00020\b2\b\b\u0002\u0010\t\u001a\u00020\n2\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\u00052\b\b\u0002\u0010\f\u001a\u00020\u00052\b\b\u0002\u0010\r\u001a\u00020\u000e2\b\b\u0002\u0010\u000f\u001a\u00020\u0010H\u00c6\u0001\u00a2\u0006\u0002\u0010,J\u0013\u0010-\u001a\u00020.2\b\u0010/\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003J\t\u00100\u001a\u00020\nH\u00d6\u0001J\t\u00101\u001a\u00020\u0005H\u00d6\u0001R\u0011\u0010\u000f\u001a\u00020\u0010\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013R\u0011\u0010\u0006\u001a\u00020\u0005\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0015R\u0011\u0010\f\u001a\u00020\u0005\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0015R\u0015\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u00a2\u0006\n\n\u0002\u0010\u0019\u001a\u0004\b\u0017\u0010\u0018R\u0013\u0010\u000b\u001a\u0004\u0018\u00010\u0005\u00a2\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\u0015R\u0011\u0010\u0004\u001a\u00020\u0005\u00a2\u0006\b\n\u0000\u001a\u0004\b\u001b\u0010\u0015R\u0011\u0010\t\u001a\u00020\n\u00a2\u0006\b\n\u0000\u001a\u0004\b\u001c\u0010\u001dR\u0011\u0010\u0007\u001a\u00020\b\u00a2\u0006\b\n\u0000\u001a\u0004\b\u001e\u0010\u001fR\u0011\u0010\r\u001a\u00020\u000e\u00a2\u0006\b\n\u0000\u001a\u0004\b \u0010!\u00a8\u00062"}, d2 = {"Lcom/andrea_murillo/involucrate/model/Producto;", "", "id", "", "nombre", "", "descripcion", "precio", "Ljava/math/BigDecimal;", "porcentajeDonacion", "", "imagen", "estado", "vendedor", "Lcom/andrea_murillo/involucrate/model/Usuario;", "categoria", "Lcom/andrea_murillo/involucrate/model/Categoria;", "(Ljava/lang/Long;Ljava/lang/String;Ljava/lang/String;Ljava/math/BigDecimal;ILjava/lang/String;Ljava/lang/String;Lcom/andrea_murillo/involucrate/model/Usuario;Lcom/andrea_murillo/involucrate/model/Categoria;)V", "getCategoria", "()Lcom/andrea_murillo/involucrate/model/Categoria;", "getDescripcion", "()Ljava/lang/String;", "getEstado", "getId", "()Ljava/lang/Long;", "Ljava/lang/Long;", "getImagen", "getNombre", "getPorcentajeDonacion", "()I", "getPrecio", "()Ljava/math/BigDecimal;", "getVendedor", "()Lcom/andrea_murillo/involucrate/model/Usuario;", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "copy", "(Ljava/lang/Long;Ljava/lang/String;Ljava/lang/String;Ljava/math/BigDecimal;ILjava/lang/String;Ljava/lang/String;Lcom/andrea_murillo/involucrate/model/Usuario;Lcom/andrea_murillo/involucrate/model/Categoria;)Lcom/andrea_murillo/involucrate/model/Producto;", "equals", "", "other", "hashCode", "toString", "app_debug"})
public final class Producto {
    @org.jetbrains.annotations.Nullable()
    private final java.lang.Long id = null;
    @org.jetbrains.annotations.NotNull()
    private final java.lang.String nombre = null;
    @org.jetbrains.annotations.NotNull()
    private final java.lang.String descripcion = null;
    @org.jetbrains.annotations.NotNull()
    private final java.math.BigDecimal precio = null;
    private final int porcentajeDonacion = 0;
    @org.jetbrains.annotations.Nullable()
    private final java.lang.String imagen = null;
    @org.jetbrains.annotations.NotNull()
    private final java.lang.String estado = null;
    @org.jetbrains.annotations.NotNull()
    private final com.andrea_murillo.involucrate.model.Usuario vendedor = null;
    @org.jetbrains.annotations.NotNull()
    private final com.andrea_murillo.involucrate.model.Categoria categoria = null;
    
    public Producto(@org.jetbrains.annotations.Nullable()
    java.lang.Long id, @org.jetbrains.annotations.NotNull()
    java.lang.String nombre, @org.jetbrains.annotations.NotNull()
    java.lang.String descripcion, @org.jetbrains.annotations.NotNull()
    java.math.BigDecimal precio, int porcentajeDonacion, @org.jetbrains.annotations.Nullable()
    java.lang.String imagen, @org.jetbrains.annotations.NotNull()
    java.lang.String estado, @org.jetbrains.annotations.NotNull()
    com.andrea_murillo.involucrate.model.Usuario vendedor, @org.jetbrains.annotations.NotNull()
    com.andrea_murillo.involucrate.model.Categoria categoria) {
        super();
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.Long getId() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String getNombre() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String getDescripcion() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.math.BigDecimal getPrecio() {
        return null;
    }
    
    public final int getPorcentajeDonacion() {
        return 0;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.String getImagen() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String getEstado() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final com.andrea_murillo.involucrate.model.Usuario getVendedor() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final com.andrea_murillo.involucrate.model.Categoria getCategoria() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.Long component1() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String component2() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String component3() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.math.BigDecimal component4() {
        return null;
    }
    
    public final int component5() {
        return 0;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.String component6() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String component7() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final com.andrea_murillo.involucrate.model.Usuario component8() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final com.andrea_murillo.involucrate.model.Categoria component9() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final com.andrea_murillo.involucrate.model.Producto copy(@org.jetbrains.annotations.Nullable()
    java.lang.Long id, @org.jetbrains.annotations.NotNull()
    java.lang.String nombre, @org.jetbrains.annotations.NotNull()
    java.lang.String descripcion, @org.jetbrains.annotations.NotNull()
    java.math.BigDecimal precio, int porcentajeDonacion, @org.jetbrains.annotations.Nullable()
    java.lang.String imagen, @org.jetbrains.annotations.NotNull()
    java.lang.String estado, @org.jetbrains.annotations.NotNull()
    com.andrea_murillo.involucrate.model.Usuario vendedor, @org.jetbrains.annotations.NotNull()
    com.andrea_murillo.involucrate.model.Categoria categoria) {
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