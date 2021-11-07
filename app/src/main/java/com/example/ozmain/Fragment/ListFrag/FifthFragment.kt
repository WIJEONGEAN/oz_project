package com.example.ozmain.Fragment.ListFrag

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.ozmain.Fragment.ContentListModel
import com.example.ozmain.Fragment.FirstFragAdapter
import com.example.ozmain.Fragment.Menuinfo.MenuinfoActivity
import com.example.ozmain.R
import kotlinx.android.synthetic.main.fragment_fifth.view.*
import kotlinx.android.synthetic.main.fragment_first.view.*
import kotlinx.android.synthetic.main.fragment_fourth.view.*

class FifthFragment : Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstances: Bundle?): View? {

        val view: View = inflater.inflate(R.layout.fragment_fifth, container, false)

        val list_array = arrayListOf<ContentListModel>(
            ContentListModel(R.drawable.briseredorange_tea, "브리즈 레드오렌지 티", 1, "tea"),
            ContentListModel(R.drawable.browngarden_tea, "브라운 가든 티", 2, "tea"),
            ContentListModel(R.drawable.redpeach_tea, "레드피치 티", 3, "tea")

        )

        val list_adapter = FifthFragAdapter(requireContext(), list_array)
        view.listview_Fifth_fragment.adapter = list_adapter

        view.listview_Fifth_fragment.setOnItemClickListener { adapterView, view, i, l ->

            val intent = Intent(requireContext(), MenuinfoActivity::class.java)
            startActivity(intent)
        }
        return view
    }
}