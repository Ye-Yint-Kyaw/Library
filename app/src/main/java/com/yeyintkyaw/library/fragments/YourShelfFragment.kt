package com.yeyintkyaw.library.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.RelativeLayout
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import androidx.cardview.widget.CardView
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.yeyintkyaw.library.R
import com.yeyintkyaw.library.activities.CreateShelfActivity
import com.yeyintkyaw.library.adapters.ShelfViewHolderAdapter
import com.yeyintkyaw.library.data.vos.ShelfVO
import com.yeyintkyaw.library.mvp.presenter.YourShelfPresenter
import com.yeyintkyaw.library.mvp.presenter.YourShelfPresenterImpl
import com.yeyintkyaw.library.mvp.view.YourShelfView


class YourShelfFragment : Fragment(), YourShelfView {
    private lateinit var mPresenter: YourShelfPresenter
    private lateinit var mAdapter: ShelfViewHolderAdapter
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_your_shelf, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setUpPresenter()
//        setUpHideShow(view)
        setUpAdapter(view)
        setUpListener(view)
        mPresenter.onUiReady(this)
    }

    private fun setUpHideShow(shelfList: List<ShelfVO>) {
        val noShelf: RelativeLayout? = view?.findViewById(R.id.rlNoShelf)
        val shelf: RelativeLayout? = view?.findViewById(R.id.rlShelf)

        if (shelfList.isEmpty()) {
            shelf?.visibility = View.GONE
            noShelf?.visibility = View.VISIBLE
        }else{
            noShelf?.visibility = View.GONE
            shelf?.visibility =View.VISIBLE
        }
}

    private fun setUpAdapter(view: View) {
        val rvShelf: RecyclerView = view.findViewById(R.id.rvShelf)
        mAdapter = ShelfViewHolderAdapter(mPresenter)
        rvShelf.adapter = mAdapter
        rvShelf.layoutManager = LinearLayoutManager(requireContext(), LinearLayoutManager.VERTICAL, false)
    }

    private fun setUpPresenter() {
        mPresenter = ViewModelProvider(this)[YourShelfPresenterImpl::class.java]
        (mPresenter as YourShelfPresenterImpl).initView(this)
    }

    private fun setUpListener(view: View) {
        val fabBtn: CardView = view.findViewById(R.id.fabCreateBtn)
        fabBtn.setOnClickListener{
            startActivity(CreateShelfActivity.newIntent(requireContext()))
        }
    }

    override fun showAllShelves(shelves: List<ShelfVO>) {
        setUpHideShow(shelves)
        mAdapter.setNewData(shelves)
    }

    override fun showDialog(shelfId: Int) {
            val alertDialogBuilder = context?.let { AlertDialog.Builder(it) }
            alertDialogBuilder?.setMessage("Are you sure you want to continue?")
            alertDialogBuilder?.setPositiveButton("Yes") { dialog, which ->
                mPresenter.onTapDelete(shelfId)
                Toast.makeText(requireContext(), "You have successfully deleted", Toast.LENGTH_SHORT).show()
            }
            alertDialogBuilder?.setNegativeButton("Cancel") { dialog, which ->

            }

            val alertDialog = alertDialogBuilder?.create()
            alertDialog?.show()
    }

    override fun showError(errMsg: String) {
        Toast.makeText(requireContext(), errMsg, Toast.LENGTH_SHORT).show()
    }


}