package com.yeyintkyaw.library.fragments

import android.content.res.Resources
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.commit
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.RecyclerView
import androidx.viewpager2.widget.CompositePageTransformer
import androidx.viewpager2.widget.MarginPageTransformer
import androidx.viewpager2.widget.ViewPager2
import com.google.android.material.tabs.TabLayout
import com.yeyintkyaw.library.R
import com.yeyintkyaw.library.activities.BookDetailActivity
import com.yeyintkyaw.library.adapters.ClickedBooksViewHolderAdapter
import com.yeyintkyaw.library.data.vos.BooksVO
import com.yeyintkyaw.library.mvp.presenter.HomePresenter
import com.yeyintkyaw.library.mvp.presenter.HomePresenterImpl
import com.yeyintkyaw.library.mvp.presenter.MainPresenter
import com.yeyintkyaw.library.mvp.presenter.MainPresenterImpl
import com.yeyintkyaw.library.mvp.view.HomeView
import com.yeyintkyaw.library.mvp.view.MainView


class HomeFragment : Fragment(), MainView, HomeView {

    lateinit var mPresenter: MainPresenter
    lateinit var mHomePresenter: HomePresenter

    lateinit var mClickedBookAdapter: ClickedBooksViewHolderAdapter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_home, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setUpPresenter()
        setUpViewPager()
        childFragmentManager.commit {
            replace(R.id.booksFragmentContainer, EbooksFragment())
        }
        setUpTabLayout()
        mHomePresenter.onUiReady(this)

    }
    private fun setUpPresenter(){
        mPresenter = ViewModelProvider(this)[MainPresenterImpl::class.java]
        (mPresenter as MainPresenterImpl).initView(this)

        mHomePresenter = ViewModelProvider(this)[HomePresenterImpl::class.java]
        (mHomePresenter as HomePresenterImpl).initView(this)
    }

    private fun setUpTabLayout() {
        val tlEbooks: TabLayout? = view?.findViewById(R.id.tlBooks)
        tlEbooks?.addTab(tlEbooks.newTab().setText("Ebooks"));
        tlEbooks?.addTab(tlEbooks.newTab().setText("Audiobooks"));
        tlEbooks?.addOnTabSelectedListener(object : TabLayout.OnTabSelectedListener {
            override fun onTabSelected(tab: TabLayout.Tab) {
                when(tab.position){
                    0 -> childFragmentManager.commit {
                        replace(R.id.booksFragmentContainer, EbooksFragment())
                    }
                    1 -> childFragmentManager.commit {
                        replace(R.id.booksFragmentContainer, AudiobooksFragment())
                    }
                    else -> childFragmentManager.commit {
                        replace(R.id.booksFragmentContainer, EbooksFragment())
                    }
                }
            }

            override fun onTabUnselected(tab: TabLayout.Tab) {}

            override fun onTabReselected(tab: TabLayout.Tab) {}
        })

    }

    private fun setUpViewPager() {
        val viewPagerClickedBooks: ViewPager2? = view?.findViewById(R.id.viewPagerClickedBooks)
        viewPagerClickedBooks?.apply {
            clipChildren = false  // No clipping the left and right items
            clipToPadding = false  // Show the viewpager in full width without clipping the padding
            offscreenPageLimit = 3  // Render the left and right items
            (getChildAt(0) as RecyclerView).overScrollMode =
                RecyclerView.OVER_SCROLL_NEVER // Remove the scroll effect
        }
        val compositePageTransformer = CompositePageTransformer()
        compositePageTransformer.addTransformer(MarginPageTransformer((40 * Resources.getSystem().displayMetrics.density).toInt()))
        compositePageTransformer.addTransformer { page, position ->
            val r = 1 - kotlin.math.abs(position)
            page.scaleY = (0.80f + r * 0.20f)
        }
        viewPagerClickedBooks?.setPageTransformer(compositePageTransformer)
        mClickedBookAdapter = ClickedBooksViewHolderAdapter(mPresenter)
        viewPagerClickedBooks?.adapter = mClickedBookAdapter

    }

    override fun showBottomSheet() {
//        Toast.makeText(context, "Tapped Bottom Sheet", Toast.LENGTH_SHORT).show()

        val bottomSheetFragment = BottomSheetFragment()
        bottomSheetFragment.show(parentFragmentManager,bottomSheetFragment.tag)
    }

    override fun navigateToBookDetail(book: BooksVO) {
       //startActivity(BookDetailActivity.newIntent(requireContext()))
    }

    override fun navigateToBookLists() {

    }

    override fun navigateToSearch(search: String) {
//        Toast.makeText(requireContext(), "Search", Toast.LENGTH_SHORT).show()
//        startActivity(SearchBookActivity.newIntent(requireContext()))
    }

    override fun showClickedBooks(books: List<BooksVO>) {
        mClickedBookAdapter.setNewData(books)
    }


    override fun showError(errMsg: String) {
        Toast.makeText(requireContext(), errMsg, Toast.LENGTH_SHORT).show()
    }




}