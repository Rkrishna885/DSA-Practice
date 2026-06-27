# Merge Overlapping Subintervals

## Problem Statement
Given an array of intervals where each interval is represented as `[start, end]`, merge all overlapping intervals and return the resulting list of non-overlapping intervals.

### Example

**Input**
```text
[[1,5],[3,6],[8,10],[15,18]]
```

**Output**
```text
[[1,6],[8,10],[15,18]]
```

**Explanation**

- `[1,5]` and `[3,6]` overlap.
- They are merged into `[1,6]`.
- The remaining intervals do not overlap.

---

## Approach (Brute Force after Sorting)

### Step 1: Sort the Intervals
Sort all intervals based on their starting point.

### Step 2: Traverse the Intervals
- Take the current interval's `start` and `end`.
- If the interval is already covered by the last merged interval, skip it.
- Otherwise, check all following intervals.
- If the next interval overlaps (`nextStart <= currentEnd`), update the ending point.
- Continue until no more overlapping intervals exist.
- Add the merged interval to the answer list.

---

## Algorithm

1. Sort intervals according to the starting value.
2. Create an empty answer list.
3. Traverse every interval.
4. Skip intervals already included in the previous merged interval.
5. Merge all overlapping intervals by updating the ending point.
6. Store the merged interval.
7. Return the answer.

---

## Code

```java
class Solution {
    public List<List<Integer>> mergeOverlap(List<List<Integer>> intervals) {
        int n = intervals.size();

        Collections.sort(intervals, (a, b) -> Integer.compare(a.get(0), b.get(0)));

        List<List<Integer>> ans = new ArrayList<>();

        for (int i = 0; i < n; i++) {

            int start = intervals.get(i).get(0);
            int end = intervals.get(i).get(1);

            if (!ans.isEmpty() && end <= ans.get(ans.size() - 1).get(1)) {
                continue;
            }

            for (int j = i + 1; j < n; j++) {
                if (intervals.get(j).get(0) <= end) {
                    end = Math.max(end, intervals.get(j).get(1));
                } else {
                    break;
                }
            }

            ans.add(Arrays.asList(start, end));
        }

        return ans;
    }
}
```

---

## Dry Run

### Input

```text
[[1,5],[3,6],[8,10],[15,18]]
```

### After Sorting

```text
[[1,5],[3,6],[8,10],[15,18]]
```

### Iteration 1

Current Interval:

```text
[1,5]
```

Next interval starts at `3`, which is less than or equal to `5`.

Merge:

```text
end = max(5,6) = 6
```

Merged interval:

```text
[1,6]
```

Answer:

```text
[[1,6]]
```

---

### Iteration 2

Current interval:

```text
[3,6]
```

Already covered by `[1,6]`.

Skip.

---

### Iteration 3

Current interval:

```text
[8,10]
```

No overlap.

Answer:

```text
[[1,6],[8,10]]
```

---

### Iteration 4

Current interval:

```text
[15,18]
```

No overlap.

Final Answer:

```text
[[1,6],[8,10],[15,18]]
```

---

## Time Complexity

### Sorting

```text
O(n log n)
```

### Nested Traversal

```text
O(n²)
```

Worst-case occurs when many intervals overlap and each interval checks the remaining intervals.

**Overall Time Complexity**

```text
O(n²)
```

---

## Space Complexity

Only the output list is used.

```text
O(n)
```

---

## Key Concepts Learned

- Sorting intervals based on starting points.
- Detecting interval overlap.
- Merging overlapping ranges.
- Using nested loops for interval expansion.
- Skipping intervals that are already merged.
- Understanding brute-force interval merging.

---

## Note

This solution uses a nested loop after sorting, giving a worst-case time complexity of **O(n²)**. An optimized solution is available that merges intervals in a single traversal after sorting, reducing the overall time complexity to **O(n log n)**.