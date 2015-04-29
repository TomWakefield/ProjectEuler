/*
 * Project Euler 0023
 *
 * A perfect number is a number for which the sum of its proper divisors is
 * exactly equal to the number. For example, the sum of the proper divisors of
 * 28 would be 1 + 2 + 4 + 7 + 14 = 28, which means that 28 is a perfect number.
 *
 * A number n is called deficient if the sum of its proper divisors is less than
 * n and it is called abundant if this sum exceeds n.
 *
 * As 12 is the smallest abundant number, 1 + 2 + 3 + 4 + 6 = 16, the smallest
 * number that can be written as the sum of two abundant numbers is 24. By
 * mathematical analysis, it can be shown that all integers greater than 28123
 * can be written as the sum of two abundant numbers. However, this upper limit
 * cannot be reduced any further by analysis even though it is known that the
 * greatest number that cannot be expressed as the sum of two abundant numbers
 * is less than this limit.
 *
 * Find the sum of all the positive integers which cannot be written as the sum
 * of two abundant numbers.
 */
package projecteuler;

/**
 *
 * @author Tom
 */
import java.util.Arrays;

public class Euler0023 {
    
    private static final int LIMIT = 28123;
    private static boolean[] abundant;
    private static boolean[] abundantSums;
    
    public static void solve() {
        int total = 0;
        getAbundantNumbers();
        getAbundantSums();
        for (int i = 0; i < abundant.length; i++) {
            if (!abundantSums[i]) { total += i; }
        }
        System.out.println(String.valueOf(total));
    }
    
    private static void getAbundantNumbers() {
        abundant = new boolean[LIMIT + 1]; 
        Arrays.fill(abundant, 0, abundant.length, false);
        for (int i = 12; i <= LIMIT - 12; i++) {
            if (i < sumOfProperFactors(i)) { abundant[i] = true; }
        }
    }
    
    private static int sumOfProperFactors(int number) {
        int total = 1;
        
        for (int i = 2; i * i <= number; i++) {
            if (number % i == 0) {
                total += i;
                if (i * i != number) { total += (number/i); }
            }
        }
        
        return total;
    }
    
    private static void getAbundantSums() {
        abundantSums = new boolean[LIMIT + 1];
        Arrays.fill(abundantSums, 0, abundant.length, false);
        for (int i = 12; i < abundant.length; i++) {
            for (int j = i; j < abundant.length; j++) {
                if (i + j > LIMIT) {
                    break;
                } else if (abundant[i] && abundant[j]) {
                    abundantSums[i+j] = true;
                }
            }
        }
    }
}
