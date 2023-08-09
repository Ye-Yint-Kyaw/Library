package com.yeyintkyaw.library.network.responses

import com.google.gson.annotations.SerializedName
import com.yeyintkyaw.library.data.vos.ResultsVO

data class ListResponse (
    @SerializedName("results")
    val results: List<ResultsVO>
        )