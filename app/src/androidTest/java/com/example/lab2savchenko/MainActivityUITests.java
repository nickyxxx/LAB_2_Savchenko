package com.example.lab2savchenko;

import android.content.Context;

import androidx.test.platform.app.InstrumentationRegistry;
import androidx.test.ext.junit.runners.AndroidJUnit4;
import androidx.test.espresso.Espresso;
import androidx.test.espresso.action.ViewActions;
import androidx.test.espresso.assertion.ViewAssertions;
import androidx.test.espresso.matcher.ViewMatchers;
import androidx.test.ext.junit.rules.ActivityScenarioRule;
import androidx.test.filters.LargeTest;


import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import static org.junit.Assert.*;
@RunWith(AndroidJUnit4.class)
@LargeTest
public class MainActivityUITests {

    @Rule
    public ActivityScenarioRule<MainActivity> activityRule =
            new ActivityScenarioRule<>(MainActivity.class);

    @Test
    public void testWordCountButton() {
        Espresso.onView(ViewMatchers.withId(R.id.editText))
                .perform(ViewActions.typeText("This is a test"));

        Espresso.onView(ViewMatchers.withId(R.id.button))
                .perform(ViewActions.click());

        Espresso.onView(ViewMatchers.withId(R.id.resultText))
                .check(ViewAssertions.matches(ViewMatchers.withText("Words: 4")));
    }

    @Test
    public void testCharCountButton() {
        Espresso.onView(ViewMatchers.withId(R.id.editText))
                .perform(ViewActions.typeText("Hello"));

        Espresso.onView(ViewMatchers.withId(R.id.spinner))
                .perform(ViewActions.click());
        Espresso.onData(ViewMatchers.withText("Chars"))
                .perform(ViewActions.click());

        Espresso.onView(ViewMatchers.withId(R.id.button))
                .perform(ViewActions.click());

        Espresso.onView(ViewMatchers.withId(R.id.resultText))
                .check(ViewAssertions.matches(ViewMatchers.withText("Characters: 5")));
    }


}