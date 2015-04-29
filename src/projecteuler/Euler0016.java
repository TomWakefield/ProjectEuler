/*
 * Project Euler 0016
 *
 * 2^15 = 32768 and the sum of its digits is 3 + 2 + 7 + 6 + 8 = 26.
 * What is the sum of the digits of the number 2^1000?
 */
package projecteuler;

/**
 *
 * @author Tom
 */
import java.math.BigInteger;

public class Euler0016 {
    
    public static void solve() {
        BigInteger number = new BigInteger("1");
        String strNumber;
        int total = 0;
        
        for (int i = 0; i < 1000; i++) {
            number = number.multiply(new BigInteger("2"));
        }
        strNumber = number.toString();
        
        for (int i = 0; i < strNumber.length(); i++) {
            total += strNumber.charAt(i) - 48; // -48 converts ascii code to value
        }
        
        System.out.println(String.valueOf(total));
    }

}
