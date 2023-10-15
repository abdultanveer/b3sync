package com.example.b3sync

import android.app.Service
import android.content.Intent
import android.os.IBinder
import android.util.Log

class MyService : Service() {
var TAG = MyService::class.java.simpleName
    override fun onCreate() {
        super.onCreate()
        Log.i(TAG,"service created")

    }

    override fun onStartCommand(intent: Intent?, flags: Int, startId: Int): Int {
         super.onStartCommand(intent, flags, startId)
        var fileurl = intent?.getStringExtra("filekey")
        Log.i(TAG,"service started-- downloading from --"+fileurl)

        return START_STICKY
    }

    override fun onDestroy() {
        super.onDestroy()
        Log.i(TAG,"service destroyed")

    }

    override fun onBind(intent: Intent): IBinder {
        TODO("Return the communication channel to the service.")
    }
}