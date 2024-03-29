package com.example.ozmain.Fragment

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import com.example.ozmain.R
import kotlinx.android.synthetic.main.review_item.view.*

class ReviewListAdapter (val context: Context, val list_nickname: ArrayList<String>, val list_text: ArrayList<String>, val list_rating: ArrayList<String>) : BaseAdapter() {

    override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View {
        val view: View = LayoutInflater.from(context).inflate(R.layout.review_item, null)

        view.review_nickname.text = list_nickname.get(position)
        view.review_content.text = list_text.get(position)
        view.review_rating.text = list_rating.get(position)

        return view
    }

    override fun getItem(position: Int): Any {
        return 0
    }

    override fun getItemId(position: Int): Long {
        return 0
    }

    override fun getCount(): Int {
        return list_nickname.size
    }

}