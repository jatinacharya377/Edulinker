package com.link.edulinker

import android.app.Application

class EduLinkerApplication : Application() {

    override fun onCreate() {
        super.onCreate()
        INSTANCE = this
    }

    companion object {
        lateinit var INSTANCE: EduLinkerApplication
            private set
    }
}