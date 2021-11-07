package com.example.ozmain.Fragment

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import com.example.ozmain.Fragment.Menuinfo.WriteActivity
import com.example.ozmain.R
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.firestore.FirebaseFirestore
import kotlinx.android.synthetic.main.fragment_review.view.*

class ReviewFragment : Fragment() {
    private lateinit var auth: FirebaseAuth
    private val db = FirebaseFirestore.getInstance()
    private val text_array = ArrayList<String>()
    private val nickname_array = ArrayList<String>()
    private val rating_array = ArrayList<String>()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        auth = FirebaseAuth.getInstance()
        val view: View = inflater.inflate(R.layout.fragment_review, container, false)

        // 어뎁터, 리스트뷰 연결
        val review_adapter = ReviewListAdapter(requireContext(), nickname_array, text_array, rating_array)
        view.listview_review.adapter = review_adapter
        
        // firebase에서 데이터 받아오기
        db.collection("reviews")
            .get()
            .addOnSuccessListener { result ->
                for (document in result) {
                    text_array.add(document.get("text") as String)
                    nickname_array.add(document.get("writer") as String)
                    rating_array.add(document.get("rating") as String)
                }
                review_adapter.notifyDataSetChanged()  // 어뎁터에 데이터 다시 넣기
            }
            .addOnFailureListener { exception ->

            }

        view.write_button.setOnClickListener {
            if (auth.currentUser == null) {
                Toast.makeText(requireContext(), "로그인이 필요한 서비스입니다.", Toast.LENGTH_LONG).show()
            } else {
                val intent = Intent(requireContext(), WriteActivity::class.java)
                startActivity(intent)
            }
        }

        return view
    }


}