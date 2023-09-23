package com.example.b3sync.kotlinexs.inheritance

open class Tax {
   open fun calculateTax(price: Int):Int {
        return price / 10
    }
}