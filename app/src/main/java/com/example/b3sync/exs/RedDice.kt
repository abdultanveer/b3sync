package com.example.b3sync.exs

class RedDice(var sides: Int) {
   // var sides = 6

    fun roll():Int{
        //val diceRange = 1..6
        return (1..sides).random()

        //println("random no is $randomNum")
        //return  randomNum
    }
}