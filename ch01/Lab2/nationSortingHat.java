/* This program takes a list of countries and alphabetizes them.
 *
 * R Stone
 */

package ch01.Lab2;

import java.util.Arrays;

public class nationSortingHat {
    public static void main(String[] args) {

        // generate array of countries
        String[] nationList = { "Bolivia", "Canada", "Switzerland", "Iceland", "China", "Korea", "Spain" };

        System.out.println("List of countries as follows:");
        System.out.println(Arrays.toString(nationList));

        Arrays.sort(nationList); // sort through list and alphabetize them

        // print sorted list
        System.out.println("\nAlphabetized list of countries:");
        System.out.println(Arrays.toString(nationList));
    }
}
