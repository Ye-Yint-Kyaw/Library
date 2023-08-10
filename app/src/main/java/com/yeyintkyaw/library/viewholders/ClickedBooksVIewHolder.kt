package com.yeyintkyaw.library.viewholders

import android.view.View
import android.widget.ImageView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.google.android.material.imageview.ShapeableImageView
import com.yeyintkyaw.library.R
import com.yeyintkyaw.library.data.vos.BooksVO
import com.yeyintkyaw.library.delegates.HomeViewPagerMenuDelegate

class ClickedBooksVIewHolder(itemView: View,delegate: HomeViewPagerMenuDelegate) : RecyclerView.ViewHolder(itemView) {


    init {
        itemView.findViewById<ImageView>(R.id.ivYourBookMenu).setOnClickListener {
            delegate.onTapItem()
        }


        itemView.findViewById<ShapeableImageView>(R.id.ivBookCover).setOnClickListener {
            delegate.onTapBook()
        }
    }

    fun bind(book: BooksVO){
        val image: ShapeableImageView = itemView.findViewById(R.id.ivBookCover)
        Glide.with(itemView.context)
            .load(book.bookImage)
            .into(image)
    }

}