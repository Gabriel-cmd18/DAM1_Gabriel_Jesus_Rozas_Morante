package com.example.appgrupo1

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class PostAdapter(
    private val listaPosts: List<Post>
) : RecyclerView.Adapter<PostAdapter.PostViewHolder>() {

    class PostViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        val tvTitle: TextView = itemView.findViewById(R.id.tvTitle)
        val tvBody: TextView = itemView.findViewById(R.id.tvBody)
        val tvViews: TextView = itemView.findViewById(R.id.tvViews)
        val tvUserId: TextView = itemView.findViewById(R.id.tvUserId)
    }

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): PostViewHolder {

        val vista = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_post, parent, false)

        return PostViewHolder(vista)
    }

    override fun onBindViewHolder(
        holder: PostViewHolder,
        position: Int
    ) {

        val post = listaPosts[position]

        holder.tvTitle.text = post.title
        holder.tvBody.text = post.body
        holder.tvViews.text = "Vistas: ${post.views}"
        holder.tvUserId.text = "Usuario: ${post.userId}"
    }

    override fun getItemCount(): Int {
        return listaPosts.size
    }
}