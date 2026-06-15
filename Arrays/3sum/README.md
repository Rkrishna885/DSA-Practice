3Sum - Optimal Solution (Sorting + Two Pointers)
Problem Statement

Given an integer array nums, return all the unique triplets [nums[i], nums[j], nums[k]] such that:

nums[i] + nums[j] + nums[k] = 0

The solution set must not contain duplicate triplets.

Pattern Used

✅ Sorting

✅ Two Pointers

✅ Duplicate Handling

Intuition

A brute force solution would check every possible triplet.

i, j, k

This requires 3 nested loops.

Time Complexity:

O(N³)

This is too slow for large inputs.

Optimization
Step 1: Sort the Array
Arrays.sort(nums);

Example:

[-1, 0, 1, 2, -1, -4]

↓

[-4, -1, -1, 0, 1, 2]

Sorting helps us:

Use Two Pointers
Easily skip duplicates
Step 2: Fix One Element

Use a loop to fix the first element of the triplet.

for(int i = 0; i <= nums.length - 3; i++)

Example:

i = -4
Find two numbers whose sum = 4

i = -1
Find two numbers whose sum = 1
Step 3: Apply Two Pointers

After fixing nums[i]:

int left = i + 1;
int right = nums.length - 1;

Now search for:

nums[left] + nums[right] = -nums[i]
Pointer Movement Logic
Calculate Current Sum
int currentSum = nums[i] + nums[left] + nums[right];
Case 1: Sum = 0

Triplet found.

sum.add(Arrays.asList(nums[i], nums[left], nums[right]));

Move both pointers.

left++;
right--;
Case 2: Sum < 0

Need a larger value.

Since the array is sorted:

left++;

Move left pointer rightward.

Case 3: Sum > 0

Need a smaller value.

right--;

Move right pointer leftward.

Handling Duplicates
Duplicate Fixed Element
if(i > 0 && nums[i] == nums[i - 1])
    continue;

Without this:

[-1, -1, 0, 1]

would generate duplicate triplets.

Duplicate Left Pointer
while(left < right && nums[left] == nums[left - 1])
    left++;

Skip repeated values after finding a valid triplet.

Duplicate Right Pointer
while(left < right && nums[right] == nums[right + 1])
    right--;

Skip repeated values from the right side.

Dry Run
Input
[-1, 0, 1, 2, -1, -4]
After Sorting
[-4, -1, -1, 0, 1, 2]
i = 0
nums[i] = -4
left = -1
right = 2

sum = -3

Need larger sum.

Move:

left++

No triplet found.

i = 1
nums[i] = -1
left = -1
right = 2

Sum:

-1 + (-1) + 2 = 0

Triplet:

[-1, -1, 2]

Move pointers.

left++
right--

Now:

left = 0
right = 1

Sum:

-1 + 0 + 1 = 0

Triplet:

[-1, 0, 1]
i = 2

Duplicate -1

continue;

Skipped.

Result
[
 [-1,-1,2],
 [-1,0,1]
]
Why Sorting Helps

Without sorting:

Cannot decide which pointer to move.

After sorting:

Sum < 0 → move left
Sum > 0 → move right

This reduces the search from:

O(N²) pairs per i

to

O(N)

per i.

Complexity Analysis
Time Complexity

Sorting:

O(N log N)

Outer loop:

O(N)

Two pointers:

O(N)

Overall:

O(N²)
Space Complexity

Ignoring output list:

O(1)

Extra space used:

Only left, right, currentSum
Key Interview Observations
Clue 1

Question asks:

Find triplets

Think:

Fix one element + Two Sum
Clue 2

Need unique triplets.

Think:

Sort array
Skip duplicates
Clue 3

Need better than O(N³).

Think:

Sorting + Two Pointers
Template to Remember
1. Sort array

2. Fix one element

3. Use left = i+1
   right = n-1

4. Calculate sum

5. sum == target
      store answer
      skip duplicates

6. sum < target
      left++

7. sum > target
      right--

8. Skip duplicate i values
Pattern Recognition

When you see:

Triplets
Unique combinations
Sorted array
Need better than O(N³)

Think:

Sorting + Two Pointers (3Sum Pattern).