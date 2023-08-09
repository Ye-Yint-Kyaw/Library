package com.yeyintkyaw.library.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.yeyintkyaw.library.R
import com.yeyintkyaw.library.delegates.HomeViewPagerMenuDelegate
import com.yeyintkyaw.library.viewholders.EbookViewHolder

class EbookViewHolderAdapter(private val delegate: HomeViewPagerMenuDelegate): RecyclerView.Adapter<EbookViewHolder>(){
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): EbookViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.ebooks_view_holder, parent, false)
        return EbookViewHolder(view, delegate)
    }

    override fun getItemCount(): Int = 10

    override fun onBindViewHolder(holder: EbookViewHolder, position: Int) {

    }
}