package com.yeyintkyaw.library.mvp.presenter

import android.util.Log
import androidx.lifecycle.ViewModel
import com.yeyintkyaw.library.data.model.BookModel
import com.yeyintkyaw.library.mvp.view.MainView

object MainPresenterImpl:ViewModel(), MainPresenter {

    //View
    private var mView: MainView? = null


    //Model
    private var mBookModel: BookModel? = null

    override fun initView(view: MainView) {
        mView = view
    }

    override fun onTapSearch(search: String) {
        Log.d("search",search)
        mView?.navigateToSearch(search)
    }


    override fun onTapItem() {
        mView?.showBottomSheet()
    }

    override fun onTapBook() {
        //mView?.navigateToBookDetail(BooksVO)
    }
}