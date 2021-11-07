package com.example.ozmain.Fragment.ListFrag

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.ozmain.Fragment.ContentListModel
import com.example.ozmain.Fragment.FirstFragAdapter
import com.example.ozmain.Fragment.Menuinfo.MenuinfoActivity
import com.example.ozmain.R
import kotlinx.android.synthetic.main.fragment_first.view.*
import kotlinx.android.synthetic.main.fragment_third.view.*


class ThirdFragment : Fragment() {
    override fun onCreateView(
            inflater: LayoutInflater, container: ViewGroup?, savedInstances: Bundle?): View? {

        val view: View = inflater.inflate(R.layout.fragment_third, container, false)

        val list_array = arrayListOf<ContentListModel>(
                ContentListModel(R.drawable.vinhibiscus_ade, "뱅 히비스커스 에이드", 1, "ade"),
                ContentListModel(R.drawable.galaxy_ade, "갤럭시 에이드", 2, "ade"),
                ContentListModel(R.drawable.orange_ade, "오렌지 에이드", 3, "ade")

        )

        val list_adapter = ThirdFragAdapter(requireContext(), list_array)
        view.listview_third_fragment.adapter = list_adapter

       view.listview_third_fragment.setOnItemClickListener { adapterView, view, i, l ->

            val intent = Intent(requireContext(), MenuinfoActivity::class.java)
            startActivity(intent)
        }
        return view
    }
}