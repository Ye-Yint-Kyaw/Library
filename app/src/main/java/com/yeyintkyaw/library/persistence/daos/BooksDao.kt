package com.yeyintkyaw.library.persistence.daos

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.yeyintkyaw.library.data.vos.BooksVO
import io.reactivex.Completable

@Dao
interface BooksDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertClickedBooks(book: BooksVO): Completable

    @Query("SELECT * FROM clicked_books ORDER BY clicked_book_id DESC")
    fun getClickedBooks(): LiveData<List<BooksVO>>
}