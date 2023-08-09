package com.yeyintkyaw.library.data.vos

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.google.gson.annotations.SerializedName

@Entity(tableName = "lists")
data class BookListsVO(
    @SerializedName("list_id")
    @ColumnInfo(name = "list_id")
    @PrimaryKey
    val listId: Int?,

    @SerializedName("list_name")
    @ColumnInfo(name = "list_name")
    val listName: String?,

    @SerializedName("list_name_encoded")
    @ColumnInfo(name = "list_name_encoded")
    val listNameEncoded: String?,

    @SerializedName("display_name")
    @ColumnInfo(name = "display_name")
    val displayName: String?,

    @SerializedName("updated")
    @ColumnInfo(name = "updated")
    val updated: String?,

    @SerializedName("books")
    @ColumnInfo(name = "books")
    val books: MutableList<BooksVO>?
)