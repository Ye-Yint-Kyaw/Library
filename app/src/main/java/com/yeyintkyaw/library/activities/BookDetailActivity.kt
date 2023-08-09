package com.yeyintkyaw.library.activities

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import com.bumptech.glide.Glide
import com.yeyintkyaw.library.R
import com.yeyintkyaw.library.data.vos.BooksVO
import com.yeyintkyaw.library.singleton_object.DataManager

class BookDetailActivity : AppCompatActivity() {
    companion object{
        private const val BOOK = "BOOK"
        fun newIntent(context: Context): Intent{
              return Intent(context, BookDetailActivity::class.java)
//            intent.putExtra(BOOK_ID, movieId)
//            return intent
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_book_detail)
        setUpListener()
        val book = DataManager.book
        book?.let {
            requestData(it)
        }
    }

    private fun requestData(book: BooksVO) {
        val image: ImageView = findViewById(R.id.iBookCover)
        val title: TextView = findViewById(R.id.tvBookText)
        val author: TextView = findViewById(R.id.tvSubTaskOne)
        val description: TextView = findViewById(R.id.tvAboutTitle)

        title.text = book.title
        author.text = book.author
        description.text = book.description
        Glide.with(this)
            .load(book.bookImage)
            .into(image)
    }

    private fun setUpListener(){
        val back: ImageView = findViewById(R.id.ivBack)
        back.setOnClickListener {
            super.onBackPressed()
        }
        val goAbout: ImageView = findViewById(R.id.ivAboutMoreIcon)
        goAbout.setOnClickListener {
            startActivity(AboutBookActivity.newIntent(this))
        }
        val goRating: ImageView = findViewById(R.id.ivRatingMoreIcon)
        goRating.setOnClickListener {
            startActivity(RatingsAndReviewsActivity.newIntent(this))
        }
    }
}