package com.maskalor.myapplication

import android.app.Application
import com.maskalor.myapplication.di.Dependencies

class App : Application() {
    override fun onCreate() {
        super.onCreate()
        Dependencies.init(applicationContext)
    }
}