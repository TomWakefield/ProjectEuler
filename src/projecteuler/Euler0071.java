/*
 * Euler0071
 *
 * Consider the fraction, n/d, where n and d are positive integers. If n < d and
 * HCF(n, d) = 1, it is called a reduced proper fraction.
 *
 * If we list the set of reduced proper fractions for d ≤ 8 in ascending order
 * of size, we get:
 *
 * 1/8, 1/7, 1/6, 1/5, 1/4, 2/7, 1/3, 3/8, 2/5, 3/7, 1/2, 4/7, 3/5, 5/8, 2/3,
 * 5/7, 3/4, 4/5, 5/6, 6/7, 7/8
 *
 * It can be seen that 2/5 is the fraction immediately to the left of 3/7.
 *
 * By listing the set of reduced proper fractions for d ≤ 1,000,000 in ascending
 * order of size, find the numerator of the fraction immediately to the left of
 * 3/7.
 */
package projecteuler;

/**
 *
 * @author Tom
 */
public class Euler0071
{
    public static void solve() {

        double maxValue = 0.0;
        double maxNumerator = 0.0;
        double numerator;

        for (int denominator = 1000000; denominator > 0; denominator--) {
            /* 
             * Sets numerator to highest value so numerator/denominator strictly
             * less than 3/7
             */
            numerator = Math.floor(denominator * (3.0/7.0));
            if (numerator/denominator == 3.0/7.0) { numerator--; }

            if (numerator/denominator > maxValue) {
                maxValue = numerator/denominator;
                maxNumerator = numerator;
            } 
        }   
        System.out.println(String.format("%.0f", maxNumerator));
    }
}
