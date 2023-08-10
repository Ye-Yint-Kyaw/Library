package com.yeyintkyaw.library.persistence.daos

import androidx.room.Insert
import androidx.room.OnConflictStrategy
import com.yeyintkyaw.library.data.vos.BooksVO
import io.reactivex.Completable

interface ClickedBookDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertClickedBook(book: BooksVO): Completable
}