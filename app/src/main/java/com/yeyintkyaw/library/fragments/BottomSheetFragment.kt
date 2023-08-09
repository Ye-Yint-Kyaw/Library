package com.yeyintkyaw.library.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.ListView
import android.widget.RelativeLayout
import com.google.android.material.bottomsheet.BottomSheetDialogFragment
import com.yeyintkyaw.library.R
import com.yeyintkyaw.library.activities.ShelfListActivity

class BottomSheetFragment : BottomSheetDialogFragment(){


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_bottom_sheet, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
//        val options = listOf<String>(
//            "Download",
//            "Delete from your library",
//            "Add to shelves",
//            "Mark as read"
//
//        )
//        val listView: ListView? = view?.findViewById(R.id.lvOptions)
//        listView?.adapter = ArrayAdapter<String>(
//            requireContext(),
//            android.R.layout.simple_list_item_activated_1,
//            options
//        )
        val add: RelativeLayout? = view?.findViewById(R.id.rlAdd)
        add?.setOnClickListener {
            startActivity(ShelfListActivity.newIntent(requireContext()))
        }
    }

}