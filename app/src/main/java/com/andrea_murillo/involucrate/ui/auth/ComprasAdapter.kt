package com.andrea_murillo.involucrate.ui.compras

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageButton
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.andrea_murillo.involucrate.R
import com.andrea_murillo.involucrate.model.Producto
import com.bumptech.glide.Glide

class ComprasAdapter(
    private var productos: List<Producto> = emptyList(),
    private val onViewClick: (Producto) -> Unit
) : RecyclerView.Adapter<ComprasAdapter.CompraViewHolder>() {

    inner class CompraViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val image: ImageView = view.findViewById(R.id.imgProducto)
        val nombre: TextView = view.findViewById(R.id.txtNombre)
        val estado: TextView = view.findViewById(R.id.txtEstado)
        val btnVer: ImageButton = view.findViewById(R.id.btnVer)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CompraViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_producto_compra, parent, false)
        return CompraViewHolder(view)
    }

    override fun onBindViewHolder(holder: CompraViewHolder, position: Int) {
        val producto = productos[position]
        holder.nombre.text = producto.nombre
        holder.estado.text = producto.estado
        Glide.with(holder.image.context)
            .load("http://192.168.1.160:8080/api/uploads/files/${producto.imagen}")
            .placeholder(R.drawable.ic_placeholder_pink)
            .into(holder.image)

        holder.btnVer.setOnClickListener { onViewClick(producto) }
    }

    override fun getItemCount(): Int = productos.size

    fun submitList(nuevaLista: List<Producto>) {
        productos = nuevaLista
        notifyDataSetChanged()
    }
}
