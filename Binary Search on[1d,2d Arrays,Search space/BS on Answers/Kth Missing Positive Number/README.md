# 1539. Kth Missing Positive Number

## 📌 Problem Statement

Given a sorted array of **positive integers** `arr` and an integer `k`, return the **kth missing positive integer**.

### Example

**Input**
```text
arr = [2,3,4,7,11]
k = 5
Output

9

Explanation

Missing positive numbers are:

1, 5, 6, 8, 9, 10, 12...

The 5th missing positive number is 9.

💡 Approach

The idea is simple:

Traverse the array from left to right.
If the current array element is less than or equal to k, it means one missing number is skipped before or at this value.
Increase k by 1 because the target missing number shifts forward.
If an element becomes greater than k, stop the traversal.
Finally, return k.
✅ Algorithm
Iterate through the array.
If arr[i] <= k
Increment k.
Otherwise
Stop the loop.
Return k.
💻 Java Code
class Solution {
    public static int findKthPositive(int[] arr, int k) {
        for(int i = 0; i < arr.length; i++) {
            if(arr[i] <= k) {
                k++;
            } else {
                break;
            }
        }
        return k;
    }
}
⏱️ Complexity Analysis
Time Complexity: O(n)
Space Complexity: O(1)
🧠 Key Insight

Whenever an array element is less than or equal to the current value of k, it pushes the kth missing number one position further, so we increase k.

🚀 Topics Covered
Arrays
Linear Search
Greedy Logic
🏷️ LeetCode

Problem: 1539 - Kth Missing Positive Number


> **Note:** Your loop should iterate through the entire array:
> ```java
> for (int i = 0; i < arr.length; i++)
> ```
> instead of
> ```java
> for (int i = 0; i < arr.length - 1; i++)
> ```
> Otherwise, the last element is never checked, which can produce incorrect results for some test cases.

---

## GitHub Commit Message

```text
Solved LeetCode 1539: Kth Missing Positive Number using a linear traversal approach. Updated k whenever an array element was less than or equal to it, achieving O(n) time and O(1) space complexity.