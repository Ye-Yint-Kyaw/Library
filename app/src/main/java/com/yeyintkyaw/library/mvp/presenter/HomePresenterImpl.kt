package com.yeyintkyaw.library.mvp.presenter

import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.ViewModel
import com.yeyintkyaw.library.data.model.BookModel
import com.yeyintkyaw.library.data.model.BookModelImpl
import com.yeyintkyaw.library.mvp.view.HomeView

object HomePresenterImpl:ViewModel(), HomePresenter {
    private var mView: HomeView? = null
    private var mBookModel: BookModel = BookModelImpl
    override fun initView(view: HomeView) {
        mView = view
    }

    override fun onUiReady(owner: LifecycleOwner) {
        mBookModel.getClickedBooks()?.observe(owner){
            it?.let{
                books->
                mView?.showClickedBooks(books)
            }
        }
    }

}