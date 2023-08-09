package com.yeyintkyaw.library.network

import com.yeyintkyaw.library.data.vos.BooksVO
import com.yeyintkyaw.library.network.responses.BookResponse
import com.yeyintkyaw.library.network.responses.ListResponse
import com.yeyintkyaw.library.utils.API_KEY
import com.yeyintkyaw.library.utils.GET_ALL_BOOKS
import com.yeyintkyaw.library.utils.GET_BOOKS_BY_LIST
import com.yeyintkyaw.library.utils.PARAM_API_KEY
import com.yeyintkyaw.library.utils.PARAM_LIST
import io.reactivex.rxjava3.core.Observable
import retrofit2.http.GET
import retrofit2.http.Query

interface BookApi {
    @GET(GET_ALL_BOOKS)
    fun getAllBooks(
        @Query(PARAM_API_KEY) apiKey: String = API_KEY
    ):Observable<BookResponse>

    @GET(GET_BOOKS_BY_LIST)
    fun getBooksByList(
        @Query(PARAM_LIST) list: String,
        @Query(PARAM_API_KEY) apiKey: String = API_KEY,

    ):Observable<ListResponse>
}