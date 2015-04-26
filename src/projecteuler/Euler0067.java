/*
 * Project Euler 0067
 *
 * By starting at the top of the triangle below and moving to adjacent numbers
 * on the row below, the maximum total from top to bottom is 23.
 *
 *    3
 *   7 4
 *  2 4 6
 * 8 5 9 3
 *
 * That is, 3 + 7 + 4 + 9 = 23.
 * 
 * Find the maximum total from top to bottom in triangle.txt (right click and
 * 'Save Link/Target As...'), a 15K text file containing a triangle with
 * one-hundred rows.
 *
 * NOTE: This is a much more difficult version of Problem 18. It is not possible
 * to try every route to solve this problem, as there are 2^99 altogether! If
 * you could check one trillion (10^12) routes every second it would take over
 * twenty billion years to check them all. There is an efficient algorithm to solve it. ;o)
 */
package projecteuler;

import java.io.*;
import java.util.Scanner;

/**
 *
 * @author Tom
 */
public class Euler0067
{
    private static int[][] numbers;
    public static void solve() {
        fillNumbers();
        for (int i = numbers.length - 2; i >= 0; i--) {
            for (int j = 0; j < numbers[i].length; j++) {
                numbers[i][j] += Math.max(numbers[i+1][j], numbers[i+1][j+1]);
            }
        }
        System.out.println(numbers[0][0]);
    }
    
    private static void fillNumbers() {
        numbers = new int[100][];
        for (int i = 0; i < 100; i++) {
            numbers[i] = new int[i+1];
        }
        int index1 = 0;
        int index2;
        int value;
        
        File file = new File("src/projecteuler/data/euler0067.txt");
        BufferedReader bReader = null;
        try {
            bReader = new BufferedReader(new FileReader(file));
            String line = bReader.readLine();
            while(line != null) {
                index2 = 0;
                Scanner lScanner = new Scanner(line);
                while (lScanner.hasNext()) {
                    value = lScanner.nextInt();
                    numbers[index1][index2] = value;
                    index2++;
                }
                line = bReader.readLine();
                index1++;
            }
        } catch (Exception e) {
            System.out.println(e);
        }
        finally {
            try {
                bReader.close();
            } catch (Exception e) {
                System.out.println(e);
            }
        }
        
        
        
    }
}
