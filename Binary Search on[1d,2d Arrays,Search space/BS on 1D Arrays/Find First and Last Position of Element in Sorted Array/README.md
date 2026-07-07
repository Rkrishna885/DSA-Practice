# 34. Find First and Last Position of Element in Sorted Array

## Problem Statement

Given a sorted integer array `nums` in non-decreasing order, return the first and last position of a given `target`.

- If the target is not found, return `[-1, -1]`.
- The solution must run in **O(log n)** time.

### Example

```text
Input:
nums = [5,7,7,8,8,10]
target = 8

Output:
[3,4]
```

---

# Approach 1: Using Lower Bound and Upper Bound

## Idea

Instead of searching for the first and last occurrence separately, we use two binary search helper functions.

- **Lower Bound** → Finds the first index where `nums[i] >= target`.
- **Upper Bound** → Finds the first index where `nums[i] > target`.

Then,

- First occurrence = Lower Bound
- Last occurrence = Upper Bound - 1

If the lower bound points outside the array or doesn't contain the target, the target doesn't exist.

---

## Algorithm

### Lower Bound

- Search for the first element greater than or equal to target.
- Store the possible answer.
- Continue searching on the left.

### Upper Bound

- Search for the first element strictly greater than target.
- Store the possible answer.
- Continue searching on the left.

### Final Answer

```java
first = lowerBound(target)
last = upperBound(target) - 1
```

---

## Dry Run

Array

```text
[5,7,7,8,8,10]
```

Target

```text
8
```

Lower Bound

```text
low = 0 high = 5

mid = 2 -> 7 < 8
move right

mid = 4 -> 8 >= 8
answer = 4
move left

mid = 3 -> 8 >= 8
answer = 3
move left

Lower Bound = 3
```

Upper Bound

```text
low = 0 high = 5

mid = 2 -> 7 <= 8
move right

mid = 4 -> 8 <= 8
move right

mid = 5 -> 10 > 8
answer = 5

Upper Bound = 5
```

Result

```text
First = 3
Last = 5 - 1 = 4
```

---

## Complexity

### Time

```
Lower Bound : O(log n)
Upper Bound : O(log n)

Total : O(log n)
```

### Space

```
O(1)
```

---

# Approach 2: Binary Search for First and Last Occurrence

## Idea

Run binary search twice.

### First Binary Search

Whenever target is found

- Save answer.
- Continue searching on the left.

This guarantees the leftmost occurrence.

---

### Second Binary Search

Whenever target is found

- Save answer.
- Continue searching on the right.

This guarantees the rightmost occurrence.

---

## Algorithm

### First Occurrence

```text
If arr[mid] == target

store answer
search left

Else

perform normal binary search
```

### Last Occurrence

```text
If arr[mid] == target

store answer
search right

Else

perform normal binary search
```

---

## Dry Run

Array

```text
[5,7,7,8,8,10]
```

Target

```text
8
```

### First Occurrence

```text
mid = 2 -> 7
move right

mid = 4 -> 8
first = 4
move left

mid = 3 -> 8
first = 3
move left

Result = 3
```

### Last Occurrence

```text
mid = 2 -> 7
move right

mid = 4 -> 8
last = 4
move right

mid = 5 -> 10
move left

Result = 4
```

---

## Complexity

### Time

```
First Search : O(log n)
Last Search  : O(log n)

Total : O(log n)
```

### Space

```
O(1)
```

---

# Comparison

| Approach | Idea | Time | Space |
|----------|------|------|--------|
| Lower Bound + Upper Bound | Find insertion positions | O(log n) | O(1) |
| First & Last Occurrence | Binary search twice | O(log n) | O(1) |

---

# Key Learning

- Lower Bound returns the first index where `arr[i] >= target`.
- Upper Bound returns the first index where `arr[i] > target`.
- Last occurrence can be computed as `upperBound - 1`.
- Binary search can be modified to find the leftmost or rightmost occurrence by continuing the search even after finding the target.
- Both approaches satisfy the required **O(log n)** time complexity.

---

## Tags

- Binary Search
- Lower Bound
- Upper Bound
- Searching
- Arrays
- LeetCode 34