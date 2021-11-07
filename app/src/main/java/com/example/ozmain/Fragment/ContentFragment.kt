package com.example.ozmain.Fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentContainer
import com.example.ozmain.Adapter.ListAdapter
import com.example.ozmain.R
import kotlinx.android.synthetic.main.fragment_content.view.*

class ContentFragment : Fragment() {
    //임시
    val list1 = ArrayList<String>()
    val list2 = ArrayList<String>()

    override fun onCreateView(
            inflater: LayoutInflater, container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View? {

        val view: View = inflater.inflate(R.layout.fragment_content, container, false)

        list1.add("a")

        list2.add("b")

        val list_adapter = ListAdapter(requireContext(), list1, list2)
        view.content_listview.adapter = list_adapter

                return view
    }

}