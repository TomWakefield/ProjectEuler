/*
 * Project Euler 0007
 *
 * By listing the first six prime numbers: 2, 3, 5, 7, 11, and 13, we can see
 * that the 6th prime is 13.
 *
 * What is the 10001st prime number?
 */
package projecteuler;

import java.util.*;

/**
 *
 * @author Tom
 */
public class Euler0007 {
    private static final int limit = 10001;
    private static List<Integer> primes;
    
    public static void solve() {
        int current = 1;
        primes = new ArrayList<>();
        primes.add(2);
        primes.add(3);
        
        while (primes.size() < limit) {
            addIfPrime(6 * current - 1);
            addIfPrime(6 * current + 1);
            current++;
        }
        System.out.println(String.valueOf(primes.get(limit - 1)));
}
    
    private static boolean addIfPrime(int number) {
        for (int i : primes) {
            if (number % i == 0) return false;
        }
        primes.add(number);
        return true;
    }
}
