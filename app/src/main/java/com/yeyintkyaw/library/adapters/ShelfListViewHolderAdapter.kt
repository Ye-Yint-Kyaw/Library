package com.yeyintkyaw.library.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.yeyintkyaw.library.R
import com.yeyintkyaw.library.viewholders.ShelfListViewHolder

class ShelfListViewHolderAdapter: RecyclerView.Adapter<ShelfListViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ShelfListViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.shelf_list_view_holder, parent, false)
        return ShelfListViewHolder(view)
    }

    override fun getItemCount(): Int{
        return 4
    }

    override fun onBindViewHolder(holder: ShelfListViewHolder, position: Int) {

    }
}