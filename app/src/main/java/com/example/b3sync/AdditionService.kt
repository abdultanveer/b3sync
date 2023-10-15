package com.example.b3sync

import android.app.Service
import android.content.Intent
import android.os.Binder
import android.os.IBinder

class AdditionService : Service() {
    private val binder = LocalBinder()

    fun getAds( a:Int,  b:Int) = a + b

    override fun onBind(intent: Intent): IBinder {
        //this Ibinder will be received in onServiceConnected on ServiceConnection
        return  binder
    }

    inner class LocalBinder : Binder() {

        fun getAddService(): AdditionService = this@AdditionService

    }

    }