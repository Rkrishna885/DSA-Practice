# 81. Search in Rotated Sorted Array II

## Problem Statement
Given a rotated sorted array `nums` that may contain **duplicate elements**, determine whether a given `target` exists in the array.

Return:
- `true` if the target is present.
- `false` otherwise.

---

## Example

### Input
```text
nums = [2,5,6,0,0,1,2]
target = 0
```

### Output
```text
true
```

### Input
```text
nums = [2,5,6,0,0,1,2]
target = 3
```

### Output
```text
false
```

---

# Approach

Since the array is **rotated**, a normal binary search cannot always determine which half is sorted.

Additionally, **duplicates** make the problem more difficult because they can hide the pivot.

### Algorithm

1. Initialize two pointers:
   - `low = 0`
   - `high = n - 1`

2. Find the middle index.

3. If `nums[mid] == target`, return `true`.

4. If
   ```java
   nums[low] == nums[mid] && nums[mid] == nums[high]
   ```
   we cannot determine the sorted half because all three values are equal.

   Therefore,
   - Increment `low`
   - Decrement `high`

5. Otherwise,
   - If the **left half is sorted**
     - Check whether the target lies inside it.
     - If yes, search the left half.
     - Otherwise search the right half.

6. Else,
   - The **right half is sorted**.
   - Check whether the target lies inside it.
   - Search accordingly.

7. If the loop ends, return `false`.

---

# Dry Run

### Input

```text
nums = [2,5,6,0,0,1,2]
target = 0
```

### Iteration 1

```text
low = 0
high = 6
mid = 3

nums[mid] = 0
```

Since

```text
nums[mid] == target
```

Return

```text
true
```

---

### Duplicate Case

```text
nums = [1,0,1,1,1]
target = 0
```

Initially,

```text
low = 0
mid = 2
high = 4

nums[low] = 1
nums[mid] = 1
nums[high] = 1
```

Since

```text
nums[low] == nums[mid] == nums[high]
```

we cannot identify the sorted half.

So,

```text
low++
high--
```

Continue searching until a sorted half becomes visible.

---

# Code Logic

### Duplicate Handling

```java
if(arr[low] == arr[mid] && arr[mid] == arr[high]){
    low++;
    high--;
    continue;
}
```

This removes duplicate boundaries when they prevent identifying the sorted half.

---

### Left Half Sorted

```java
if(arr[low] <= arr[mid])
```

Check whether

```text
arr[low] <= target <= arr[mid]
```

If true, move left.

Otherwise move right.

---

### Right Half Sorted

```java
else
```

Check whether

```text
arr[mid] <= target <= arr[high]
```

If true, move right.

Otherwise move left.

---

# Time Complexity

### Average Case

```text
O(log n)
```

Binary Search divides the search space in half.

### Worst Case

```text
O(n)
```

When many duplicate elements exist (for example `[1,1,1,1,1,1]`), we may only shrink the search space one element at a time.

---

# Space Complexity

```text
O(1)
```

Only constant extra space is used.

---

# Key Learning

- Binary Search can be applied to rotated sorted arrays.
- Duplicates make identifying the sorted half difficult.
- When `low`, `mid`, and `high` are equal, shrink the search space by moving both pointers.
- Average complexity remains **O(log n)**, but duplicates can degrade it to **O(n)** in the worst case.

---

# Topics

- Binary Search
- Rotated Sorted Array
- Searching
- Arrays

---

# Interview Tips

- First check whether `mid` is the target.
- Handle duplicates before checking sorted halves.
- Determine which half is sorted.
- Search only in the half where the target can exist.
- Remember that duplicates can increase the worst-case time complexity from **O(log n)** to **O(n)**.