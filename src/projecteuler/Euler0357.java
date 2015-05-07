/*
 * Project Euler 0357
 *
 * Consider the divisors of 30: 1,2,3,5,6,10,15,30.
 * It can be seen that for every divisor d of 30, d+30/d is prime.
 *
 * Find the sum of all positive integers n not exceeding 100 000 000
 * such that for every divisor d of n, d+n/d is prime.
 */
package projecteuler;

/**
 *
 * @author Tom
 */
import java.util.*;

public class Euler0357
{
    private static Set<Integer> primes;
    private static final int LIMIT = 100000000;
    
    public static void solve() {
        long total = 0;
        primes = Functions.getSetPrimesUpToN(LIMIT);
        
        /*
         * if d = 1 then d + n/d = 1 + n/1 = 1 + n
         * therefore 1 + n must be prime. Therefore only p - 1 for each prime p
         * less than the upper limit needs to be checked
         */
        for (int p : primes) {
            if (isValid(p - 1)) { total += (p - 1); }
        }

        System.out.println(String.valueOf(total));
    }
    
    private static boolean isValid(int n) {
        if (n == 1) { return true; }
        for (int d = 2; d <= Math.sqrt(n); d++) {
            if (n % d == 0) {
                if (n % (d * d) == 0 || !primes.contains(d + (n/d))) {
                    return false;
                }
            }
        }
        return true;
    }
}
