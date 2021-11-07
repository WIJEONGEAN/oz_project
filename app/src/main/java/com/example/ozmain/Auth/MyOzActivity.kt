package com.example.ozmain.Auth

import android.content.Intent
import android.media.MediaPlayer
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.bumptech.glide.Glide
import com.example.ozmain.MainActivity
import com.example.ozmain.R
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.firestore.FirebaseFirestore
import kotlinx.android.synthetic.main.activity_my_oz.*

class MyOzActivity : AppCompatActivity() {

    private val db = FirebaseFirestore.getInstance()
    private lateinit var auth : FirebaseAuth

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_my_oz)

        auth = FirebaseAuth.getInstance()

        val docRef = db.collection("Users").document(auth.currentUser?.uid.toString())

        docRef.get().addOnSuccessListener {
                documentSnapshot -> nickname_area.setText(documentSnapshot.get("nickname").toString())
        }

        logout_button.setOnClickListener{
            auth.signOut()
            val intent = Intent(this, MainActivity::class.java)
            intent.flags = Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TASK
            startActivity(intent)
        }

        
        // 프로필 이미지 다운로드(from firebase)
       /* image_download.setOnClickListener{
            val ref = FirebaseFirestore.getInstance().getReference("buleberries.png")

            ref.downloadUrl
                .addCompleteListener(MediaPlayer.OnCompletionListener{
                    task -> if(task.isSuccessful){
                        Glide.with(this)
                            .load(task.result)
                            .into(profile_img)
                } else{
                    Toast.makeText(this, "실패", Toast.LENGTH_LONG).show()
                }
                })
        }*/

    }
}