package com.yeyintkyaw.library.mvp.presenter

import androidx.lifecycle.LifecycleOwner
import com.yeyintkyaw.library.delegates.ClickMoreIconDelegate
import com.yeyintkyaw.library.delegates.HomeViewPagerMenuDelegate
import com.yeyintkyaw.library.mvp.view.EBookView

interface EBookPresenter: HomeViewPagerMenuDelegate, ClickMoreIconDelegate {
    fun initView(view: EBookView)
    fun onUiReady(owner: LifecycleOwner)
}