package com.yeyintkyaw.library.activities

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.EditText
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import androidx.lifecycle.ViewModelProvider
import com.yeyintkyaw.library.R
import com.yeyintkyaw.library.mvp.presenter.CreateShelfPresenter
import com.yeyintkyaw.library.mvp.presenter.CreateShelfPresenterImpl
import com.yeyintkyaw.library.mvp.view.CreateShelfView

class CreateShelfActivity : AppCompatActivity(), CreateShelfView {
    lateinit var mPresenter: CreateShelfPresenter
    companion object{
        fun newIntent(context: Context): Intent{
            return Intent(context, CreateShelfActivity::class.java,)
        }
    }
    override fun onCreate(savedInstanceState: Bundle?) {


        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_create_shelf)
        setUpPresenter()
        gpBack()
        setOnFocus()
        setUpListener()

    }
    private fun setUpListener() {
        val name: TextView = findViewById(R.id.editTextCreateShelf)
        val tvSave: TextView = findViewById(R.id.tvSave)
        tvSave.setOnClickListener {
            if (!name.text.isNullOrEmpty()){
                mPresenter.onTapBtn(name.text.toString())
                Toast.makeText(this, "You have successfully created", Toast.LENGTH_SHORT).show()
                finish()
            }else{
                showDialog()
            }
        }
    }

    private fun showDialog() {
        val dialog = AlertDialog.Builder(this)
        dialog.setMessage("Please type a name")
        dialog.setPositiveButton("Ok"){
            Dialog, it ->
        }
        val alertDialog = dialog.create()
        alertDialog.show()
    }

    private fun setUpPresenter() {
        mPresenter = ViewModelProvider(this)[CreateShelfPresenterImpl::class.java]
        (mPresenter as CreateShelfPresenterImpl).initView(this)
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

    override fun saveShelf(name: String) {
        Toast.makeText(this, name, Toast.LENGTH_SHORT).show()
        super.onBackPressed()
    }

    override fun showError(errMsg: String) {
        Toast.makeText(this, errMsg, Toast.LENGTH_SHORT).show()
    }
}