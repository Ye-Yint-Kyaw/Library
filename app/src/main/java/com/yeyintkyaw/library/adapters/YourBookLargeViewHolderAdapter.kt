package com.yeyintkyaw.library.adapters

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.yeyintkyaw.library.R
import com.yeyintkyaw.library.data.vos.BooksVO
import com.yeyintkyaw.library.delegates.FilterBottomSheetDelegate
import com.yeyintkyaw.library.delegates.HomeViewPagerMenuDelegate
import com.yeyintkyaw.library.delegates.RadioButtonDelegate
import com.yeyintkyaw.library.viewholders.YourBookListLargeViewHolder

class YourBookLargeViewHolderAdapter(private val mDelegate: HomeViewPagerMenuDelegate): RecyclerView.Adapter<YourBookListLargeViewHolder>() {
    private var mBook: List<BooksVO> = listOf()
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): YourBookListLargeViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.your_book_large_view_holder, parent, false)
        return YourBookListLargeViewHolder(view, mDelegate)
    }

    override fun onBindViewHolder(holder: YourBookListLargeViewHolder, position: Int) {
        holder.bind(mBook[position])
    }

    override fun getItemCount(): Int = mBook.size

    @SuppressLint("NotifyDataSetChanged")
    fun setNewData(books: List<BooksVO>){
        mBook = books
        notifyDataSetChanged()
    }

}