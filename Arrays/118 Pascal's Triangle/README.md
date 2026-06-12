# Pascal's Triangle - Optimal Solution

## Problem Statement

Given an integer `numRows`, return the first `numRows` of Pascal's Triangle.

### Example

Input:

```text
numRows = 5
```

Output:

```text
[
     [1],
    [1,1],
   [1,2,1],
  [1,3,3,1],
 [1,4,6,4,1]
]
```

---

## Approach

Instead of calculating every element using previous rows, this solution directly generates each row using the mathematical combination relationship.

For a row:

```text
1
1 1
1 2 1
1 3 3 1
1 4 6 4 1
```

Each element can be generated from the previous element using:

[
C(n,r)=C(n,r-1)\times\frac{n-r+1}{r}
]

This avoids repeatedly computing factorials and makes the solution efficient.

---

## Algorithm

### Generate a Single Row

1. Start with `1`.
2. Add it to the row.
3. Use the formula:

```java
ans = ans * (row - col);
ans = ans / col;
```

4. Continue until all elements of the row are generated.

### Generate Pascal's Triangle

1. Create an empty list `ans`.
2. For each row from `1` to `numRows`:

   * Generate the row using `generateRow()`.
   * Add it to the result.
3. Return the final triangle.

---

## Code Explanation

### `generateRow(int row)`

Generates one row of Pascal's Triangle.

Example:

```java
generateRow(5)
```

Produces:

```text
[1, 4, 6, 4, 1]
```

### `generate(int numRows)`

Generates the complete Pascal's Triangle.

Example:

```java
generate(5)
```

Produces:

```text
[
 [1],
 [1,1],
 [1,2,1],
 [1,3,3,1],
 [1,4,6,4,1]
]
```

---

## Dry Run

For `row = 5`

Initial:

```text
ans = 1
row = [1]
```

### col = 1

```text
ans = 1 * (5 - 1) / 1
ans = 4
```

Row:

```text
[1, 4]
```

### col = 2

```text
ans = 4 * (5 - 2) / 2
ans = 6
```

Row:

```text
[1, 4, 6]
```

### col = 3

```text
ans = 6 * (5 - 3) / 3
ans = 4
```

Row:

```text
[1, 4, 6, 4]
```

### col = 4

```text
ans = 4 * (5 - 4) / 4
ans = 1
```

Final Row:

```text
[1, 4, 6, 4, 1]
```

---

## Time Complexity

Generating row `i` takes:

```text
O(i)
```

Total work:

```text
O(1 + 2 + 3 + ... + n)
= O(n²)
```

### Time Complexity

```text
O(numRows²)
```

---

## Space Complexity

Result storage:

```text
O(numRows²)
```

Auxiliary space:

```text
O(1)
```

---

## Key Learning

* Pascal's Triangle values are binomial coefficients.
* Each element can be generated from the previous one without using factorials.
* This approach is more efficient and cleaner than calculating combinations separately for every element.

**Formula Used:**

C(n,r)=C(n,r-1)\times\frac{n-r+1}{r}

This formula allows generating each row in linear time.
