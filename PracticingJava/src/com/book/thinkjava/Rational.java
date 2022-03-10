package com.book.thinkjava;

/**
 *
 * @author Attila Molnar
 */
public class Rational { //Exercise 11.4

    private int numerator;
    private int denominator;
    private String text;

    public Rational() {
        this.numerator = 0;
        this.denominator = 1;
    }

    public Rational(int numerator, int denominator) {
        this.numerator = numerator;
        this.denominator = denominator;
    }

    public void printRational() {
        text = String.format("%1$3s %2$3s", numerator, denominator);
        System.out.println("Print rational nums: " + text);
    }

    public static void main(String[] args) {
        Rational rational = new Rational(2, 3);
        rational.printRational();
        System.out.println("Numbers: " + rational.toString());
        System.out.println("Negate nums");
        rational.negate();
        System.out.println("Negated nums: " + rational.toString());
        System.out.println("Invert nums");
        rational.invert();
        System.out.println("Inverted nums: " + rational.toString());
        System.out.println("Rational num: " + rational.toDouble());
        rational = new Rational(60, 42);
        System.out.println("Greatest common divisor: " + rational.reduce(rational.getNumerator(), rational.getDenominator()));
        Rational rat = rational.add(new Rational(210, 45));
        System.out.println("New rational number:" + rat.toString());
    }

    public int getNumerator() {
        return numerator;
    }

    public int getDenominator() {
        return denominator;
    }

    public String getText() {
        return text;
    }

    @Override
    public String toString() {
        return numerator + ", " + denominator;
    }

    public void negate() {
        this.numerator = numerator - (numerator * 2);
        this.denominator = denominator - (denominator * 2);
    }

    public void invert() {
        int temp = this.numerator;
        this.numerator = denominator;
        this.denominator = temp;
    }

    public double toDouble() {
        return (double) numerator / denominator;
    }

    public int reduce(int numerator, int denominator) {
        int r = 0;

        if (numerator < denominator) {
            System.out.println("Numerator should be bigger then denominator");
            return 0;
        }

        r = numerator % denominator;

        if (r != 0) {
            numerator = denominator;
            denominator = reduce(numerator, r);
        }

        return denominator;

    }

    public Rational add(Rational number) {
        int numerator = this.numerator + number.getNumerator();
        int denominator = this.denominator + number.getDenominator();
        int gcd = reduce(numerator, denominator);
        numerator = numerator / gcd;
        denominator = denominator / gcd;
        return new Rational(numerator, denominator);
    }
}
