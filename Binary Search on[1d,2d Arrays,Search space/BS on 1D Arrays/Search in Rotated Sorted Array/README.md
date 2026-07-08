# Search in Rotated Sorted Array (LeetCode 33)

## Problem Statement

Given a rotated sorted array of **distinct integers** and a target value, return the index of the target if it exists; otherwise return `-1`.

The solution must run in **O(log n)** time.

### Example

Input:
nums = [4,5,6,7,0,1,2]
target = 0

Output:
4

---

## Approach

A normal Binary Search cannot be directly applied because the array is rotated.

However, **at least one half of the array is always sorted**.

### Steps

1. Find the middle element.
2. If it is the target, return its index.
3. Check whether the **left half is sorted**.
   - If the target lies inside the left sorted half, search left.
   - Otherwise, search right.
4. Otherwise, the **right half is sorted**.
   - If the target lies inside the right sorted half, search right.
   - Otherwise, search left.
5. Continue until the target is found or the search space becomes empty.

---

## Algorithm

1. Initialize `low = 0` and `high = n - 1`.
2. Repeat while `low <= high`:
   - Compute `mid`.
   - If `nums[mid] == target`, return `mid`.
   - If left half is sorted (`nums[low] <= nums[mid]`):
     - If target lies between `nums[low]` and `nums[mid]`,
       move `high = mid - 1`.
     - Else,
       move `low = mid + 1`.
   - Otherwise, the right half is sorted:
     - If target lies between `nums[mid]` and `nums[high]`,
       move `low = mid + 1`.
     - Else,
       move `high = mid - 1`.
3. Return `-1`.

---

## Dry Run

### Input

nums = [4,5,6,7,0,1,2]
target = 0

| low | mid | high | nums[mid] | Action |
|-----|-----|------|-----------|--------|
|0|3|6|7|Left half sorted, target not in left → Search right|
|4|5|6|1|Left half sorted, target in left → Search left|
|4|4|4|0|Target found|

Answer = **4**

---

## Time Complexity

- Binary Search is performed once.
- Search space reduces by half every iteration.

**Time Complexity:** `O(log n)`

---

## Space Complexity

Only a few variables are used.

**Space Complexity:** `O(1)`

---

## Key Learning

- Rotated sorted arrays still contain one sorted half.
- Determine the sorted half in every iteration.
- Decide whether the target belongs to that half.
- This maintains the logarithmic time complexity.

---

## Java Code

```java
class Solution {
    public int search(int[] nums, int target) {
        int low = 0, high = nums.length - 1;

        while (low <= high) {
            int mid = (low + high) / 2;

            if (nums[mid] == target)
                return mid;

            // Left half is sorted
            if (nums[low] <= nums[mid]) {
                if (nums[low] <= target && target <= nums[mid]) {
                    high = mid - 1;
                } else {
                    low = mid + 1;
                }
            }
            // Right half is sorted
            else {
                if (nums[mid] <= target && target <= nums[high]) {
                    low = mid + 1;
                } else {
                    high = mid - 1;
                }
            }
        }

        return -1;
    }
}
```

---

## Pattern Used

- Binary Search
- Search on Rotated Sorted Array
- Sorted Half Identification
- Divide and Conquer