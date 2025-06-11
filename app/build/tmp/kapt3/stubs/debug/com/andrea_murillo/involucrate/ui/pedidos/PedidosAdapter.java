package com.andrea_murillo.involucrate.ui.pedidos;

@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\f\u0012\b\u0012\u00060\u0002R\u00020\u00000\u0001:\u0001\u0015B)\u0012\u000e\b\u0002\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004\u0012\u0012\u0010\u0006\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\b0\u0007\u00a2\u0006\u0002\u0010\tJ\b\u0010\n\u001a\u00020\u000bH\u0016J\u001c\u0010\f\u001a\u00020\b2\n\u0010\r\u001a\u00060\u0002R\u00020\u00002\u0006\u0010\u000e\u001a\u00020\u000bH\u0016J\u001c\u0010\u000f\u001a\u00060\u0002R\u00020\u00002\u0006\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u000bH\u0016J\u0014\u0010\u0013\u001a\u00020\b2\f\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004R\u001a\u0010\u0006\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\b0\u0007X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0014\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004X\u0082\u000e\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0016"}, d2 = {"Lcom/andrea_murillo/involucrate/ui/pedidos/PedidosAdapter;", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "Lcom/andrea_murillo/involucrate/ui/pedidos/PedidosAdapter$PedidoViewHolder;", "pedidos", "", "Lcom/andrea_murillo/involucrate/model/Pedido;", "onViewClick", "Lkotlin/Function1;", "", "(Ljava/util/List;Lkotlin/jvm/functions/Function1;)V", "getItemCount", "", "onBindViewHolder", "holder", "pos", "onCreateViewHolder", "parent", "Landroid/view/ViewGroup;", "viewType", "submitList", "lista", "PedidoViewHolder", "app_debug"})
public final class PedidosAdapter extends androidx.recyclerview.widget.RecyclerView.Adapter<com.andrea_murillo.involucrate.ui.pedidos.PedidosAdapter.PedidoViewHolder> {
    @org.jetbrains.annotations.NotNull()
    private java.util.List<com.andrea_murillo.involucrate.model.Pedido> pedidos;
    @org.jetbrains.annotations.NotNull()
    private final kotlin.jvm.functions.Function1<com.andrea_murillo.involucrate.model.Pedido, kotlin.Unit> onViewClick = null;
    
    public PedidosAdapter(@org.jetbrains.annotations.NotNull()
    java.util.List<com.andrea_murillo.involucrate.model.Pedido> pedidos, @org.jetbrains.annotations.NotNull()
    kotlin.jvm.functions.Function1<? super com.andrea_murillo.involucrate.model.Pedido, kotlin.Unit> onViewClick) {
        super();
    }
    
    @java.lang.Override()
    @org.jetbrains.annotations.NotNull()
    public com.andrea_murillo.involucrate.ui.pedidos.PedidosAdapter.PedidoViewHolder onCreateViewHolder(@org.jetbrains.annotations.NotNull()
    android.view.ViewGroup parent, int viewType) {
        return null;
    }
    
    @java.lang.Override()
    public void onBindViewHolder(@org.jetbrains.annotations.NotNull()
    com.andrea_murillo.involucrate.ui.pedidos.PedidosAdapter.PedidoViewHolder holder, int pos) {
    }
    
    @java.lang.Override()
    public int getItemCount() {
        return 0;
    }
    
    public final void submitList(@org.jetbrains.annotations.NotNull()
    java.util.List<com.andrea_murillo.involucrate.model.Pedido> lista) {
    }
    
    @kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0086\u0004\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004R\u0011\u0010\u0005\u001a\u00020\u0006\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0011\u0010\t\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0011\u0010\f\u001a\u00020\r\u00a2\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u0011\u0010\u0010\u001a\u00020\u0011\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013R\u0011\u0010\u0014\u001a\u00020\r\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u000f\u00a8\u0006\u0016"}, d2 = {"Lcom/andrea_murillo/involucrate/ui/pedidos/PedidosAdapter$PedidoViewHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "v", "Landroid/view/View;", "(Lcom/andrea_murillo/involucrate/ui/pedidos/PedidosAdapter;Landroid/view/View;)V", "btnVer", "Landroid/widget/ImageButton;", "getBtnVer", "()Landroid/widget/ImageButton;", "estadoDot", "getEstadoDot", "()Landroid/view/View;", "estadoTxt", "Landroid/widget/TextView;", "getEstadoTxt", "()Landroid/widget/TextView;", "img", "Landroid/widget/ImageView;", "getImg", "()Landroid/widget/ImageView;", "nombre", "getNombre", "app_debug"})
    public final class PedidoViewHolder extends androidx.recyclerview.widget.RecyclerView.ViewHolder {
        @org.jetbrains.annotations.NotNull()
        private final android.widget.ImageView img = null;
        @org.jetbrains.annotations.NotNull()
        private final android.widget.TextView nombre = null;
        @org.jetbrains.annotations.NotNull()
        private final android.widget.TextView estadoTxt = null;
        @org.jetbrains.annotations.NotNull()
        private final android.view.View estadoDot = null;
        @org.jetbrains.annotations.NotNull()
        private final android.widget.ImageButton btnVer = null;
        
        public PedidoViewHolder(@org.jetbrains.annotations.NotNull()
        android.view.View v) {
            super(null);
        }
        
        @org.jetbrains.annotations.NotNull()
        public final android.widget.ImageView getImg() {
            return null;
        }
        
        @org.jetbrains.annotations.NotNull()
        public final android.widget.TextView getNombre() {
            return null;
        }
        
        @org.jetbrains.annotations.NotNull()
        public final android.widget.TextView getEstadoTxt() {
            return null;
        }
        
        @org.jetbrains.annotations.NotNull()
        public final android.view.View getEstadoDot() {
            return null;
        }
        
        @org.jetbrains.annotations.NotNull()
        public final android.widget.ImageButton getBtnVer() {
            return null;
        }
    }
}