package com.example.demo.junit.junittestingbasics;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import static org.junit.jupiter.api.Assertions.assertThrows;

/**
 * @Package: com.example.demo.junit.junittestingbasics
 * @Author:
 * @Email:
 * @CreateDate: 2019-04-27 15:45
 * @Description:
 */
public class AssertAnExceptionIsThrownInJUnit4And5 {
    // JUnit 5
    // JUnit 5 Jupiter assertions API introduces the assertThrows method for asserting exceptions.
    @Test
    public void whenExceptionThrown_thenAssertionSucceeds() {
        String test = null;
        assertThrows(NullPointerException.class, () -> {
            test.length();
        });
    }

    @Test
    public void whenDerivedExceptionThrown_thenAssertionSucceds() {
        String test = null;
        assertThrows(RuntimeException.class, () -> {
            test.length();
        });
    }

    // JUnit 4
    @Test(expected = NullPointerException.class)
    public void whenExceptionThrown_thenExpectationSatisfied() {
        String test = null;
        test.length();
    }

    @Rule
    public ExpectedException exceptionRule = ExpectedException.none();

    @Test
    public void whenExceptionThrown_thenRuleIsApplied() {
        exceptionRule.expect(NumberFormatException.class);
        exceptionRule.expectMessage("For input string");
        Integer.parseInt("1a");
    }
}
