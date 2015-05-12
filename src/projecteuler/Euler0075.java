/*
 * Euler0075
 *
 * It turns out that 12 cm is the smallest length of wire that can be bent to
 * form an integer sided right angle triangle in exactly one way, but there are
 * many more examples.
 *
 * 12 cm: (3,4,5)
 * 24 cm: (6,8,10)
 * 30 cm: (5,12,13)
 * 36 cm: (9,12,15)
 * 40 cm: (8,15,17)
 * 48 cm: (12,16,20)
 *
 * In contrast, some lengths of wire, like 20 cm, cannot be bent to form an
 * integer sided right angle triangle, and other lengths allow more than one
 * solution to be found; for example, using 120 cm it is possible to form
 * exactly three different integer sided right angle triangles.
 *
 * 120 cm: (30,40,50), (20,48,52), (24,45,51)
 *
 * Given that L is the length of the wire, for how many values of L ≤ 1,500,000
 * can exactly one integer sided right angle triangle be formed?
 */
package projecteuler;

/**
 *
 * @author Tom
 */
import java.util.Arrays;
import java.util.Collections;

public class Euler0075
{
    public static void solve() {
        Integer[] triangles = new Integer[1500001];
        Arrays.fill(triangles, 0);
        int a, b, c;
        int length;
        int factor;
        for (int m = 2; m <= 1000; m++) {
            for (int n = m % 2 + 1; n < m; n += 2) {
                if (Functions.getGCD(m, n) == 1) {
                    a = m * m - n * n;
                    b = 2 * m * n;
                    c = m * m + n * n;
                    length = a + b + c;
                    factor = 1;
                    while (factor * length <= 1500000) {
                        triangles[factor * length] = 
                                triangles[factor * length] + 1;
                        factor++;
                    }   
                }
            }
        }
        System.out.println(Collections.frequency(Arrays.asList(triangles), 1));
    }
}
