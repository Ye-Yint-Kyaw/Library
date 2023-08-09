package com.yeyintkyaw.library.mvp.presenter

import androidx.lifecycle.LifecycleOwner
import com.yeyintkyaw.library.delegates.ClickMoreIconDelegate
import com.yeyintkyaw.library.delegates.GoBackDelegate
import com.yeyintkyaw.library.mvp.view.BookListView

interface BookListPresenter: GoBackDelegate {
    fun initView(view: BookListView)
    fun onUiReady(owner: LifecycleOwner)
    fun getDetail(owner: LifecycleOwner, query: String)
}