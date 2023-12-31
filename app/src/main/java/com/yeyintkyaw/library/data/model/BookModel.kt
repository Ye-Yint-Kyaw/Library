package com.yeyintkyaw.library.data.model

import androidx.lifecycle.LiveData
import com.yeyintkyaw.library.data.vos.BookListsVO
import com.yeyintkyaw.library.data.vos.BooksVO
import com.yeyintkyaw.library.data.vos.ResultsVO
import com.yeyintkyaw.library.data.vos.ShelfVO

interface BookModel {
    fun insertAllBook()
    fun getAllBooks(
        onFailure: (String) -> Unit
    ): LiveData<List<BookListsVO>>?
    fun getBooksByList(
        string: String,
        onFailure: (String) -> Unit,
        onSuccess: (List<ResultsVO>) -> Unit
    )
    fun insertClickedBook(book: BooksVO)

    fun getClickedBooks(): LiveData<List<BooksVO>>?

    fun insertShelf(shelfVO: ShelfVO)

    fun getCountShelf(): Int?

    fun getAllShelves(): LiveData<List<ShelfVO>>?
    fun deleteShelf(shelfId: Int)
}