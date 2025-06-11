package com.andrea_murillo.involucrate.viewmodel;

@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0002J\u001c\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u00062\u0006\u0010\b\u001a\u00020\tH\u0086@\u00a2\u0006\u0002\u0010\nJ\u001c\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\f0\u00062\u0006\u0010\r\u001a\u00020\fH\u0086@\u00a2\u0006\u0002\u0010\u000eR\u000e\u0010\u0003\u001a\u00020\u0004X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u000f"}, d2 = {"Lcom/andrea_murillo/involucrate/viewmodel/AuthViewModel;", "Landroidx/lifecycle/ViewModel;", "()V", "api", "Lcom/andrea_murillo/involucrate/network/AuthApi;", "login", "Lretrofit2/Response;", "Lcom/andrea_murillo/involucrate/model/AuthResponse;", "request", "Lcom/andrea_murillo/involucrate/model/AuthRequest;", "(Lcom/andrea_murillo/involucrate/model/AuthRequest;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "register", "Lcom/andrea_murillo/involucrate/model/Usuario;", "usuario", "(Lcom/andrea_murillo/involucrate/model/Usuario;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "app_debug"})
public final class AuthViewModel extends androidx.lifecycle.ViewModel {
    @org.jetbrains.annotations.NotNull()
    private final com.andrea_murillo.involucrate.network.AuthApi api = null;
    
    public AuthViewModel() {
        super();
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.Object login(@org.jetbrains.annotations.NotNull()
    com.andrea_murillo.involucrate.model.AuthRequest request, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super retrofit2.Response<com.andrea_murillo.involucrate.model.AuthResponse>> $completion) {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.Object register(@org.jetbrains.annotations.NotNull()
    com.andrea_murillo.involucrate.model.Usuario usuario, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super retrofit2.Response<com.andrea_murillo.involucrate.model.Usuario>> $completion) {
        return null;
    }
}