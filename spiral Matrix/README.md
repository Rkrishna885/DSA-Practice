Spiral Matrix
Problem Statement

Given an m x n matrix, return all elements of the matrix in spiral order.

Example

Input:

1  2  3
4  5  6
7  8  9

Output:

[1,2,3,6,9,8,7,4,5]

Traversal:

→ → →
      ↓
← ← ←
↑
→
Approach: Boundary Traversal

Instead of moving cell by cell and tracking directions, we use 4 boundaries:

top    -> first row
bottom -> last row
left   -> first column
right  -> last column

Initially:

top = 0
bottom = rows - 1

left = 0
right = cols - 1

After completing one layer, we shrink the boundaries inward.

Visualization

Matrix:

1   2   3   4
5   6   7   8
9  10  11  12
13 14  15 16

Initial boundaries:

top = 0
bottom = 3
left = 0
right = 3
Step 1: Traverse Left → Right
for(int i = left; i <= right; i++)

Visit:

1 2 3 4

Result:

[1,2,3,4]

Move top boundary down:

top++;

New:

top = 1
Step 2: Traverse Top → Bottom
for(int i = top; i <= bottom; i++)

Visit:

8
12
16

Result:

[1,2,3,4,8,12,16]

Move right boundary left:

right--;

New:

right = 2
Step 3: Traverse Right → Left
for(int i = right; i >= left; i--)

Visit:

15 14 13

Result:

[1,2,3,4,8,12,16,15,14,13]

Move bottom boundary up:

bottom--;

New:

bottom = 2
Step 4: Traverse Bottom → Top
for(int i = bottom; i >= top; i--)

Visit:

9
5

Result:

[1,2,3,4,8,12,16,15,14,13,9,5]

Move left boundary right:

left++;

New:

left = 1

Now one outer layer is completed.

Remaining matrix:

6   7
10 11

Repeat the same process until:

top > bottom
OR
left > right
Why Do We Need These Conditions?
Condition 1
while(top <= bottom && left <= right)

Ensures valid rows and columns still exist.

Condition 2
if(top <= bottom)

Needed before traversing the bottom row.

Example:

1 2 3

After traversing top row:

top = 1
bottom = 0

Bottom row no longer exists.

Without this condition, elements would be added twice.

Condition 3
if(left <= right)

Needed before traversing the left column.

Example:

1
2
3

After traversing the right column:

left = 1
right = 0

No valid column remains.

Without this check, duplicate traversal occurs.

Dry Run

Input:

1 2 3
4 5 6
7 8 9
Round 1

Top Row:

1 2 3

Right Column:

6 9

Bottom Row:

8 7

Left Column:

4

Result:

[1,2,3,6,9,8,7,4]
Round 2

Remaining:

5

Top Row:

5

Final Result:

[1,2,3,6,9,8,7,4,5]
Memory Trick

Think of the matrix as an onion 🧅.

You peel one layer at a time:

1. Top Row    →
2. Right Col  ↓
3. Bottom Row ←
4. Left Col   ↑

Then shrink boundaries:

top++
right--
bottom--
left++

Repeat.

Shortcut Formula
→  ↓  ←  ↑

top++
right--
bottom--
left++

Remember:

Travel Clockwise
Shrink Boundaries
Repeat
Time Complexity

We visit every element exactly once.

Time Complexity: O(m × n)

where:

m = number of rows
n = number of columns
Space Complexity

Ignoring output list:

O(1)

Including output list:

O(m × n)

because all elements are stored in the result.

Key Interview Insight

This is a Boundary Traversal Pattern problem.

Whenever you hear:

Spiral Matrix
Layer by Layer Traversal
Clockwise Matrix Traversal

Think:

top
bottom
left
right

and follow:

Top Row    →
Right Col  ↓
Bottom Row ←
Left Col   ↑

Then:

top++
right--
bottom--
left++

This pattern is the core idea that solves almost every Spiral Matrix problem. 🚀