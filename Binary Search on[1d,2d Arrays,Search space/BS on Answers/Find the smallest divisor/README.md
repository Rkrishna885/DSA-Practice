# Find the Smallest Divisor Given a Threshold

## 📌 Problem Statement

Given an integer array `nums` and an integer `threshold`, find the **smallest positive divisor** such that the sum of the ceiling values of each division is **less than or equal to** the given threshold.

For each element:

ceil(nums[i] / divisor)

Return the smallest divisor that satisfies the condition.

---

## 💡 Approach

This problem can be solved efficiently using **Binary Search on the Answer**.

### Observation

- The smallest possible divisor is **1**.
- The largest possible divisor is the **maximum element** in the array.
- As the divisor increases, the total sum of ceiling divisions decreases.
- Since the answer is monotonic, Binary Search can be applied.

---

## 🔍 Algorithm

1. Initialize:
   - `low = 1`
   - `high = maximum element in nums`
2. Perform Binary Search:
   - Find the middle divisor.
   - Calculate the total sum using ceiling division.
   - If the sum is less than or equal to the threshold:
     - Store the divisor as a possible answer.
     - Search for a smaller divisor.
   - Otherwise:
     - Search in the larger half.
3. Return the stored answer.

---

## 🧮 Ceiling Division Formula

Instead of using `Math.ceil()`:

```java
(num + divisor - 1) / divisor
```

or

```java
if (num % divisor == 0)
    sum += num / divisor;
else
    sum += (num / divisor) + 1;
```

Both produce the same result.

---

## ✅ Example

### Input

```text
nums = [1,2,5,9]
threshold = 6
```

### Binary Search

| Divisor | Sum | Valid |
|---------:|----:|:-----:|
| 5 | 5 | ✅ |
| 3 | 7 | ❌ |
| 4 | 7 | ❌ |

Smallest valid divisor = **5**

### Output

```text
5
```

---

## ⏱️ Time Complexity

- Finding maximum element: **O(n)**
- Binary Search: **O(log(max(nums)))**
- Each binary search iteration scans the array: **O(n)**

Overall:

**O(n × log(max(nums)))**

---

## 💾 Space Complexity

**O(1)**

Only a few extra variables are used.

---

## 🚀 Key Concepts

- Binary Search on Answer
- Ceiling Division
- Monotonic Search Space
- Optimization Problems

---

## 📖 Learning Outcome

This problem teaches how Binary Search can be applied to find the minimum valid answer instead of searching directly through every possible divisor. It is a classic example of **Binary Search on Answer**, where increasing the divisor decreases the computed sum, creating a monotonic search space.