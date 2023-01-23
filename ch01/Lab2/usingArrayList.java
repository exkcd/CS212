/* This program takes the previous two exercises and implements the use of ArrayList.
 *
 * R Stone
 */

package ch01.Lab2;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;

public class usingArrayList {
    public static void main(String[] args) {
        Random randNum = new Random(); // for the random numbers
        ArrayList<Integer> numList = new ArrayList<>(); // init number array using ArrayList

        // generates random numbers and puts them in the list
        for (int i = 0; i < 20; i++) {
            numList.add(randNum.nextInt(99));
        }

        // output
        System.out.println("List of random numbers by ArrayList:");
        System.out.println(numList);

        Collections.sort(numList); // sorted by smallest to largest value

        System.out.println("\nSorted numbers by increasing value:");
        System.out.println(numList);

        // country ArrayList
        ArrayList<String> nationList = new ArrayList<>();

        // adding countries to the list
        nationList.add("Bolivia");
        nationList.add("Canada");
        nationList.add("Switzerland");
        nationList.add("Iceland");
        nationList.add("China");
        nationList.add("Korea");
        nationList.add("Spain");

        // output
        System.out.println("\n\nList of random nations by ArrayList:");
        System.out.println(nationList);

        Collections.sort(nationList); // sorting using Collections modulee

        System.out.println("\nAlphabetized list of random nations:");
        System.out.println(nationList);
    }
}
