package com.example.b3sync

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.PersistableBundle
import android.util.Log
import android.widget.Button
import android.widget.EditText
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
        var etStory:EditText = findViewById(R.id.etStory)

        if(savedInstanceState != null){
            var storyline = savedInstanceState.getString("story")
            etStory.setText(storyline)

        }
        Log.i(TAG,"activity created")
        rollButton = findViewById(R.id.btnRoll) //taking handle of button
        rollButton.setOnClickListener {
            Log.e(TAG,"button clicked")

            rollDice()
        }
    }

    override fun onSaveInstanceState(outState: Bundle, outPersistentState: PersistableBundle) {
        super.onSaveInstanceState(outState, outPersistentState)
        var etStory:EditText = findViewById(R.id.etStory)
        outState.putString("story",etStory.text.toString())
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
    }
