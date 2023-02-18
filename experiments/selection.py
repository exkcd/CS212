"""
An example of a selection sort.
Works by repeatedly selecting the smallest or largest element from the unsorted portion of the arr and swaps it with the first element of the unsorted part. This process repeats until the entire array is sorted.
"""

import random


def selectionSort(arr):

    # scan all array elements
    for i in range(len(arr)):
        mid = i

    # find smallest element in unsorted array
    for j in (range(i + 1, len(arr))):
        if arr[mid] > arr[j]:
            mid = j

    # swap the smallest element with the first element
    arr[i], arr[mid] = arr[mid], arr[i]


if __name__ == "__main__":
    arr = []

    for r in range(10):
        nums = random.randint(1, 100)
        arr.append(nums)

    print("Selection sort example")
    print("Unsorted array")
    for i in range(len(arr)):
        print("%d" % arr[i], end=" ")

    selectionSort(arr)

    print("\nSorted array")
    for i in range(len(arr)):
        print("%d" % arr[i], end=" ")
