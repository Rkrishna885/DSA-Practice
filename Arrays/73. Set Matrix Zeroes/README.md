Set Matrix Zeroes
Problem

Given an m x n matrix, if an element is 0, set its entire row and column to 0.

Example

Input:

1 1 1
1 0 1
1 1 1

Output:

1 0 1
0 0 0
1 0 1
Core Idea

The challenge is:

How do we remember which rows and columns must become zero without using extra arrays?

Instead of using:

int[] rows
int[] cols

we use the matrix itself as storage.

Trick

Use:

First row → stores column markers
First column → stores row markers

This reduces extra space from O(m+n) to O(1).

Visualization

Suppose:

1 2 3
4 0 6
7 8 9

When we find:

matrix[1][1] = 0

Mark:

matrix[1][0] = 0   // row marker
matrix[0][1] = 0   // column marker

Matrix becomes:

1 0 3
0 0 6
7 8 9

Notice:

First row remembers columns.
First column remembers rows.
Why do we need firstRowZero and firstColZero?

Problem:

We are using the first row and first column as markers.

What if they originally contained a zero?

Example:

0 1 2
3 4 5
6 7 8

If we don't save this information beforehand:

We won't know whether the first row became zero because of marking
Or because it originally contained zero

So we store:

boolean firstRowZero
boolean firstColZero

before doing any marking.

Algorithm
Step 1

Check if the first row contains any zero.

firstRowZero = true;

if found.

Step 2

Check if the first column contains any zero.

firstColZero = true;

if found.

Step 3

Traverse the remaining matrix.

Whenever:

matrix[i][j] == 0

mark:

matrix[i][0] = 0;
matrix[0][j] = 0;

Think:

"I found a zero. Let me remember its row and column."

Step 4

Traverse again.

For every cell:

if(matrix[i][0] == 0 || matrix[0][j] == 0)

make it zero.

This uses the markers created in Step 3.

Step 5

If:

firstRowZero == true

make the entire first row zero.

Step 6

If:

firstColZero == true

make the entire first column zero.

Dry Run

Input:

1 1 1
1 0 1
1 1 1
After marking
1 0 1
0 0 1
1 1 1
After applying markers
1 0 1
0 0 0
1 0 1
First row/column update

No change.

Final:

1 0 1
0 0 0
1 0 1
Memory Trick

Remember this sentence:

"Use the first row and first column as a notebook."

Whenever a zero is found:

Write row information in column 0.
Write column information in row 0.

Then later read the notebook and update the matrix.

Pattern Recognition

Whenever a problem says:

Mark rows/columns and later modify the matrix

think:

✅ Use first row and first column as markers.

This pattern appears in:

Set Matrix Zeroes
Matrix marking problems
In-place matrix transformation questions
Complexity Analysis
Time Complexity
O(m × n)

Matrix is traversed a constant number of times.

Space Complexity
O(1)

No extra row/column arrays used.

Interview Explanation (30 Seconds)

I use the first row and first column as marker arrays. First, I save whether the original first row or first column contains a zero. Then, for every zero in the matrix, I mark its row and column using the first column and first row. In a second pass, I update cells based on those markers. Finally, I update the first row and first column if needed. This achieves O(m×n) time and O(1) extra space.

One-Line Recall

"First row stores column markers, first column stores row markers, booleans protect original zeros." 🚀