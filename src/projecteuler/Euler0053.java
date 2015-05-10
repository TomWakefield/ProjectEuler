/*
 * There are exactly ten ways of selecting three from five, 12345:
 *
 * 123, 124, 125, 134, 135, 145, 234, 235, 245, and 345
 *
 * In combinatorics, we use the notation, 5C3 = 10.
 *
 * In general,
 *
 * nCr = n!/r!(n−r)! ,where r ≤ n, n! = n×(n−1)×...×3×2×1, and 0! = 1.
 * It is not until n = 23, that a value exceeds one-million: 23C10 = 1144066.
 *
 * How many, not necessarily distinct, values of  nCr, for 1 ≤ n ≤ 100, are
 * greater than one-million?
 */
package projecteuler;

/**
 *
 * @author Tom
 */
public class Euler0053 {
    
    public static void solve() {
        long counter = 0;
        int r;
        for (int n = 23; n <= 100; n++) {
            r = -1;
            while (nCr(n, r + 1) <= 1000000 && (r + 1 < n / 2)) { r++; }
            // n + 1 options, less first and last r + 1 options
            counter += (n - (2 * r) - 1); 
        }
        System.out.println(String.valueOf(counter));
    }
    
    public static int nCr(int n, int r) {
        double result = 1.0;
        for (int i = r + 1; i <= n; i++) {
            result *= i;
        }
        for (int i = (n - r); i >= 2; i--) {
            result /= i;
        }
        return (int)result;
    }
}