package com.yeyintkyaw.library.viewpods

import android.content.Context
import android.util.AttributeSet
import android.widget.RelativeLayout
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.yeyintkyaw.library.R
import com.yeyintkyaw.library.adapters.EbookViewHolderAdapter
import com.yeyintkyaw.library.delegates.HomeViewPagerMenuDelegate
import com.yeyintkyaw.library.mvp.presenter.EBookPresenter
import com.yeyintkyaw.library.mvp.presenter.MainPresenter

class EbooksViewPod @JvmOverloads constructor(context: Context, attrs: AttributeSet? = null
): RelativeLayout(context, attrs) {

    lateinit var mEbookViewHolderAdapter: EbookViewHolderAdapter

    override fun onFinishInflate() {
        super.onFinishInflate()
    }

     fun setUpEbooks(mPresenter: EBookPresenter){
        val rvEbooks: RecyclerView = findViewById(R.id.rvEbook)
        mEbookViewHolderAdapter = EbookViewHolderAdapter(mPresenter)
        rvEbooks.adapter = mEbookViewHolderAdapter
        rvEbooks.layoutManager = LinearLayoutManager(context, LinearLayoutManager.HORIZONTAL, false)
    }
}