package com.example.demo.junit.junittestingbasics;

import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Optional;
import java.util.function.BooleanSupplier;

import static java.time.Duration.ofSeconds;
import static java.util.Arrays.asList;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertSame;
import static org.junit.Assert.*;
import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.fail;
import static org.junit.matchers.JUnitMatchers.hasItems;


/**
 * @Package: com.example.demo.junit.junittestingbasics
 * @Author:
 * @Email:
 * @CreateDate: 2019-04-27 14:37
 * @Description:
 */
public class AssertionsInJUnit4AndJUnit5 {
    // Assertions in JUnit 4
    @Test
    public void whenAssertingEquality_thenEqual() {
        String expected = "Baeldung";
        String actual = "Baeldung";

        assertEquals(expected, actual);
    }

    @Test
    public void whenAssertingEquality_thenEqual_v2() {
        String expected = "Baeldung";
        String actual = "Baeldung";

        Assert.assertEquals("failure - strings are not equal", expected, actual);
    }

    @Test
    public void whenAssertingArraysEquality_thenEqual() {
        char[] expected = {'J', 'u', 'n', 'i', 't'};
        char[] actual = "Junit".toCharArray();

        assertArrayEquals(expected, actual);
    }

    @Test
    public void givenNullArrays_whenAssertingArraysEquality_thenEqual() {
        int[] expected = null;
        int[] actual = null;

        assertEquals(expected, actual);
    }

    @Test
    public void whenAssertingNull_thenTrue() {
        Object car = null;

        assertNull("The car should be null", car);
    }

    @Test
    public void whenAssertingNotNull_thenTrue() {
        Object car = "Toyota";

        assertNotNull("The car should be null", car);
    }

    @Test
    public void testAssertThatHasItems() {
        assertThat(
                asList("Java", "Kotlin", "Scala"),
                hasItems("Java", "Kotlin"));
    }

    // JUnit 5 Assertions
    @Test
    public void whenAssertingArraysEquality_thenEqual_JUnit5() {

        char[] expected = {'J', 'u', 'p', 'i', 't', 'e', 'r'};
        char[] actual = "Jupiter".toCharArray();

        assertArrayEquals(expected, actual, "Arrays should be equal");
    }

    @Test
    public void whenAssertingEquality_thenEqual_JUnit5() {
        float square = 2 * 2;
        float rectangle = 2 * 2;

        assertEquals(square, rectangle);
    }

    @Test
    public void whenAssertingEqualityWithDelta_thenEqual_JUnit5() {
        float square = 2 * 2;
        float rectangle = 3 * 2;
        float delta = 2;

        assertEquals(square, rectangle, delta);
    }

    @Test
    public void whenAssertingConditions_thenVerified_JUnit5() {
        assertTrue(5 > 4, "5 is greater the 4");
        assertTrue(null == null, "null is equal to null");
    }

    @Test
    public void givenBooleanSupplier_whenAssertingCondition_thenVerified_JUnit5() {
        BooleanSupplier condition = () -> 5 > 6;

        assertFalse(condition, "5 is not greater then 6");
    }

    @Test
    public void whenAssertingNotNull_thenTrue_JUnit5() {
        Object dog = new Object();

        assertNotNull(dog, () -> "The dog should not be null");
    }

    @Test
    public void whenAssertingNull_thenTrue_JUnit5() {
        Object cat = null;

        assertNull(cat, () -> "The cat should be null");
    }

    @Test
    public void whenAssertingSameObject_thenSuccessfull_JUnit5() {
        String language = "Java";
        Optional<String> optional = Optional.of(language);

        assertSame(language, optional.get());
    }

    @Test
    public void whenFailingATest_thenFailed_JUnit5() {
        // Test not completed
        fail("FAIL - test not completed");
    }

    @Test
    public void givenMultipleAssertion_whenAssertingAll_thenOK_JUnit5() {
        assertAll(
                "heading",
                () -> assertEquals(4, 2 * 2, "4 is 2 times 2"),
                () -> assertEquals("java", "JAVA".toLowerCase()),
                () -> assertEquals(null, null, "null is equal to null")
        );
    }

    @Test
    public void givenTwoLists_whenAssertingIterables_thenEquals_JUnit5() {
        Iterable<String> al = new ArrayList<>(asList("Java", "Junit", "Test"));
        Iterable<String> ll = new LinkedList<>(asList("Java", "Junit", "Test"));

        assertIterableEquals(al, ll);
    }

    @Test
    public void whenAssertingEqualityListOfStrings_thenEqual_JUnit5() {
        List<String> expected = asList("Java", "\\d+", "JUnit");
        List<String> actual = asList("Java", "11", "JUnit");

        assertLinesMatch(expected, actual);
    }

    @Test
    public void whenAssertingEquality_thenNotEqual_JUnit5() {
        Integer value = 5; // result of an algorithm

        assertNotEquals(0, value, "The result cannot be 0");
    }

    @Test
    public void whenAssertingException_thenThrown_JUnit5() {
        Throwable exception = assertThrows(
                IllegalArgumentException.class,
                () -> {
                    throw new IllegalArgumentException("Exception message");
                }
        );
        assertEquals("Exception message", exception.getMessage());
    }

    @Test
    public void whenAssertingTimeout_thenNotExceeded_JUnit5() {
        assertTimeout(
                ofSeconds(2),
                () -> {
                    // code that requires less then 2 minutes to execute
                    Thread.sleep(1000);
                }
        );
    }
}
