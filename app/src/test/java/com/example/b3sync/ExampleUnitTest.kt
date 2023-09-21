package com.example.b3sync

import com.example.b3sync.data.Sample
import org.junit.Test

import org.junit.Assert.*

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * See [testing documentation](http://d.android.com/tools/testing).
 */
class ExampleUnitTest {
    @Test
    fun addition_isCorrect() {
        var expected = 40;
        //Sample sample = new Sample();
        var sample = Sample()
        var actual = sample.sum(2,2)
        assertEquals(expected, actual)
    }
}