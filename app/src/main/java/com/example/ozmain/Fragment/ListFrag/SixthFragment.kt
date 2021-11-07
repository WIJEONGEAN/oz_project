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
import kotlinx.android.synthetic.main.fragment_first.view.*
import kotlinx.android.synthetic.main.fragment_sixth.view.*

class SixthFragment : Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstances: Bundle?): View? {

        val view: View = inflater.inflate(R.layout.fragment_sixth, container, false)

        val list_array = arrayListOf<ContentListModel>(
            ContentListModel(R.drawable.vanilla_powder, "바닐라 파우더", 1, "powder"),
            ContentListModel(R.drawable.dalgona, "달고나 분태", 2, "toppings"),
            ContentListModel(R.drawable.brown_sugar, "브라운 슈가 시럽", 3, "syrup")

        )

        val list_adapter = SixthFragAdapter(requireContext(), list_array)
        view.listview_Sixth_fragment.adapter = list_adapter

        view.listview_Sixth_fragment.setOnItemClickListener { adapterView, view, i, l ->

            val intent = Intent(requireContext(), MenuinfoActivity::class.java)
            startActivity(intent)
        }
        return view
    }
}