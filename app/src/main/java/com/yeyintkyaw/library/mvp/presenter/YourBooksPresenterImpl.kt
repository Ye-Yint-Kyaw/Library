package com.yeyintkyaw.library.mvp.presenter

import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.ViewModel
import com.yeyintkyaw.library.data.model.BookModel
import com.yeyintkyaw.library.data.model.BookModelImpl
import com.yeyintkyaw.library.mvp.view.YourBooksView

private var mBookModel: BookModel = BookModelImpl

object YourBooksPresenterImpl: ViewModel(), YourBooksPresenter {

    private var mView: YourBooksView? = null

    override fun initView(view: YourBooksView) {
        mView = view
    }

    override fun onUiReady(owner: LifecycleOwner) {
        mBookModel.getClickedBooks()?.observe(owner){
            it?.let { booklist->
                mView?.showClickedBooks(booklist)
            }
        }
    }

    override fun showError(errMsg: String) {

    }


    override fun getRadioId(str: String) {
        mView?.changeLayout(str)
    }



    override fun onTapItem() {
       mView?.showBottomSheet()
    }

    override fun onTapBook() {
      //  mView?.navigateToBookDetail()
    }

    override fun filterBottomSheet() {

    }
}