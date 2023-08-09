package com.yeyintkyaw.library.persistence.daos

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.yeyintkyaw.library.data.vos.BookListsVO

@Dao
interface ListDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertAllLists(lists: List<BookListsVO>)



}