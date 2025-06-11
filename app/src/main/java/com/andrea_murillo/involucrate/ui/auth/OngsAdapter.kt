package com.andrea_murillo.involucrate.ui.ongs

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageButton
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.andrea_murillo.involucrate.R
import com.andrea_murillo.involucrate.model.Ong
import com.bumptech.glide.Glide

class OngsAdapter(
    private var items: List<Ong> = emptyList(),
    private val onViewClick: (Ong) -> Unit
) : RecyclerView.Adapter<OngsAdapter.OngViewHolder>() {

    inner class OngViewHolder(v: View) : RecyclerView.ViewHolder(v) {
        val img: ImageView = v.findViewById(R.id.imgOng)
        val nombre: TextView = v.findViewById(R.id.txtNombreOng)
        val desc: TextView = v.findViewById(R.id.txtDescripcionOng)
        val btnVer: ImageButton = v.findViewById(R.id.btnVerOng)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) = OngViewHolder(
        LayoutInflater.from(parent.context).inflate(R.layout.item_ong, parent, false)
    )

    override fun onBindViewHolder(holder: OngViewHolder, position: Int) {
        val ong = items[position]
        holder.nombre.text = ong.nombreOng
        holder.desc.text = ong.descripcion
        Glide.with(holder.img.context)
            .load("http://192.168.1.160:8080/api/uploads/files/${ong.imagen}")
            .placeholder(R.drawable.ic_placeholder_pink)
            .into(holder.img)
        holder.btnVer.setOnClickListener { onViewClick(ong) }
    }

    override fun getItemCount(): Int = items.size
    fun submitList(list: List<Ong>) { items = list; notifyDataSetChanged() }
}