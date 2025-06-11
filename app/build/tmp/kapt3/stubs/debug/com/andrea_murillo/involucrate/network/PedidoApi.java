package com.andrea_murillo.involucrate.network;

@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0004\bf\u0018\u00002\u00020\u0001J$\u0010\u0002\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00050\u00040\u00032\b\b\u0001\u0010\u0006\u001a\u00020\u0007H\u00a7@\u00a2\u0006\u0002\u0010\bJ\u001e\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00050\u00032\b\b\u0001\u0010\n\u001a\u00020\u0007H\u00a7@\u00a2\u0006\u0002\u0010\b\u00a8\u0006\u000b"}, d2 = {"Lcom/andrea_murillo/involucrate/network/PedidoApi;", "", "listarPedidosUsuario", "Lretrofit2/Response;", "", "Lcom/andrea_murillo/involucrate/model/Pedido;", "usuarioId", "", "(JLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "obtenerPedidoPorId", "id", "app_debug"})
public abstract interface PedidoApi {
    
    @retrofit2.http.GET(value = "pedidos/usuario/{id}")
    @org.jetbrains.annotations.Nullable()
    public abstract java.lang.Object listarPedidosUsuario(@retrofit2.http.Path(value = "id")
    long usuarioId, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super retrofit2.Response<java.util.List<com.andrea_murillo.involucrate.model.Pedido>>> $completion);
    
    @retrofit2.http.GET(value = "pedidos/{id}")
    @org.jetbrains.annotations.Nullable()
    public abstract java.lang.Object obtenerPedidoPorId(@retrofit2.http.Path(value = "id")
    long id, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super retrofit2.Response<com.andrea_murillo.involucrate.model.Pedido>> $completion);
}