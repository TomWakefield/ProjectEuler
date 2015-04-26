/*
 * Project Euler 0005
 *
 * 2520 is the smallest number that can be divided by each of the numbers from
 * 1 to 10 without any remainder.
 *
 * What is the smallest positive number that is evenly divisible by all of the
 * numbers from 1 to 20?
 */
package projecteuler;

/**
 *
 * @author Tom
 */
public class Euler0005 {
    
    public static void solve() {
        int total = 1;
        for (int i = 2; i <= 20; i++) {
            total = lcm(total, i);
        }
        
        System.out.println(String.valueOf(total));
    }
    
    public static int hcf(int num1, int num2) {
        if (num2 == 0) return num1;
        return hcf(num2, num1 % num2);
    }
    
    public static int lcm(int num1, int num2) {
        return num1 / hcf(num1, num2) * num2;
    }
}