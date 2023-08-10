package com.yeyintkyaw.library.mvp.presenter

import androidx.lifecycle.LifecycleOwner
import com.yeyintkyaw.library.delegates.FilterBottomSheetDelegate
import com.yeyintkyaw.library.delegates.RadioButtonDelegate
import com.yeyintkyaw.library.delegates.HomeViewPagerMenuDelegate
import com.yeyintkyaw.library.mvp.view.BaseView
import com.yeyintkyaw.library.mvp.view.YourBooksView

interface YourBooksPresenter: BaseView, RadioButtonDelegate, HomeViewPagerMenuDelegate, FilterBottomSheetDelegate {
    fun initView(view: YourBooksView)
    fun onUiReady(owner: LifecycleOwner)
}