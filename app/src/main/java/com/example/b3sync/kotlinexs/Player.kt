package com.example.b3sync.kotlinexs

import com.example.b3sync.data.Dice

class Player {
}

fun main() {
   val myFirstDice = Dice(6)
    val rollResult = myFirstDice.roll()
        println("your ${myFirstDice.sides}  sided dice rolled ${rollResult}"
    )
}
