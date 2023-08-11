package com.yeyintkyaw.library.mvp.presenter

import androidx.lifecycle.LifecycleOwner
import com.yeyintkyaw.library.data.vos.ShelfVO
import com.yeyintkyaw.library.delegates.ShelfClickDelegate
import com.yeyintkyaw.library.mvp.view.YourShelfView

interface YourShelfPresenter: ShelfClickDelegate {
    fun initView(view: YourShelfView)
    fun numShelf(): Int?

    fun onUiReady(owner: LifecycleOwner)
    fun onTapDelete(shelfId: Int)
}