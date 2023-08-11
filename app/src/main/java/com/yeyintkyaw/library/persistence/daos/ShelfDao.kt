package com.yeyintkyaw.library.persistence.daos

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.yeyintkyaw.library.data.vos.BooksVO
import com.yeyintkyaw.library.data.vos.ShelfVO
import io.reactivex.Completable
import retrofit2.http.GET

@Dao
interface ShelfDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertShelf(shelfVO: ShelfVO): Completable

    @Query("SELECT COUNT(shelf_name) FROM shelf")
    fun getCount(): Int

    @Query("SELECT * FROM shelf")
    fun getAllShelves(): LiveData<List<ShelfVO>>

    @Query("DELETE FROM shelf WHERE shelf_id = :shelfId")
    fun deleteShelf(shelfId: Int)
}