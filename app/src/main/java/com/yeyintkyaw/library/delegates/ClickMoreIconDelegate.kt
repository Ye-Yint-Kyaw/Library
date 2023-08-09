package com.yeyintkyaw.library.delegates

import com.yeyintkyaw.library.data.vos.BooksVO

interface ClickMoreIconDelegate {
    fun onTapMoreIcon(list_name: String)
    fun onTapBookToDetail(book: BooksVO)
}