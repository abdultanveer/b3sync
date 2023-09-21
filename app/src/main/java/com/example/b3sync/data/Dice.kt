package com.example.b3sync.data
//var every instance will have the partition named sides in it
class Dice(var sides: Int) {
    //var sides = 6

    fun roll():Int{
        /*val diceRange = 1..6
        val randomNo = diceRange.random()*/
        return  (1..sides).random()
       // println("random no is $randomNumber")
       // return  randomNumber


    }
}