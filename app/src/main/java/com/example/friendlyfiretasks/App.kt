package com.example.friendlyfiretasks

import android.app.Application
import com.example.friendlyfiretasks.di.Dependencies

class App : Application() {
    override fun onCreate() {
        super.onCreate()
        Dependencies.init(applicationContext)
    }
}