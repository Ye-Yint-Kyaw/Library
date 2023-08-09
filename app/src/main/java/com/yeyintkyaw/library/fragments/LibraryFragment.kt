package com.yeyintkyaw.library.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TableLayout
import androidx.fragment.app.commit
import com.google.android.material.tabs.TabLayout
import com.yeyintkyaw.library.R


class LibraryFragment : Fragment() {


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_library, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setUpTabLayout(view)
    }

    private fun setUpTabLayout(view: View) {
        val tlLibrary: TabLayout = view.findViewById(R.id.tlLibrary)
        tlLibrary.addTab(tlLibrary.newTab().setText("Your Books"));
        tlLibrary.addTab(tlLibrary.newTab().setText("Your Shelves"));
        childFragmentManager.commit {
            replace(R.id.fragmentContainerLibrary, YourBookFragment())
        }
        tlLibrary.addOnTabSelectedListener(object : TabLayout.OnTabSelectedListener {
            override fun onTabSelected(tab: TabLayout.Tab?) {
                when(tab?.position){
                    0 -> childFragmentManager.commit {
                        replace(R.id.fragmentContainerLibrary, YourBookFragment())
                    }
                    1 -> childFragmentManager.commit {
                        replace(R.id.fragmentContainerLibrary, YourShelfFragment())
                    }
                    else -> childFragmentManager.commit {
                        replace(R.id.fragmentContainerLibrary, YourBookFragment())
                    }
                }
            }

            override fun onTabUnselected(tab: TabLayout.Tab?) {

            }

            override fun onTabReselected(tab: TabLayout.Tab?) {

            }

        })
    }

}