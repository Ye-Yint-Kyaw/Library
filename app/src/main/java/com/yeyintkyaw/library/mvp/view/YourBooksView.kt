package com.yeyintkyaw.library.mvp.view

import com.yeyintkyaw.library.data.vos.BookListsVO
import com.yeyintkyaw.library.data.vos.BooksVO

interface YourBooksView: BaseView , MainView{
    fun changeLayout(str: String)
    fun showFilterBottomSheet()
    fun showClickedBooks(books: List<BooksVO>)
}