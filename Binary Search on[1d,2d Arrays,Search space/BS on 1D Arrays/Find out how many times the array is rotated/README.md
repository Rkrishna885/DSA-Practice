# Find Out How Many Times the Array is Rotated

## Problem Statement

Given a **sorted array of distinct integers** that has been rotated to the right an unknown number of times, determine **how many times the array has been rotated**.

The number of rotations is equal to the **index of the minimum element**.

---

## Example

### Input

```text
nums = [4,5,6,7,0,1,2,3]
```

### Output

```text
4
```

### Explanation

Original array:

```text
[0,1,2,3,4,5,6,7]
```

After 4 right rotations:

```text
[4,5,6,7,0,1,2,3]
```

Therefore,

```text
Rotations = 4
```

---

### Input

```text
nums = [3,4,5,1,2]
```

### Output

```text
3
```

---

# Intuition

A rotated sorted array always contains one sorted half.

The **minimum element** marks the point where the rotation happened.

Since the number of rotations equals the **index of the minimum element**, the task becomes finding the minimum element's index using Binary Search.

---

# Approach

1. Initialize:
   - `low = 0`
   - `high = n - 1`
   - `ans = Integer.MAX_VALUE`
   - `ansIndex = 0`

2. If the current search range is already sorted:
   - The first element is the minimum.
   - Store its index and stop searching.

3. Find the middle element.

4. If the left half is sorted:
   - Update the minimum using `nums[low]`.
   - Search the right half.

5. Otherwise:
   - Update the minimum using `nums[mid]`.
   - Search the left half.

6. Return the index of the minimum element.

---

# Dry Run

### Input

```text
nums = [4,5,6,7,0,1,2,3]
```

### Initial State

```text
low = 0
high = 7
ans = ∞
index = 0
```

### Iteration 1

```text
mid = 3

nums[mid] = 7
```

Left half is sorted.

Update

```text
ans = 4
index = 0
```

Move right.

```text
low = 4
```

---

### Iteration 2

Current range

```text
[0,1,2,3]
```

is already sorted.

Update

```text
ans = 0
index = 4
```

Return

```text
4
```

---

# Code Logic

### Already Sorted

```java
if(nums.get(low) <= nums.get(high))
```

The first element is the smallest.

Store its index and stop searching.

---

### Left Half Sorted

```java
if(nums.get(low) <= nums.get(mid))
```

Store the first element if it is the smallest seen so far.

Search the right half.

---

### Right Half Unsorted

```java
else
```

The minimum lies in the left unsorted half.

Store `nums[mid]` if it is smaller.

Continue searching left.

---

# Time Complexity

```text
O(log n)
```

Binary Search eliminates half of the search space in every iteration.

---

# Space Complexity

```text
O(1)
```

No extra space is used.

---

# Key Observations

- The rotation count equals the index of the minimum element.
- Every rotated sorted array has one sorted half.
- If the current range is already sorted, the first element is the minimum.
- Binary Search makes the solution efficient.

---

# Topics

- Binary Search
- Arrays
- Rotated Sorted Array

---

# Interview Tips

- Rotation count = Index of the minimum element.
- Always check whether the current search range is already sorted.
- Keep track of both the minimum value and its index.
- This solution works only because the array contains distinct elements.