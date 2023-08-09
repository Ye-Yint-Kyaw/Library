package com.yeyintkyaw.library.activities

import android.annotation.SuppressLint
import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.yeyintkyaw.library.R
import com.yeyintkyaw.library.adapters.ShelfListViewHolderAdapter

class ShelfListActivity : AppCompatActivity() {
    lateinit var mAdapter: ShelfListViewHolderAdapter
    companion object{
        fun newIntent(context: Context): Intent{
            return Intent(context, ShelfListActivity::class.java)
        }
    }


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_shelf_list)
        setUpShelfList()
        setUpListener()
    }

    private fun setUpListener() {
        val close: ImageView = findViewById(R.id.ivClose)
        close.setOnClickListener {
            super.onBackPressed()
        }
    }

    private fun setUpShelfList() {
        val rvShelf: RecyclerView = findViewById(R.id.rvShelfList)
        mAdapter = ShelfListViewHolderAdapter()
        rvShelf.adapter = mAdapter
        rvShelf.layoutManager = LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false)
    }
}