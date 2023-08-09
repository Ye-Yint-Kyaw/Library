package com.yeyintkyaw.library.mvp.presenter

import androidx.lifecycle.ViewModel
import com.yeyintkyaw.library.mvp.view.YourBooksView

object YourBooksPresenterImpl: ViewModel(), YourBooksPresenter {

    private var mView: YourBooksView? = null

    override fun initView(view: YourBooksView) {
        mView = view
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