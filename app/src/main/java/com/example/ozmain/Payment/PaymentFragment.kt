package com.example.ozmain.Payment

import android.content.Context
import androidx.fragment.app.Fragment

class PaymentFragment: Fragment() {

    // 포그라운드 서비스 처리용 브로드 캐스트 리시버 등록
    override fun onAttach(context: Context) {
        super.onAttach(context)

        //registForegroundServiceReceiver(context)
    }
}