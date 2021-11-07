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
import kotlinx.android.synthetic.main.fragment_fourth.view.*
import kotlinx.android.synthetic.main.fragment_second.view.*

class FourthFragment : Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstances: Bundle?): View? {

        val view: View = inflater.inflate(R.layout.fragment_fourth, container, false)

        val list_array = arrayListOf<ContentListModel>(
            ContentListModel(R.drawable.strawberry_smoothie, "딸기 요거트 스무디", 1, "smoothie"),
            ContentListModel(R.drawable.coconutcoffee_smoothie, "코코넛 커피 스무디", 2, "smoothie"),
            ContentListModel(R.drawable.cloud_smoothie, "구름 스무디", 3, "smoothie")

        )

        val list_adapter = FourthFragAdapter(requireContext(), list_array)
        view.listview_Fourth_fragment.adapter = list_adapter


        view.listview_Fourth_fragment.setOnItemClickListener { adapterView, view, i, l ->

            val intent = Intent(requireContext(), MenuinfoActivity::class.java)
            startActivity(intent)
        }
        return view
    }
}