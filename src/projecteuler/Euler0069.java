/*
 * Project Euler 0069
 *
 * Euler's Totient function, φ(n) [sometimes called the phi function], is used
 * to determine the number of numbers less than n which are relatively prime to
 * n. For example, as 1, 2, 4, 5, 7, and 8, are all less than nine and
 * relatively prime to nine, φ(9)=6.
 * # TABLE #
 * It can be seen that n=6 produces a maximum n/φ(n) for n ≤ 10.
 *
 * Find the value of n ≤ 1,000,000 for which n/φ(n) is a maximum.
 */
package projecteuler;

/**
 *
 * @author Tom
 */
public class Euler0069 {
    public static boolean isPrime(int number) {
        if (number < 2) { return false; }
        if (number == 2) { return true; }
        if (number % 2 == 0) { return false; }
        
        for (int i = 3; i <= Math.sqrt(number); i += 2) {
            if (number % i == 0) { return false; }
        }
        
        return true;
    }
    
    public static int getNextPrime(int lastNumber) {
        int nextTest = lastNumber + 1;
        while (isPrime(nextTest) == false) {
            nextTest++;
        }
        return nextTest;
    }
    
    public static void solve() {
        /*
         * The maximum n/φ(n) requires a small φ(n) i.e. as few relatively
         * prime numbers as possible. Therefore the target number is the product
         * of all primes up to the point that it goes over 1000000.
         */
        int total = 1;
        int nextPrime = getNextPrime(1);
        while (total * nextPrime <= 1000000) {
            total *= nextPrime;
            nextPrime = getNextPrime(nextPrime);
        }
        System.out.println(total);
    }
}
