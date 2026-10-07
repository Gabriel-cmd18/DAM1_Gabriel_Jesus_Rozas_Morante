package com.example.appgrupo1

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide

data class Pais(
    val nombre: String,
    val imagenUrl: String
)

class PaisAdapter(
    private val listaPaises: List<Pais>
) : RecyclerView.Adapter<PaisAdapter.PaisViewHolder>() {

    class PaisViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        val tvPais: TextView = itemView.findViewById(R.id.tvPais)
        val imgBandera: ImageView = itemView.findViewById(R.id.imgBandera)
    }

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): PaisViewHolder {

        val vista = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_pais, parent, false)

        return PaisViewHolder(vista)
    }

    override fun onBindViewHolder(
        holder: PaisViewHolder,
        position: Int
    ) {

        val pais = listaPaises[position]

        holder.tvPais.text = pais.nombre

        Glide.with(holder.itemView.context)
            .load(pais.imagenUrl)
            .into(holder.imgBandera)
    }

    override fun getItemCount(): Int {
        return listaPaises.size
    }
}