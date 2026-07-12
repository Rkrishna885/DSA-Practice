# Find Square Root of a Number

## 📌 Problem Statement

Given a positive integer `n`, find and return its square root.

- If `n` is a perfect square, return its square root.
- Otherwise, return the **floor value** of the square root.

---

## Examples

### Example 1

**Input**
```text
n = 36
```

**Output**
```text
6
```

**Explanation**

The square root of 36 is exactly 6.

---

### Example 2

**Input**
```text
n = 28
```

**Output**
```text
5
```

**Explanation**

√28 ≈ 5.29

The floor value is **5**.

---

# Approach 1: Brute Force

## Idea

Start checking numbers from **1**.

- If `i × i <= n`, store `i` as the answer.
- Stop when `i × i > n`.
- The last valid value is the floor square root.

### Algorithm

1. Initialize `ans = 1`.
2. Traverse from `1` to `n`.
3. If `i * i <= n`, update `ans`.
4. Otherwise, stop the loop.
5. Return `ans`.

---

### Dry Run

**Input**

```text
n = 28
```

| i | i² | i² ≤ 28 | ans |
|---|----|----------|-----|
|1|1|✔|1|
|2|4|✔|2|
|3|9|✔|3|
|4|16|✔|4|
|5|25|✔|5|
|6|36|✘|Stop|

**Answer = 5**

---

### Complexity Analysis

**Time Complexity**

```text
O(√n)
```

**Space Complexity**

```text
O(1)
```

---

# Approach 2: Binary Search (Optimal)

## Idea

The answer lies between **1** and **n**.

Use Binary Search to find the largest number whose square is less than or equal to `n`.

- If `mid² <= n`, move right.
- Otherwise, move left.
- At the end, `high` stores the floor square root.

---

### Algorithm

1. Initialize:
   - `low = 1`
   - `high = n`
2. Find `mid`.
3. Compute `mid * mid`.
4. If `mid² <= n`
   - Move right.
5. Else
   - Move left.
6. Return `high`.

---

### Dry Run

**Input**

```text
n = 28
```

Initial

```text
low = 1
high = 28
```

Iteration 1

```text
mid = 14
14² = 196 > 28

high = 13
```

Iteration 2

```text
mid = 7
7² = 49 > 28

high = 6
```

Iteration 3

```text
mid = 3
3² = 9 ≤ 28

low = 4
```

Iteration 4

```text
mid = 5
5² = 25 ≤ 28

low = 6
```

Iteration 5

```text
mid = 6
6² = 36 > 28

high = 5
```

Loop ends.

Return **5**.

---

## Complexity Analysis

**Time Complexity**

```text
O(log n)
```

**Space Complexity**

```text
O(1)
```

---

# Java Code

## Brute Force

```java
class Solution {
    public int floorSqrt(int n) {
        long ans = 1;

        for (long i = 1; i < n; i++) {
            if (i * i <= n) {
                ans = i;
            } else {
                break;
            }
        }

        return (int) ans;
    }
}
```

---

## Binary Search

```java
class Solution {
    public int floorSqrt(int n) {
        long low = 1;
        long high = n;

        while (low <= high) {
            long mid = (low + high) / 2;
            long value = mid * mid;

            if (value <= n) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }

        return (int) high;
    }
}
```

---

# Key Learning

- Brute Force checks every possible value until the square exceeds `n`.
- Binary Search reduces the search space by half in every iteration.
- Using `long` prevents integer overflow while calculating `mid * mid`.
- Binary Search is the preferred solution because it satisfies optimal time complexity.

---

# Topics

- Binary Search
- Mathematics
- Square Root
- Searching