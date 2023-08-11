package com.yeyintkyaw.library.data.model

import android.annotation.SuppressLint
import android.util.Log
import androidx.lifecycle.LiveData
import com.yeyintkyaw.library.data.vos.BookListsVO
import com.yeyintkyaw.library.data.vos.BooksVO
import com.yeyintkyaw.library.data.vos.ResultsVO
import com.yeyintkyaw.library.data.vos.ShelfVO
import com.yeyintkyaw.library.utils.subscribeDBWithCompletable
import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers
import io.reactivex.rxjava3.schedulers.Schedulers

object BookModelImpl : BaseModel(), BookModel {
    @SuppressLint("CheckResult")
    override fun insertAllBook() {
        mBookApi.getAllBooks()
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe { bookResponse ->
                bookResponse.result?.let {
                    it.lists?.let { it1 -> mBookDatabase?.listDao()?.insertAllLists(it1)?.subscribeDBWithCompletable() }
                    Log.d("data", it.lists.toString())
                }
            }
    }

    @SuppressLint("CheckResult")
    override fun getAllBooks(
        onFailure: (String) -> Unit
    ): LiveData<List<BookListsVO>>? {
        return mBookDatabase?.listDao()?.getAllBooks()
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

    override fun insertClickedBook(book: BooksVO) {
        mBookDatabase?.bookDao()?.insertClickedBooks(book)?.subscribeDBWithCompletable()
    }

    override fun getClickedBooks(): LiveData<List<BooksVO>>? {

        return mBookDatabase?.bookDao()?.getClickedBooks()

    }

    override fun insertShelf(shelfVO: ShelfVO) {
        mBookDatabase?.shelfDao()?.insertShelf(shelfVO)?.subscribeDBWithCompletable()
    }

    override fun getCountShelf(): Int? {
        return mBookDatabase?.shelfDao()?.getCount()
    }

    override fun getAllShelves(): LiveData<List<ShelfVO>>? {
        return mBookDatabase?.shelfDao()?.getAllShelves()
    }

    override fun deleteShelf(shelfId: Int) {
        mBookDatabase?.shelfDao()?.deleteShelf(shelfId)
    }
}