You can save the following notes in your GitHub repository along with the code.

# Remove Element (LeetCode 27)

## Idea

Remove all occurrences of `val` **in-place** and return the new length.

Instead of creating a new array, we move all valid elements to the front of the same array.

---

## Core Logic

Use **two pointers**:

* `i` → scans every element in the array.
* `index` → points to where the next valid element should be placed.

### Rule

If the current element is **not equal to `val`**:

1. Copy it to `nums[index]`.
2. Move `index` forward.

At the end:

* Elements from `0` to `index - 1` are the required elements.
* `index` is the new length.

---

## Visualization

Input:

```text
nums = [3,2,2,3]
val = 3
```

Initial:

```text
i = 0
index = 0
```

### Step 1

```text
nums[0] = 3
3 == val
Skip
```

```text
index = 0
```

### Step 2

```text
nums[1] = 2
2 != val
```

Place at `index`:

```text
[2,2,2,3]
 ^
index
```

```text
index = 1
```

### Step 3

```text
nums[2] = 2
2 != val
```

Place at `index`:

```text
[2,2,2,3]
   ^
 index
```

```text
index = 2
```

### Step 4

```text
nums[3] = 3
3 == val
Skip
```

Final:

```text
[2,2,_,_]
```

Return:

```text
2
```

---

## Memory Trick

Imagine:

> **"i searches, index stores."**

* `i` = Explorer 🔍
* `index` = Writer ✍️

Whenever the explorer finds a valid element:

* Give it to the writer.
* Writer moves forward.

---

## Pattern Recognition

Whenever a question says:

* Remove elements in-place
* Move valid elements to front
* Return new length

Think:

```text
Scan → Check → Copy → Move index
```

This is a classic **Two Pointer / Slow-Fast Pointer** pattern.

---

## Code

```java
class Solution {
    public int removeElement(int[] nums, int val) {
        int index = 0;

        for(int i = 0; i < nums.length; i++) {
            if(nums[i] != val) {
                nums[index] = nums[i];
                index++;
            }
        }

        return index;
    }
}
```

---

## Complexity

### Time Complexity

```text
O(n)
```

One traversal of the array.

### Space Complexity

```text
O(1)
```

No extra array used.

---

## One-Line Interview Explanation

> "I use a two-pointer approach where one pointer scans the array and another pointer maintains the position for the next valid element. Every non-target element is copied to the front, and the final value of the write pointer gives the new length."
