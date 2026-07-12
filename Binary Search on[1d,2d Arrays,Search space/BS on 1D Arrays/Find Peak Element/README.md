# 162. Find Peak Element

## 📌 Problem Statement
A **peak element** is an element that is **strictly greater than its adjacent elements**.

Given a **0-indexed integer array `nums`**, return the index of **any peak element**.

You may assume:
- `nums[-1] = nums[n] = -∞`
- The first and last elements can also be peaks.

> **Constraint:** The solution must run in **O(log n)** time.

---

## Example

### Input
```text
nums = [1,2,3,1]
```

### Output
```text
2
```

### Explanation
`3` is greater than both its neighbors (`2` and `1`), so index `2` is returned.

---

## Approach

This problem can be solved efficiently using **Binary Search**.

### Step 1: Handle Edge Cases
- If the array contains only one element, return `0`.
- If the first element is greater than the second, return `0`.
- If the last element is greater than the second last, return the last index.

### Step 2: Binary Search
Search between indices `1` and `n-2`.

For every middle element:

- If it is greater than both neighbors, it is a peak.
- If the right neighbor is greater, move to the right half.
- Otherwise, move to the left half.

The idea is:
- An increasing slope always contains a peak on the right.
- A decreasing slope always contains a peak on the left.

---

## Algorithm

1. If `n == 1`, return `0`.
2. Check if the first element is a peak.
3. Check if the last element is a peak.
4. Apply binary search:
   - Calculate `mid`.
   - If `nums[mid]` is greater than both neighbors, return `mid`.
   - If `nums[mid] < nums[mid + 1]`, search the right half.
   - Otherwise, search the left half.
5. Return `-1` (this case never occurs for valid input).

---

## Dry Run

### Input
```text
nums = [1,2,3,1]
```

### Initial Values
```text
low = 1
high = 2
```

### Iteration 1
```text
mid = 1
nums[mid] = 2

2 < 3
Move Right

low = 2
```

### Iteration 2
```text
mid = 2
nums[mid] = 3

3 > 2
3 > 1

Peak Found
Return 2
```

---

## Complexity Analysis

### Time Complexity
```text
O(log n)
```
Binary search halves the search space in every iteration.

### Space Complexity
```text
O(1)
```
No extra space is used.

---

## Java Code

```java
class Solution {
    public int findPeakElement(int[] nums) {
        int low = 1, high = nums.length - 2;

        if (nums.length == 1) return 0;
        if (nums[0] > nums[1]) return 0;
        if (nums[nums.length - 1] > nums[nums.length - 2])
            return nums.length - 1;

        while (low <= high) {
            int mid = (low + high) / 2;

            if (nums[mid] > nums[mid - 1] && nums[mid] > nums[mid + 1])
                return mid;

            if (nums[mid] < nums[mid + 1]) {
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

## Key Learning

- Peak problems often have a **Binary Search** solution.
- If the array is increasing, a peak exists on the **right**.
- If the array is decreasing, a peak exists on the **left**.
- Checking edge elements separately simplifies the binary search.
- Binary Search can be applied even when the array is **not sorted**, as long as the search space can be reduced using problem-specific properties.

---

## Tags

- Binary Search
- Array
- Peak Element
- Divide and Conquer
- LeetCode 162