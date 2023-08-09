package com.yeyintkyaw.library.activities

import android.content.Context
import android.content.Intent
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.EditText
import android.widget.ImageView
import androidx.annotation.RequiresApi
import com.yeyintkyaw.library.R

class CreateShelfActivity : AppCompatActivity() {
    companion object{
        fun newIntent(context: Context): Intent{
            return Intent(context, CreateShelfActivity::class.java,)
        }
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_create_shelf)
        gpBack()
        setOnFocus()


    }

    private fun setOnFocus() {
        val editText: EditText = findViewById(R.id.editTextCreateShelf)
        editText.requestFocus()
    }

    private fun gpBack() {
        val back: ImageView = findViewById(R.id.ivShelfBack)
        back.setOnClickListener {
            super.onBackPressed()
        }
    }
}