package com.example.b3sync.kotlinexs.inheritance

class Gst  : Tax(){
    //lateinit var category:String
    override fun calculateTax(price: Int): Int {
        var oldTax = super.calculateTax(price)
        var newTax = price /5
        println("old tax was $oldTax and new tax is $newTax")
        return  newTax
    }
}