"""
An example of a quick sort.
Like merge sort it's a divide and conquer algorithm. Picks an element as a pivot and partitions the given array around the picked pivot.
"""

import random


def partition(array, low, high):

    # choose the rightmost element as the pivot
    pivot = array[high]

    # pointer for greater element
    i = low - 1

    # traverse through all elements and compare each element with pivot
    for j in range(low, high):
        if array[j] <= pivot:

            # if element smaller than pivot is found swap with greater element pointed by i
            i = i + 1

            # swapping element at i with element at j
            (array[i], array[j]) = (array[j], array[i])

    (array[i + 1], array[high]) = (array[high], array[i + 1])

    # return the position from where partition is done
    return i + 1

    # function ot perform quicksort


def quickSort(array, low, high):

    # find pivot element such that element smaller than pivot are on the left and element greater than pivot on the right
    if low < high:
        pi = partition(array, low, high)

        # recursive call on the left of pivot
        quickSort(array, low, pi - 1)

        # recursive call on the right of pivot
        quickSort(array, pi + 1, high)


if __name__ == "__main__":
    arr = []

    for r in range(10):
        nums = random.randint(1, 100)
        arr.append(nums)

    print("Quick sort example")
    print("Unsorted array")
    for i in range(len(arr)):
        print("%d" % arr[i], end=" ")

    quickSort(arr, 0, len(arr) - 1)

    print("\nSorted array")
    for i in range(len(arr)):
        print("%d" % arr[i], end=" ")
