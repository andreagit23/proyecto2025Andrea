package com.andrea_murillo.involucrate.ui.usuario;

@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000P\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0002J\b\u0010\u0018\u001a\u00020\u0019H\u0002J\b\u0010\u001a\u001a\u00020\u0019H\u0002J\u0012\u0010\u001b\u001a\u00020\u00192\b\u0010\u001c\u001a\u0004\u0018\u00010\u001dH\u0016J$\u0010\u001e\u001a\u00020\u001f2\u0006\u0010 \u001a\u00020!2\b\u0010\"\u001a\u0004\u0018\u00010#2\b\u0010\u001c\u001a\u0004\u0018\u00010\u001dH\u0016J\b\u0010$\u001a\u00020\u0019H\u0016J\u001a\u0010%\u001a\u00020\u00192\u0006\u0010&\u001a\u00020\u001f2\b\u0010\u001c\u001a\u0004\u0018\u00010\u001dH\u0016R\u0010\u0010\u0003\u001a\u0004\u0018\u00010\u0004X\u0082\u000e\u00a2\u0006\u0002\n\u0000R#\u0010\u0005\u001a\n \u0007*\u0004\u0018\u00010\u00060\u00068BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b\n\u0010\u000b\u001a\u0004\b\b\u0010\tR\u0014\u0010\f\u001a\u00020\u00048BX\u0082\u0004\u00a2\u0006\u0006\u001a\u0004\b\r\u0010\u000eR\u0010\u0010\u000f\u001a\u0004\u0018\u00010\u0010X\u0082\u000e\u00a2\u0006\u0002\n\u0000R#\u0010\u0011\u001a\n \u0007*\u0004\u0018\u00010\u00120\u00128BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b\u0015\u0010\u000b\u001a\u0004\b\u0013\u0010\u0014R\u000e\u0010\u0016\u001a\u00020\u0017X\u0082\u000e\u00a2\u0006\u0002\n\u0000\u00a8\u0006\'"}, d2 = {"Lcom/andrea_murillo/involucrate/ui/usuario/EditUsuarioFragment;", "Landroidx/fragment/app/Fragment;", "()V", "_binding", "Lcom/andrea_murillo/involucrate/databinding/FragmentEditUsuarioBinding;", "authApi", "Lcom/andrea_murillo/involucrate/network/AuthApi;", "kotlin.jvm.PlatformType", "getAuthApi", "()Lcom/andrea_murillo/involucrate/network/AuthApi;", "authApi$delegate", "Lkotlin/Lazy;", "binding", "getBinding", "()Lcom/andrea_murillo/involucrate/databinding/FragmentEditUsuarioBinding;", "originalUsuario", "Lcom/andrea_murillo/involucrate/model/Usuario;", "usuarioApi", "Lcom/andrea_murillo/involucrate/network/UsuarioApi;", "getUsuarioApi", "()Lcom/andrea_murillo/involucrate/network/UsuarioApi;", "usuarioApi$delegate", "usuarioId", "", "actualizarUsuario", "", "cargarDatosUsuario", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "onCreateView", "Landroid/view/View;", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "onDestroyView", "onViewCreated", "view", "app_debug"})
public final class EditUsuarioFragment extends androidx.fragment.app.Fragment {
    @org.jetbrains.annotations.Nullable()
    private com.andrea_murillo.involucrate.databinding.FragmentEditUsuarioBinding _binding;
    @org.jetbrains.annotations.NotNull()
    private final kotlin.Lazy usuarioApi$delegate = null;
    @org.jetbrains.annotations.NotNull()
    private final kotlin.Lazy authApi$delegate = null;
    @org.jetbrains.annotations.Nullable()
    private com.andrea_murillo.involucrate.model.Usuario originalUsuario;
    private long usuarioId = -1L;
    
    public EditUsuarioFragment() {
        super();
    }
    
    private final com.andrea_murillo.involucrate.databinding.FragmentEditUsuarioBinding getBinding() {
        return null;
    }
    
    private final com.andrea_murillo.involucrate.network.UsuarioApi getUsuarioApi() {
        return null;
    }
    
    private final com.andrea_murillo.involucrate.network.AuthApi getAuthApi() {
        return null;
    }
    
    @java.lang.Override()
    public void onCreate(@org.jetbrains.annotations.Nullable()
    android.os.Bundle savedInstanceState) {
    }
    
    @java.lang.Override()
    @org.jetbrains.annotations.NotNull()
    public android.view.View onCreateView(@org.jetbrains.annotations.NotNull()
    android.view.LayoutInflater inflater, @org.jetbrains.annotations.Nullable()
    android.view.ViewGroup container, @org.jetbrains.annotations.Nullable()
    android.os.Bundle savedInstanceState) {
        return null;
    }
    
    @java.lang.Override()
    public void onViewCreated(@org.jetbrains.annotations.NotNull()
    android.view.View view, @org.jetbrains.annotations.Nullable()
    android.os.Bundle savedInstanceState) {
    }
    
    private final void cargarDatosUsuario() {
    }
    
    private final void actualizarUsuario() {
    }
    
    @java.lang.Override()
    public void onDestroyView() {
    }
}