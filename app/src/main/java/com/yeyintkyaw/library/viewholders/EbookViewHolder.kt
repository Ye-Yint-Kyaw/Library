package com.yeyintkyaw.library.viewholders

import android.view.View
import android.widget.ImageView
import androidx.cardview.widget.CardView
import androidx.recyclerview.widget.RecyclerView
import com.yeyintkyaw.library.R
import com.yeyintkyaw.library.delegates.HomeViewPagerMenuDelegate

class EbookViewHolder(itemView: View, delegate: HomeViewPagerMenuDelegate) : RecyclerView.ViewHolder(itemView) {
    init {
        itemView.findViewById<ImageView>(R.id.ivEbooksForYouMenu).setOnClickListener {
            delegate.onTapItem()
        }
        itemView.findViewById<CardView>(R.id.cvEbooks).setOnClickListener {
            delegate.onTapBook()
        }
    }
}