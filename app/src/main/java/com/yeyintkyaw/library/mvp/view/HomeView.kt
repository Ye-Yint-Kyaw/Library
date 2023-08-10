package com.yeyintkyaw.library.mvp.view

import com.yeyintkyaw.library.data.vos.BooksVO

interface HomeView: BaseView {
    fun showClickedBooks(books: List<BooksVO>)
}