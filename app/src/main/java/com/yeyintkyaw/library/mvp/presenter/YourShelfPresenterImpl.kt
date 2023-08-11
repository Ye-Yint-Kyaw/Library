package com.yeyintkyaw.library.mvp.presenter

import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.ViewModel
import com.yeyintkyaw.library.data.model.BookModel
import com.yeyintkyaw.library.data.model.BookModelImpl
import com.yeyintkyaw.library.mvp.view.YourShelfView

object YourShelfPresenterImpl: ViewModel(), YourShelfPresenter {
    private var mView: YourShelfView? = null
    private var mBookModel: BookModel = BookModelImpl
    override fun initView(view: YourShelfView) {
        mView = view
    }

    override fun numShelf(): Int? {
        return mBookModel.getCountShelf()
    }

    override fun onUiReady(owner: LifecycleOwner) {
        mBookModel.getAllShelves()?.observe(owner){
            it?.let {
                shelves ->
                mView?.showAllShelves(shelves)
            }
        }
    }

    override fun onTapDelete(shelfId: Int) {
        mBookModel.deleteShelf(shelfId)
    }

    override fun onTapShelf(shelfId: Int) {
        mView?.showDialog(shelfId)
    }
}