/*
* For this project, you will create two classes representing two data structure components for searching and
* managing lists of integers. The two classes from the user's point of view share identical interfaces and
* operations but have very different underlying data structures, one using a simple array of integers,
* the other an ArrayList of type Integer.
*
* R Stone
*/

package ch04.Project04;

import java.util.*;
import java.util.concurrent.ThreadLocalRandom;

interface BinarySearch { // initialize the interface
    int binarySearch(int key);

    void add(int value);

    void yeet(int index);

    boolean contains(int value);

    void printElements();

    void initializeArray();

    void sort();
}

class BinarySearchArrayList implements BinarySearch {
    ArrayList<Integer> arrList = new ArrayList<>(); // new ArrayList

    @Override
    public int binarySearch(int key) {
        return Collections.binarySearch(arrList, key);
    }

    @Override
    public void add(int value) {
        // adds a value only if it does not exist yet

        if (!contains(value)) {
            arrList.add(value);
        } else {
            System.out.println("Item " + value + " already exists in the list. Not added.");
        }
        sort();
        printElements();
    }

    @Override
    public void yeet(int index) {
        // removes an existing value

        if (!contains(index)) {
            arrList.remove(index);
            sort();
            printElements();
        } else if (contains(index)) {
            System.out.println("Whoops");
        }
    }

    @Override
    public boolean contains(int value) {
        // I think this is a redundant statement because the ArrayList package already
        // has a function called 'contains'

        return arrList.contains(value);
    }

    @Override
    public void printElements() {
        System.out.println("Search elements:");
        System.out.println(arrList.toString() + " ");
        System.out.println("\n");
    }

    @Override
    public void initializeArray() {
        // takes some random numbers between 1 and 25 and puts them into an ArrayList
        Random rand = ThreadLocalRandom.current();
        int max = 25, min = 1;
        int added = 0;
        while (added < 10) {
            int num = rand.nextInt((max - min) + 1) + min;
            if (!contains(num)) {
                arrList.add(num);
                added++;
            }
        }
    }

    @Override
    public void sort() {
        Collections.sort(arrList);
    }
}

class BinarySearchArray implements BinarySearch {

    int[] arr = new int[15];

    @Override
    public int binarySearch(int key) {
        return Arrays.binarySearch(arr, key);
    }

    @Override
    public void add(int value) {
        if (contains(value)) {
            return;
        }
        if (!contains(0)) {
            System.out.println("No space available");
        }
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == 0) {
                arr[i] = value;
                break;
            }
        }
        sort();
        printElements();
    }

    @Override
    public void yeet(int index) {
        for (int i = index; i < arr.length - 1; i++) {
            arr[i] = arr[i + 1];
        }
        arr[arr.length - 1] = 0;
        sort();
        printElements();
    }

    @Override
    public boolean contains(int value) {
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == value) {
                return true;
            }
        }
        return false;
    }

    @Override
    public void printElements() {
        System.out.println("Search elements:");
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println("\n");
    }

    @Override
    public void initializeArray() {
        for (int i = 0; i < 15; i++) {
            arr[i] = 0;
        }
        Random rand = ThreadLocalRandom.current();
        int max = 25, min = 1;
        int addNum = 10, added = 0;
        while (added < addNum) {
            int num = rand.nextInt((max - min) + 1) + min;
            if (!contains(num)) {
                for (int i = 0; i < arr.length; i++) {
                    if (arr[i] == 0) {
                        arr[i] = num;
                        break;
                    }
                }
                added++;
            }
        }
    }

    @Override
    public void sort() {
        Arrays.sort(arr);
    }
}

public class nonBinarySearch {
    public void printWelcomeMessage(String mode) {
        System.out.println("\nWelcome to the NON-Binary Search Test (" + mode + "):\n");
    }

    public void nonBinaryTest(BinarySearch searchObject) {
        Scanner in = new Scanner(System.in);
        int value;
        while (true) {
            System.out.print("Enter an integer to search (or -1 to quit): ");
            String ss = in.nextLine();
            value = Integer.parseInt(ss);

            if (value == -1) {
                break;
            }
            int index;
            if ((index = searchObject.binarySearch(value)) >= 0) {
                System.out.print("Value " + value + " found." + " Do you want to remove it? (y/n) ");
                String ans = in.nextLine();

                if (ans.equals("y")) {
                    searchObject.yeet(index);
                }
            } else {
                System.out.print("Value " + value + " not found." + " Do you want to add it? (y/n) ");
                String ans = in.nextLine();

                if (ans.equals("y")) {
                    searchObject.add(value);
                }
            }
        }
        System.out.println("Goodbye...");
        in.close();
    }

    public void binarySearchDriver() {
        System.out.println();
        BinarySearch bs = new BinarySearchArray();
        bs.initializeArray();
        bs.sort();
        String mode = bs.getClass().getSimpleName();
        printWelcomeMessage(mode);
        bs.printElements();
        nonBinaryTest(bs);
    }

    public void nonBinarySearchDriver() {
        System.out.println();
        BinarySearch brrr = new BinarySearchArrayList();
        brrr.initializeArray();
        brrr.sort();
        String mode = brrr.getClass().getSimpleName();
        printWelcomeMessage(mode);
        brrr.printElements();
        nonBinaryTest(brrr);
    }

    public static void main(String[] args) {
        nonBinarySearch noBS = new nonBinarySearch();
        noBS.binarySearchDriver();
        noBS.nonBinarySearchDriver();
    }
}