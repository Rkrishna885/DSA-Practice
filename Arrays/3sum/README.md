3Sum Problem – Brute Force Approach (Detailed README)
Problem Statement

Given an integer array nums, find all unique triplets such that:

nums[i] + nums[j] + nums[k] = 0

where:

i != j
j != k
i != k

The result should not contain duplicate triplets.

Brute Force Solution

This approach checks every possible triplet in the array and verifies whether its sum equals zero.

Code
class Solution {
    public List<List<Integer>> threeSum(int[] nums) {

        List<List<Integer>> ans = new ArrayList<>();
        Set<List<Integer>> st = new HashSet<>();

        for(int i = 0; i < nums.length; i++) {

            for(int j = i + 1; j < nums.length; j++) {

                for(int k = j + 1; k < nums.length; k++) {

                    if(nums[i] + nums[j] + nums[k] == 0) {

                        List<Integer> temp =
                            Arrays.asList(nums[i], nums[j], nums[k]);

                        Collections.sort(temp);

                        if(!st.contains(temp)) {
                            st.add(temp);
                            ans.add(temp);
                        }
                    }
                }
            }
        }

        return ans;
    }
}
Intuition

The simplest way to solve the problem is:

Pick the first number.
Pick the second number.
Pick the third number.
Check whether their sum is zero.
If yes, store the triplet.
Avoid duplicates.

Since we don't know which three numbers can form a valid triplet, we try all possible combinations of three elements.

Why Three Loops?

A triplet contains exactly 3 numbers.

Therefore:

First loop selects first element.
Second loop selects second element.
Third loop selects third element.
i → First element
j → Second element
k → Third element
Understanding the Loop Structure
for(int i=0;i<nums.length;i++)

Selects the first element.

for(int j=i+1;j<nums.length;j++)

Selects the second element after i.

for(int k=j+1;k<nums.length;k++)

Selects the third element after j.

This guarantees:

i < j < k

which ensures:

No repeated indices
No duplicate combinations like:
(0,1,2)
(1,0,2)
(2,1,0)
Visual Representation

Suppose:

nums = [-1, 0, 1, 2]

The loops generate:

(-1,0,1)
(-1,0,2)
(-1,1,2)
(0,1,2)

Every possible triplet is checked exactly once.

Checking the Sum

Inside the innermost loop:

if(nums[i] + nums[j] + nums[k] == 0)

Example:

nums[i] = -1
nums[j] = 0
nums[k] = 1

Sum:

-1 + 0 + 1 = 0

Valid triplet found.

Creating the Triplet
List<Integer> temp =
Arrays.asList(nums[i], nums[j], nums[k]);

Example:

[-1, 0, 1]
Why Sort the Triplet?

Consider:

[-1, 0, 1]

Later we might encounter:

[1, -1, 0]

Although both contain the same numbers, Java considers them different lists.

To standardize the order:

Collections.sort(temp);

Both become:

[-1, 0, 1]

Now they can be compared correctly.

Why Use a HashSet?

The problem requires unique triplets.

Example:

Input:
[-1,0,1,2,-1,-4]

Triplet:

[-1,0,1]

might be discovered multiple times.

Without a Set:

[-1,0,1]
[-1,0,1]
[-1,0,1]

would appear in the answer.

Using:

Set<List<Integer>> st

ensures only one copy is stored.

Duplicate Removal Process
First occurrence
if(!st.contains(temp))

returns:

true

Add it:

st.add(temp);
ans.add(temp);
Second occurrence
st.contains(temp)

returns:

true

Triplet is skipped.

Dry Run
Input
[-1,0,1,2,-1,-4]
i = 0 (-1)
j = 1 (0)
k = 2 (1)
-1 + 0 + 1 = 0

Triplet:

[-1,0,1]

Add to answer.

k = 3 (2)
-1 + 0 + 2 = 1

Not valid.

k = 4 (-1)
-1 + 0 + (-1) = -2

Not valid.

j = 2 (1)
k = 4 (-1)
-1 + 1 + (-1) = -1

Not valid.

j = 3 (2)
k = 4 (-1)
-1 + 2 + (-1) = 0

Triplet:

[-1,2,-1]

Sort:

[-1,-1,2]

Add to answer.

After checking all combinations:

[
 [-1,0,1],
 [-1,-1,2]
]
Complexity Analysis
Time Complexity

Three nested loops:

for i → O(n)
for j → O(n)
for k → O(n)

Total:

O(n³)
Why O(n³)?

Because every possible triplet is checked.

Number of combinations:

nC3 ≈ n³
Space Complexity
HashSet

Stores unique triplets:

O(m)

where:

m = number of unique triplets
Answer List

Also stores triplets:

O(m)

Overall:

Space Complexity = O(m)

Worst case:

O(n²)
Example Walkthrough

Input:

[-1,0,1,2,-1,-4]

Triplets checked:

(-1,0,1)  ✓
(-1,0,2)  ✗
(-1,0,-1) ✗
(-1,1,2)  ✗
(-1,2,-1) ✓
...

Valid unique triplets:

[-1,0,1]
[-1,-1,2]

Output:

[
    [-1,-1,2],
    [-1,0,1]
]
Advantages

✅ Very easy to understand

✅ Straightforward implementation

✅ Good for learning and interviews when explaining the brute-force approach

✅ Guarantees finding all valid triplets

Disadvantages

❌ Extremely slow for large inputs

❌ Checks many unnecessary combinations

❌ Time Complexity = O(n³)

Key Takeaway

The brute-force solution works by:

Choose first element
      ↓
Choose second element
      ↓
Choose third element
      ↓
Check if sum = 0
      ↓
Sort triplet
      ↓
Use HashSet to avoid duplicates
      ↓
Store answer
Algorithm Summary
for every i
    for every j > i
        for every k > j

            if nums[i] + nums[j] + nums[k] == 0

                sort triplet

                if triplet not already present
                    add to answer

Time Complexity: O(n³)
Space Complexity: O(m) (for storing unique triplets)

This is the classic Brute Force Approach for the 3Sum problem and serves as the foundation before moving to the Better (HashSet) and Optimal (Sorting + Two Pointers) solutions.


BETTER APPROACH

3Sum Problem – Detailed Explanation
Problem Statement

Given an integer array nums, return all the unique triplets [nums[i], nums[j], nums[k]] such that:

i != j
j != k
i != k
nums[i] + nums[j] + nums[k] == 0

The solution should not contain duplicate triplets.

Approach Used in This Code

This solution uses:

Outer loop to fix the first element.
HashSet to efficiently find the third element.
Sorting each triplet to maintain a consistent order.
HashSet of Lists to automatically remove duplicate triplets.
Code
class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        Set<List<Integer>> st = new HashSet<>();

        for(int i = 0; i < nums.length; i++) {

            Set<Integer> hashset = new HashSet<>();

            for(int j = i + 1; j < nums.length; j++) {

                int third = -(nums[i] + nums[j]);

                if(hashset.contains(third)) {

                    List<Integer> temp =
                        Arrays.asList(nums[i], nums[j], third);

                    Collections.sort(temp);

                    st.add(temp);
                }

                hashset.add(nums[j]);
            }
        }

        return new ArrayList<>(st);
    }
}
Core Idea

We know:

a + b + c = 0

If we already have:

a = nums[i]
b = nums[j]

Then:

c = -(a + b)

So for every pair (a, b) we calculate the required third value and check if it has appeared before in the current iteration using a HashSet.

Step-by-Step Working

Consider:

nums = [-1, 0, 1, 2, -1, -4]
Iteration 1
Fix i = 0
nums[i] = -1

Create empty hashset:

{}
j = 1
nums[j] = 0

Required third:

third = -(-1 + 0)
      = 1

Check:

hashset contains 1 ?

No.

Add current element:

hashset = {0}
j = 2
nums[j] = 1

Required third:

third = -(-1 + 1)
      = 0

Check:

hashset contains 0 ?

Yes!

Triplet found:

[-1, 1, 0]

Sort it:

[-1, 0, 1]

Store in result set.

Add current element:

hashset = {0,1}
j = 3
nums[j] = 2

Required third:

third = -(-1 + 2)
      = -1

Check:

hashset contains -1 ?

No.

Add:

hashset = {0,1,2}
j = 4
nums[j] = -1

Required third:

third = -(-1 + -1)
      = 2

Check:

hashset contains 2 ?

Yes.

Triplet:

[-1,-1,2]

Sort:

[-1,-1,2]

Store in set.

Why Do We Sort the Triplet?

Suppose we find:

[-1,0,1]

Later we may find:

[1,-1,0]

Both represent the same triplet.

Without sorting:

[-1,0,1]
[1,-1,0]

HashSet considers them different.

After sorting:

[-1,0,1]
[-1,0,1]

Now duplicates are automatically removed.

Why Use Set<List<Integer>>?

The problem requires unique triplets only.

Example:

[-1,0,1]
[-1,0,1]
[-1,0,1]

Using:

Set<List<Integer>>

ensures only one copy is stored.

Visualization

For every fixed element:

nums[i]
    |
    V

Find two numbers whose sum = -nums[i]

Example:

nums[i] = -1

Need:

x + y = 1

We iterate through remaining elements and use HashSet to quickly check whether the needed value exists.

Dry Run

Input:

[-1,0,1,2,-1,-4]

Generated triplets:

[-1,0,1]
[-1,-1,2]

Output:

[
 [-1,-1,2],
 [-1,0,1]
]
Time Complexity Analysis

Outer loop:

O(n)

Inner loop:

O(n)

Total:

O(n²)

Sorting a triplet:

O(3 log 3)

which is constant.

Therefore:

Time Complexity = O(n²)
Space Complexity Analysis

HashSet inside loop:

O(n)

Result Set:

O(number of unique triplets)

Overall:

Space Complexity = O(n)
Why This Approach Works

For every fixed element:

We convert the problem into a Two Sum problem.
HashSet allows O(1) lookup.
The third element is computed mathematically:
third = -(nums[i] + nums[j]);
Sorting triplets guarantees a standard representation.
Set<List<Integer>> removes duplicate triplets automatically.

Thus, all unique triplets summing to zero are found efficiently in O(n²) time.

Key Learning

This solution is a combination of:

3Sum → Reduced to Two Sum
HashSet for O(1) lookup
Sorting for duplicate normalization
Set of Lists for duplicate elimination

Pattern to remember:

Fix one element
↓
Use HashSet to solve Two Sum on remaining elements
↓
Sort triplet
↓
Store in Set

This is the classic Better Approach (O(n²), O(n) space) for the 3Sum problem before the optimal sorting + two pointers solution.


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