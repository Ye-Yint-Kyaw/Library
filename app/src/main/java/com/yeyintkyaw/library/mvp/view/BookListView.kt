package com.yeyintkyaw.library.mvp.view

import com.yeyintkyaw.library.data.vos.ResultsVO

interface BookListView: BaseView {
    fun back()
    fun showBookList(books: List<ResultsVO>)
}