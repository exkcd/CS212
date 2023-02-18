"""
An example of a bubble sort.
Works by repeatedly swapping the adjacent elements if they are in the wrong order. Not suitable for large data sets as its average and worst-case complexity is quite high.
"""

import random


def bubbleSort(arr):
    n = len(arr)

    # scan all array elements
    for i in range(n):

        # last i elements are already in place
        for j in range(0, n-i-1):

            # scan from 0 to n-i-1 and swap if
            # element found is great than adjacent element
            if arr[j] > arr[j + 1]:
                arr[j], arr[j + 1] = arr[j+1], arr[j]


if __name__ == "__main__":
    arr = []

    for r in range(10):
        nums = random.randint(1, 100)
        arr.append(nums)

    print("Bubble sort example")
    print("Unsorted array")
    for i in range(len(arr)):
        print("%d" % arr[i], end=" ")

    bubbleSort(arr)

    print("\nSorted array")
    for i in range(len(arr)):
        print("%d" % arr[i], end=" ")
