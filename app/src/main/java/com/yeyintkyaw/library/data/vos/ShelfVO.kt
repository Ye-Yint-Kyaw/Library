package com.yeyintkyaw.library.data.vos

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "shelf")
data class ShelfVO (
    @ColumnInfo("shelf_name")
    val shelfName: String? = null,

    @ColumnInfo("books_list")
    val bookLists: List<BooksVO>? = null,

    @ColumnInfo("shelf_id")
    @PrimaryKey(autoGenerate = true)
    val shelfId: Int?=null,

)