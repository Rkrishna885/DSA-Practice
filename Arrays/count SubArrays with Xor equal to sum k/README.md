# Count Subarrays With XOR Equal to K

## Problem Statement

Given an integer array `nums` and an integer `k`, find the total number of subarrays whose XOR is equal to `k`.

### Example

```text
Input:
nums = [4, 2, 2, 6, 4]
k = 6

Output:
4

Explanation:
Subarrays with XOR = 6:
[4, 2]
[2, 2, 6]
[6]
[2, 6, 4]
```

---

## Approaches

### 1. Brute Force Approach

#### Idea
Generate all possible subarrays and calculate XOR for each subarray using a third loop.

#### Code Logic

- Start from every index `i`.
- Generate every subarray ending at index `j`.
- Calculate XOR of elements from `i` to `j`.
- If XOR equals `k`, increment count.

#### Time Complexity

```text
O(N³)
```

#### Space Complexity

```text
O(1)
```

---

### 2. Better Approach

#### Idea
Instead of recalculating XOR for every subarray, maintain a running XOR while extending the subarray.

#### Code Logic

- Fix starting index `i`.
- Initialize `xOR = 0`.
- Extend subarray using index `j`.
- Update XOR as:

```java
xOR ^= nums[j];
```

- If XOR equals `k`, increment count.

#### Time Complexity

```text
O(N²)
```

#### Space Complexity

```text
O(1)
```

---

### 3. Optimal Approach (Prefix XOR + HashMap)

#### Idea

Use Prefix XOR and HashMap to count subarrays efficiently.

##### Key Observation

Let:

```text
PrefixXOR = XR
Required XOR = k
```

For a subarray XOR to be `k`:

```text
XR ^ previousPrefixXOR = k
```

Therefore:

```text
previousPrefixXOR = XR ^ k
```

If `XR ^ k` already exists in the HashMap, then a valid subarray exists.

#### Algorithm

1. Initialize:
   ```java
   XR = 0
   map.put(0,1)
   ```

2. Traverse the array:
   - Update prefix XOR.
   - Compute:
     ```java
     x = XR ^ k
     ```
   - Add occurrences of `x` from HashMap to answer.
   - Store current prefix XOR frequency.

#### Time Complexity

```text
O(N)
```

#### Space Complexity

```text
O(N)
```

---

## Optimal Java Solution

```java
class Solution {
    public int subarraysWithXorK(int[] nums, int k) {
        int XR = 0;
        int count = 0;

        Map<Integer, Integer> map = new HashMap<>();
        map.put(0, 1);

        for (int i = 0; i < nums.length; i++) {
            XR ^= nums[i];

            int x = XR ^ k;
            count += map.getOrDefault(x, 0);

            map.put(XR, map.getOrDefault(XR, 0) + 1);
        }

        return count;
    }
}
```

---

## Complexity Comparison

| Approach | Time Complexity | Space Complexity |
|-----------|----------------|------------------|
| Brute Force | O(N³) | O(1) |
| Better | O(N²) | O(1) |
| Optimal (Prefix XOR + HashMap) | O(N) | O(N) |

---

## Key Concepts Learned

- XOR Properties
- Prefix XOR
- HashMap Frequency Counting
- Subarray Problems
- Time Complexity Optimization

---

## Tags

```text
Array
HashMap
Prefix XOR
Bit Manipulation
Subarray
Interview Preparation
```