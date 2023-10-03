package com.example.b3sync

import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.provider.AlarmClock
import android.util.Log
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.constraintlayout.widget.ConstraintLayout
import com.example.b3sync.data.Dice
import com.google.android.material.snackbar.Snackbar
import java.lang.NullPointerException

//class MainActivity extends AppCompatActivity
class MainActivity : AppCompatActivity() {
    private  val TAG = "MainActivity"
    lateinit var rollButton: Button  //global variable

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)  //inflation --layout inflater
        Log.i(TAG,"activity created")
        rollButton = findViewById(R.id.btnRoll) //taking handle of button
        rollButton.setOnClickListener {
            Log.e(TAG,"button clicked")

            rollDice()
        }

        var affirmBtn = findViewById<Button>(R.id.btnAffirm)
        affirmBtn.setOnClickListener {
            val afIntent = Intent(this,AffirmationsActivity::class.java)
            startActivity(afIntent)
        }

        var dialBtn = findViewById<Button>(R.id.btnDialer)
        dialBtn.setOnClickListener {
            val dialIntent = Intent(Intent.ACTION_DIAL, Uri.parse("tel:12345678"))
            startActivity(dialIntent)
        }

        var alarmBtn = findViewById<Button>(R.id.btnAlarm)
        alarmBtn.setOnClickListener {
            createAlarm("b3 sync", 12,32)
        }

    }

    fun rollDice() {
        Log.w(TAG,"dice was rolled")

        var tvRoll: TextView = findViewById(R.id.tvRoll) //taking handle
        var ivDice: ImageView = findViewById(R.id.ivDice)
        ivDice.setImageResource(R.drawable.dice_3)
        var dice = Dice(sides = 6)
        val diceRoll = dice.roll()
        Log.v(TAG,"you got $diceRoll")


        tvRoll.setText("you got $diceRoll")
        rollButton.setText("dice rolled")

       /* when (diceRoll) {
            1 -> ivDice.setImageResource(R.drawable.dice_1)
            2 -> ivDice.setImageResource(R.drawable.dice_2)
            3 -> ivDice.setImageResource(R.drawable.dice_3)
            4 -> ivDice.setImageResource(R.drawable.dice_4)
            5 -> ivDice.setImageResource(R.drawable.dice_5)
            6 -> ivDice.setImageResource(R.drawable.dice_6)

        }*/

       val imagetobeSet =  when(diceRoll){
           1-> R.drawable.dice_1
           2-> R.drawable.dice_2
           3-> R.drawable.dice_3
           4-> R.drawable.dice_4
           5-> R.drawable.dice_5
           6-> R.drawable.dice_6
           else -> { 0}
       }
        ivDice.setImageResource(imagetobeSet)
       // throw NullPointerException("simply crashing the app")
        }


    fun createAlarm(message: String, hour: Int, minutes: Int) {

        val intent = Intent(AlarmClock.ACTION_SET_ALARM).apply {
            putExtra(AlarmClock.EXTRA_MESSAGE, message)
            putExtra(AlarmClock.EXTRA_HOUR, hour)
            putExtra(AlarmClock.EXTRA_MINUTES, minutes)
        }
        //if (intent.resolveActivity(packageManager) != null) {
            startActivity(intent)
        //}
    }


    }
