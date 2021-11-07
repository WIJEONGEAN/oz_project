package com.example.ozmain.Payment

import android.app.Application
import com.iamport.sdk.domain.core.Iamport

class PaymentBase: Application() {
    override fun onCreate() {
        super.onCreate()
        Iamport.create(this)
    }
}