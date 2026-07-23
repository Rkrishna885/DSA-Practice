# 88. Merge Sorted Array

## Problem Statement
You are given two integer arrays `nums1` and `nums2`, sorted in non-decreasing order.

- `nums1` has a length of `m + n`, where the first `m` elements are valid and the last `n` elements are `0` (extra space).
- `nums2` has `n` valid elements.

Merge `nums2` into `nums1` so that `nums1` becomes a single sorted array.

---

## Approach

Instead of creating a new array, this solution merges the arrays **from the end**.

### Why merge from the end?

If we start from the beginning, elements in `nums1` would be overwritten before they are compared.

To avoid this, three pointers are used:

- `p1` → Last valid element in `nums1`
- `p2` → Last element in `nums2`
- `p` → Last position of `nums1`

The larger element between `nums1[p1]` and `nums2[p2]` is placed at `nums1[p]`, and the corresponding pointer moves backward.

After one array is exhausted, any remaining elements from `nums2` are copied into `nums1`.

---

## Algorithm

1. Initialize three pointers:
   - `p1 = m - 1`
   - `p2 = n - 1`
   - `p = nums1.length - 1`

2. Compare the last elements of both arrays.

3. Place the larger element at the end of `nums1`.

4. Move the corresponding pointer backward.

5. Repeat until either array is exhausted.

6. Copy any remaining elements from `nums2`.

---

## Time Complexity

- **O(m + n)**

Each element is processed only once.

---

## Space Complexity

- **O(1)**

No extra array is used. The merge is performed in-place.

---

## Java Code

```java
class Solution {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int p1 = m - 1, p2 = n - 1, p = nums1.length - 1;

        while ((p1 >= 0 && p2 >= 0) && p >= 0) {
            if (nums1[p1] > nums2[p2]) {
                nums1[p] = nums1[p1];
                p--;
                p1--;
            } else if (nums1[p1] < nums2[p2]) {
                nums1[p] = nums2[p2];
                p2--;
                p--;
            } else {
                nums1[p] = nums1[p1];
                p1--;
                p--;
            }
        }

        while (p2 >= 0) {
            nums1[p] = nums2[p2];
            p--;
            p2--;
        }
    }
}
```

---

## Example

### Input

```
nums1 = [1,2,3,0,0,0]
m = 3

nums2 = [2,5,6]
n = 3
```

### Output

```
[1,2,2,3,5,6]
```

---

## Key Concepts Learned

- Two Pointer Technique
- In-place Array Manipulation
- Backward Traversal
- Space Optimization
- Sorted Array Merging

---

## Interview Tip

The key observation is to **fill the array from the back**. This prevents overwriting the valid elements already present in `nums1` and allows the merge to be completed in **O(1)** extra space.