package com.andrea_murillo.involucrate.ui.usuario;

@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000h\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0002J\b\u0010\"\u001a\u00020#H\u0002J\b\u0010$\u001a\u00020#H\u0002J\u0012\u0010%\u001a\u00020#2\b\u0010&\u001a\u0004\u0018\u00010\'H\u0016J$\u0010(\u001a\u00020)2\u0006\u0010*\u001a\u00020+2\b\u0010,\u001a\u0004\u0018\u00010-2\b\u0010&\u001a\u0004\u0018\u00010\'H\u0016J\b\u0010.\u001a\u00020#H\u0016J\u001a\u0010/\u001a\u00020#2\u0006\u00100\u001a\u00020)2\b\u0010&\u001a\u0004\u0018\u00010\'H\u0016R\u0010\u0010\u0003\u001a\u0004\u0018\u00010\u0004X\u0082\u000e\u00a2\u0006\u0002\n\u0000R#\u0010\u0005\u001a\n \u0007*\u0004\u0018\u00010\u00060\u00068BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b\n\u0010\u000b\u001a\u0004\b\b\u0010\tR\u0014\u0010\f\u001a\u00020\u00048BX\u0082\u0004\u00a2\u0006\u0006\u001a\u0004\b\r\u0010\u000eR\u0010\u0010\u000f\u001a\u0004\u0018\u00010\u0010X\u0082\u000e\u00a2\u0006\u0002\n\u0000R#\u0010\u0011\u001a\n \u0007*\u0004\u0018\u00010\u00120\u00128BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b\u0015\u0010\u000b\u001a\u0004\b\u0013\u0010\u0014R\u001c\u0010\u0016\u001a\u0010\u0012\f\u0012\n \u0007*\u0004\u0018\u00010\u00180\u00180\u0017X\u0082\u0004\u00a2\u0006\u0002\n\u0000R#\u0010\u0019\u001a\n \u0007*\u0004\u0018\u00010\u001a0\u001a8BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b\u001d\u0010\u000b\u001a\u0004\b\u001b\u0010\u001cR\u0010\u0010\u001e\u001a\u0004\u0018\u00010\u001fX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010 \u001a\u00020!X\u0082\u000e\u00a2\u0006\u0002\n\u0000\u00a8\u00061"}, d2 = {"Lcom/andrea_murillo/involucrate/ui/usuario/NuestraInformacionFragment;", "Landroidx/fragment/app/Fragment;", "()V", "_binding", "Lcom/andrea_murillo/involucrate/databinding/FragmentNuestraInformacionBinding;", "authApi", "Lcom/andrea_murillo/involucrate/network/AuthApi;", "kotlin.jvm.PlatformType", "getAuthApi", "()Lcom/andrea_murillo/involucrate/network/AuthApi;", "authApi$delegate", "Lkotlin/Lazy;", "binding", "getBinding", "()Lcom/andrea_murillo/involucrate/databinding/FragmentNuestraInformacionBinding;", "currentOng", "Lcom/andrea_murillo/involucrate/model/Ong;", "ongApi", "Lcom/andrea_murillo/involucrate/network/OngApi;", "getOngApi", "()Lcom/andrea_murillo/involucrate/network/OngApi;", "ongApi$delegate", "seleccionarImagen", "Landroidx/activity/result/ActivityResultLauncher;", "", "uploadApi", "Lcom/andrea_murillo/involucrate/network/UploadApi;", "getUploadApi", "()Lcom/andrea_murillo/involucrate/network/UploadApi;", "uploadApi$delegate", "uriImagen", "Landroid/net/Uri;", "usuarioId", "", "actualizarOng", "", "cargarDatosOng", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "onCreateView", "Landroid/view/View;", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "onDestroyView", "onViewCreated", "view", "app_debug"})
public final class NuestraInformacionFragment extends androidx.fragment.app.Fragment {
    @org.jetbrains.annotations.Nullable()
    private com.andrea_murillo.involucrate.databinding.FragmentNuestraInformacionBinding _binding;
    @org.jetbrains.annotations.NotNull()
    private final kotlin.Lazy ongApi$delegate = null;
    @org.jetbrains.annotations.NotNull()
    private final kotlin.Lazy authApi$delegate = null;
    @org.jetbrains.annotations.NotNull()
    private final kotlin.Lazy uploadApi$delegate = null;
    @org.jetbrains.annotations.Nullable()
    private com.andrea_murillo.involucrate.model.Ong currentOng;
    @org.jetbrains.annotations.Nullable()
    private android.net.Uri uriImagen;
    @org.jetbrains.annotations.NotNull()
    private final androidx.activity.result.ActivityResultLauncher<java.lang.String> seleccionarImagen = null;
    private long usuarioId = -1L;
    
    public NuestraInformacionFragment() {
        super();
    }
    
    private final com.andrea_murillo.involucrate.databinding.FragmentNuestraInformacionBinding getBinding() {
        return null;
    }
    
    private final com.andrea_murillo.involucrate.network.OngApi getOngApi() {
        return null;
    }
    
    private final com.andrea_murillo.involucrate.network.AuthApi getAuthApi() {
        return null;
    }
    
    private final com.andrea_murillo.involucrate.network.UploadApi getUploadApi() {
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
    
    private final void cargarDatosOng() {
    }
    
    private final void actualizarOng() {
    }
    
    @java.lang.Override()
    public void onDestroyView() {
    }
}