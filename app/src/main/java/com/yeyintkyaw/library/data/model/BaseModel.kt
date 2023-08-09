package com.yeyintkyaw.library.data.model

import android.content.Context
import com.yeyintkyaw.library.network.BookApi
import com.yeyintkyaw.library.persistence.BookDatabase
import com.yeyintkyaw.library.utils.BASE_URL
import hu.akarnokd.rxjava3.retrofit.RxJava3CallAdapterFactory
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit

abstract class BaseModel {
    protected lateinit var mBookApi: BookApi
    protected var mBookDatabase: BookDatabase? = null

     fun init(context: Context){
        initNetwork(context)
        initDatabase(context)
    }

    private fun initDatabase(context: Context) {
        mBookDatabase = BookDatabase.getDBInstant(context)
    }

    private fun initNetwork(context: Context){
        val mOkHttpClient = OkHttpClient.Builder()
            .connectTimeout(15, TimeUnit.SECONDS)
            .readTimeout(15, TimeUnit.SECONDS)
            .writeTimeout(15, TimeUnit.SECONDS)
            .build()

        val retrofit = Retrofit.Builder()
            .baseUrl(BASE_URL)
            .client(mOkHttpClient)
            .addConverterFactory(GsonConverterFactory.create())
            .addCallAdapterFactory(RxJava3CallAdapterFactory.create())
            .build()

        mBookApi = retrofit.create(BookApi::class.java)
    }


}