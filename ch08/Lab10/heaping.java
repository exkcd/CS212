/*
 * This lab showcases how the heap algorithm works and shorts through an array of numbers. Min heap and max heap are used.
 * 
 * R Stone
 */

package ch08.Lab10;

import java.util.*;

public class heaping {
    public static void main(String[] args) {
        MinHeap minHeap = new MinHeap(10);
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder());
        Random rand = new Random();

        for (int i = 0; i < 10; i++) {
            int randNum = rand.nextInt(100);

            // make sure there are no duplicate random numbers
            if (!maxHeap.contains(randNum)) {
                minHeap.insert(randNum);
                maxHeap.add(randNum);
            }
        }
        minHeap.minHeap();

        System.out.println("\nThe Min Heap is: " + Arrays.toString(minHeap.Heap));
        minHeap.printHeap();

        int removeMin = minHeap.remove();

        System.out.println("\nThe Min value is: " + removeMin);
        System.out.println("Removing...");

        System.out.println("\nThe NEW Min Heap is: " + Arrays.toString(minHeap.Heap));
        minHeap.printHeap();

        System.out.println("\nAdding value back...");
        minHeap.insert(removeMin);

        System.out.println("Min heap: " + Arrays.toString(minHeap.Heap));

        System.out.println("\n-------\nMAX HEAP TIME");
        System.out.println("\nThe Max Heap is: " + Arrays.toString(maxHeap.toArray()));

        System.out.println("\nThe Max value is: " + maxHeap.peek());
        System.out.println("Removing...");

        int removeMax = maxHeap.remove();

        System.out.println("\nThe NEW Max Heap is: " + Arrays.toString(maxHeap.toArray()));

        System.out.println("Adding value back...");
        maxHeap.add(removeMax);

        System.out.println("\nMax heap: " + Arrays.toString(maxHeap.toArray()));

        PriorityQueue<String> stringHeap = new PriorityQueue<String>(new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                return o2.compareTo(o1);
            }
        });

        stringHeap.add("Kyrgyzstan");
        stringHeap.add("Mozambique");
        stringHeap.add("Zambia");
        stringHeap.add("China");
        stringHeap.add("Japan");
        stringHeap.add("Switzerland");

        System.out.println("\nThe Max Heap is: " + Arrays.toString(stringHeap.toArray()));

        System.out.println("\nThe Max value is: " + stringHeap.peek());
        System.out.println("Removing...");

        String removeString = stringHeap.remove();

        System.out.println("\nThe NEW Max Heap is: " + Arrays.toString(stringHeap.toArray()));

        System.out.println("Adding value back...");
        stringHeap.add(removeString);

        System.out.println("\nMax heap: " + Arrays.toString(stringHeap.toArray()));
    }
}

class MinHeap {
    int[] Heap;
    private int index;
    private final int size;

    public MinHeap(int size) {
        this.index = 0;
        this.size = size;
        Heap = new int[size];
    }

    private int parent(int i) {
        return (i - 1) / 2;
    }

    private int leftChild(int i) {
        return (i * 2) + 1;
    }

    private int rightChild(int i) {
        return (i * 2) + 2;
    }

    private boolean isLeaf(int i) {
        return rightChild(i) >= size || leftChild(i) >= size;
    }

    private void swap(int fPos, int sPos) {
        int tmp;
        tmp = Heap[fPos];

        Heap[fPos] = Heap[sPos];
        Heap[sPos] = tmp;
    }

    public void insert(int element) {
        if (index >= size) {
            return;
        }
        Heap[index] = element;
        int current = index;

        while (Heap[current] < Heap[parent(current)]) {
            swap(current, parent(current));
            current = parent(current);
        }
        index++;
    }

    public int remove() {
        int popped = Heap[0];
        Heap[0] = Heap[--index];
        minHeapify(0);
        return popped;
    }

    public void minHeapify(int i) {
        if (!isLeaf(i)) {
            if (Heap[i] > Heap[leftChild(i)] || Heap[i] > Heap[rightChild(i)]) {
                if (Heap[leftChild(i)] < Heap[rightChild(i)]) {
                    swap(i, leftChild(i));
                } else {
                    swap(i, rightChild(i));
                    minHeapify(rightChild(i));
                }
            }
        }
    }

    public void minHeap() {
        for (int i = (index); i >= 1; i--) {
            minHeapify(i);
        }
    }

    public void printHeap() {
        for (int i = 0; i < (index / 2); i++) {
            System.out.print("Parent: " + Heap[i]);
            if (leftChild(i) < index) {
                System.out.print(" Left: " + Heap[leftChild(i)]);
            }
            if (rightChild(i) < index) {
                System.out.print(" Right: " + Heap[rightChild(i)]);
            }
            System.out.println();
        }
    }
}
