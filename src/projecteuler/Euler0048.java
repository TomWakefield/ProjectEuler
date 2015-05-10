/*
 * Project Euler 0048
 *
 * The series, 1^1 + 2^2 + 3^3 + ... + 10^10 = 10405071317.
 *
 * Find the last ten digits of the series, 1^1 + 2^2 + 3^3 + ... + 1000^1000.
 */
package projecteuler;

/**
 *
 * @author Tom
 */
import java.math.BigInteger;

public class Euler0048 {
    
    public static void solve() {
        BigInteger total = new BigInteger("0");
        BigInteger current;
        for (int counter = 1; counter <= 1000; counter++) {
            current = new BigInteger(String.valueOf(counter));
            current = current.pow(counter);
            total = total.add(current);
        }
        String totalStr = total.toString();
        System.out.println(totalStr.substring(totalStr.length()- 10));
    }
}