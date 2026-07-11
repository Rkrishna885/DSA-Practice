# Single Element in a Sorted Array

## Problem Statement

Given a sorted array where every element appears exactly twice except for one element that appears only once, find and return that single element.

The solution must run in:

* **Time Complexity:** `O(log n)`
* **Space Complexity:** `O(1)`

---

## Approach

This solution uses **Binary Search** by taking advantage of the sorted nature of the array.

### Key Observation

* Before the single element, duplicate pairs follow the pattern:

  * First occurrence at an **even** index.
  * Second occurrence at an **odd** index.
* After the single element, this pattern is reversed.
* Using the index parity (even/odd), we can determine which half of the array contains the single element.

---

## Algorithm

1. Handle special edge cases:

   * If the array contains only one element, return it.
   * If the first element is unique, return it.
   * If the last element is unique, return it.

2. Perform Binary Search between indices `1` and `n - 2`.

3. For every middle element:

   * If it is different from both its previous and next elements, it is the required answer.
   * If:

     * `mid` is **odd** and `nums[mid] == nums[mid - 1]`, or
     * `mid` is **even** and `nums[mid] == nums[mid + 1]`,
       then the pairing is correct, so search the **right half**.
   * Otherwise, search the **left half**.

4. Return the single element.

---

## Code Logic

```java
if (nums[mid] != nums[mid - 1] && nums[mid] != nums[mid + 1])
    return nums[mid];
```

Checks whether the current element is different from both neighbors. If true, it is the unique element.

```java
if ((mid % 2 != 0 && nums[mid] == nums[mid - 1]) ||
    (mid % 2 == 0 && nums[mid] == nums[mid + 1])) {
    low = mid + 1;
}
```

If the duplicate pairing is correct, continue searching in the right half.

```java
else {
    high = mid - 1;
}
```

Otherwise, the unique element lies in the left half.

---

## Time Complexity

* Binary Search reduces the search space by half in each iteration.

**Time Complexity:** `O(log n)`

---

## Space Complexity

No additional data structures are used.

**Space Complexity:** `O(1)`

---

## Example

### Input

```text
nums = [1,1,2,3,3,4,4,8,8]
```

### Output

```text
2
```

---

## Features

* Uses Binary Search for efficient searching.
* Handles all edge cases.
* Constant extra space.
* Interview-friendly implementation.
* Meets the required `O(log n)` time complexity.
