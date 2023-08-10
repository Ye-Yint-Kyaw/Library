package com.yeyintkyaw.library.mvp.presenter

import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.ViewModel
import com.yeyintkyaw.library.data.model.BookModel
import com.yeyintkyaw.library.data.model.BookModelImpl
import com.yeyintkyaw.library.data.vos.BooksVO
import com.yeyintkyaw.library.data.vos.ClickedBooksVO
import com.yeyintkyaw.library.mvp.view.EBookView

object EBookPresenterImpl: ViewModel(), EBookPresenter {

    private var mView: EBookView? = null

    private var mBookModel: BookModel = BookModelImpl

    override fun initView(view: EBookView) {
        mView = view
    }

    override fun onUiReady(owner: LifecycleOwner) {
       mBookModel.getAllBooks {
           mView?.showError(it)
       }?.observe(owner){
           mView?.showAllBooks(it)
       }
        //mBookModel.insertAllBook()

    }

    override fun onTapItem() {
        mView?.showBottomSheet()
    }

    override fun onTapBook() {

    }

    override fun onTapBookToDetail(book: BooksVO) {
        mBookModel?.insertClickedBook(book)
        mView?.navigateToBookDetail(book)
    }

    override fun onTapMoreIcon(list_name: String) {
        mView?.navigateToBookList(list_name)
    }


}