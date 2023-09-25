package com.example.b3sync

import androidx.test.espresso.Espresso
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.action.ViewActions.click
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.matcher.ViewMatchers.withId
import androidx.test.espresso.matcher.ViewMatchers.withText
import androidx.test.ext.junit.rules.ActivityScenarioRule
import androidx.test.ext.junit.runners.AndroidJUnit4
import androidx.test.filters.LargeTest
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith


@LargeTest
@RunWith(AndroidJUnit4::class)
class MyMainActivityTest {
    @Rule
    @JvmField
    var mActivityScenarioRule = ActivityScenarioRule(MainActivity::class.java)


    @Test
    fun mainActivityTest() {
        //click the button roll with id btnRoll
        onView(withId(R.id.btnRoll)).perform(click())
        //check if the textview with id tvRoll has "you got 3"
        var rollNum = MainActivity.rollNo
        onView(withId(R.id.tvRoll)).check(matches(withText("you got $rollNum")))
    }

}