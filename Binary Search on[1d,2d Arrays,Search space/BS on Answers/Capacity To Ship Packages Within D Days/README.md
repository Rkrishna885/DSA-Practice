# Capacity To Ship Packages Within D Days

## Problem Statement
A conveyor belt has packages that must be shipped from one port to another within a given number of days.

Each package has a weight, and the ship can carry packages only in the given order. The total weight loaded on a ship in a single day cannot exceed the ship's capacity.

Find the **minimum ship capacity** required to deliver all packages within the given number of days.

---

## Example

### Input
```text
weights = [1,2,3,4,5,6,7,8,9,10]
days = 5
```

### Output
```text
15
```

### Explanation
Capacity **15** allows shipping as:

- Day 1 → 1 + 2 + 3 + 4 + 5 = 15
- Day 2 → 6 + 7 = 13
- Day 3 → 8
- Day 4 → 9
- Day 5 → 10

No smaller capacity can finish the shipment within 5 days.

---

# Approach

This problem can be solved using **Binary Search on Answer**.

### Step 1: Define the Search Space

- **Minimum Capacity (low)** = Maximum package weight
  - Because every package must fit into the ship.

- **Maximum Capacity (high)** = Sum of all package weights
  - Ship everything in one day.

---

### Step 2: Binary Search

For every capacity (`mid`):

- Calculate how many days are needed.
- If required days are **less than or equal to** given days:
  - Try a smaller capacity.
- Otherwise:
  - Increase the capacity.

Continue until the minimum valid capacity is found.

---

# Algorithm

1. Find the maximum element in the array.
2. Find the total sum of weights.
3. Perform Binary Search between `maxWeight` and `sum`.
4. For each capacity:
   - Simulate shipping packages.
   - Count the number of days required.
5. Return the smallest valid capacity.

---

# Dry Run

### Input

```text
weights = [3,2,2,4,1,4]
days = 3
```

Search Space:

```text
low = 4
high = 16
```

### Iteration 1

```text
mid = 10

Days Needed = 2

2 <= 3
Move Left
```

### Iteration 2

```text
mid = 6

Days Needed = 3

Valid Answer
Move Left
```

### Iteration 3

```text
mid = 4

Days Needed = 5

Too many days
Move Right
```

### Iteration 4

```text
mid = 5

Days Needed = 4

Move Right
```

Final Answer:

```text
6
```

---

# Time Complexity

### Binary Search

```
O(log(Sum - MaxWeight))
```

### Checking Days

```
O(n)
```

### Overall

```
O(n × log(Sum))
```

---

# Space Complexity

```
O(1)
```

No extra space is used.

---

# Key Observations

- Ship capacity can never be smaller than the heaviest package.
- Ship capacity never needs to exceed the total weight of all packages.
- As ship capacity increases, required days decrease.
- Since the answer is monotonic, Binary Search is the optimal approach.

---

# Concepts Used

- Binary Search on Answer
- Greedy Simulation
- Arrays