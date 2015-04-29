/*
 * Project Euler 0040
 *
 * An irrational decimal fraction is created by concatenating the positive integers:
 *
 * 0.123456789101112131415161718192021...
 *
 * It can be seen that the 12th digit of the fractional part is 1.
 *
 * If d(n) represents the nth digit of the fractional part, find the value of the
 * following expression.
 *
 * d(1) × d(10) × d(100) × d(1000) × d(10000) × d(100000) × d(1000000)
 */
package projecteuler;

/**
 *
 * @author Tom
 */
import static java.lang.Math.*;

public class Euler0040 {
    
    public static void solve() {
        int total = 1;
        for (int i = 0; i < 7; i++) {
            total *= getD((int) pow(10, i));
        }
        System.out.println(String.valueOf(total));
    }
    
    public static int getD(int n) {
        int remaining = n;
        int targetNumber;
        int digits;
        
        // Removes count for all numbers with fewer digits
        digits = 1;
        while (remaining > (digits * 9 * pow(10, digits - 1))) {
            remaining -= (digits * 9 * pow(10, digits - 1));
            digits++;
        }
        
        /*
         * targetNumber is at 99.. for x-1 9s if the index n refers to a digit
         * in a number with x digits
         */
        targetNumber = (int) pow(10, digits - 1) - 1;
        
        // targetNumber is now the correct value from which the digit is taken
        targetNumber += (int) (remaining - 1)/digits + 1;
        remaining = remaining % digits;
        
        if (remaining == 0) {
            return targetNumber % 10;
        } else {
            return Character.getNumericValue(String.valueOf(targetNumber).charAt(remaining - 1));
        }
    }
}