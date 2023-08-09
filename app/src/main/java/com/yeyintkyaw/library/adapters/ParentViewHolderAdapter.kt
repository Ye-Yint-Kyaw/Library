package com.yeyintkyaw.library.adapters

import android.annotation.SuppressLint
import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.yeyintkyaw.library.R
import com.yeyintkyaw.library.data.vos.BookListsVO
import com.yeyintkyaw.library.delegates.ClickMoreIconDelegate
import com.yeyintkyaw.library.viewholders.ParentViewHolder

class ParentViewHolderAdapter(private val mDelegate: ClickMoreIconDelegate): RecyclerView.Adapter<ParentViewHolder>() {

    private var mBookList: MutableList<BookListsVO> = mutableListOf()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ParentViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.parent_view_holder, parent, false)
        return ParentViewHolder(view, mDelegate)
    }

    override fun getItemCount(): Int {
        return mBookList.size
    }

    override fun onBindViewHolder(holder: ParentViewHolder, position: Int) {

        if (mBookList.isNotEmpty()){
            holder.bind(mBookList[position], position)
        }else{
            Log.d("ActorError", "Error!")
        }
    }

    @SuppressLint("NotifyDataSetChanged")
    fun setNewData(books: List<BookListsVO>){

        if (mBookList.isEmpty()){
            mBookList.addAll(books)
        }
        else{
            mBookList.clear()
        }

        notifyDataSetChanged()
    }
}