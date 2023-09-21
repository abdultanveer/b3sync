package com.example.b3sync

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.constraintlayout.widget.ConstraintLayout
import com.example.b3sync.data.Dice
import com.google.android.material.snackbar.Snackbar

//class MainActivity extends AppCompatActivity
class MainActivity : AppCompatActivity() {

lateinit var rollButton: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)  //inflation --layout inflater

         rollButton = findViewById(R.id.btnRoll) //taking handle of button
        rollButton.setOnClickListener {
         rollDice()
        }
    }

    fun rollDice(){
        var tvRoll: TextView = findViewById(R.id.tvRoll) //taking handle
        var ivDice : ImageView = findViewById(R.id.ivDice)
        ivDice.setImageResource(R.drawable.dice_3)
        var dice = Dice(sides = 6)

        tvRoll.setText("no is -- ${dice.roll()}")
        rollButton.setText("dice rolled")


        var  layout :ConstraintLayout = findViewById(R.id.layout);

        var snackbar = Snackbar.make(this,layout,"button rolled",Snackbar.LENGTH_SHORT).show()

    }
}