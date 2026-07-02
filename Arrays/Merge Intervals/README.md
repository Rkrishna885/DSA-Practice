# Merge Overlapping Intervals

## 📌 Problem Statement

Given a list of intervals where each interval is represented as `[start, end]`, merge all overlapping intervals and return the resulting list of non-overlapping intervals.

### Example

**Input**

```text
[[1,3],[2,6],[8,10],[15,18]]
```

**Output**

```text
[[1,6],[8,10],[15,18]]
```

---

# Approach 1: Optimal Solution

## Idea

1. Sort the intervals based on their starting point.
2. Traverse the sorted intervals.
3. If the current interval does not overlap with the last interval in the answer list, add it.
4. Otherwise, merge them by updating the ending point with the maximum end value.

---

## Algorithm

1. Sort intervals by starting time.
2. Create an empty answer list.
3. For every interval:

   * If the answer list is empty or the current interval starts after the last merged interval ends, add it.
   * Otherwise, merge by updating the last interval's ending value.
4. Return the merged intervals.

---

## Dry Run

Input:

```text
[[1,3],[2,6],[8,10],[15,18]]
```

After Sorting:

```text
[[1,3],[2,6],[8,10],[15,18]]
```

Process:

* Add `[1,3]`
* `[2,6]` overlaps → Merge → `[1,6]`
* `[8,10]` doesn't overlap → Add
* `[15,18]` doesn't overlap → Add

Final Answer:

```text
[[1,6],[8,10],[15,18]]
```

---

## Time Complexity

* Sorting: **O(N log N)**
* Traversal: **O(N)**

**Overall:** `O(N log N)`

---

## Space Complexity

Answer list:

```text
O(N)
```

---

# Approach 2: Better Solution

## Idea

1. Sort the intervals.
2. Start from every interval.
3. Skip intervals that are already completely covered by the previously merged interval.
4. Extend the current interval while the next intervals overlap.
5. Store the merged interval.

---

## Algorithm

1. Sort intervals.
2. Traverse every interval.
3. Ignore intervals already covered.
4. Merge all overlapping intervals.
5. Store the merged interval.
6. Return the answer.

---

## Dry Run

Input:

```text
[[1,3],[2,6],[8,10],[15,18]]
```

Process:

* Start = 1, End = 3
* Merge with `[2,6]`
* End becomes 6
* Store `[1,6]`

Next interval:

```text
[8,10]
```

No overlap → Store

Next interval:

```text
[15,18]
```

No overlap → Store

Final Output:

```text
[[1,6],[8,10],[15,18]]
```

---

## Time Complexity

* Sorting: **O(N log N)**
* Nested loop: **O(N)** in the best/average cases, but **O(N²)** in the worst case.

**Overall Worst Case:** `O(N²)`

---

## Space Complexity

```text
O(N)
```

---

# Key Observations

* Sorting by the starting point makes overlapping intervals appear consecutively.
* If the current interval starts after the previous merged interval ends, there is no overlap.
* Otherwise, merge by taking the maximum ending value.
* The optimal approach performs merging in a single traversal after sorting.

---

# Comparison

| Feature          | Better Approach    | Optimal Approach |
| ---------------- | ------------------ | ---------------- |
| Sorting          | ✅                  | ✅                |
| Traversal        | Nested Loop        | Single Loop      |
| Time Complexity  | O(N²) (Worst Case) | O(N log N)       |
| Space Complexity | O(N)               | O(N)             |
| Recommended      | ❌                  | ✅                |

---

# Concepts Used

* Sorting
* Greedy Algorithm
* Interval Merging
* ArrayList
* Custom Comparator
* List Operations

---

## Learning Outcome

After solving this problem, you will understand:

* How sorting simplifies interval problems.
* How to detect overlapping intervals.
* How greedy algorithms efficiently merge intervals.
* Why the single-pass greedy approach is optimal after sorting.
* How to optimize from a nested-loop solution to an `O(N log N)` solution.
