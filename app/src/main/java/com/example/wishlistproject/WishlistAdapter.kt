package com.example.wishlistproject

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class WishlistAdapter(private val WishlistItems: List<WishlistItem>): RecyclerView.Adapter<WishlistAdapter.ViewHolder>() {
    class ViewHolder(itemView: View): RecyclerView.ViewHolder(itemView){
        val nameTextView: TextView
        val amtTextView: TextView
        val descTextView: TextView
        init {
            nameTextView = itemView.findViewById(R.id.nameTv)
            amtTextView = itemView.findViewById(R.id.amtTv)
            descTextView = itemView.findViewById(R.id.descTv)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val context = parent.context
        val inflater = LayoutInflater.from(context)
        val contactView = inflater.inflate(R.layout.wishlist_item, parent, false)
        return ViewHolder(contactView)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val wishlistItem = WishlistItems.get(position)
        holder.nameTextView.text = wishlistItem.name
        holder.amtTextView.text = wishlistItem.amt
        holder.descTextView.text = wishlistItem.desc
    }

    override fun getItemCount(): Int {
        return WishlistItems.size
    }
}