package projecteuler;

/**
 *
 * @author Tom
 */
public class Caller {
    public static void main(String[] args) {
        final long startTime = System.currentTimeMillis();
        
        Euler0036.solve();
        
        final long endTime = System.currentTimeMillis();
        System.out.println(String.valueOf(endTime - startTime) + "ms");
    }
}
