package com.andrea_murillo.involucrate.ui.compras;

@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0002J\b\u0010\u001d\u001a\u00020\u001eH\u0002J\b\u0010\u001f\u001a\u00020\u001eH\u0002J\b\u0010 \u001a\u00020\u001eH\u0002J\u0012\u0010!\u001a\u00020\u001e2\b\u0010\"\u001a\u0004\u0018\u00010#H\u0016J$\u0010$\u001a\u00020%2\u0006\u0010&\u001a\u00020\'2\b\u0010(\u001a\u0004\u0018\u00010)2\b\u0010\"\u001a\u0004\u0018\u00010#H\u0016J\b\u0010*\u001a\u00020\u001eH\u0016J\u001a\u0010+\u001a\u00020\u001e2\u0006\u0010,\u001a\u00020%2\b\u0010\"\u001a\u0004\u0018\u00010#H\u0016J\b\u0010-\u001a\u00020\u001eH\u0002J\b\u0010.\u001a\u00020\u001eH\u0002R\u0010\u0010\u0003\u001a\u0004\u0018\u00010\u0004X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082.\u00a2\u0006\u0002\n\u0000R\u0014\u0010\u0007\u001a\u00020\u00048BX\u0082\u0004\u00a2\u0006\u0006\u001a\u0004\b\b\u0010\tR#\u0010\n\u001a\n \f*\u0004\u0018\u00010\u000b0\u000b8BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b\u000f\u0010\u0010\u001a\u0004\b\r\u0010\u000eR\u0014\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00130\u0012X\u0082\u000e\u00a2\u0006\u0002\n\u0000R#\u0010\u0014\u001a\n \f*\u0004\u0018\u00010\u00150\u00158BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b\u0018\u0010\u0010\u001a\u0004\b\u0016\u0010\u0017R\u0014\u0010\u0019\u001a\b\u0012\u0004\u0012\u00020\u001a0\u0012X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u001b\u001a\u00020\u001cX\u0082\u000e\u00a2\u0006\u0002\n\u0000\u00a8\u0006/"}, d2 = {"Lcom/andrea_murillo/involucrate/ui/compras/ComprasFragment;", "Landroidx/fragment/app/Fragment;", "()V", "_binding", "Lcom/andrea_murillo/involucrate/databinding/FragmentComprasBinding;", "adapter", "Lcom/andrea_murillo/involucrate/ui/compras/ComprasAdapter;", "binding", "getBinding", "()Lcom/andrea_murillo/involucrate/databinding/FragmentComprasBinding;", "categoriaApi", "Lcom/andrea_murillo/involucrate/network/CategoriaApi;", "kotlin.jvm.PlatformType", "getCategoriaApi", "()Lcom/andrea_murillo/involucrate/network/CategoriaApi;", "categoriaApi$delegate", "Lkotlin/Lazy;", "categorias", "", "Lcom/andrea_murillo/involucrate/model/Categoria;", "productoApi", "Lcom/andrea_murillo/involucrate/network/ProductoApi;", "getProductoApi", "()Lcom/andrea_murillo/involucrate/network/ProductoApi;", "productoApi$delegate", "todosProductos", "Lcom/andrea_murillo/involucrate/model/Producto;", "usuarioId", "", "applyFilters", "", "loadCategorias", "loadProductos", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "onCreateView", "Landroid/view/View;", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "onDestroyView", "onViewCreated", "view", "setupRecycler", "setupSearchAndFilter", "app_debug"})
public final class ComprasFragment extends androidx.fragment.app.Fragment {
    @org.jetbrains.annotations.Nullable()
    private com.andrea_murillo.involucrate.databinding.FragmentComprasBinding _binding;
    @org.jetbrains.annotations.NotNull()
    private final kotlin.Lazy productoApi$delegate = null;
    @org.jetbrains.annotations.NotNull()
    private final kotlin.Lazy categoriaApi$delegate = null;
    @org.jetbrains.annotations.NotNull()
    private java.util.List<com.andrea_murillo.involucrate.model.Producto> todosProductos;
    @org.jetbrains.annotations.NotNull()
    private java.util.List<com.andrea_murillo.involucrate.model.Categoria> categorias;
    private com.andrea_murillo.involucrate.ui.compras.ComprasAdapter adapter;
    private long usuarioId = -1L;
    
    public ComprasFragment() {
        super();
    }
    
    private final com.andrea_murillo.involucrate.databinding.FragmentComprasBinding getBinding() {
        return null;
    }
    
    private final com.andrea_murillo.involucrate.network.ProductoApi getProductoApi() {
        return null;
    }
    
    private final com.andrea_murillo.involucrate.network.CategoriaApi getCategoriaApi() {
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
    
    private final void setupRecycler() {
    }
    
    private final void setupSearchAndFilter() {
    }
    
    private final void loadCategorias() {
    }
    
    private final void loadProductos() {
    }
    
    private final void applyFilters() {
    }
    
    @java.lang.Override()
    public void onDestroyView() {
    }
}