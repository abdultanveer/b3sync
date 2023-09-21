package com.example.b3sync.kotlinexs

import com.example.b3sync.data.Dice

class Player {
}

fun main() {
    val num = (1..6).random()
    if (num>4) {
        println("you win $num")
    }
    else{
        println("you lost $num")

    }
}