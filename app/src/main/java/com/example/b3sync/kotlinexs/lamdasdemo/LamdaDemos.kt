package com.example.b3sync.kotlinexs.lamdasdemo

import kotlin.math.roundToInt

class LamdaDemos {
}

fun calculate(fParam: Int,
              sParam: Int,
              tParam: (Int, Int) -> Int): Int {  // 1
    return tParam(fParam, sParam)                                          // 2
}

fun sum(x: Int, y: Int) = x + y                                     // 3

//::sum -- method reference
fun main() {
    val sumResult = calculate(4, 5, ::sum)                          // 4
    val mulResult = calculate(4, 5, { a, b -> a * b } )              // 5
    println("sumResult $sumResult, mulResult $mulResult")
}

val sum: (Float,Float)->Int = { a,b -> (a+b).roundToInt() }



/*
fun main() {
    val sum: (Int, Int) -> Int = { x: Int, y: Int -> x + y }
    val name : String = "abdul"
}*/
