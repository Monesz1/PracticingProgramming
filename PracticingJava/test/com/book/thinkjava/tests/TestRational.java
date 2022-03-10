/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.book.thinkjava.tests;

import com.book.thinkjava.Rational;
import static org.junit.Assert.assertEquals;
import org.junit.Before;
import org.junit.Test;

/**
 *
 * @author Attila Molnar
 */
public class TestRational {

    Rational rational;

    @Before
    public void setUp() {
        rational = new Rational();
    }

    @Test
    public void testConstructorAndGetter() {
        rational = new Rational(3, 2);
        assertEquals("Numerator should be 3", 3, rational.getNumerator());
        assertEquals("Denominator should be 2", 2, rational.getDenominator());
    }

    @Test
    public void testPrintRational() {
        rational = new Rational(3, 2);
        rational.printRational();
        String t = String.format("%1$3s %2$3s", 3, 2);
        assertEquals(t, rational.getText());
    }

    @Test
    public void testToString() {
        rational = new Rational(3, 2);
        assertEquals("toString not working properly", "3, 2", rational.toString());
    }

    @Test
    public void testNegate() {
        rational = new Rational(3, 2);
        rational.negate();
        assertEquals(-3, rational.getNumerator());
        assertEquals(-2, rational.getDenominator());
    }

    @Test
    public void testInvert() {
        rational = new Rational(3, 2);
        rational.invert();
        assertEquals(2, rational.getNumerator());
        assertEquals(3, rational.getDenominator());
    }

    @Test
    public void testToDouble() {
        rational = new Rational(4, 2);
        double d = 2.0;
        assertEquals(d, rational.toDouble(), 0);
    }

    @Test
    public void testReduce() {
        rational = new Rational();
        rational.reduce(210, 45);
    }

    @Test
    public void testAdd() {
        rational = new Rational(60, 42);
        Rational rational2 = new Rational(210, 45);
        Rational rational3 = rational.add(rational2);
        assertEquals("90, 29", rational3.toString());
    }

}
