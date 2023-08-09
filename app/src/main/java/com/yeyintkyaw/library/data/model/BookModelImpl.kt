package com.yeyintkyaw.library.data.model

import android.annotation.SuppressLint
import androidx.lifecycle.LiveData
import com.yeyintkyaw.library.data.vos.BookListsVO
import com.yeyintkyaw.library.data.vos.BooksVO
import com.yeyintkyaw.library.data.vos.ResultsVO
import com.yeyintkyaw.library.network.responses.ListResponse
import com.yeyintkyaw.library.utils.API_KEY
import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers
import io.reactivex.rxjava3.schedulers.Schedulers

object BookModelImpl : BaseModel(), BookModel {
    @SuppressLint("CheckResult")
    override fun getAllBooks(
        onFailure: (String) -> Unit,
        onSucess: (List<BookListsVO>) -> Unit
    ) {

        mBookApi.getAllBooks()
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe({bookResponse->
                bookResponse.result?.let {
                    mBookDatabase?.listDao()?.insertAllLists(it.lists)
                    onSucess(it.lists)
                }
            }, {
                onFailure(it.message.toString())
            })
    }

    @SuppressLint("CheckResult")
    override fun getBooksByList(
        str: String,
        onFailure: (String) -> Unit,
        onSuccess: (List<ResultsVO>) -> Unit
    ) {
        mBookApi.getBooksByList(str)
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe({
                onSuccess(it.results)
            },{
                onFailure(it.message.toString())
            })
    }
}