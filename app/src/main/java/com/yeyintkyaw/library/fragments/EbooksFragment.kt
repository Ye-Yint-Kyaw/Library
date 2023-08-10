package com.yeyintkyaw.library.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.yeyintkyaw.library.R
import com.yeyintkyaw.library.activities.BookDetailActivity
import com.yeyintkyaw.library.activities.BookListActivity
import com.yeyintkyaw.library.adapters.ParentViewHolderAdapter
import com.yeyintkyaw.library.data.vos.BookListsVO
import com.yeyintkyaw.library.data.vos.BooksVO
import com.yeyintkyaw.library.mvp.presenter.EBookPresenter
import com.yeyintkyaw.library.mvp.presenter.EBookPresenterImpl
import com.yeyintkyaw.library.mvp.view.EBookView
import com.yeyintkyaw.library.singleton_object.DataManager

class EbooksFragment : Fragment(), EBookView {
    lateinit var mPresenter: EBookPresenter
    lateinit var mParentAdapter: ParentViewHolderAdapter
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_ebooks, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setUpPresenter()
        setUpRecyclerView(view)
        setUpListener(view)

        mPresenter.onUiReady(this)
    }

    private fun setUpRecyclerView(view: View){
        val parentRecyclerView: RecyclerView = view.findViewById(R.id.parentRV)
        mParentAdapter = ParentViewHolderAdapter(mPresenter)
        parentRecyclerView.adapter = mParentAdapter
        parentRecyclerView.layoutManager = LinearLayoutManager(requireContext(), LinearLayoutManager.VERTICAL, false)
    }

    private fun setUpListener(view: View){
//        val rv: RecyclerView = view.findViewById(R.id.parentRV)
//        val more: ImageView = rv.findViewById(R.id.ivMoreIcon)
//        more
    }

    private fun setUpPresenter(){
        mPresenter = ViewModelProvider(this)[EBookPresenterImpl::class.java]
        (mPresenter as EBookPresenterImpl).initView(this)
    }

    override fun showAllBooks(books: List<BookListsVO>) {
        mParentAdapter.setNewData(books)
    }

    override fun navigateToBookList(list_name: String) {
        startActivity(BookListActivity.newIntent(requireContext(), list_name))
    }


    override fun showBottomSheet() {
        val bottomSheetFragment = BottomSheetFragment()
        bottomSheetFragment.show(parentFragmentManager,bottomSheetFragment.tag)
    }

    override fun navigateToBookDetail(book: BooksVO) {
        DataManager.book = book
       startActivity(BookDetailActivity.newIntent(requireContext()))
    }

    override fun navigateToBookLists() {

    }

    override fun navigateToSearch(search: String) {

    }


    override fun showError(errMsg: String) {

    }


}