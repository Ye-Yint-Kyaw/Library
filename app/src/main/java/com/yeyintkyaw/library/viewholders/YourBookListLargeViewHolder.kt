package com.yeyintkyaw.library.viewholders

import android.view.View
import android.widget.ImageView
import androidx.recyclerview.widget.RecyclerView
import com.yeyintkyaw.library.R
import com.yeyintkyaw.library.delegates.FilterBottomSheetDelegate
import com.yeyintkyaw.library.delegates.HomeViewPagerMenuDelegate
import com.yeyintkyaw.library.delegates.RadioButtonDelegate

class YourBookListLargeViewHolder(itemView: View, private val mDelegate: HomeViewPagerMenuDelegate) : RecyclerView.ViewHolder(itemView) {
    init {
        val menu: ImageView = itemView.findViewById(R.id.ivYourBookMenu)
        menu.setOnClickListener {
            mDelegate.onTapItem()
        }
        val book: ImageView = itemView.findViewById(R.id.ivYourBookListBookCover)
        book.setOnClickListener {
            mDelegate.onTapBook()
        }
    }
}