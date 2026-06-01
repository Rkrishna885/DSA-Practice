Quick Sort (Using Hoare Partition) - Notes
📌 What is Quick Sort?

Quick Sort is a Divide and Conquer sorting algorithm.

It works by:

Selecting a pivot element.
Placing the pivot in its correct sorted position.
Moving smaller elements to the left of the pivot.
Moving larger elements to the right of the pivot.
Recursively sorting the left and right subarrays.
📌 Approach Used in This Code

This implementation uses:

First element as Pivot (arr[low])
Two Pointer Technique
i starts from left.
j starts from right.
Hoare Partition Scheme
📌 Partition Function
Pivot Selection
int pivot = arr[low];

The first element is chosen as the pivot.

Initialize Pointers
int i = low;
int j = high;
i moves from left to right.
j moves from right to left.
Move Pointers
while(arr[i] <= pivot && i <= high - 1)
{
    i++;
}

Move i until an element greater than the pivot is found.

while(arr[j] >= pivot && j >= low + 1)
{
    j--;
}

Move j until an element smaller than the pivot is found.

Swap Elements
if(i < j)
{
    swap(arr[i], arr[j]);
}

Swap the misplaced elements.

Place Pivot at Correct Position
swap(arr[low], arr[j]);

The pivot is placed at index j.

return j;

Return the pivot's final position.

📌 Recursive Calls

After partitioning:

qS(arr, low, partitionIndex - 1);
qS(arr, partitionIndex + 1, high);

Sort:

Left subarray
Right subarray
📌 Dry Run
Input
[4, 6, 2, 5, 7, 9, 1, 3]
Step 1

Pivot = 4

4 6 2 5 7 9 1 3

After partition:

3 1 2 4 7 9 5 6
      ↑
   Pivot

Pivot Index = 3

Recursive Calls

Left Part:

3 1 2

Right Part:

7 9 5 6

Continue recursively until every subarray has size 1.

📌 Recursion Tree
[4,6,2,5,7,9,1,3]
          |
          4
       /     \
   [3,1,2]  [7,9,5,6]
     / \      /   \
   ... ...  ... ...
📌 Time Complexity
Best Case

Pivot divides array into equal halves.

O(N log N)
Average Case
O(N log N)
Worst Case

Occurs when the array is already sorted and the first element is chosen as the pivot.

O(N²)

Example:

[1,2,3,4,5]

or

[5,4,3,2,1]
📌 Space Complexity

Recursion stack only:

O(log N)  -> Best/Average
O(N)      -> Worst
📌 Why Quick Sort is Fast?
No extra array is used.
Works in-place.
Better cache performance.
Usually faster than Merge Sort in practice.
📌 Algorithm
QuickSort(arr, low, high)

1. If low < high:
2.    Find partition index.
3.    Sort left subarray.
4.    Sort right subarray.

Partition:

1. Choose first element as pivot.
2. Move i from left.
3. Move j from right.
4. Swap when needed.
5. Place pivot in correct position.
6. Return pivot index.
📌 Key Points for Interviews

✅ Divide and Conquer Algorithm

✅ In-place Sorting Algorithm

✅ Not Stable

✅ Average Time Complexity = O(N log N)

✅ Worst Time Complexity = O(N²)

✅ Uses Recursion

✅ Hoare Partition Scheme in this implementation