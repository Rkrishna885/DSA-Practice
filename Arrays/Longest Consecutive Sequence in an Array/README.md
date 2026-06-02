Longest Consecutive Sequence (Sorting Approach)
Problem

Given an unsorted integer array nums, find the length of the longest consecutive elements sequence.

Example
Input: [100,4,200,1,3,2]
Output: 4

Explanation:

Sequence: 1 → 2 → 3 → 4
Length = 4
Approach: Sorting
Idea
Sort the array.
Traverse the sorted array.
Ignore duplicate elements.
If the current element is exactly 1 greater than the previous element, extend the streak.
Otherwise, start a new streak.
Keep track of the maximum streak length.
Dry Run
nums = [100,4,200,1,3,2]

After sorting:

[1,2,3,4,100,200]
Element	Current Streak	Longest Streak
1	1	1
2	2	1
3	3	1
4	4	1
100	1	4
200	1	4

Answer = 4

Algorithm
1. If array is empty, return 0.
2. Sort the array.
3. Initialize:
      currentStreak = 1
      longestStreak = 1
4. Traverse from index 1 to n-1:
      a) Skip duplicates.
      b) If current element = previous + 1:
             currentStreak++
         Else:
             update longestStreak
             reset currentStreak = 1
5. Return max(longestStreak, currentStreak).
Code Logic
Base Case
if(nums.length==0) return 0;

If the array is empty, no sequence exists.

Sorting
Arrays.sort(nums);

Sorting brings consecutive numbers together.

Streak Variables
int longestStreak = 1;
int currentStreak = 1;
currentStreak → length of current sequence.
longestStreak → maximum sequence found so far.
Duplicate Handling
if(nums[i] != nums[i-1])

Duplicates should not break the sequence.

Example:

[1,2,2,3]

The second 2 is ignored.

Consecutive Check
if(nums[i] == nums[i-1] + 1)

If current number is exactly 1 greater than the previous number:

currentStreak++;
Sequence Break
else{
    longestStreak = Math.max(longestStreak, currentStreak);
    currentStreak = 1;
}

Store the maximum streak and start a new sequence.

Final Answer
return Math.max(longestStreak, currentStreak);

Handles the case where the longest sequence ends at the last element.

Complexity Analysis
Time Complexity
Sorting  : O(n log n)
Traversal: O(n)

Total    : O(n log n)
Space Complexity
O(1)

(ignoring the sorting algorithm's internal space)

Key Learning
Sorting makes consecutive elements appear next to each other.
Always handle duplicates separately.
Maintain both current streak and maximum streak.
Update the answer after traversal because the longest sequence may end at the last element.
Pattern

Sort + Linear Traversal + Streak Counting

This pattern is commonly used in:

Consecutive sequence problems
Interval merging problems
Duplicate handling problems
Frequency streak tracking problems

LeetCode: Longest Consecutive Sequence
Approach Used: Sorting + Streak Counting
Time: O(n log n)
Space: O(1)