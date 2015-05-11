/*
 * Euler0081
 *
 * In the 5 by 5 matrix below, the minimal path sum from the top left to the
 * bottom right, by only moving to the right and down, is indicated in bold red
 * and is equal to 2427.
 *
 * 131 673 234 103 018
 * 201 096 342 965 150
 * 630 803 746 422 111
 * 537 699 497 121 956
 * 805 732 524 037 331
 * Find the minimal path sum, in matrix.txt (right click and "Save Link/Target
 * As..."), a 31K text file containing a 80 by 80 matrix, from the top left to
 * the bottom right by only moving right and down.
 */
package projecteuler;

/**
 *
 * @author Tom
 */
import java.io.*;
import java.util.Scanner;

public class Euler0081
{
    public static void solve() {
        int[][] matrix = fillMatrix();
        for (int x = 0; x < 80; x++) {
            for (int y = 0; y < 80; y++) {
                if (x == 0 && y > 0) {
                    matrix[0][y] += matrix[0][y - 1];
                } else if (y == 0 && x > 0) {
                    matrix[x][0] += matrix[x - 1][0];
                } else if (x > 0 || y > 0) {
                    matrix[x][y] += Math.min(matrix[x - 1][y], matrix[x][y - 1]);
                }
            }
        }
        System.out.println(String.valueOf(matrix[79][79]));
    }
    
    private static int[][] fillMatrix() {
        int [][] matrix = new int[80][80];
        int x = 0;
        int y;
        int number;
        Scanner lScanner;
        
        File file = new File("src/projecteuler/data/euler0081.txt");
        BufferedReader bReader = null;        
        try {
            bReader = new BufferedReader(new FileReader(file));
            String line = bReader.readLine();
            while (line != null) {
                y = 0;
                lScanner = new Scanner(line);
                lScanner.useDelimiter(",");
                while (lScanner.hasNextInt()) {
                    number = lScanner.nextInt();
                    matrix[x][y] = number;
                    y++;
                }
                x++;
                line = bReader.readLine();
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
        return matrix;
    }
}
