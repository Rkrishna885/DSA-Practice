# 🍌 Koko Eating Bananas

## 📌 Problem Statement

Koko loves eating bananas. There are `n` piles of bananas, where `piles[i]` represents the number of bananas in the `i-th` pile.

She can eat at a constant speed of **k bananas per hour**.

- In one hour, Koko chooses **one pile** and eats up to **k bananas**.
- If the pile contains fewer than `k` bananas, she eats the entire pile and waits until the next hour.
- The guards will return after **h hours**.

Find the **minimum eating speed `k`** so that Koko can finish all the bananas within `h` hours.

---

## 💡 Examples

### Example 1

**Input**
```text
piles = [3,6,7,11]
h = 8
```

**Output**
```text
4
```

---

### Example 2

**Input**
```text
piles = [30,11,23,4,20]
h = 5
```

**Output**
```text
30
```

---

### Example 3

**Input**
```text
piles = [30,11,23,4,20]
h = 6
```

**Output**
```text
23
```

---

# 🚀 Approach (Binary Search on Answer)

The eating speed (`k`) can range from:

- **Minimum:** `1` banana/hour
- **Maximum:** `max(piles)` bananas/hour

Since a higher eating speed always decreases the required time, the answer space is **monotonic**, making **Binary Search** the optimal solution.

---

## Algorithm

1. Set:
   - `low = 1`
   - `high = maximum pile size`
2. Perform Binary Search.
3. For each middle value (`mid`):
   - Calculate the total hours required to finish all piles.
   - Hours for one pile:
     ```
     ceil(pile / mid)
     ```
   - Integer implementation:
     ```
     (pile + mid - 1) / mid
     ```
4. If required hours are less than or equal to `h`:
   - Store `mid` as a possible answer.
   - Search for a smaller speed.
5. Otherwise:
   - Increase the eating speed.
6. Return the minimum valid speed.

---

# 🧠 Key Observation

The required hours decrease as the eating speed increases.

```
Speed = 2  →  More Hours
Speed = 4  →  Fewer Hours
Speed = 8  →  Even Fewer Hours
```

Since this relationship is monotonic, Binary Search can efficiently find the minimum valid speed.

---

# ⏱️ Complexity Analysis

### Time Complexity

- Finding maximum pile:
  ```
  O(n)
  ```

- Binary Search:
  ```
  O(log(maxPile))
  ```

- Each Binary Search iteration checks all piles:
  ```
  O(n)
  ```

Overall:

```
O(n × log(maxPile))
```

---

### Space Complexity

```
O(1)
```

Only a few variables are used.

---

# ✅ Code Explanation

### `canEatAll()`

Calculates the total number of hours required if Koko eats at speed `mid`.

```java
totalTime += (pile + mid - 1) / mid;
```

This is the integer equivalent of:

```text
ceil(pile / mid)
```

Example:

```
Pile = 11
Speed = 4

11 / 4 = 2.75

Ceiling = 3

Formula:
(11 + 4 - 1) / 4
= 14 / 4
= 3
```

---

### Binary Search

```java
if(requiredTime <= h)
```

- Current speed is sufficient.
- Try finding a smaller valid speed.

```java
else
```

- Speed is too slow.
- Increase the eating speed.

---

# 📖 Dry Run

### Input

```text
piles = [3,6,7,11]
h = 8
```

Maximum pile:

```
11
```

Search range:

```
low = 1
high = 11
```

### Iteration 1

```
mid = 6
```

Hours:

```
3 → 1
6 → 1
7 → 2
11 → 2

Total = 6
```

```
6 <= 8
```

Answer = 6

Search left.

---

### Iteration 2

```
mid = 3
```

Hours:

```
3 → 1
6 → 2
7 → 3
11 → 4

Total = 10
```

```
10 > 8
```

Need higher speed.

---

### Iteration 3

```
mid = 4
```

Hours:

```
3 → 1
6 → 2
7 → 2
11 → 3

Total = 8
```

Valid answer.

---

### Iteration 4

```
mid = 3
```

Already checked.

Binary Search ends.

Final Answer:

```
4
```

---

# 🔑 Concepts Learned

- Binary Search on Answer
- Monotonic Search Space
- Ceiling Division
- Optimization Problems
- Time Complexity Optimization

---

# 🏷️ Tags

- Binary Search
- Binary Search on Answer
- Arrays
- LeetCode 875
- Medium
```