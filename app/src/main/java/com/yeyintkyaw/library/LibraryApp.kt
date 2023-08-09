package com.yeyintkyaw.library

import android.app.Application
import android.content.Context
import com.yeyintkyaw.library.data.model.BaseModel
import com.yeyintkyaw.library.data.model.BookModelImpl

class LibraryApp: Application() {
    override fun onCreate() {
        super.onCreate()
        application = applicationContext
        BookModelImpl.init(application)
    }

    companion object{
        const val TAG="LibraryApp"
        lateinit var application: Context
    }
}