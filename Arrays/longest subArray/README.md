# Longest Subarray with Sum Zero

## Problem Statement

Given an array of integers `arr[]`, find the length of the longest subarray whose sum is equal to `0`.

### Example

**Input:**

```java
arr = [15, -2, 2, -8, 1, 7, 10, 23]
```

**Output:**

```java
5
```

**Explanation:**
The subarray `[-2, 2, -8, 1, 7]` has a sum of `0` and length `5`.

---

## Approach (Optimal Using HashMap)

### Key Observation

If the same prefix sum appears more than once, the elements between those two indices must have a sum of `0`.

For example:

| Index | Element | Prefix Sum |
| ----- | ------- | ---------- |
| 0     | 15      | 15         |
| 1     | -2      | 13         |
| 2     | 2       | 15         |

Since prefix sum `15` appears at indices `0` and `2`, the subarray between them (`[-2, 2]`) has sum `0`.

### Algorithm

1. Maintain a running prefix sum.
2. Store the first occurrence of each prefix sum in a `HashMap`.
3. If the prefix sum becomes `0`, update the maximum length.
4. If the same prefix sum is found again:

   * Calculate the subarray length.
   * Update the maximum length if necessary.
5. Return the maximum length.

---

## Code

```java
class Solution {
    public int maxLen(int[] arr) {
       HashMap<Long,Integer> map = new HashMap<>();
       long sum = 0;
       int maxLength = 0;

       for(int i = 0; i < arr.length; i++) {
           sum += arr[i];

           if(sum == 0) {
               maxLength = i + 1;
           }

           if(map.containsKey(sum)) {
               maxLength = Math.max(maxLength, i - map.get(sum));
           } else {
               map.put(sum, i);
           }
       }

       return maxLength;
    }
}
```

---

## Dry Run

### Input

```java
arr = [1, -1, 3, 2, -2, -3]
```

### Prefix Sum Calculation

| Index | Value | Prefix Sum |
| ----- | ----- | ---------- |
| 0     | 1     | 1          |
| 1     | -1    | 0          |
| 2     | 3     | 3          |
| 3     | 2     | 5          |
| 4     | -2    | 3          |
| 5     | -3    | 0          |

* Prefix sum becomes `0` at index `1` → Length = `2`
* Prefix sum `3` repeats at indices `2` and `4` → Length = `2`
* Prefix sum becomes `0` at index `5` → Length = `6`

**Answer = 6**

---

## Complexity Analysis

### Time Complexity

```java
O(N)
```

Each element is processed once.

### Space Complexity

```java
O(N)
```

HashMap stores prefix sums and their indices.

---

## Concepts Used

* Prefix Sum
* HashMap
* Array Traversal
* Longest Subarray Problems
* Optimal O(N) Solution
