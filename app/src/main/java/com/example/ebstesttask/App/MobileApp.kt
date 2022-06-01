package com.example.ebstesttask.App

import android.app.Application
import com.example.data.storage.MobileDatabase
import dagger.hilt.android.HiltAndroidApp

@HiltAndroidApp
class MobileApp: Application() {
    val bd by lazy {
        MobileDatabase.getInstance(this)
    }
}