package com.yeyintkyaw.library.viewholders

import android.view.View
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.yeyintkyaw.library.R
import com.yeyintkyaw.library.data.vos.BooksVO
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
    fun bind(book: BooksVO){
        val title: TextView = itemView.findViewById(R.id.tvYourBookTitle)
        val image: ImageView = itemView.findViewById(R.id.ivYourBookListBookCover)
        title.text = book.title
        Glide.with(itemView.context)
            .load(book.bookImage)
            .into(image)
    }
}