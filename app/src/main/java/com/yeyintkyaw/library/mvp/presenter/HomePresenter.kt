package com.yeyintkyaw.library.mvp.presenter

import androidx.lifecycle.LifecycleOwner
import com.yeyintkyaw.library.mvp.view.HomeView

interface HomePresenter {
    fun initView(view: HomeView)
    fun onUiReady(owner: LifecycleOwner)
}