/*
 * Project Euler 0009
 *
 * A Pythagorean triplet is a set of three natural numbers, a < b < c, for which,
 * a^2 + b^2 = c^2
 * For example, 3^2 + 4^2 = 9 + 16 = 25 = 5^2.
 *
 * There exists exactly one Pythagorean triplet for which a + b + c = 1000.
 * Find the product abc.
 */
package projecteuler;

import static java.lang.Math.pow;

/**
 *
 * @author Tom
 */
public class Euler0009 {
    
    public static void solve() {
        int a;
        outerloop:
        for (int c = 334; c <= 500; c++) {
            for (int b = c/2; b < c; b++){
                a = 1000 - b - c;
                if (pow(a, 2) + pow(b, 2) == pow(c, 2)) {
                    System.out.println(String.valueOf(a * b * c));
                    break outerloop;
                }
            }
        }
    }
}