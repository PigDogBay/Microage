package com.mpdbailey.microage

import android.app.Application
import com.mpdbailey.microage.presenters.Coordinator

class MicroageApplication : Application(){
    companion object {
        lateinit var instance : MicroageApplication
            private set
    }

    val coordinator = Coordinator()

    override fun onCreate() {
        super.onCreate()
        instance = this
    }
}