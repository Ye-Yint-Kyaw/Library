package com.yeyintkyaw.library.adapters

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.yeyintkyaw.library.R
import com.yeyintkyaw.library.data.vos.BookListsVO
import com.yeyintkyaw.library.data.vos.BooksVO
import com.yeyintkyaw.library.data.vos.ResultsVO
import com.yeyintkyaw.library.viewholders.BookListViewHolder

class BookListViewHolderAdapter: RecyclerView.Adapter<BookListViewHolder>() {
    private var mBooks: List<ResultsVO> = listOf()
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BookListViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.book_list_view_holder, parent, false)
        return BookListViewHolder(view)
    }

    override fun getItemCount(): Int = mBooks.size

    override fun onBindViewHolder(holder: BookListViewHolder, position: Int) {
        holder.bind(mBooks[position])
    }
    @SuppressLint("NotifyDataSetChanged")
    fun setNewData(book: List<ResultsVO>){
        mBooks = book
        notifyDataSetChanged()
    }
}