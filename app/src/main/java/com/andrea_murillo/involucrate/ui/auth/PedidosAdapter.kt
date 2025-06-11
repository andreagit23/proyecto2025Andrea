package com.andrea_murillo.involucrate.ui.pedidos

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageButton
import android.widget.ImageView
import android.widget.TextView
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.RecyclerView
import com.andrea_murillo.involucrate.R
import com.andrea_murillo.involucrate.model.EstadoPedido
import com.andrea_murillo.involucrate.model.Pedido
import com.bumptech.glide.Glide

class PedidosAdapter(
    private var pedidos: List<Pedido> = emptyList(),
    private val onViewClick: (Pedido) -> Unit
) : RecyclerView.Adapter<PedidosAdapter.PedidoViewHolder>() {

    inner class PedidoViewHolder(v: View) : RecyclerView.ViewHolder(v) {
        val img: ImageView = v.findViewById(R.id.imgProducto)
        val nombre: TextView = v.findViewById(R.id.txtNombre)
        val estadoTxt: TextView = v.findViewById(R.id.txtEstadoPedido)
        val estadoDot: View = v.findViewById(R.id.viewEstado)
        val btnVer: ImageButton = v.findViewById(R.id.btnVer)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) =
        PedidoViewHolder(
            LayoutInflater.from(parent.context)
                .inflate(R.layout.item_pedido, parent, false)
        )

    override fun onBindViewHolder(holder: PedidoViewHolder, pos: Int) {
        val pedido = pedidos[pos]
        holder.nombre.text = pedido.producto.nombre
        holder.estadoTxt.text = pedido.estado.name
        // color del punto
        val color = if (pedido.estado == EstadoPedido.PENDIENTE) R.color.amarillo else R.color.verde
        holder.estadoDot.backgroundTintList = ContextCompat.getColorStateList(holder.img.context, color)

        Glide.with(holder.img.context)
            .load("http://192.168.1.160:8080/api/uploads/files/${pedido.producto.imagen}")
            .placeholder(R.drawable.ic_placeholder_pink)
            .into(holder.img)

        holder.btnVer.setOnClickListener { onViewClick(pedido) }
    }

    override fun getItemCount() = pedidos.size

    fun submitList(lista: List<Pedido>) {
        pedidos = lista
        notifyDataSetChanged()
    }
}