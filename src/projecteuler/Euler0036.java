/*
 * Project Euler 0036 
 *
 * The decimal number, 585 = 10010010012 (binary), is palindromic in both bases.
 *
 * Find the sum of all numbers, less than one million, which are palindromic in
 * base 10 and base 2.
 *
 * (Please note that the palindromic number, in either base, may not include
 * leading zeros.)
 */
package projecteuler;

/**
 *
 * @author Tom
 */
public class Euler0036 {
    public static boolean isPalindrome(String word) {
        return word.equals(new StringBuilder(word).reverse().toString());
    }
    
    public static void solve() {
        int total = 0;
        int temp;
        /* possible formats for number:
         * a, aa, aba, abba, abcba, abccba
         * where a is odd, since if a was even the binary number would end in 0
         * and therefore start with 0, which is forbidden
         */
        for (int a = 1; a <= 9; a+= 2 ) {
            if (isPalindrome(Integer.toBinaryString(a))) {
                total += a;
            }
            temp = 11 * a;
            if (isPalindrome(Integer.toBinaryString(temp))) {
                total += temp;
            }
            for (int b = 0; b <= 9; b++ ) {
                temp = 101 * a + 10 * b;
                if (isPalindrome(Integer.toBinaryString(temp))) {
                    total += temp;
                }
                temp = 1001 * a + 110 * b;
                if (isPalindrome(Integer.toBinaryString(temp))) {
                    total += temp;
                }
                for (int c = 0; c <= 9; c++ ) {
                    temp = 10001 * a + 1010 * b + 100 * c;
                    if (isPalindrome(Integer.toBinaryString(temp))) {
                        total += temp;
                    }
                    temp = 100001 * a + 10010 * b + 1100 * c;
                    if (isPalindrome(Integer.toBinaryString(temp))) {
                        total += temp;
                    }
                }
            }
        }
        
        System.out.println(total);
    }
}
