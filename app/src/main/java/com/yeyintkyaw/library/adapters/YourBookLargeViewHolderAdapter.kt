package com.yeyintkyaw.library.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.yeyintkyaw.library.R
import com.yeyintkyaw.library.delegates.FilterBottomSheetDelegate
import com.yeyintkyaw.library.delegates.HomeViewPagerMenuDelegate
import com.yeyintkyaw.library.delegates.RadioButtonDelegate
import com.yeyintkyaw.library.viewholders.YourBookListLargeViewHolder

class YourBookLargeViewHolderAdapter(private val mDelegate: HomeViewPagerMenuDelegate): RecyclerView.Adapter<YourBookListLargeViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): YourBookListLargeViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.your_book_large_view_holder, parent, false)
        return YourBookListLargeViewHolder(view, mDelegate)
    }

    override fun onBindViewHolder(holder: YourBookListLargeViewHolder, position: Int) {
    }

    override fun getItemCount(): Int = 30


}