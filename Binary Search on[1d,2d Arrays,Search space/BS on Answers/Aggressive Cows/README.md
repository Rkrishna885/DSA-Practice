# Aggressive Cows

## Problem Statement

Given an array `nums` representing the positions of stalls and an integer `k` representing the number of aggressive cows, place the cows in the stalls such that the minimum distance between any two cows is as large as possible.

Return the maximum possible minimum distance.

---

## Example

### Input
```
nums = [0, 3, 4, 7, 10, 9]
k = 4
```

### Output
```
3
```

### Explanation

After sorting the stalls:

```
[0, 3, 4, 7, 9, 10]
```

The optimal placement is:

```
0 → 3 → 7 → 10
```

Minimum distance = **3**

---

## Approach

### Binary Search on Answer

The answer lies between:

- **Minimum distance = 1**
- **Maximum distance = last stall - first stall**

Use binary search to find the largest valid minimum distance.

### Greedy Placement

For every candidate distance (`mid`):

1. Place the first cow in the first stall.
2. Place the next cow only if the distance from the last placed cow is at least `mid`.
3. Count how many cows can be placed.
4. If at least `k` cows can be placed, the distance is feasible.
5. Otherwise, reduce the search space.

---

## Algorithm

1. Sort the stall positions.
2. Set:
   - `low = 1`
   - `high = maxPosition - minPosition`
3. While `low <= high`:
   - Find `mid`.
   - Count cows that can be placed using greedy placement.
   - If count ≥ `k`
     - Store answer.
     - Search for a larger distance.
   - Else
     - Search for a smaller distance.
4. Return the stored answer.

---

## Time Complexity

- Sorting: **O(n log n)**
- Binary Search: **O(log(maxDistance))**
- Checking each distance: **O(n)**

Overall:

```
O(n log n + n log(maxDistance))
```

---

## Space Complexity

```
O(1)
```

(Excluding the sorting algorithm's internal space.)

---

## Key Concepts

- Binary Search on Answer
- Greedy Algorithm
- Searching in Monotonic Space
- Optimization Problems

---

## Java Solution

```java
class Solution {
    public int findPlaces(int[] nums, int mid) {
        int count = 1;
        int fixed = nums[0];

        for (int i = 1; i < nums.length; i++) {
            if (nums[i] - fixed >= mid) {
                fixed = nums[i];
                count++;
            }
        }

        return count;
    }

    public int aggressiveCows(int[] nums, int k) {
        Arrays.sort(nums);

        int low = 1;
        int high = nums[nums.length - 1] - nums[0];
        int ans = 0;

        while (low <= high) {
            int mid = (low + high) / 2;

            int maxPossible = findPlaces(nums, mid);

            if (maxPossible < k) {
                high = mid - 1;
            } else {
                ans = mid;
                low = mid + 1;
            }
        }

        return ans;
    }
}
```

---

## Learning Outcome

This problem demonstrates how Binary Search can be applied to optimize an answer instead of searching an array. The greedy placement ensures efficient validation for each candidate distance, making the overall solution highly efficient.