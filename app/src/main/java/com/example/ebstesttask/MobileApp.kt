package com.example.ebstesttask

import android.app.Application

class MobileApp: Application() {
    val bd by lazy {
        MobileDatabase.getInstance(this)
    }
}