4Sum - Brute Force Approach
Problem Statement

Given an integer array nums and an integer target, return all unique quadruplets [nums[a], nums[b], nums[c], nums[d]] such that:

a, b, c, and d are distinct indices.
nums[a] + nums[b] + nums[c] + nums[d] == target.

The solution should not contain duplicate quadruplets.

Approach: Brute Force

This solution checks every possible combination of four elements using four nested loops.

Algorithm
Use four loops to generate all possible quadruplets.
Calculate the sum of the four selected elements.
If the sum equals the target:
Store the quadruplet in a HashSet to avoid duplicates.
Convert the set into a list and return the result.
Code Logic
for(int i=0;i<nums.length;i++){
    for(int j=i+1;j<nums.length;j++){
        for(int k=j+1;k<nums.length;k++){
            for(int l=k+1;l<nums.length;l++){

                long currentSum=(long)nums[i]+nums[j]+nums[k]+nums[l];

                if(currentSum==target){
                    sum.add(Arrays.asList(nums[i],nums[j],nums[k],nums[l]));
                }
            }
        }
    }
}
Why use long?
long currentSum=(long)nums[i]+nums[j]+nums[k]+nums[l];

The sum of four integers may exceed the range of int.

Example:

1000000000 + 1000000000 + 1000000000 + 1000000000

This can cause integer overflow.

Using long prevents overflow and gives the correct result.

Time Complexity
Four Nested Loops

The algorithm checks every possible quadruplet:

O(N⁴)
Total Time Complexity
O(N⁴)
Space Complexity
HashSet

Stores all unique quadruplets.

O(K)

Where K is the number of unique quadruplets.

Example
Input
nums = [1, 0, -1, 0, -2, 2]
target = 0
Output
[
 [-2, -1, 1, 2],
 [-2, 0, 0, 2],
 [-1, 0, 0, 1]
]
Dry Run

For:

nums = [1, 0, -1, 0]
target = 0

Possible quadruplet:

1 + 0 + (-1) + 0 = 0

Store:

[1, 0, -1, 0]

Return:

[[1, 0, -1, 0]]
Notes
This is the simplest approach to understand.
Uses four nested loops to generate all combinations.
HashSet helps remove duplicate quadruplets.
Not efficient for large inputs because of O(N⁴) time complexity.
Better solutions exist using sorting and the two-pointer technique with O(N³) complexity.
Key Learning

✅ Generating all possible quadruplets using nested loops.

✅ Using HashSet to avoid duplicates.

✅ Using long to prevent integer overflow.

✅ Understanding why brute force solutions are often too slow for large inputs.


4Sum - Better Approach Using HashSet
Problem Statement

Given an integer array nums and an integer target, return all unique quadruplets:

[a, b, c, d]

such that:

a + b + c + d = target

The solution set must not contain duplicate quadruplets.

Intuition

In the brute force approach, we used four nested loops to generate all possible quadruplets.

Time Complexity:

O(N⁴)

This becomes very slow for large arrays.

To optimize, we can reduce one loop by using a HashSet.

The idea is similar to the Better Approach used in the 3Sum problem.

Instead of searching for the fourth element using another loop, we store previously visited elements in a HashSet and check whether the required fourth element already exists.

This reduces the complexity from:

O(N⁴) → O(N³)
Approach

For every pair (i, j):

Create a new HashSet.
Traverse the remaining elements using k.
Calculate the required fourth element.
fourth = target - (nums[i] + nums[j] + nums[k])
Check if fourth already exists in the HashSet.
If it exists:
We found a valid quadruplet.
Store it in sorted order.
Add the current element nums[k] into the HashSet.
Use a Set of Lists to remove duplicate quadruplets.
Dry Run
Input
nums = [1, 0, -1, 0, -2, 2]
target = 0
i = 0 (1)
j = 1 (0)

Create:

hashset = {}
k = 2 (-1)

Required fourth:

0 - (1 + 0 + (-1))
= 0

Check:

hashset.contains(0)

False

Add:

hashset = {-1}
k = 3 (0)

Required fourth:

0 - (1 + 0 + 0)
= -1

Check:

hashset.contains(-1)

True

Quadruplet:

[1, 0, 0, -1]

Sort:

[-1, 0, 0, 1]

Add to answer set.

Continue similarly for all (i,j) pairs.

Final Answer:

[
[-2,-1,1,2],
[-2,0,0,2],
[-1,0,0,1]
]
Code Explanation
Step 1: Create Result Set
Set<List<Integer>> st = new HashSet<>();

Stores unique quadruplets.

Why?

Different index combinations can generate the same quadruplet.

Example:

[-1,0,0,1]

might appear multiple times.

The Set automatically removes duplicates.

Step 2: Fix First Element
for(int i=0;i<n;i++)

Choose the first number.

Step 3: Fix Second Element
for(int j=i+1;j<n;j++)

Choose the second number.

Step 4: Create HashSet
Set<Integer> hashset = new HashSet<>();

Stores numbers already seen while traversing k.

Step 5: Traverse Third Element
for(int k=j+1;k<n;k++)

Choose the third number.

Step 6: Calculate Fourth Element
long fourth =
target - ((long)nums[i] + nums[j] + nums[k]);

We need:

nums[i] + nums[j] + nums[k] + fourth
= target

So:

fourth =
target - (nums[i] + nums[j] + nums[k])
Why Use Long?
(long)nums[i]

Prevents integer overflow.

Example:

1000000000 +
1000000000 +
1000000000

This exceeds Integer range.

Using long ensures correct calculations.

Step 7: Check HashSet
if(hashset.contains((int)fourth))

If the required fourth number already exists among previously visited elements, we found a valid quadruplet.

Step 8: Store Quadruplet
List<Integer> temp =
Arrays.asList(nums[i],
              nums[j],
              nums[k],
              (int)fourth);

Create the quadruplet.

Step 9: Sort Quadruplet
Collections.sort(temp);

Why?

Without sorting:

[1,0,0,-1]

and

[-1,0,0,1]

would be considered different.

After sorting:

[-1,0,0,1]

Both become identical.

This helps the Set remove duplicates.

Step 10: Add to Set
st.add(temp);

Store the unique quadruplet.

Step 11: Insert Current Element
hashset.add(nums[k]);

Store current element for future lookups.

Complexity Analysis
Time Complexity
Outer Loop
O(N)
Second Loop
O(N)
Third Loop
O(N)
HashSet Operations
O(1)

Average case.

Total
O(N × N × N)
O(N³)
Space Complexity
HashSet
O(N)

Used for storing visited elements.

Result Set
O(K)

Where K is the number of unique quadruplets.

Total Space Complexity
O(N + K)
Comparison with Other Approaches
Approach	Time Complexity	Space Complexity
Brute Force	O(N⁴)	O(K)
Better (HashSet)	O(N³)	O(N + K)
Optimal (Sorting + Two Pointers)	O(N³)	O(K)
Advantages

✅ Faster than brute force.

✅ Reduces one nested loop.

✅ Easy to understand.

✅ HashSet lookup takes O(1) average time.

✅ Handles duplicate quadruplets using a Set.

Disadvantages

❌ Extra space required for HashSet.

❌ Still not the most optimal solution.

❌ Sorting every quadruplet adds additional overhead.

❌ Optimal two-pointer solution is generally preferred in interviews.

Key Learning Points
Use HashSet to replace an inner loop search.
Convert a 4-loop solution into a 3-loop solution.
Use complement logic:
fourth = target - currentSum
Use long to avoid integer overflow.
Sort quadruplets before storing them to remove duplicates.
HashSet provides O(1) average lookup time.
This is a common interview optimization technique between brute force and optimal approaches.
Final Complexity
Time Complexity  : O(N³)

Space Complexity : O(N + K)

where K is the number of unique quadruplets stored in the answer.


4Sum - Optimal Approach (Sorting + Two Pointers)
Problem Statement

Given an integer array nums and an integer target, return all unique quadruplets:

[a, b, c, d]

such that:

a + b + c + d = target

The solution set must not contain duplicate quadruplets.

Intuition

The Brute Force approach uses 4 nested loops:

O(N⁴)

The Better approach reduces one loop using a HashSet:

O(N³)

We can achieve the same O(N³) complexity without using extra HashSet space by combining:

Sorting
Two Pointer Technique
Duplicate Skipping

This is the most commonly accepted interview solution for the 4Sum problem.

Approach
Step 1: Sort the Array
Arrays.sort(nums);

Sorting helps us:

Use the two-pointer technique.
Skip duplicate elements efficiently.
Generate quadruplets in sorted order.
Step 2: Fix First Element (i)
for(int i = 0; i < nums.length; i++)

Choose the first number of the quadruplet.

Step 3: Skip Duplicate First Elements
if(i > 0 && nums[i] == nums[i - 1])
    continue;

Example:

[-2,-2,-1,0,1,2]

If we already processed the first -2, processing the second -2 again would generate duplicate quadruplets.

Step 4: Fix Second Element (j)
for(int j = i + 1; j < nums.length; j++)

Choose the second number.

Step 5: Skip Duplicate Second Elements

The duplicate check should be:

if(j > i + 1 && nums[j] == nums[j - 1])
    continue;
Why?

Your code currently has:

if(j > 0 && nums[j] == nums[j - 1])
    continue;

This may skip valid combinations.

Correct version:

if(j > i + 1 && nums[j] == nums[j - 1])
    continue;

This skips duplicates only within the current i.

Step 6: Apply Two Pointers
int left = j + 1;
int right = nums.length - 1;

Now search for two numbers that complete the target.

Step 7: Calculate Current Sum
long currentSum =
(long) nums[i]
+ nums[j]
+ nums[left]
+ nums[right];

We use long to prevent integer overflow.

Step 8: Compare with Target
Case 1: Found a Quadruplet
currentSum == target

Store it:

sum.add(Arrays.asList(
    nums[i],
    nums[j],
    nums[left],
    nums[right]
));

Move both pointers:

left++;
right--;
Skip Duplicate Third Elements
while(left < right &&
      nums[left] == nums[left - 1])
{
    left++;
}
Skip Duplicate Fourth Elements
while(left < right &&
      nums[right] == nums[right + 1])
{
    right--;
}
Case 2: Sum Too Small
currentSum < target

Need a larger sum.

Move:

left++;
Case 3: Sum Too Large
currentSum > target

Need a smaller sum.

Move:

right--;
Dry Run
Input
nums = [1,0,-1,0,-2,2]
target = 0
After Sorting
[-2,-1,0,0,1,2]
i = -2
j = -1
left = 0
right = 2

Current Sum:

-2 + (-1) + 0 + 2
= -1

Too small.

Move:

left++

Now:

-2 + (-1) + 1 + 2
= 0

Found:

[-2,-1,1,2]

Continue searching...

Final Answer:

[
 [-2,-1,1,2],
 [-2,0,0,2],
 [-1,0,0,1]
]
Why Sorting is Important

Without sorting:

[1,0,-1,0]

and

[-1,0,0,1]

look different.

After sorting:

[-1,0,0,1]

Duplicate handling becomes easy.

Sorting is also required for the two-pointer technique.

Why Use Long?

Consider:

1000000000
+1000000000
+1000000000
+1000000000

Result:

4000000000

This exceeds the range of int.

Therefore:

long currentSum

is necessary.

Complexity Analysis
Sorting
O(N log N)
First Loop (i)
O(N)
Second Loop (j)
O(N)
Two Pointers

For every (i,j) pair:

O(N)
Total Time Complexity
O(N × N × N)
O(N³)
Space Complexity

Ignoring output storage:

O(1)

No extra HashSet or Map is used.

Including answer storage:

O(K)

Where:

K = number of quadruplets returned.
Comparison of All Approaches
Approach	Time Complexity	Space Complexity
Brute Force	O(N⁴)	O(K)
Better (HashSet)	O(N³)	O(N + K)
Optimal (Two Pointers)	O(N³)	O(K)
Advantages

✅ Most accepted interview solution.

✅ No extra HashSet needed.

✅ Efficient duplicate removal.

✅ Uses sorted array and two pointers.

✅ Constant auxiliary space.

Disadvantages

❌ Requires sorting.

❌ More difficult to understand than brute force.

❌ Still O(N³), which can be expensive for very large inputs.

Important Correction in Your Code

Current code:

if(j > 0 & nums[j] == nums[j - 1])
    continue;

Should be:

if(j > i + 1 && nums[j] == nums[j - 1])
    continue;

Reasons:

Use && instead of &.
Duplicate check must be relative to the current i.

This ensures valid quadruplets are not skipped.

Key Learning Points
Sort the array first.
Fix two elements (i and j).
Use two pointers (left, right) to find the remaining two numbers.
Skip duplicates at every level.
Use long to avoid overflow.
Two-pointer technique is powerful for sorted arrays.
This is the standard optimal solution for the 4Sum problem.
Final Complexity
Time Complexity  : O(N³)

Space Complexity : O(1)  // excluding answer list

or

Space Complexity : O(K)

if the output list is included.