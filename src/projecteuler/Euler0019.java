/*
 * Project Euler 0019
 *
 * You are given the following information, but you may prefer to do some
 * research for yourself.

 * 1 Jan 1900 was a Monday.
 * Thirty days has September,
 * April, June and November.
 * All the rest have thirty-one,
 * Saving February alone,
 * Which has twenty-eight, rain or shine.
 * And on leap years, twenty-nine.
 * A leap year occurs on any year evenly divisible by 4, but not on a century
 * unless it is divisible by 400.
 * How many Sundays fell on the first of the month during the twentieth century
 * (1 Jan 1901 to 31 Dec 2000)?
 */
package projecteuler;

/**
 *
 * @author Tom
 */
import java.util.Calendar;

public class Euler0019 {
    
    public static void solve() {
        int count = 0;
        Calendar cal = Calendar.getInstance();
        for (int aYear = 1901; aYear <= 2000; aYear++) {
            for (int aMonth = 0; aMonth <= 11; aMonth++) { // months start at 0
                cal.set(aYear, aMonth, 1);
                if (cal.get(Calendar.DAY_OF_WEEK) == 1) { count++; }
            }
        }
        
        System.out.println(count);
    }
}
