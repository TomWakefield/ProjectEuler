/*
 * Project Euler 0006
 *
 * The sum of the squares of the first ten natural numbers is,
 * 1^2 + 2^2 + ... + 10^2 = 385
 * The square of the sum of the first ten natural numbers is,
 * (1 + 2 + ... + 10)^2 = 55^2 = 3025
 * Hence the difference between the sum of the squares of the first ten natural
 * numbers and the square of the sum is 3025 − 385 = 2640.
 *
 * Find the difference between the sum of the squares of the first one hundred
 * natural numbers and the square of the sum.
 */
package projecteuler;

/**
 *
 * @author Tom
 */
public class Euler0006 {
    public static void solve() {
        double sumOfSquares = 0;
        double squareOfSum;
        
        squareOfSum = Math.pow(0.5 * 100 * 101, 2);
        
        for (int i = 1; i <= 100; i++) {
            sumOfSquares += Math.pow(i, 2);
        }
        
        System.out.printf("%.0f%n", squareOfSum - sumOfSquares);
    }
}
