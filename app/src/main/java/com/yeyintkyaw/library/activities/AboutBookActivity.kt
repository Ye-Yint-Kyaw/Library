package com.yeyintkyaw.library.activities

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import com.yeyintkyaw.library.R

class AboutBookActivity : AppCompatActivity() {
    companion object {
        fun newIntent(context: Context): Intent{
            return Intent(context, AboutBookActivity::class.java)
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_about_book)
        val back: ImageView = findViewById(R.id.ivBack)
        back.setOnClickListener {
            super.onBackPressed()
        }
    }
}