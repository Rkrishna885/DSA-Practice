# Find Nth Root of a Number

## Problem Statement
Given two integers **N** and **M**, find the **Nth root** of **M**.

The Nth root of a number **M** is an integer **X** such that:

> X^N = M

If no integer Nth root exists, return **-1**.

### Examples

**Example 1**
```
Input:
N = 3, M = 27

Output:
3
```

**Explanation:**
3³ = 27, so the answer is 3.

---

**Example 2**
```
Input:
N = 4, M = 69

Output:
-1
```

**Explanation:**
There is no integer whose fourth power equals 69.

---

# Approach

We use **Binary Search on the answer**.

- The possible Nth root lies between **0** and **M**.
- Calculate the middle value (`mid`).
- Compute `mid^N`.
- If `mid^N == M`, return `mid`.
- If `mid^N < M`, search in the right half.
- Otherwise, search in the left half.
- If no integer root is found, return **-1**.

---

# Algorithm

1. Initialize:
   - `low = 0`
   - `high = M`
2. Perform binary search while `low <= high`.
3. Find `mid`.
4. Compute `mid^N`.
5. If:
   - `mid^N == M` → return `mid`
   - `mid^N < M` → search right (`low = mid + 1`)
   - `mid^N > M` → search left (`high = mid - 1`)
6. If the loop ends, return **-1**.

---

# Time Complexity

- Binary Search: **O(log M)**
- Power calculation in each iteration: **O(N)**

**Overall Time Complexity:** **O(N × log M)**

---

# Space Complexity

- **O(1)**

No extra space is used except a few variables.

---

# Key Concepts

- Binary Search on Answers
- Integer Power Calculation
- Overflow Prevention
- Efficient Searching

---

# Java Solution

```java
class Solution {
    public int NthRoot(int N, int M) {
        int low = 0, high = M;

        while (low <= high) {
            int mid = (low + high) / 2;

            long ans = 1;
            boolean exceeded = false;

            for (int i = 0; i < N; i++) {
                ans *= mid;

                if (ans > M) {
                    exceeded = true;
                    break;
                }
            }

            if (ans == M && !exceeded) {
                return mid;
            } else if (ans < M && !exceeded) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }

        return -1;
    }
}
```

---

# Why Binary Search?

A brute-force solution checks every number from `1` to `M`, resulting in **O(M × N)** time.

Binary Search significantly reduces the search space, making the solution much faster with **O(N × log M)** complexity.

---

## Tags

- Binary Search
- Binary Search on Answers
- Math
- Searching
- DSA