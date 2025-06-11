package com.andrea_murillo.involucrate.network;

@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\b\u0005\bf\u0018\u00002\u00020\u0001J(\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\b\b\u0001\u0010\u0005\u001a\u00020\u00062\b\b\u0001\u0010\u0007\u001a\u00020\bH\u00a7@\u00a2\u0006\u0002\u0010\tJ\u001e\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\b\b\u0001\u0010\u0007\u001a\u00020\bH\u00a7@\u00a2\u0006\u0002\u0010\u000bJ\u001e\u0010\f\u001a\b\u0012\u0004\u0012\u00020\r0\u00032\b\b\u0001\u0010\u0005\u001a\u00020\u0006H\u00a7@\u00a2\u0006\u0002\u0010\u000eJ$\u0010\u000f\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00040\u00100\u00032\b\b\u0001\u0010\u0011\u001a\u00020\u0006H\u00a7@\u00a2\u0006\u0002\u0010\u000eJ\u001a\u0010\u0012\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00040\u00100\u0003H\u00a7@\u00a2\u0006\u0002\u0010\u0013J\u001e\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\b\b\u0001\u0010\u0005\u001a\u00020\u0006H\u00a7@\u00a2\u0006\u0002\u0010\u000e\u00a8\u0006\u0015"}, d2 = {"Lcom/andrea_murillo/involucrate/network/ProductoApi;", "", "actualizarProducto", "Lretrofit2/Response;", "Lcom/andrea_murillo/involucrate/model/Producto;", "id", "", "request", "Lcom/andrea_murillo/involucrate/model/ProductoRequest;", "(JLcom/andrea_murillo/involucrate/model/ProductoRequest;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "crearProducto", "(Lcom/andrea_murillo/involucrate/model/ProductoRequest;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "eliminarProducto", "", "(JLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getProductosDelUsuario", "", "userId", "listarProductosDisponibles", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "obtenerProductoPorId", "app_debug"})
public abstract interface ProductoApi {
    
    @retrofit2.http.GET(value = "productos")
    @org.jetbrains.annotations.Nullable()
    public abstract java.lang.Object listarProductosDisponibles(@org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super retrofit2.Response<java.util.List<com.andrea_murillo.involucrate.model.Producto>>> $completion);
    
    @retrofit2.http.GET(value = "productos/{id}")
    @org.jetbrains.annotations.Nullable()
    public abstract java.lang.Object obtenerProductoPorId(@retrofit2.http.Path(value = "id")
    long id, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super retrofit2.Response<com.andrea_murillo.involucrate.model.Producto>> $completion);
    
    @retrofit2.http.GET(value = "productos/usuario/{id}")
    @org.jetbrains.annotations.Nullable()
    public abstract java.lang.Object getProductosDelUsuario(@retrofit2.http.Path(value = "id")
    long userId, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super retrofit2.Response<java.util.List<com.andrea_murillo.involucrate.model.Producto>>> $completion);
    
    @retrofit2.http.POST(value = "productos")
    @org.jetbrains.annotations.Nullable()
    public abstract java.lang.Object crearProducto(@retrofit2.http.Body()
    @org.jetbrains.annotations.NotNull()
    com.andrea_murillo.involucrate.model.ProductoRequest request, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super retrofit2.Response<com.andrea_murillo.involucrate.model.Producto>> $completion);
    
    @retrofit2.http.PUT(value = "productos/{id}")
    @org.jetbrains.annotations.Nullable()
    public abstract java.lang.Object actualizarProducto(@retrofit2.http.Path(value = "id")
    long id, @retrofit2.http.Body()
    @org.jetbrains.annotations.NotNull()
    com.andrea_murillo.involucrate.model.ProductoRequest request, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super retrofit2.Response<com.andrea_murillo.involucrate.model.Producto>> $completion);
    
    @retrofit2.http.DELETE(value = "productos/{id}")
    @org.jetbrains.annotations.Nullable()
    public abstract java.lang.Object eliminarProducto(@retrofit2.http.Path(value = "id")
    long id, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super retrofit2.Response<kotlin.Unit>> $completion);
}