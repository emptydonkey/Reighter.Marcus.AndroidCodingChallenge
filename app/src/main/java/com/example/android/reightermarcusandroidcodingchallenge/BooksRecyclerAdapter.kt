package com.example.android.reightermarcusandroidcodingchallenge

import android.content.Context
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import com.squareup.picasso.Picasso

class BooksRecyclerAdapter(val mContext: Context, var mBooks: List<Book>?) : RecyclerView.Adapter<BooksRecyclerAdapter.ViewHolder>()  {

    val mInflater: LayoutInflater = LayoutInflater.from(mContext)

    fun addBooks(books: List<Book>?) {
        mBooks = books
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BooksRecyclerAdapter.ViewHolder {
        val itemView = mInflater.inflate(R.layout.list_item, parent, false)
        return ViewHolder(itemView)
    }

    override fun getItemCount(): Int {
        return mBooks!!.size
    }

    override fun onBindViewHolder(holder: BooksRecyclerAdapter.ViewHolder, position: Int) {
        val book = mBooks!![position]
        holder.textAuthor.text = book.author
        holder.textTitle.text = book.title
        Picasso.get().load(book.imageURL).into(holder.image)
    }

    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val textAuthor: TextView = itemView.findViewById<View>(R.id.Author_TextView) as TextView
        val textTitle: TextView = itemView.findViewById<View>(R.id.Title_TextView) as TextView
        val image: ImageView = itemView.findViewById<View>(R.id.Image_ImageView) as ImageView
    }
}