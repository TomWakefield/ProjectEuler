/*
 * Project Euler 0050
 *
 * The prime 41, can be written as the sum of six consecutive primes:
 *
 * 41 = 2 + 3 + 5 + 7 + 11 + 13
 * This is the longest sum of consecutive primes that adds to a prime below
 * one-hundred.
 *
 * The longest sum of consecutive primes below one-thousand that adds to a
 * prime, contains 21 terms, and is equal to 953.
 *
 * Which prime, below one-million, can be written as the sum of the most
 * consecutive primes?
 */
package projecteuler;

/**
 *
 * @author Tom
 */
import java.util.*;

public class Euler0050 {
    private static final int LIMIT = 1000000;
    
    public static void solve() {
        List<Integer> primes = Functions.getPrimesUpToN(LIMIT);
        List<Integer> cummPrimes = new ArrayList<>();
        Set<Integer> primesSet = new HashSet<>(primes);
        int total = 0;
        int index1 = 0;
        int index2;
        int currentSum;
        int maxLength = 0;
        int maxLengthSum = 0;
        
        while (total + primes.get(index1) <= LIMIT) {
            total += primes.get(index1);
            cummPrimes.add(total);
            index1++;
        }
        
        index1 = cummPrimes.size() - 1;
        while (index1 > maxLength) {
            if (primesSet.contains(cummPrimes.get(index1))) {
                maxLength = index1 + 1;
                maxLengthSum = cummPrimes.get(index1);
            } else {
                index2 = 0;
                while (index1 - index2 > maxLength) {
                    currentSum = cummPrimes.get(index1) - cummPrimes.get(index2);
                    if (primesSet.contains(currentSum)) {
                        maxLength = index1 - index2;
                        maxLengthSum = currentSum;
                    }
                    index2++;
                }
            }
            index1--;
        }
        
        System.out.println(String.valueOf(maxLengthSum));
    }
}
