/*
 * Euler0042
 *
 * The nth term of the sequence of triangle numbers is given by, tn = ½n(n+1);
 * so the first ten triangle numbers are:
 *
 * 1, 3, 6, 10, 15, 21, 28, 36, 45, 55, ...
 *
 * By converting each letter in a word to a number corresponding to its
 * alphabetical position and adding these values we form a word value.
 * For example, the word value for SKY is 19 + 11 + 25 = 55 = t(10). If the word
 * value is a triangle number then we shall call the word a triangle word.
 *
 * Using words.txt (right click and 'Save Link/Target As...'), a 16K text file
 * containing nearly two-thousand common English words, how many are triangle
 * words?
 */
package projecteuler;

/**
 *
 * @author Tom
 */
import java.io.*;
import java.util.Scanner;

public class Euler0042
{
    public static void solve() {
        int counter = 0;
        File file = new File("src/projecteuler/data/euler0042.txt");
        BufferedReader bReader = null;
        try {
            bReader = new BufferedReader(new FileReader(file));
            String line = bReader.readLine();
            Scanner lScanner = new Scanner(line);
            lScanner.useDelimiter(",");
            while (lScanner.hasNext()) {
                if (isTriangleWord(lScanner.next().replaceAll("\"",""))) {
                    counter++;
                }
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
        
        System.out.println(String.valueOf(counter));
    }
    
    private static boolean isTriangleWord(String word) {
        return isTriangleNumber(scoreWord(word));
    }
    
    private static boolean isTriangleNumber(int number) {
        int index = (int) (Math.sqrt(2 * number + 0.5) - 0.25);
        return index * (index + 1) * 0.5 == number;
    }
    
    private static int scoreWord(String word) {
        int total = 0;
        for (int index = 0; index < word.length(); index++) {
            total += (int) word.charAt(index) - 64;
        }
        return total;
    }
}
