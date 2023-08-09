package com.yeyintkyaw.library.mvp.presenter

import androidx.lifecycle.LifecycleOwner
import com.yeyintkyaw.library.delegates.HomeViewPagerMenuDelegate
import com.yeyintkyaw.library.mvp.view.MainView

interface MainPresenter: HomeViewPagerMenuDelegate{
    fun initView(view: MainView)
    fun onTapSearch(search: String)
}