package com.example.ozmain

import android.content.Intent
import com.iamport.sdk.domain.core.Iamport
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.viewpager.widget.ViewPager
import com.example.ozmain.Adapter.ViewPagerAdapter
import com.example.ozmain.Auth.LoginActivity
import com.example.ozmain.Auth.MyOzActivity
import com.example.ozmain.Zzim.ZzimActivity
import com.google.android.material.snackbar.Snackbar
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.ktx.Firebase
import com.iamport.sdk.data.sdk.IamPortRequest
import com.iamport.sdk.data.sdk.PG
import com.iamport.sdk.data.sdk.PayMethod
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.bottom_tab.*
import java.util.*

class MainActivity : AppCompatActivity() {

    internal lateinit var viewpager: ViewPager
    private lateinit var auth: FirebaseAuth

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // 결제 요청 함수 호출
        Iamport.init(this)


        val img = arrayOf(
            R.drawable.ic_coffee,
            R.drawable.ic_latte,
            R.drawable.ic_ade,
            R.drawable.ic_smoothie,
            R.drawable.ic_tea,
            R.drawable.ic_mtaerial
        )

        val text = arrayOf(
            "COFFEE",
            "LATTE",
            "ADE",
            "SMOOTHIE",
            "TEA",
            "METERIAL"
        )

        val gridviewAdapter = GridviewAdapter(this, img, text)
        gridview.adapter = gridviewAdapter

        // gridviewadapter 클릭시 lectureAct 실행

        gridview.setOnItemClickListener { adapterView, view, i, l ->
            val intent = Intent(this, LectureActivity::class.java)
            startActivity(intent)
        }


        viewpager = findViewById(R.id.viewpager) as ViewPager

        val adapter = ViewPagerAdapter(this)
        viewpager.adapter = adapter

        // 찜
        zzim_icon.setOnClickListener{
            val intent = Intent(this, ZzimActivity::class.java)
            startActivity(intent)
        }

        // 마이페이지(myOZ)
        my_page.setOnClickListener {

            if (auth.currentUser == null) {

                val intent = Intent(this, LoginActivity::class.java)
                startActivity(intent)
            } else {
                val intent = Intent(this, MyOzActivity::class.java)
                startActivity(intent)
            }
        }

    }

    override fun onStart() {
        super.onStart()

        // SDK 에 결제 요청할 데이터
        val request = IamPortRequest(
            pg = PG.html5_inicis.makePgRawName(""),         // PG사
            pay_method = PayMethod.card,                    // 결제수단
            name = "아임포트로 결제를 진행합니다.",                      // 주문명
            merchant_uid = "sample_aos_${Date().time}",     // 주문번호
            amount = "15,000",                                // 결제금액
            buyer_name = "위정언"
        )

        /*binding.fab.setOnClickListener { view ->
            Snackbar.make(view, "아임포트에서 결제를 진행합니다", Snackbar.LENGTH_LONG).setAction("결제") {
                // 아임포트에 결제 요청하기
                Iamport.payment("iamport", request, paymentResultCallback = {
                    // 결제 완료 후 결과 콜백을 토스트 메시지로 보여줌
                    Toast.makeText(this, "결제결과 => $it", Toast.LENGTH_LONG).show()
                })
            }.show()
        }*/
    }
}
