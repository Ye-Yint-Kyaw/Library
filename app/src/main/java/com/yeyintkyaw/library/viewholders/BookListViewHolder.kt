package com.yeyintkyaw.library.viewholders

import android.media.Image
import android.view.View
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.yeyintkyaw.library.R
import com.yeyintkyaw.library.data.vos.BookListsVO
import com.yeyintkyaw.library.data.vos.BooksVO
import com.yeyintkyaw.library.data.vos.ResultsVO

class BookListViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
    fun bind(book: ResultsVO){
        val title: TextView = itemView.findViewById(R.id.tvBookListTitle)
        book.book_details.firstOrNull()?.let {book->
           title.text = book.title ?: ""
        }
    }
}