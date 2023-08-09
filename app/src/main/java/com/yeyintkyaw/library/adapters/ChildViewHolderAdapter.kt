package com.yeyintkyaw.library.adapters

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.yeyintkyaw.library.R
import com.yeyintkyaw.library.data.vos.BooksVO
import com.yeyintkyaw.library.delegates.BookDetailDelegate
import com.yeyintkyaw.library.delegates.ClickMoreIconDelegate
import com.yeyintkyaw.library.viewholders.ChildViewHolder

class ChildViewHolderAdapter(private val mDelegate: ClickMoreIconDelegate): RecyclerView.Adapter<ChildViewHolder>() {
    private var mBooks: MutableList<BooksVO> = mutableListOf()
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ChildViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.child_view_item, parent, false)
        return ChildViewHolder(view, mDelegate)
    }

    override fun getItemCount(): Int {
        if (mBooks.size >= 10){
            return 10
        }else{
            return mBooks.size
        }
    }

    override fun onBindViewHolder(holder: ChildViewHolder, position: Int) {
        holder.bind(mBooks[position])
    }

    @SuppressLint("NotifyDataSetChanged")
    fun setNewData(books: MutableList<BooksVO>){
        if (mBooks.isEmpty()){
            mBooks.addAll(books)
        }else{
            mBooks.clear()
        }
        notifyDataSetChanged()
    }

}