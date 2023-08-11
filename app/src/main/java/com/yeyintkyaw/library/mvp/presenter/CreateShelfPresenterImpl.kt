package com.yeyintkyaw.library.mvp.presenter

import androidx.lifecycle.ViewModel
import com.yeyintkyaw.library.data.model.BookModel
import com.yeyintkyaw.library.data.model.BookModelImpl
import com.yeyintkyaw.library.data.vos.ShelfVO
import com.yeyintkyaw.library.mvp.view.CreateShelfView

object CreateShelfPresenterImpl: ViewModel(), CreateShelfPresenter {
    lateinit var mView: CreateShelfView
    private var mBookModel: BookModel = BookModelImpl
    override fun initView(view: CreateShelfView) {
        mView = view
    }

    override fun onTapBtn(name: String) {

        var shelfVO = ShelfVO(name)
        mBookModel.insertShelf(shelfVO)

    }
}