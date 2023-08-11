package com.yeyintkyaw.library.viewholders

import android.annotation.SuppressLint
import android.provider.ContactsContract.CommonDataKinds.Im
import android.view.View
import android.widget.ImageView
import android.widget.RelativeLayout
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.yeyintkyaw.library.R
import com.yeyintkyaw.library.data.vos.ShelfVO
import com.yeyintkyaw.library.delegates.ShelfClickDelegate

class ShelfViewHolder(itemView: View, private val mDelegate: ShelfClickDelegate): RecyclerView.ViewHolder(itemView) {
    lateinit var mShelf: ShelfVO
    init {
        val shelf: RelativeLayout = itemView.findViewById(R.id.rlShelfRow)
        shelf.setOnLongClickListener{
//            Toast.makeText(itemView.context, "Hi", Toast.LENGTH_SHORT).show()
            mShelf.shelfId?.let { shelfId-> mDelegate.onTapShelf(shelfId) }
            true
        }
    }
    @SuppressLint("SetTextI18n")
    fun bind(shelf: ShelfVO){
        mShelf = shelf
        val ivBookOne: ImageView = itemView.findViewById(R.id.ivShelfBookOne)
        val ivBookTwo: ImageView = itemView.findViewById(R.id.ivShelfBookTwo)
        val tvShelfName: TextView = itemView.findViewById(R.id.tvBooksShelfName)
        val tvNumberOfBooks: TextView = itemView.findViewById(R.id.tvNumberOfBooks)
        val num = shelf.bookLists?.size
        tvShelfName.text = shelf.shelfName
        if (num != null) {
            if (num > 1){
                tvNumberOfBooks.text = "$num books"
            }else{
                tvNumberOfBooks.text = "$num book"
            }
        }
        val imageURL = shelf.bookLists?.firstOrNull()?.bookImage
        if (!imageURL.isNullOrEmpty()){
            Glide.with(itemView.context)
                .load(imageURL)
                .into(ivBookOne)
        }else{
            Glide.with(itemView.context)
                .load(R.drawable.book)
                .into(ivBookOne)
        }

    }
}