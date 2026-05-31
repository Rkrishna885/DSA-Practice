Insertion Sort (Recursive) - Notes
Idea

Insertion Sort works like arranging playing cards in your hand.

Assume the left part of the array is already sorted.
Take the next element and insert it into its correct position in the sorted part.
Repeat until the entire array becomes sorted.

Example:

[5, 3, 4, 1]

Pass 1:
[3, 5, 4, 1]

Pass 2:
[3, 4, 5, 1]

Pass 3:
[1, 3, 4, 5]
Recursive Approach Used
Recursive Function
insertion(arr, n, i)
i represents the current element to insert.
Left side (0 to i-1) is considered sorted.
Insert arr[i] into its correct position.
Recursively move to the next index.
Base Case
if(n == i) return;

When i reaches the array length, sorting is complete.

Logic Breakdown
Step 1: Pick Current Element
int j = i;

j starts from the current index.

Step 2: Move Left Until Correct Position Found
while(j > 0 && arr[j-1] > arr[j])

If the previous element is greater than the current element:

swap(arr[j], arr[j-1]);

Move the element one position left.

Step 3: Continue Recursively
insertion(arr, n, i + 1);

Sort the next element.

Dry Run

Array:

[5, 3, 4]
i = 1
5 > 3

Swap

[3, 5, 4]
i = 2
5 > 4

Swap

[3, 4, 5]

Array sorted.

Time Complexity
Best Case (Already Sorted)
O(n)

No swaps needed.

Average Case
O(n²)
Worst Case (Reverse Sorted)
O(n²)

Every element shifts to the beginning.

Space Complexity

Iterative Insertion Sort:

O(1)

Recursive Insertion Sort (this code):

O(n)

because of recursion stack.

Pattern to Remember

Think:

SORTED | UNSORTED

Example:

[3,5] | [4,1]

Take the first element from the UNSORTED part and insert it into the correct place in the SORTED part.

Memory Trick

Imagine arranging exam ranks on a notice board:

First student's rank is already placed.
Next student comes.
Move him left until he reaches his correct rank position.
Repeat for every student.

OR

Three-Step Formula
Pick
Shift Left
Insert

In code:

j = i;              // Pick

while(...)          // Shift Left

insertion(...);     // Next element
Recursive Flow
insertion(i=1)
    |
    v
insertion(i=2)
    |
    v
insertion(i=3)
    |
    v
...
    |
    v
Base Case

Each recursive call fixes one position of the array.