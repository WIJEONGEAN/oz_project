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
import kotlinx.android.synthetic.main.fragment_second.view.*


class SecoundFragment : Fragment() {
    override fun onCreateView(
            inflater: LayoutInflater, container: ViewGroup?, savedInstances: Bundle?): View? {

        val view: View = inflater.inflate(R.layout.fragment_second, container, false)

        val list_array = arrayListOf<ContentListModel>(
                ContentListModel(R.drawable.tiramisu_latte, "티라미수라떼", 1, "latte"),
                ContentListModel(R.drawable.buttercream_latte, "크림버터라떼", 2, "latte"),
                ContentListModel(R.drawable.cube_latte, "큐브라떼", 3, "latte")

        )

        val list_adapter = SecoundFragAdapter(requireContext(), list_array)
        view.listview_Secound_fragment.adapter = list_adapter

        view.listview_Secound_fragment.setOnItemClickListener { adapterView, view, i, l ->

            val intent = Intent(requireContext(), MenuinfoActivity::class.java)
            startActivity(intent)
        }
        return view
    }
}