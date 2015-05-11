/*
 * Euler0099
 *
 * Comparing two numbers written in index form like 2^11 and 3^7 is not difficult,
 * as any calculator would confirm that 2^11 = 2048 < 3^7 = 2187.
 *
 * However, confirming that 632382^518061 > 519432^525806 would be much more
 * difficult, as both numbers contain over three million digits.
 *
 * Using base_exp.txt (right click and 'Save Link/Target As...'), a 22K text
 * file containing one thousand lines with a base/exponent pair on each line,
 * determine which line number has the greatest numerical value.
 *
 * NOTE: The first two lines in the file represent the numbers in the example
 * given above.
 */
package projecteuler;

/**
 *
 * @author Tom
 */
import java.io.*;
import java.util.Scanner;

public class Euler0099
{
    public static void solve () {
        File file = new File("src/projecteuler/data/euler0099.txt");
        BufferedReader bReader = null;
        int number, exp, lineNumber;
        int maxNumber, maxExp, maxLineNumber;
        
        lineNumber = 0;
        maxNumber = 1; // arbitrary number to prevent log(0) error
        maxExp = 0;
        maxLineNumber = 0;
        
        try {
            bReader = new BufferedReader(new FileReader(file));
            String line = bReader.readLine();
            while (line != null) {
                Scanner lScanner = new Scanner(line);
                lScanner.useDelimiter(",");
                number = lScanner.nextInt();
                exp = lScanner.nextInt();
                line = bReader.readLine();
                lineNumber++;
                if (exp * Math.log(number) > maxExp * Math.log(maxNumber)) {
                    maxNumber = number;
                    maxExp = exp;
                    maxLineNumber = lineNumber;
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
        
        System.out.println(String.valueOf(maxLineNumber));
    }
}
