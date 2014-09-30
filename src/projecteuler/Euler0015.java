/*
 * Starting in the top left corner of a 2×2 grid, and only being able to move to
 * the right and down, there are exactly 6 routes to the bottom right corner.
 * # IMAGE #
 * How many such routes are there through a 20×20 grid?
 */
package projecteuler;

/**
 *
 * @author Tom
 */
public class Euler0015 {
    private static double factorial(int input ) {
        double total = 1;
        for (int i = 2; i <= input; i++) {
            total *= i;
        }
        return total;
    }
    private static double countRoutes(int rows, int columns) {
        return factorial(rows + columns)/(factorial(rows) * factorial(columns));
    }
    
    public static void solve() {
        System.out.printf("%.0f%n", countRoutes(20, 20));
    }
}
