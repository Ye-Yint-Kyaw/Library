package com.yeyintkyaw.library.data.vos

import com.google.gson.annotations.SerializedName

data class ResultsVO(
    @SerializedName("bestsellers_date")
    val bestsellers_date: String?,

    @SerializedName("display_name")
    val display_name: String?,

    @SerializedName("published_date")
    val published_date: String?,

    @SerializedName("published_date_description")
    val published_date_description: String?,

    @SerializedName("previous_published_date")
    val previous_published_date: String?,

    @SerializedName("next_published_date")
    val next_published_date: String?,

    @SerializedName("lists")
    val lists: List<BookListsVO>,

    @SerializedName("book_details")
    val book_details: List<BooksVO>
)