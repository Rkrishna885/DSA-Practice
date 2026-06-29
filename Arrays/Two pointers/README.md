What is the Two Pointers Pattern?
The Two Pointers technique involves using two indices (pointers) to iterate over a data structure 
(usually an array or a string) to solve problems efficiently by avoiding nested loops.
●
●
When to Use Two Pointers?
When you need to find pairs, triplets, or subarrays meeting certain conditions.
When the data is sorted or can be sorted.
●
●
When you want to optimize brute force solutions that use nested loops (O(n²)) to linear or 
near-linear time (O(n)).
How It Works?
You maintain two pointers that move through the data structure according to certain rules:
One pointer starts at the beginning, the other at the end (common in problems like 
finding pairs with a sum).
●
●
Or, both pointers start at the beginning, with one moving faster than the other (useful for 
sliding window problems).
Move pointers towards each other or forward depending on the problem condition.
Typical Approach:

1.Initialize two pointers, left and right.
2.Check condition based on the current pointers.
3.Move pointers accordingly:
4.If condition not met, move left or right pointer to try to satisfy the condition.
5.If condition met, record the answer or move