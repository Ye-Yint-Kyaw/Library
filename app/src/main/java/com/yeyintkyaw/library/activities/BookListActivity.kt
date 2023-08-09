package com.yeyintkyaw.library.activities

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import android.widget.Toast
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.yeyintkyaw.library.R
import com.yeyintkyaw.library.adapters.BookListViewHolderAdapter
import com.yeyintkyaw.library.data.vos.ResultsVO
import com.yeyintkyaw.library.mvp.presenter.BookListPresenter
import com.yeyintkyaw.library.mvp.presenter.BookListPresenterImpl
import com.yeyintkyaw.library.mvp.view.BookListView

class BookListActivity : AppCompatActivity(), BookListView {
    private lateinit var mBookListPresenter: BookListPresenter
    companion object{
        private const val BOOK_LIST_NAME = "BOOK_LIST_NAME"

        fun newIntent(context: Context, book_list_name: String): Intent {
            val intent = Intent(context, BookListActivity::class.java)
            intent.putExtra(BOOK_LIST_NAME, book_list_name)
            return intent
        }
    }
    private lateinit var mBookListAdapter: BookListViewHolderAdapter
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_book_list)
        setUpPresenter()
        getIntentExtra()
        setUpAdapter()
        setUpListener()
        mBookListPresenter.onUiReady(this)

    }

    private fun getIntentExtra() {
        val name = intent?.getStringExtra(BOOK_LIST_NAME)
        if (name != null) {
            mBookListPresenter.getDetail(this,name)
        }
    }

    private fun setUpPresenter() {
        mBookListPresenter = ViewModelProvider(this)[BookListPresenterImpl::class.java]
        (mBookListPresenter as BookListPresenterImpl).initView(this)
    }

    private fun setUpListener(){
        val back: ImageView = findViewById(R.id.ivBack)
        back.setOnClickListener {
            super.onBackPressed()
        }
    }
    private fun setUpAdapter(){
        val rvMoreBooks: RecyclerView = findViewById(R.id.rvMoreBooks)
        mBookListAdapter = BookListViewHolderAdapter()
        rvMoreBooks.adapter = mBookListAdapter
        rvMoreBooks.layoutManager = GridLayoutManager(this, 2)
    }

    override fun back() {
        super.onBackPressed()
    }

    override fun showBookList(books: List<ResultsVO>) {
        mBookListAdapter.setNewData(books)
    }


    override fun showError(errMsg: String) {
        Toast.makeText(this, "$errMsg",Toast.LENGTH_LONG ).show()
    }
}