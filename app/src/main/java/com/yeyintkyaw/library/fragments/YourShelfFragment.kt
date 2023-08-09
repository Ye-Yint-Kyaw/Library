package com.yeyintkyaw.library.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.cardview.widget.CardView
import com.yeyintkyaw.library.R
import com.yeyintkyaw.library.activities.CreateShelfActivity
import com.yeyintkyaw.library.mvp.view.YourBooksView


class YourShelfFragment : Fragment() {


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
        setUpListener(view)
    }

    private fun setUpListener(view: View) {
        val fabBtn: CardView = view.findViewById(R.id.fabCreateBtn)
        fabBtn.setOnClickListener{
            startActivity(CreateShelfActivity.newIntent(requireContext()))
        }
    }


}