# Leaders in an Array

## 🧩 Problem Statement
Given an integer array `nums`, return all leaders in the array.

A **leader** is an element that is strictly greater than all elements to its right.

👉 The rightmost element is always a leader.

---

## 📌 Example

### Input:nums = [1, 2, 5, 3, 1, 2]

### Output:[5, 3, 2]

---

## 🧠 Approach 1: Brute Force

### 💡 Idea:
- For each element, check all elements to the right.
- If it's greater than all, it's a leader.

### ⏱️ Complexity:
- Time: **O(n²)**
- Space: **O(1)**

---

## ⚡ Approach 2: Optimized

### 💡 Idea:
- Traverse from right to left.
- Keep track of maximum element seen so far.

### Steps:
1. Start from last element
2. Keep updating `maxRight`
3. If current element > maxRight → it's a leader

### ⏱️ Complexity:
- Time: **O(n)**
- Space: **O(1)**

---

## 🚀 Key Learning

- Avoid nested loops when possible
- Use reverse traversal for optimization
- Track running maximum

---

## 📁 Files

- `BruteForce.java` → O(n²) solution
- `Optimized.java` → O(n) solution

