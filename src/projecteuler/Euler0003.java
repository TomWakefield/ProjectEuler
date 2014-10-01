/*
 * Project Euler 0003
 *
 * The prime factors of 13195 are 5, 7, 13 and 29.
 * What is the largest prime factor of the number 600851475143 ?
 */
package projecteuler;

/**
 *
 * @author Tom
 */
public class Euler0003 {
    
    public static void solve() {
        long startNum = 600851475143L;
        int factor = 3; // by inspection the number is not even

        while (startNum > 1) {
            if (startNum % factor == 0) {
                startNum /= factor;
            } else {
                factor += 2; // only check odd numbers
            }
        }

        System.out.println(factor); 
    }
}
