package com.yeyintkyaw.library.mvp.presenter

import com.yeyintkyaw.library.mvp.view.CreateShelfView

interface CreateShelfPresenter {
    fun initView(view: CreateShelfView)
    fun onTapBtn(name: String)

}