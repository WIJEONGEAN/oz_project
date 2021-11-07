package com.example.ozmain.Fragment.Menuinfo

import android.graphics.Color
import android.os.Bundle
import android.util.TypedValue
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.ozmain.Fragment.ContentFragment
import com.example.ozmain.Fragment.InfoFragment
import com.example.ozmain.R
import com.example.ozmain.Utils.FirebaseUtils
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.firestore.FirebaseFirestore
import kotlinx.android.synthetic.main.activity_menuinfo.*

class MenuinfoActivity : AppCompatActivity() {

    private var auth: FirebaseAuth = FirebaseAuth.getInstance()
    private val db: FirebaseFirestore = FirebaseFirestore.getInstance()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_menuinfo)

        lecture_text.text = intent.getStringExtra("title")

        // 찜 여부 확인

        FirebaseUtils.db
            .collection("zzim")
            .document(FirebaseUtils.getUid())
            .get()
            .addOnSuccessListener {
                documentSnapshot-> if(intent.getStringExtra("title")?.let { documentSnapshot.get(it) } ==true){
                header_zzim.text="찜 완료!"
                header_zzim.setTextColor(Color.BLUE)
                    
            }
            }

        FirebaseUtils.getUid()


        zzim.setOnClickListener{

            // 찜 되어있을 때
            if(header_zzim.text.equals("찜 완료!")){

                header_zzim.text="찜"
                header_zzim.setTextColor(Color.RED)

                intent.getStringExtra("title")?.let { it1 ->
                    FirebaseUtils.db
                        .collection("zzim")
                        .document(FirebaseUtils.getUid())
                        .update(it1, "")
                        .addOnSuccessListener {
                            Toast.makeText(this, "해당 상품을 찜하였습니다.", Toast.LENGTH_LONG).show()
                        }
                        .addOnFailureListener {
                            Toast.makeText(this, "해당 상품을 찜하는데 실패하였습니다.", Toast.LENGTH_LONG).show()
                        }
                }

                } else{
                // 찜 되어있지 않을 때

                header_zzim.text="찜 완료!"
                header_zzim.setTextColor(Color.BLUE)

                intent.getStringExtra("title")?.let { it1 ->
                    FirebaseUtils.db
                        .collection("zzim")
                        .document(FirebaseUtils.getUid())
                        .update(it1, true)
                        .addOnFailureListener {
                            Toast.makeText(this, "해당 상품을 찜하였습니다.", Toast.LENGTH_LONG).show()
                        }
                        .addOnFailureListener {
                            Toast.makeText(this, "해당 상품을 찜하는데 실패하였습니다.", Toast.LENGTH_LONG).show()
                        }
                }

            }


        }

        supportFragmentManager.beginTransaction().replace(R.id.fragment_area, ContentFragment()).commit()

        figure_1.setOnClickListener{

            figure_1.setTextSize(TypedValue.COMPLEX_UNIT_DIP, 25F)
            figure_2.setTextSize(TypedValue.COMPLEX_UNIT_DIP, 15F)

            supportFragmentManager.beginTransaction()
                    .replace(R.id.fragment_area, InfoFragment())
                    . commit()

        }

        figure_2.setOnClickListener{

            figure_1.setTextSize(TypedValue.COMPLEX_UNIT_DIP, 15F)
            figure_2.setTextSize(TypedValue.COMPLEX_UNIT_DIP, 25F)

            supportFragmentManager.beginTransaction()
                    .replace(R.id.fragment_area, ContentFragment())
                    . commit()

        }

    }
}