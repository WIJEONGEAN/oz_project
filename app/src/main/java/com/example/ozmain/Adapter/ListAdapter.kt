package com.example.ozmain.Adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import com.example.ozmain.R

class ListAdapter (val context: Context, val list_price : ArrayList<String>, val list_name: ArrayList<String>): BaseAdapter(){
    override fun getCount(): Int {
        return list_name.size
    }

    override fun getItem(p0: Int): Any {
       return 0
    }

    override fun getItemId(p0: Int): Long {
        return 0
    }

    override fun getView(p0: Int, p1: View?, p2: ViewGroup?): View {

        // 이전에 만들었던 리스트 뷰 아이템 재활용
       val view: View = LayoutInflater.from(context).inflate(R.layout.listview_item, null)

        return  view
    }

}