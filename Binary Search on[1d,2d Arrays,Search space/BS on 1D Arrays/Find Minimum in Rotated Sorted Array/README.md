# 153. Find Minimum in Rotated Sorted Array

## Problem Statement

Given a **sorted array of unique elements** that has been rotated at an unknown pivot, find and return the **minimum element**.

You must solve the problem in **O(log n)** time.

---

## Example

### Input

```text
nums = [3,4,5,1,2]
```

### Output

```text
1
```

---

### Input

```text
nums = [4,5,6,7,0,1,2]
```

### Output

```text
0
```

---

### Input

```text
nums = [11,13,15,17]
```

### Output

```text
11
```

---

# Intuition

A rotated sorted array always has **one sorted half**.

- If the entire search range is already sorted, then the first element is the minimum.
- Otherwise, identify the sorted half:
  - If the **left half is sorted**, its first element is the smallest in that half, but the overall minimum may still be in the right half.
  - If the **right half is unsorted**, the minimum lies in that half, and `mid` could be the minimum.

By repeatedly eliminating one half, we achieve **O(log n)** time.

---

# Approach

1. Initialize:
   - `low = 0`
   - `high = n - 1`
   - `ans = Integer.MAX_VALUE`

2. While `low <= high`:
   - If the current range is already sorted (`nums[low] <= nums[high]`):
     - Update the answer with `nums[low]`.
     - Break, since `nums[low]` is the minimum in this range.

3. Find the middle index.

4. If the **left half is sorted**:
   - Update the answer with `nums[low]`.
   - Search the right half.

5. Otherwise:
   - The minimum lies in the unsorted left half.
   - Update the answer with `nums[mid]`.
   - Search the left half.

6. Return `ans`.

---

# Dry Run

### Input

```text
nums = [4,5,6,7,0,1,2]
```

### Initial State

```text
low = 0
high = 6
ans = ∞
```

### Iteration 1

```text
mid = 3
nums[mid] = 7
```

Current range is not sorted.

Left half:

```text
[4,5,6,7]
```

is sorted.

Update

```text
ans = min(∞,4) = 4
```

Move right.

```text
low = 4
```

---

### Iteration 2

```text
low = 4
high = 6
```

Current range

```text
[0,1,2]
```

is already sorted.

Update

```text
ans = min(4,0) = 0
```

Break.

Return

```text
0
```

---

# Code Logic

### Case 1: Current Range Already Sorted

```java
if(nums[low] <= nums[high]){
    ans = Math.min(ans, nums[low]);
    break;
}
```

The first element is the smallest in this sorted range.

---

### Case 2: Left Half Sorted

```java
if(nums[low] <= nums[mid]){
    ans = Math.min(ans, nums[low]);
    low = mid + 1;
}
```

Store the smallest value of the sorted half and continue searching the other half.

---

### Case 3: Right Half Unsorted

```java
else{
    ans = Math.min(ans, nums[mid]);
    high = mid - 1;
}
```

The minimum lies in the unsorted half, so continue searching there.

---

# Time Complexity

```text
O(log n)
```

- Binary Search halves the search space in every iteration.

---

# Space Complexity

```text
O(1)
```

- Only constant extra space is used.

---

# Key Observations

- The array contains **unique elements**, making it easy to identify the sorted half.
- If the current search range is sorted, the minimum is simply the first element.
- Always keep track of the smallest value seen so far.
- Eliminate one half of the search space in each iteration.

---

# Topics

- Binary Search
- Arrays
- Rotated Sorted Array

---

# Interview Tips

- Check if the current range is already sorted before calculating `mid`.
- If the left half is sorted, record `nums[low]` and move right.
- Otherwise, record `nums[mid]` and move left.
- Since the array has **unique elements**, there is no need to handle duplicates.
- This approach guarantees **O(log n)** time and **O(1)** space.