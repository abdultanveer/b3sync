package com.example.b3sync

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import com.example.b3sync.databinding.ActivityTipBinding

class TipActivity : AppCompatActivity() {
    lateinit var binding: ActivityTipBinding


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //setContentView(R.layout.activity_tip)
        binding = ActivityTipBinding.inflate(layoutInflater)
        setContentView(binding.root)

        /*
        var calcButton: Button
        var tvTotal:TextView
        calcButton = findViewById(R.id.btnCalculate)
        tvTotal = findViewById(R.id.tvTotal)*/


        binding.btnCalculate.setOnClickListener {
            binding.tvTotal.setText("the total is 300")
        }
    }
}