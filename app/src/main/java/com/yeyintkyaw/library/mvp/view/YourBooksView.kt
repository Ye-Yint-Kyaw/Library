package com.yeyintkyaw.library.mvp.view

interface YourBooksView: BaseView , MainView{
    fun changeLayout(str: String)
    fun showFilterBottomSheet()
}