/*
 * Euler0022
 *
 * Using names.txt (right click and 'Save Link/Target As...'), a 46K text file
 * containing over five-thousand first names, begin by sorting it into
 * alphabetical order. Then working out the alphabetical value for each name,
 * multiply this value by its alphabetical position in the list to obtain a name
 * score.
 *
 * For example, when the list is sorted into alphabetical order, COLIN, which is
 * worth 3 + 15 + 12 + 9 + 14 = 53, is the 938th name in the list. So, COLIN
 * would obtain a score of 938 × 53 = 49714.
 * 
 * What is the total of all the name scores in the file?
 */
package projecteuler;

/**
 *
 * @author Tom
 */
import java.io.*;
import java.util.*;

public class Euler0022
{
    public static void solve() {
        String name;
        Set<String> names = new TreeSet<>();
        File file = new File("src/projecteuler/data/euler0022.txt");
        BufferedReader bReader = null;
        
        try {
            bReader = new BufferedReader(new FileReader(file));
            String line = bReader.readLine();
            Scanner lScanner = new Scanner(line);
            lScanner.useDelimiter(",");
            while (lScanner.hasNext()) {
                name = lScanner.next().replaceAll("\"", "");
                names.add(name);
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
        
        Iterator<String> itr = names.iterator();
        int position = 0;
        double nameScore;
        double total = 0.0;
        
        while (itr.hasNext()) {
            name = itr.next();
            position++;
            nameScore = getNameValue(name) * position;
            total+= nameScore;
        }
        
        System.out.println(String.format("%.0f", total));
    }
    
    private static double getNameValue(String name) {
        double total = 0.0;
        for (int index = 0; index < name.length(); index++) {
            total += (int) name.charAt(index) - 64;
        }
        return total;
    }
}
