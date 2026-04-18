# 1. Two Sum

## 🧠 Problem Statement
Given an array of integers `nums` and an integer `target`, return indices of the two numbers such that they add up to target.

- Each input has exactly one solution.
- You cannot use the same element twice.

---

## 🚀 Approach (Brute Force)

- Use two loops to check every pair.
- If `nums[i] + nums[j] == target`, return indices.

---

## ⏱️ Complexity

- Time Complexity: O(n²)
- Space Complexity: O(1)