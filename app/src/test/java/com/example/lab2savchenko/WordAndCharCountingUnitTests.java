package com.example.lab2savchenko;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class WordAndCharCountingUnitTests {

    @Test
    public void testWordCount() {

        assertEquals(0, Counter.countWords(""));

        assertEquals(1, Counter.countWords("Abc"));

        assertEquals(8, Counter.countWords("This is a test.Test,test.. Test 123"));

    }

    @Test
    public void testCharCount() {
        assertEquals(0, Counter.countChars(""));

        assertEquals(3, Counter.countChars("Abc"));

        assertEquals(35, Counter.countChars("This is a test.Test,test.. Test 123"));

    }


}
