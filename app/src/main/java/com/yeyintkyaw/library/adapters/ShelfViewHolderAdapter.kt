package com.yeyintkyaw.library.adapters

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.yeyintkyaw.library.R
import com.yeyintkyaw.library.data.vos.ShelfVO
import com.yeyintkyaw.library.delegates.ShelfClickDelegate
import com.yeyintkyaw.library.viewholders.ShelfViewHolder

class ShelfViewHolderAdapter(private val mDelegate: ShelfClickDelegate): RecyclerView.Adapter<ShelfViewHolder>() {
    private var mShelf: List<ShelfVO> = listOf()
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ShelfViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.shelf_view_holder, parent, false)
        return ShelfViewHolder(view, mDelegate)
    }

    override fun getItemCount(): Int {
        return mShelf.size
    }

    override fun onBindViewHolder(holder: ShelfViewHolder, position: Int) {
        holder.bind(mShelf[position])
    }
    @SuppressLint("NotifyDataSetChanged")
    fun setNewData(shelves: List<ShelfVO>){
        mShelf = shelves
        notifyDataSetChanged()
    }
}