package com.yeyintkyaw.library.data.vos

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.google.gson.annotations.SerializedName


@Entity(tableName = "books")
data class BooksVO(
    @SerializedName("author")
    @ColumnInfo("author")
    val author: String?,

    @SerializedName("book_image")
    @ColumnInfo("book_image")
    val bookImage: String?,

    @SerializedName("contributor")
    @ColumnInfo("contributor")
    val contributor: String?,

    @SerializedName("description")
    @ColumnInfo("description")
    val description: String?,

    @SerializedName("publisher")
    @ColumnInfo("publisher")
    val publisher: String?,

    @SerializedName("rank")
    @ColumnInfo("rank")
    val rank: Int?,

    @SerializedName("rank_last_week")
    @ColumnInfo("rank_last_week")
    val rankLastWeek: String?,

    @SerializedName("title")
    @ColumnInfo("title")
    val title: String?,

    @SerializedName("primary_isbn13")
    @ColumnInfo("primary_isbn13")
    @PrimaryKey
    val primaryIsbn13: String?,

    @ColumnInfo("isClicked")
    val isClicked: Boolean
)