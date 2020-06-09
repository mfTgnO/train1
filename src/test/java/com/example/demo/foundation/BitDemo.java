package com.example.demo.foundation;

import org.junit.Test;

/**
 * Java Bitwise and Bit Shift Operators
 * https://cs-fundamentals.com/java-programming/java-bitwise-operators
 *
 * Java Bitwise and Bit Shift Operators
 * https://www.programiz.com/java-programming/bitwise-operators
 *
 * Java - Basic Operators
 * https://www.tutorialspoint.com/java/java_basic_operators.htm
 */
public class BitDemo {
    /**
     * Bitwise Complement (~)
     * <p>
     * The bitwise complement (~) or bitwise NOT operator is a unary operator that inverts each bit of its single operand,
     * converting ones to zeros and zeros to ones. For example the following program inverts all bits of b and clears
     * flag f in a set of flags by using bitwise NOT operator.
     */
    @Test
    public void test1() {
        byte b = ~12;// // ~00000110 ==> 11111001 or -13 decimal
        int flags = 28;
        int f = 4;
        flags = flags & ~f;
        System.out.println("b: " + b);
        System.out.println("flags: " + flags);
    }

    /**
     * Bitwise AND (&)
     * <p>
     * The bitwise AND (&) operator is a binary operator that operates on two integer operands
     * by performing a Boolean AND operation on their individual bits. The result is 1 only if
     * the corresponding bits are 1 in both operands. The bitwise AND is a perfect way to test
     * if a particular bit is 1 or 0 in an integer. Following program demonstrates the bitwise AND operator.
     */
    @Test
    public void test2() {
        int flags = 28;
        int f = 4;
        // Test whether flag f is set
        if ((flags & f) != 0) // 011100 & 000100 ==> 000100 or 4
        {
            System.out.println("flag f is set in flags: " + (flags & f));
        } else {
            System.out.println("flag f is not set in flags: " + (flags & f));
        }
    }
}
