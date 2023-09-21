package com.example.b3sync.kotlinexs

class Demo {
}

fun main(){
    val myDice = RedDice(20)
    println("no of sides = ${myDice.sides}")
    var valueReturned = myDice.roll()
    println("dice returned = $valueReturned")

}