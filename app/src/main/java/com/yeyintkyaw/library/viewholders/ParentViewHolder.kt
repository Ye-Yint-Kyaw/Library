package com.yeyintkyaw.library.viewholders

import android.view.View
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.yeyintkyaw.library.R
import com.yeyintkyaw.library.adapters.ChildViewHolderAdapter
import com.yeyintkyaw.library.data.vos.BookListsVO
import com.yeyintkyaw.library.delegates.ClickMoreIconDelegate

class ParentViewHolder(itemView: View, private val mDelegate: ClickMoreIconDelegate) : RecyclerView.ViewHolder(itemView) {
    private lateinit var mChildAdapter: ChildViewHolderAdapter
    private lateinit var mBookList: BookListsVO
    init {
        val more: ImageView = itemView.findViewById(R.id.ivMoreIcon)
        more.setOnClickListener {
          mBookList.listName?.let { name ->
              mDelegate.onTapMoreIcon(name)
          }
        }
    }


    fun bind(booksList: BookListsVO, pos: Int){
        mBookList = booksList
        val bookTitle: TextView = itemView.findViewById(R.id.tvEbooksHeader)
        bookTitle.text = booksList.listName

        val childRV: RecyclerView = itemView.findViewById(R.id.childRV)

        mChildAdapter = ChildViewHolderAdapter(mDelegate)
        childRV.adapter = mChildAdapter
        childRV.layoutManager = LinearLayoutManager(itemView.context, LinearLayoutManager.HORIZONTAL, false)

        booksList.books?.let {mBookList->
            mChildAdapter.setNewData(mBookList)
        }

//        val books = booksList.books
//        while (books != null && pos <= books.size){
//            mChildAdapter = ChildViewHolderAdapter(books[pos])
//        }

    }

}