package com.yeyintkyaw.library.network.responses

import com.google.gson.annotations.SerializedName
import com.yeyintkyaw.library.data.vos.ResultsVO

data class BookResponse (
        @SerializedName("status")
        val status: String?,

        @SerializedName("copyright")
        val copyright: String?,

        @SerializedName("num_results")
        val num_results: Int?,

        @SerializedName("results")
        val result: ResultsVO?
        )