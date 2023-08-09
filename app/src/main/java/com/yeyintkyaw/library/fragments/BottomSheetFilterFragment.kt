package com.yeyintkyaw.library.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.RadioButton
import com.google.android.material.bottomsheet.BottomSheetDialogFragment
import com.yeyintkyaw.library.R
import com.yeyintkyaw.library.delegates.RadioButtonDelegate


class BottomSheetFilterFragment : BottomSheetDialogFragment() {
    private var mDelegate: RadioButtonDelegate? = null

    fun setBottomSheetDelegate(delegate: RadioButtonDelegate) {
        mDelegate = delegate
    }


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_bottom_sheet_filter, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        getRadioButtonIdText(view)
    }

    private fun getRadioButtonIdText(view: View) {
        val large: RadioButton = view.findViewById(R.id.large)
        val small: RadioButton = view.findViewById(R.id.small)
        large.setOnCheckedChangeListener { compoundButton, isChecked ->
            if(isChecked){
                mDelegate?.getRadioId("large")
            }
        }
        small.setOnCheckedChangeListener { compoundButton, isChecked ->
            if (isChecked){
                mDelegate?.getRadioId("small")
            }
        }

    }


}