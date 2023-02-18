"""
An example of an insertion sort.
Works similar to sorting cards in a deck. The array is split into a sorted and unsorted part. Values from the unsorted part are picked and placed at the correct position in the sorted part.
"""

import random


def insertionSort(arr):

    # scan all elements in array
    for i in range(1, len(arr)):

        key = arr[i]

        # move elements of arr[o..i-1] that are greater
        # than key to one position ahead of current position
        j = i-1

        while j > 0 and key < arr[j]:
            arr[j + 1] = arr[j]
            j -= 1
            arr[j + 1] = key


if __name__ == "__main__":
    arr = []

    for r in range(10):
        nums = random.randint(1, 100)
        arr.append(nums)

    print("Insertion sort example")
    print("Unsorted array")
    for i in range(len(arr)):
        print("%d" % arr[i], end=" ")

    insertionSort(arr)

    print("\nSorted array")
    for i in range(len(arr)):
        print("%d" % arr[i], end=" ")
