/*
 * The sum of the primes below 10 is 2 + 3 + 5 + 7 = 17.
 * Find the sum of all the primes below two million.
 */
package projecteuler;

/**
 *
 * @author Tom
 */
import java.math.BigInteger;

public class Euler0010 {
    
    private static final int limit = 2000000;
    private static int[] primes;
    
    public static void solve() {
        fillArray(limit);
        System.out.println(sumArray().toString());
    }
    
    private static BigInteger sumArray() {
        BigInteger total = new BigInteger("0");
        for (int i = 0; i < primes.length; i++) {
            if (primes[i] > 0) {
                total = total.add(new BigInteger(String.valueOf(primes[i])));
            }
        }
        return total;
    }
    
    private static void fillArray(int upperLimit) {
        int index;
        int value;
        
        primes = new int[upperLimit];
        for (int i = 1; i < upperLimit; i++) {
            primes[i-1] = i;
        }
        
        index = 0;
        primes[0] = 0; // Set 1 to non-prime
        
        while (index * index < primes.length) {
            value = primes[index];
            if (value > 0) {
                for (int i = value * value - 1; i < primes.length; i += value) {
                    primes[i] = 0;
                }
            }
            index++;
        }
    }

}