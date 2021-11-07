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
import com.example.ozmain.Utils.FirebaseUtils
import kotlinx.android.synthetic.main.fragment_first.view.*

class FirstFragment: Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstances: Bundle?): View? {

        val view: View = inflater.inflate(R.layout.fragment_first, container, false)

        val list_array = arrayListOf<ContentListModel>(
            ContentListModel(R.drawable.salt_coffee, "소금커피", 1, "coffee"),
            ContentListModel(R.drawable.toffeenut_macchiato, "토피넛마끼야또", 2, "coffee"),
            ContentListModel(R.drawable.einspanner, "아인슈페너", 3, "coffee")

        )

        val list_adapter = FirstFragAdapter(requireContext(), list_array)
        view.listview_first_fragment.adapter = list_adapter
        

        FirebaseUtils.db
            .collection("zzim")
            .document(FirebaseUtils.getUid())
            .get()
            .addOnSuccessListener {
                documentSnapshot -> if(documentSnapshot.exists()==true){
                    // 데이터필드 있을 때
            } else {
                // 데이터필드 없을 때
                val lecture = hashMapOf(
                    "상품 1" to "",
                    "상품 2" to "",
                    "상품 3" to "",
                )
                FirebaseUtils.db
                    .collection("zzim")
                    .document(FirebaseUtils.getUid())
                    .set(lecture)
                    .addOnSuccessListener {  }
                    .addOnFailureListener{  }
            }

            }

        view.listview_first_fragment.setOnItemClickListener { adapterView, view, i, l ->

            val intent = Intent(requireContext(), MenuinfoActivity::class.java)
            intent.putExtra("title", list_array.get(i).title)
            startActivity(intent)
        }
            return view
    }

}