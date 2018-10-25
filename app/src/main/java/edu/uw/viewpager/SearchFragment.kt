package edu.uw.viewpager

import android.content.Context
import android.net.Uri
import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v4.view.ViewPager
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button

import edu.uw.fragmentdemo.R
import java.lang.ClassCastException



class SearchFragment : Fragment() {

private var callback: OnSearchListener? = null

    internal interface OnSearchListener {
        fun onSearchSubmitted(searchTerm: String)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        val rootView = inflater.inflate(R.layout.fragment_search, container, false)
        val buttonView = rootView.findViewById<View>(R.id.btn_search) as Button
        val pageView = rootView.findViewById<ViewPager>(R.id.viewPager)

        buttonView.setOnClickListener {
            OnSearchListener::onSearchSubmitted
        }
        return rootView
    }

    override fun onAttach(context: Context) {
        super.onAttach(context)
        callback = context as? OnSearchListener
        if (callback == null) {
            throw ClassCastException("$context must implement OnSearchListener")
        }
    }
}
