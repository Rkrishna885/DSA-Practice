# Longest Subarray With Sum K

## Problem Statement

Given an array `nums[]` and an integer `k`, find the **length of the longest subarray whose sum equals `k`**.

### Example

```java
nums = [10, 5, 2, 7, 1, 9]
k = 15
```

Output:

```java
4
```

Because:

```java
[5, 2, 7, 1] = 15
```

Length = `4`

---

# Approach 1: Brute Force

## Idea

Generate **all possible subarrays** and calculate their sum.

If the sum becomes `k`, update the longest length.

---

## Visualization

```java
nums = [10, 5, 2, 7, 1]
```

Starting from index `0`

```java
[10]
[10,5]
[10,5,2]
[10,5,2,7]
[10,5,2,7,1]
```

Starting from index `1`

```java
[5]
[5,2]
[5,2,7]
[5,2,7,1]
```

And so on...

We check every possible subarray.

---

## Code

```java
class Solution {
    public int longestSubarray(int[] nums, int k) {
       int longest = 0;

       for(int i = 0; i < nums.length; i++) {

           long sum = 0;

           for(int j = i; j < nums.length; j++) {

               sum += nums[j];

               if(sum == k) {
                   longest = Math.max(longest, j - i + 1);
               }
           }
       }

       return longest;
    }
}
```

---

## Dry Run

```java
nums = [10,5,2,7,1,9]
k = 15
```

### i = 0

```java
10      -> sum=10
10+5    -> sum=15 ✓ length=2
10+5+2  -> sum=17
...
```

Longest = 2

### i = 1

```java
5       -> sum=5
5+2     -> sum=7
5+2+7   -> sum=14
5+2+7+1 -> sum=15 ✓ length=4
```

Longest = 4

Final Answer = 4

---

## Time Complexity

### Outer Loop

```java
for(i)
```

Runs `n` times.

### Inner Loop

```java
for(j)
```

Runs up to `n` times.

Total:

```java
O(N²)
```

---

## Space Complexity

```java
O(1)
```

No extra data structure used.

---

# Approach 2: Better Solution (Prefix Sum + HashMap)

## Key Observation

Suppose:

```java
Prefix Sum till index i = sum
```

We want:

```java
Subarray Sum = k
```

That means:

```java
currentPrefixSum - previousPrefixSum = k
```

Rearrange:

```java
previousPrefixSum = currentPrefixSum - k
```

### Formula To Remember

```java
sum - k
```

If `(sum - k)` already exists in the map, then we found a subarray whose sum is `k`.

---

# What is Prefix Sum?

Prefix Sum means:

```java
sum of elements from index 0 to current index
```

Example:

```java
nums = [10,5,2,7]
```

| Index | Element | Prefix Sum |
| ----- | ------- | ---------- |
| 0     | 10      | 10         |
| 1     | 5       | 15         |
| 2     | 2       | 17         |
| 3     | 7       | 24         |

---

# Why HashMap?

Store:

```java
prefixSum -> first occurrence index
```

Example:

```java
{
10 -> 0
15 -> 1
17 -> 2
24 -> 3
}
```

This allows O(1) lookup.

---

# Core Logic

At every index:

### Step 1

Add current element.

```java
sum += nums[i];
```

---

### Step 2

Check if prefix sum itself equals k.

```java
if(sum == k)
```

Then subarray starts from index `0`.

Length:

```java
i + 1
```

---

### Step 3

Check if:

```java
sum - k
```

exists in map.

If yes:

```java
previousIndex = map.get(sum-k)
```

Length becomes:

```java
i - previousIndex
```

---

### Step 4

Store prefix sum only once.

```java
if(!map.containsKey(sum))
```

Why?

Because we want the **earliest index**.

Earlier index = Larger subarray length.

---

# Dry Run

```java
nums = [10,5,2,7,1,9]
k = 15
```

---

### i = 0

```java
sum = 10
```

Need:

```java
10-15 = -5
```

Not found.

Store:

```java
10 -> 0
```

---

### i = 1

```java
sum = 15
```

```java
sum == k
```

Length:

```java
2
```

Store:

```java
15 -> 1
```

---

### i = 2

```java
sum = 17
```

Need:

```java
17-15 = 2
```

Not found.

Store:

```java
17 -> 2
```

---

### i = 3

```java
sum = 24
```

Need:

```java
24-15 = 9
```

Not found.

Store:

```java
24 -> 3
```

---

### i = 4

```java
sum = 25
```

Need:

```java
25-15 = 10
```

Found!

```java
10 -> index 0
```

Length:

```java
4 - 0 = 4
```

Subarray:

```java
[5,2,7,1]
```

Max Length = 4

---

# Code

```java
class Solution {
    public int longestSubarray(int[] nums, int k) {

        HashMap<Long, Integer> map = new HashMap<>();

        long sum = 0;
        int maxLength = 0;

        for(int i = 0; i < nums.length; i++) {

            sum += nums[i];

            if(sum == k) {
                maxLength = i + 1;
            }

            if(map.containsKey(sum - k)) {
                maxLength = Math.max(
                    maxLength,
                    i - map.get(sum - k)
                );
            }

            if(!map.containsKey(sum)) {
                map.put(sum, i);
            }
        }

        return maxLength;
    }
}
```

---

# Why Store First Occurrence Only?

Example:

```java
Prefix Sum = 10
```

Appears at:

```java
index 1
index 5
```

Store:

```java
10 -> 1
```

NOT

```java
10 -> 5
```

Because:

```java
Current Index - Smaller Index
```

gives a bigger length.

We always want the longest subarray.

---

# Memory Trick

Think:

```text
Current Prefix Sum = sum

Need Subarray Sum = k

Ask:
"Have I seen (sum - k) before?"
```

If YES:

```text
Subarray Found
```

Formula:

```java
sum - k
```

This is the most important line of the solution.

---

# Interview Notes

### Brute Force

```java
Generate all subarrays
Check their sums
```

Time:

```java
O(N²)
```

Space:

```java
O(1)
```

---

### Optimal (Prefix Sum + HashMap)

```java
Store prefix sums in HashMap
Check sum-k
Keep earliest occurrence
```

Time:

```java
O(N)
```

Space:

```java
O(N)
```

---

# One-Line Revision

```text
Use Prefix Sum + HashMap.
If (currentPrefixSum - k) exists before,
then the subarray between those indices has sum k.
Store only the first occurrence of each prefix sum to get the longest length.
```

### Pattern Recognition

Whenever you hear:

```text
Longest/Count subarray
+
Sum = K
+
Array contains negatives
```

Think immediately:

```text
Prefix Sum + HashMap
```
