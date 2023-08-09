package com.yeyintkyaw.library.activities

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.EditText
import android.widget.RelativeLayout
import android.widget.Toast
import androidx.cardview.widget.CardView
import androidx.fragment.app.add
import androidx.fragment.app.commit
import androidx.lifecycle.ViewModelProvider
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.yeyintkyaw.library.R
import com.yeyintkyaw.library.data.vos.BooksVO
import com.yeyintkyaw.library.fragments.HomeFragment
import com.yeyintkyaw.library.fragments.LibraryFragment
import com.yeyintkyaw.library.mvp.presenter.MainPresenter
import com.yeyintkyaw.library.mvp.presenter.MainPresenterImpl
import com.yeyintkyaw.library.mvp.view.MainView

class MainActivity : AppCompatActivity(), MainView {
    lateinit var mPresenter: MainPresenter
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setUpPresenter()
        supportFragmentManager.commit {
            replace(R.id.fragmentContainer, HomeFragment())
        }
        setUpTabLayout()
        setUpListener()

    }

    private fun setUpListener() {
        val editSearch: CardView = findViewById(R.id.viewPodSearch)
        editSearch.findViewById<RelativeLayout>(R.id.search).setOnClickListener {
            mPresenter.onTapSearch("search")
        }
    }

    private fun setUpPresenter(){
        mPresenter = ViewModelProvider(this)[MainPresenterImpl::class.java]
        (mPresenter as MainPresenterImpl).initView(this)
    }

    private fun setUpTabLayout(){
        val bottomNavigationView: BottomNavigationView = findViewById(R.id.bottomNavigationBar)
        bottomNavigationView.setOnNavigationItemSelectedListener {
            when(it.itemId){
                R.id.homeMenu -> {
                    supportFragmentManager.commit {
                        replace(R.id.fragmentContainer, HomeFragment())
                    }
                }
                R.id.libraryMenu -> {
                    supportFragmentManager.commit {
                        replace(R.id.fragmentContainer, LibraryFragment())
                    }
                }
                else -> {
                    supportFragmentManager.commit {
                        add<HomeFragment>(R.id.fragmentContainer)
                    }
                }
            }
            true
        }
    }

    override fun showBottomSheet() {

    }

    override fun navigateToBookDetail(book: BooksVO) {

    }

    override fun navigateToBookLists() {

    }

    override fun navigateToSearch(search: String) {
//        startActivity(SearchBookActivity.newIntent(this))
        Log.d("search",search)
        Toast.makeText(this, "Search", Toast.LENGTH_SHORT).show()
    }


    override fun showError(errMsg: String) {

    }
}