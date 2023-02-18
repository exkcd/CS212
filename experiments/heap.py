"""
An example of a heap sort.
A comparison-based sorting technique based on Binary Heap data structure. Similar to a selection sort where the minimum element is found and is placed at the beginning. Repeat process for the remaining elements.
"""

import random


def heapify(arr, N, i):

    # initialize the largest as root
    largest = i
    l = 2 * i + 1
    r = 2 * i + 2

    # see if left child of root exists and is greater than root
    if l < N and arr[largest] < arr[l]:
        largest = l

    # see if right child of root exists and is greater than root
    if r < N and arr[largest] < arr[r]:
        largest = r

    # change root if needed
    if largest != i:
        arr[i], arr[largest] = arr[largest], arr[i]  # swap

        # heapify the root
        heapify(arr, N, largest)


def heapSort(arr):
    N = len(arr)

    # build a maxheap
    for i in range(N//2 - 1, -1, -1):
        heapify(arr, N, i)

    # extract elements one by one
    for i in range(N-1, 0, -1):
        arr[i], arr[0] = arr[0], arr[i]  # swap
        heapify(arr, i, 0)


if __name__ == "__main__":
    arr = []

    for r in range(10):
        nums = random.randint(1, 100)
        arr.append(nums)

    print("Heap sort example")
    print("Unsorted array")
    for i in range(len(arr)):
        print("%d" % arr[i], end=" ")

    heapSort(arr)
    N = len(arr)

    print("\nSorted array")
    for i in range(len(arr)):
        print("%d" % arr[i], end=" ")
