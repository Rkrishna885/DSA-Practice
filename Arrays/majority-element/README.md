# Majority Element (Boyer-Moore Voting Algorithm)

## 🧠 Problem
Find the element that appears more than n/2 times in an array.

If no such element exists, return -1.

---

## 🚀 Approach

### Step 1: Candidate Selection
- Use Boyer-Moore Voting Algorithm
- Maintain `count` and `element`
- Increase count if same element
- Decrease count if different

### Step 2: Verification
- Count occurrences of candidate
- If count > n/2 → return element
- Else → return -1

---

## ⏱️ Complexity

- Time Complexity: **O(n)**
- Space Complexity: **O(1)**

---

## 💡 Example

Input:nums = [2,2,1,1,1,2,2]

Output:2

---

## 📌 Notes
- This algorithm works only when majority element may exist.
- Verification step ensures correctness.


