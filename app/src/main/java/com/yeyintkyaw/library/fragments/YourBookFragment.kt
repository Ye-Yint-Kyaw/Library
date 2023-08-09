package com.yeyintkyaw.library.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.yeyintkyaw.library.R
import com.yeyintkyaw.library.adapters.YourBookLargeViewHolderAdapter
import com.yeyintkyaw.library.data.vos.BooksVO
import com.yeyintkyaw.library.mvp.presenter.YourBooksPresenter
import com.yeyintkyaw.library.mvp.presenter.YourBooksPresenterImpl
import com.yeyintkyaw.library.mvp.view.YourBooksView


class YourBookFragment : Fragment(), YourBooksView {
    lateinit var mPresenter: YourBooksPresenter
    private lateinit var mAdapterLarge: YourBookLargeViewHolderAdapter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_your_book, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setUpPresenter()
        setUpRecyclerViews()
        setUpListeners(view)
    }

    private fun setUpPresenter() {
        mPresenter = ViewModelProvider(this)[YourBooksPresenterImpl::class.java]
        (mPresenter as YourBooksPresenterImpl).initView(this)
    }

    private fun setUpListeners(view: View) {
        val ivList: ImageView = view.findViewById(R.id.ivList)
        ivList.setOnClickListener {
            showFilterBottomSheet()
        }
    }

     override fun showBottomSheet() {
         val bottomSheetFragment = BottomSheetFragment()
         bottomSheetFragment.show(parentFragmentManager,bottomSheetFragment.tag)
    }

    override fun navigateToBookDetail(book: BooksVO) {
//        startActivity(BookDetailActivity.newIntent(requireContext()))
    }

    override fun navigateToBookLists() {

    }

    override fun navigateToSearch(search: String) {

    }



    private fun setUpRecyclerViews() {
        val rvYourBookLarge: RecyclerView? = view?.findViewById(R.id.rvYourBooksLarge)
        mAdapterLarge = YourBookLargeViewHolderAdapter(mPresenter)
        rvYourBookLarge?.adapter = mAdapterLarge
        rvYourBookLarge?.layoutManager = GridLayoutManager(requireContext(), 2)

    }

    private fun setUpSmallRecyclerViews() {
        val rvYourBookLarge: RecyclerView? = view?.findViewById(R.id.rvYourBooksLarge)
        mAdapterLarge = YourBookLargeViewHolderAdapter(mPresenter)
        rvYourBookLarge?.adapter = mAdapterLarge
        rvYourBookLarge?.layoutManager = GridLayoutManager(requireContext(), 3)

    }


    override fun changeLayout(str: String) {
        when(str){
            "large" -> setUpRecyclerViews()
            "small" -> setUpSmallRecyclerViews()
        }
    }

    override fun showFilterBottomSheet() {
        val bottomSheetFilterFragment = BottomSheetFilterFragment()
        bottomSheetFilterFragment.setBottomSheetDelegate(mPresenter)
        bottomSheetFilterFragment.show(parentFragmentManager, bottomSheetFilterFragment.tag)
    }

    override fun showError(errMsg: String) {

    }


}