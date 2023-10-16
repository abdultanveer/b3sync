package com.example.b3sync

import android.database.Cursor
import android.net.Uri
import android.os.Bundle
import android.widget.ListView
import android.widget.SimpleCursorAdapter
import androidx.appcompat.app.AppCompatActivity


class ContentProviderActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_content_provider)
        var cpListView:ListView = findViewById(R.id.cpListView)

        //uri pointing to the inbox table
        val uriSms = Uri.parse("content://sms/inbox")
        //query the table and get the result
        val dataCursor: Cursor? = getContentResolver().query(uriSms, null, null, null, null)
        var fromColumns = arrayOf("body","address")
        var toWidgetIds = intArrayOf(android.R.id.text1,android.R.id.text2)
        var adapter = SimpleCursorAdapter(this,
            android.R.layout.simple_list_item_2,
            dataCursor,
            fromColumns,
            toWidgetIds)
        cpListView.adapter = adapter

    }
}