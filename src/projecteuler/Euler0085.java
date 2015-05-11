/*
 * Euler0085
 *
 * By counting carefully it can be seen that a rectangular grid measuring 3 by 2
 * contains eighteen rectangles:
 *
 *
 * Although there exists no rectangular grid that contains exactly two million
 * rectangles, find the area of the grid with the nearest solution.
 */
package projecteuler;

/**
 *
 * @author Tom
 */
public class Euler0085
{
    public static void solve() {
        int variance;
        int minVariance = 2000000;
        int minRows = 1;
        int minCols = 1;
        
        /*
         * n(n + 1)/2 > 2000000
         * n(n + 1) > 4000000
         * n^2 + n > 4000000
         * (n + 1/2)^2 - 1/4 > 4000000
         * (n + 1/2)^2 > 4000000 + 1/4
         * n + 1/2 > 2000 + a bit
         * n > 2000 - a bit
         * n = 2000
         */
        int startPoint = 2000;
        for (int rows = 1; rows <= startPoint; rows++) {
            for (int cols = 1; cols <= rows; cols++) {
                variance = Math.abs(2000000 - countRectangles(rows, cols));
                if (variance < minVariance) {
                    minVariance = variance;
                    minRows = rows;
                    minCols = cols;
                }
            }
        }
        System.out.println(String.valueOf(minRows * minCols));
    }
    
    public static int countRectangles(int rows, int cols) {
        return rows * (rows + 1) * cols * (cols + 1)/4;
    }
}
