package com.yeyintkyaw.library.data.model

import androidx.lifecycle.LiveData
import com.yeyintkyaw.library.data.vos.BookListsVO
import com.yeyintkyaw.library.data.vos.BooksVO
import com.yeyintkyaw.library.data.vos.ResultsVO
import com.yeyintkyaw.library.network.responses.ListResponse

interface BookModel {
    fun getAllBooks(
        onFailure: (String) -> Unit,
        onSuccess: (List<BookListsVO>) -> Unit
    )
    fun getBooksByList(
        string: String,
        onFailure: (String) -> Unit,
        onSuccess: (List<ResultsVO>) -> Unit
    )
}