"""
An example of a merge sort.
Works by dividing an arry into smaller subarrays, sorting through each and finally merging the sorted subarrays back together. This process is repeated until the entire array is sorted.
"""

import random


def mergeSort(arr):
    if len(arr) > 1:

        # find the middle of the array
        mid = len(arr) // 2

        # divide the array elements into two halves
        L = arr[:mid]

        R = arr[mid:]

        # sort both halves
        mergeSort(L)

        mergeSort(R)

        i = j = k = 0

        # copy data to subarrays
        while i < len(L) and j < len(R):
            if L[i] <= R[j]:
                arr[k] = L[i]
                i += 1
            else:
                arr[k] = R[j]
                j += 1
            k += 1

        # checks if any element was left
        while i < len(L):
            arr[k] = L[i]
            i += 1
            k += 1

        while j < len(R):
            arr[k] = R[j]
            j += 1
            k += 1


if __name__ == "__main__":
    arr = []

    for r in range(10):
        nums = random.randint(1, 100)
        arr.append(nums)

    print("Merge sort example")
    print("Unsorted array")
    for i in range(len(arr)):
        print("%d" % arr[i], end=" ")

    mergeSort(arr)

    print("\nSorted array")
    for i in range(len(arr)):
        print("%d" % arr[i], end=" ")
