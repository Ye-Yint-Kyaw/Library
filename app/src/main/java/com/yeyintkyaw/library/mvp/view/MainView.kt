package com.yeyintkyaw.library.mvp.view

import com.yeyintkyaw.library.data.vos.BooksVO

interface MainView: BaseView {
    fun showBottomSheet()
    fun navigateToBookDetail(book: BooksVO)
    fun navigateToBookLists()
    fun navigateToSearch(search: String)
}