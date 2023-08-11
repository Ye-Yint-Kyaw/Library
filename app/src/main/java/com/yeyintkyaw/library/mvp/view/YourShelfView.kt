package com.yeyintkyaw.library.mvp.view

import com.yeyintkyaw.library.data.vos.ShelfVO

interface YourShelfView: BaseView {
    fun showAllShelves(shelves: List<ShelfVO>)
    fun showDialog(shelfId: Int)
}