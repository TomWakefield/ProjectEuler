/*
 * Project Euler 0004
 *
 * A palindromic number reads the same both ways. The largest palindrome made
 * from the product of two 2-digit numbers is 9009 = 91 × 99.
 *
 * Find the largest palindrome made from the product of two 3-digit numbers.
 */
package projecteuler;

/**
 *
 * @author Tom
 */
public class Euler0004 {
    
    public static void solve() {
        int maxNum = 100001;
        int testNum;
        
        for (int i = 999; i >= 100; i--) {
            for (int j = 999; j >= i; j--) {
                testNum = i * j;
                if (testNum <= maxNum) {
                    break;
                } else if (Functions.isPalindrome(testNum)) {
                    maxNum = testNum;
                    break;
                }
            } 
        }
        
        System.out.println(String.valueOf(maxNum));
    }
}