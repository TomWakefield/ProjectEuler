/*
 * Project Euler 0001
 *
 * If we list all the natural numbers below 10 that are multiples of 3 or 5, we
 * get 3, 5, 6 and 9. The sum of these multiples is 23. Find the sum of all the
 * multiples of 3 or 5 below 1000.
 */
package projecteuler;

/**
 *
 * @author Tom
 */
public class Euler0001 {
    
    public static final int LIMIT = 999;
	
    private static int sumOfMultiples(int multiple, int limit)
    {
        int revisedLimit = limit/multiple;
        return (int)(multiple * 0.5 * revisedLimit * (revisedLimit + 1));
    }
	
    public static void solve()
    {
        int total = sumOfMultiples(3, LIMIT) + sumOfMultiples(5, LIMIT) -
            sumOfMultiples(15, LIMIT);
        System.out.println(total);
    }
}