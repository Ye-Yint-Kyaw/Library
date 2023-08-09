package com.yeyintkyaw.library.mvp.presenter

import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.ViewModel
import com.yeyintkyaw.library.data.model.BookModel
import com.yeyintkyaw.library.data.model.BookModelImpl
import com.yeyintkyaw.library.mvp.view.BookListView

object BookListPresenterImpl : ViewModel(), BookListPresenter {

    private var mView: BookListView? = null
    private var mBookModel: BookModel = BookModelImpl
    override fun initView(view: BookListView) {
        mView = view
    }

    override fun onUiReady(owner: LifecycleOwner) {


    }

    override fun getDetail(owner: LifecycleOwner, query: String) {

        mBookModel.getBooksByList(
            query,
            onSuccess = {
                mView?.showBookList(it)
            },
            onFailure = {
                mView?.showError(it)
            })

    }

    override fun goBack() {
        mView?.back()
    }

}