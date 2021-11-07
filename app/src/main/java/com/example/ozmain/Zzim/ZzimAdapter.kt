package com.example.ozmain.Zzim

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import com.example.ozmain.R

class ZzimAdapter(val context: Context, val list_array: ArrayList<String>): BaseAdapter(){

    override fun getView(p0: Int, p1: View?, p2: ViewGroup?): View {
        val view: View = LayoutInflater.from(context).inflate(R.layout.zzim_item, null)
       // view.zzim_text.text = "1234"

        return view
    }

    override fun getItem(p0: Int): Any {return 0 }

    override fun getItemId(p0: Int): Long { return 0 }

    override fun getCount(): Int {

        return list_array.size

    }

}