/*
 * Project Euler 0024
 *
 * A permutation is an ordered arrangement of objects. For example, 3124 is one
 * possible permutation of the digits 1, 2, 3 and 4. If all of the permutations
 * are listed numerically or alphabetically, we call it lexicographic order. The
 * lexicographic permutations of 0, 1 and 2 are:
 *
 * 012   021   102   120   201   210
 *
 * What is the millionth lexicographic permutation of the digits 0, 1, 2, 3, 4, 
 * 5, 6, 7, 8 and 9?
 */
package projecteuler;

import java.util.List;
import java.util.ArrayList;

/**
 *
 * @author Tom
 */
public class Euler0024 {
    
    private static double factorial(int input) {
        double total = 1;
        for (int i = 2; i <= input; i++) {
            total *= i;
        }
        return total;
    }
        
    public static void solve() {
        String output = "";
        List<Integer> digRemaining = new ArrayList<>(9);
        for (int i = 0; i <= 9; i++) {
            digRemaining.add(i);
        }
                
        int iterRemaining = 999999;
        int index;
        double fact;
        Integer result;
        for (int numRemaining = 10; numRemaining >= 1; numRemaining--) {
            fact = factorial(numRemaining - 1);
            index = (int)(iterRemaining/fact);
            result = digRemaining.get(index);
            output += String.valueOf(result);
            iterRemaining -= (fact * index);
            digRemaining.remove(index);
        }
        
        System.out.println(output);
    }
}
