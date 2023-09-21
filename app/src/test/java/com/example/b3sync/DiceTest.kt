package com.example.b3sync

import com.example.b3sync.data.Dice
import org.junit.Assert.assertTrue
import org.junit.Test

class DiceTest {
    @Test
    fun generates_number(){
        val dice = Dice(6)
        val rollResult = dice.roll()
        assertTrue(rollResult in 1..6)


    }
}