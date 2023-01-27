/* This program generates a sequence of 20 random values between 0 and 99 in an array.
 *
 * R Stone
 */

package ch01.Lab2;

import java.util.Arrays;
import java.util.Random;

public class strangeNumbers {
    public static void main(String[] args) {
        Random randNum = new Random(); // init random generator

        int[] numList = new int[20];

        System.out.println("Generating random numbers...");

        for (int i = 0; i < numList.length; i++) { // generates random numbers in ArrayList
            numList[i] = randNum.nextInt(99);
        }

        System.out.println("The random numbers are as follows:"); // displays the random numbers in the array to the
                                                                  // console
        System.out.println(Arrays.toString(numList));

        Arrays.sort(numList);

        System.out.println("\nThe sorted random numbers are as follows:");
        System.out.println(Arrays.toString(numList));

    }
}