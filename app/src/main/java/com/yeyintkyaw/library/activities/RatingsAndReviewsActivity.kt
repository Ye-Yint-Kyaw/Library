package com.yeyintkyaw.library.activities

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import com.yeyintkyaw.library.R

class RatingsAndReviewsActivity : AppCompatActivity() {
    companion object{
        fun newIntent(context: Context): Intent{
            return Intent(context, RatingsAndReviewsActivity::class.java)
        }
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_ratings_and_reviews)
        val back: ImageView = findViewById(R.id.ivBack)
        back.setOnClickListener {
            super.onBackPressed()
        }
    }
}