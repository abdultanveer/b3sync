package com.example.b3sync.kotlinexs;

import junit.framework.TestCase;

public class CalculatorTest extends TestCase {

    public void testAdd() {
        int expected = 40;
        int actual = Calculator.add(10,20);
        assertEquals(expected,actual);
    }


    public void testNegative(){
        int expected = -10;
        int actual = Calculator.add(10,-20);
        assertEquals(expected,actual);
    }
}