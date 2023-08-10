package com.yeyintkyaw.library.utils

import android.annotation.SuppressLint
import android.util.Log
import io.reactivex.Completable
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers


@SuppressLint("CheckResult")
fun Completable.subscribeDBWithCompletable() {
    this.subscribeOn(Schedulers.io())
        .observeOn(AndroidSchedulers.mainThread())
        .subscribe ({
            Log.d("Database CRUD", "Operation is successful.")
        },{
            Log.d("Database CRUD", "Operation is a failure")
        })
}

