package com.example.b3sync.data

class DiceEx {
}

fun main(){
    val myDice = Dice(20)
    println(myDice.sides)
    val num =   myDice.roll()
    println("we got $num on dice with ${myDice.sides} sides")
}