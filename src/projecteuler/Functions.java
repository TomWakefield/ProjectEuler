/*
 * Provides functions commonly used in Project Euler problems
 */
package projecteuler;

import java.util.*;

/**
 *
 * @author Tom
 */
public class Functions
{
    public static List<Integer> getPrimesUpToN(int n) {
        List<Integer> primes = new ArrayList<>();
        boolean[] numbers = new boolean[n + 1];
        Arrays.fill(numbers, 2, n + 1, true);
        
        // Filter up to square root
        for (int index = 2;  index <= Math.sqrt(numbers.length); index++) {
            if (numbers[index]) {
                primes.add(index);
                for (int mult = index * index; mult < numbers.length; mult+= index) {
                    numbers[mult] = false;
                }
            }
        }
        
        // All remaining numbers must be prime
        for (int index = (int) Math.sqrt(numbers.length) + 1;  index < numbers.length; index++) {
            if (numbers[index]) { primes.add(index); }
        }
        
        return primes;
    }
    
    public static Set<Integer> getSetPrimesUpToN(int n) {
        Set<Integer> primes = new HashSet<>(getPrimesUpToN(n));
        return primes;
    }
    
    public static boolean isPalindrome(int number) {
        String reverse = 
                new StringBuilder(String.valueOf(number)).reverse().toString();
        return String.valueOf(number).equals(reverse);
    }
    
    public static boolean isPalindrome(String word) {
        String reverse = 
                new StringBuilder(word).reverse().toString();
        return word.equals(reverse);
    }
    
    public static int getGCD(int num1, int num2) {
        if (num2 == 0) return num1;
        return getGCD(num2, num1 % num2);
    }
}
