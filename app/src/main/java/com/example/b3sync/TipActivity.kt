package com.example.b3sync

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.b3sync.databinding.ActivityTipBinding

class TipActivity : AppCompatActivity() {
    private lateinit var binding: ActivityTipBinding


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
            calculateTip()
        }
    }

    private fun calculateTip() {
        val stringInTextField = binding.etAmount.text.toString()
        val cost:Double = stringInTextField.toDouble()
        val selectedId = binding.tipOptions.checkedRadioButtonId
        val tipPercentage = when (selectedId) {
            R.id.amazing -> 0.20
            R.id.good -> 0.18
            else -> 0.15
        }
        var tip = tipPercentage * cost
        val roundUp = binding.switchRound.isChecked

        if (roundUp) {
            tip = kotlin.math.ceil(tip)
        }
        binding.tvTotal.text = "tip is $tip"

    }
}