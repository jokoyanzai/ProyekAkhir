package com.dicoding.proyekakhir

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions

class ListBookAdapter(private val listBook: ArrayList<Book>) : RecyclerView.Adapter<ListBookAdapter.ListViewHolder>()
{
    private lateinit var onItemClickCallback: OnItemClickCallback

    fun setOnItemClickCallback(onItemClickCallback: OnItemClickCallback)
    {
        this.onItemClickCallback = onItemClickCallback
    }

    interface OnItemClickCallback
    {
        fun onItemClicked(data: Book)
    }

    inner class ListViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView)
    {
        var tvTitle: TextView = itemView.findViewById(R.id.tv_item_title)
        var tvAuthor: TextView = itemView.findViewById(R.id.tv_item_author)
        var imgCover: ImageView = itemView.findViewById(R.id.img_item_cover)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ListViewHolder
    {
        val view: View = LayoutInflater.from(parent.context).inflate(R.layout.item_row_book, parent, false)
        return ListViewHolder(view)
    }

    override fun onBindViewHolder(holder: ListViewHolder, position: Int)
    {
        val book = listBook[position]

        Glide.with(holder.itemView.context)
            .load(book.cover)
            .apply(RequestOptions().override(300, 400))
            .into(holder.imgCover)

        holder.tvTitle.text = book.title
        holder.tvAuthor.text = book.author

        holder.itemView.setOnClickListener { onItemClickCallback.onItemClicked(listBook[holder.absoluteAdapterPosition]) }
    }

    override fun getItemCount(): Int
    {
        return listBook.size
    }
}