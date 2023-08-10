package com.yeyintkyaw.library.mvp.view

import com.yeyintkyaw.library.data.vos.BookListsVO
import com.yeyintkyaw.library.data.vos.BooksVO

interface EBookView: MainView {
    fun showAllBooks(book_lists: List<BookListsVO>)
    fun navigateToBookList(list_name: String)
}