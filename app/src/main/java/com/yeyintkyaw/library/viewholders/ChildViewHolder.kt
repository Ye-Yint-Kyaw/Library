package com.yeyintkyaw.library.viewholders

import android.view.View
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.yeyintkyaw.library.R
import com.yeyintkyaw.library.data.vos.BooksVO
import com.yeyintkyaw.library.delegates.ClickMoreIconDelegate

class ChildViewHolder(itemView: View, private val mDelegate: ClickMoreIconDelegate) : RecyclerView.ViewHolder(itemView) {

    var mBook: BooksVO?=null

    init {
        itemView.setOnClickListener {
            mBook?.let { book -> mDelegate.onTapBookToDetail(book) }
        }
    }

    fun bind(book: BooksVO){

        mBook = book

        val title: TextView = itemView.findViewById(R.id.tbBookTitle)
        val image: ImageView = itemView.findViewById(R.id.ivBookListCover)
        title.text = book.title
        Glide.with(itemView.context)
            .load(book.bookImage)
            .into(image)

    }
}