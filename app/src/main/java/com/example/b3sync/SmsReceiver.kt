package com.example.b3sync

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.telephony.SmsMessage
import android.util.Log


class SmsReceiver : BroadcastReceiver() {
    var TAG = SmsReceiver::class.java.simpleName

    override fun onReceive(context: Context, intent: Intent) {
       Log.i("SMS","abdul you've an sms")

        Log.i(TAG, "Intent recieved: " + intent.action)

            val bundle = intent.extras
            if (bundle != null) {
                val pdus = bundle["pdus"] as Array<Any>?
                val messages: Array<SmsMessage?> = arrayOfNulls<SmsMessage>(pdus!!.size)
                for (i in pdus!!.indices) {
                    messages[i] = SmsMessage.createFromPdu(pdus!![i] as ByteArray)
                }
                if (messages.size > -1) {
                    Log.i(TAG, "Message recieved: " + messages[0]?.getMessageBody())
                    Log.i(TAG, "phno =: " + messages[0]?.originatingAddress)

                }
            }
            val cakeIntent = Intent("ineed.cake")
            cakeIntent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK)
        //please create a new task and place the cake activity in that newly created task
            context.startActivity(cakeIntent)

        }
    }
