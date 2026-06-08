Rotate Image (LeetCode 48)
Problem Statement

Given an n x n matrix, rotate the image by 90° clockwise.

Example

Input:

1 2 3
4 5 6
7 8 9

Output:

7 4 1
8 5 2
9 6 3
Constraints
Matrix is always square (n x n)
Must rotate in-place
Cannot use another 2D matrix
Key Observation

Instead of creating a new matrix:

Transpose the matrix
Reverse each row

This automatically produces a 90° clockwise rotation.

Visual Understanding
Step 1: Original Matrix
1 2 3
4 5 6
7 8 9
Step 2: Transpose

Transpose means:

matrix[i][j] ↔ matrix[j][i]

Swap elements across the main diagonal.

1 4 7
2 5 8
3 6 9
Step 3: Reverse Every Row

Row 1:

1 4 7
↓
7 4 1

Row 2:

2 5 8
↓
8 5 2

Row 3:

3 6 9
↓
9 6 3

Final Answer:

7 4 1
8 5 2
9 6 3
Why Does This Work?

A clockwise rotation can be viewed as:

Rows become columns
+
Columns are reversed

Transpose converts rows into columns.

Reversing each row completes the clockwise rotation.

Algorithm
Step 1: Transpose
for(int i=0;i<n;i++){
    for(int j=i+1;j<n;j++){
        swap(matrix[i][j], matrix[j][i]);
    }
}
Step 2: Reverse Each Row
for(int i=0;i<n;i++){
    int left=0;
    int right=n-1;

    while(left<right){
        swap(matrix[i][left], matrix[i][right]);
        left++;
        right--;
    }
}
Dry Run

Input:

5 1 9 11
2 4 8 10
13 3 6 7
15 14 12 16
After Transpose
5  2 13 15
1  4  3 14
9  8  6 12
11 10 7 16
After Reversing Rows
15 13 2 5
14 3 4 1
12 6 8 9
16 7 10 11

Correct Output ✅

Complexity Analysis
Time Complexity

Transpose:

O(n²)

Reverse Rows:

O(n²)

Total:

O(n²)
Space Complexity
O(1)

No extra matrix is used.

Pattern to Remember

Whenever you see:

"Rotate a square matrix 90° clockwise in-place"

Immediately think:

Transpose
+
Reverse Each Row
Shortcut Memory Trick
Clockwise Rotation
=
Transpose + Row Reverse
Anti-Clockwise Rotation
=
Transpose + Column Reverse
Interview Explanation

If asked:

How did you solve it?

Answer:

Since the matrix must be rotated in-place, creating another matrix is not allowed. A 90° clockwise rotation can be achieved by first transposing the matrix (converting rows into columns) and then reversing every row. This modifies the original matrix directly while using O(1) extra space.


Revision Notes (1 Minute)
Problem:
Rotate matrix 90° clockwise in-place.

Formula:
Transpose + Reverse Each Row

Transpose:
(i,j) ↔ (j,i)

Reverse:
Swap left and right elements in every row.

Time:
O(n²)

Space:
O(1)

Interview Keyword:
"In-place matrix transformation"