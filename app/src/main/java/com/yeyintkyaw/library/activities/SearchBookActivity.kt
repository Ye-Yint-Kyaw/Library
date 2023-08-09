package com.yeyintkyaw.library.activities

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import com.yeyintkyaw.library.R

class SearchBookActivity : AppCompatActivity() {
    companion object{
        fun newIntent(context: Context): Intent{
            return Intent(context, SearchBookActivity::class.java)
        }
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_search_book)
        goBack()
    }

    private fun goBack() {
        val back: ImageView = findViewById(R.id.ivBackSearch)
        back.setOnClickListener {
            super.onBackPressed()
        }
    }
}