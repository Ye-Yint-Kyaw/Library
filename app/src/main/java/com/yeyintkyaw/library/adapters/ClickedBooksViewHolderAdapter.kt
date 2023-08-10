package com.yeyintkyaw.library.adapters

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.yeyintkyaw.library.R
import com.yeyintkyaw.library.data.vos.BooksVO
import com.yeyintkyaw.library.delegates.HomeViewPagerMenuDelegate
import com.yeyintkyaw.library.viewholders.ClickedBooksVIewHolder

class ClickedBooksViewHolderAdapter(private val delegate: HomeViewPagerMenuDelegate)
    : RecyclerView.Adapter<ClickedBooksVIewHolder>() {
    private var mBook: List<BooksVO> = listOf()
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ClickedBooksVIewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.clicked_book_view_holder, parent, false)
        return ClickedBooksVIewHolder(view,delegate)
    }

    override fun getItemCount(): Int = mBook.size
    override fun onBindViewHolder(holder: ClickedBooksVIewHolder, position: Int) {
        holder.bind(mBook[position])
    }

    @SuppressLint("NotifyDataSetChanged")
    fun setNewData(books: List<BooksVO>){
        mBook = books
        notifyDataSetChanged()
    }

}