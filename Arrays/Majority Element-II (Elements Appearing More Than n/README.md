Majority Element-II (Elements Appearing More Than n/3 Times)
Problem Statement

Given an integer array nums of size n, find all elements that appear more than n/3 times.

Example
Input: [1, 2, 1, 1, 3, 2]

Output: [1]

Because:

n = 6
n/3 = 2

1 appears 3 times (> 2)
Important Observation

For an element to be a valid answer:

frequency > n/3

Also, there can be at most 2 such elements.

Why?

Suppose there are 3 elements appearing more than n/3 times.

Element A > n/3
Element B > n/3
Element C > n/3

Then total elements would be:

> n/3 + n/3 + n/3
> n

which is impossible.

So the answer can contain:

0, 1, or 2 elements only
Approach 1: Brute Force
Idea

For every element:

Count its frequency by traversing the entire array.
If frequency is greater than n/3, add it to the answer.
Avoid duplicates using contains().
Code
class Solution {
    public List<Integer> majorityElementTwo(int[] nums) {
        int maxcount = 0;
        List<Integer> maxElements = new ArrayList<>();

        for(int i = 0; i < nums.length; i++) {

            maxcount = 0;

            for(int j = 0; j < nums.length; j++) {

                if(nums[i] == nums[j]) {
                    maxcount++;
                }
            }

            if(maxcount >= 3) {

                if(!maxElements.contains(nums[i])) {
                    maxElements.add(nums[i]);
                }
            }

            if(maxElements.size() == 2) {
                break;
            }
        }

        return maxElements;
    }
}
Dry Run
nums = [1,2,1,1,3,2]
i = 0
nums[0] = 1

Count frequency of 1:

1 → 3 times

Add:

answer = [1]
i = 1
nums[1] = 2

Count frequency:

2 → 2 times

Not greater than n/3.

Remaining Elements

1 already exists in answer.

Final answer:

[1]
Time Complexity

Outer loop:

O(n)

Inner loop:

O(n)

Total:

O(n²)
Space Complexity
O(1)

(ignoring answer list)

Issue in Your Brute Force Code

You used:

if(maxcount >= 3)

This only works for some test cases.

The condition should be:

if(maxcount > nums.length / 3)

because the threshold changes according to array size.

Correct Version
if(maxcount > nums.length / 3)
Approach 2: Better Solution (HashMap)
Idea

Store frequency of each element in a HashMap.

Example
nums = [1,2,1,1,3,2,2]

Frequency Map:

1 → 3
2 → 3
3 → 1

Threshold:

n/3 = 7/3 = 2

Elements with frequency > 2:

1
2

Answer:

[1,2]
Code
class Solution {
    public List<Integer> majorityElementTwo(int[] nums) {

        HashMap<Integer,Integer> frequencyCounter =
                new HashMap<>();

        List<Integer> maxElements =
                new ArrayList<>();

        int threshold = nums.length / 3;

        for(int i = 0; i < nums.length; i++) {

            if(frequencyCounter.containsKey(nums[i])) {

                frequencyCounter.put(
                        nums[i],
                        frequencyCounter.get(nums[i]) + 1
                );
            }
            else {

                frequencyCounter.put(nums[i], 1);
            }

            if(frequencyCounter.get(nums[i]) > threshold) {

                if(!maxElements.contains(nums[i])) {
                    maxElements.add(nums[i]);
                }
            }

            if(maxElements.size() == 2) {
                break;
            }
        }

        return maxElements;
    }
}
Dry Run
nums = [1,2,1,1,3,2,2]

Threshold:

2
Step 1
1

Map:

{1=1}
Step 2
2

Map:

{1=1, 2=1}
Step 3
1

Map:

{1=2, 2=1}
Step 4
1

Map:

{1=3, 2=1}

Since:

3 > 2

Add:

answer = [1]
Step 5
3

Map:

{1=3, 2=1, 3=1}
Step 6
2

Map:

{1=3, 2=2, 3=1}
Step 7
2

Map:

{1=3, 2=3, 3=1}

Since:

3 > 2

Add:

answer = [1,2]

Final Answer:

[1,2]
Time Complexity

Building HashMap:

O(n)

HashMap operations:

O(1)

Average case.

Total:

O(n)
Space Complexity

HashMap stores frequencies:

O(n)
Comparison
Approach	Time	Space
Brute Force	O(n²)	O(1)
HashMap (Better)	O(n)	O(n)
Interview Notes
Remember

✔ Majority Element-I

frequency > n/2

At most:

1 element

✔ Majority Element-II

frequency > n/3

At most:

2 elements

✔ Brute Force

Check frequency of every element.

Time:

O(n²)

✔ Better

Use HashMap for frequency counting.

Time:

O(n)

Space:

O(n)

✔ Optimal (used in interviews)

Boyer-Moore Voting Algorithm

Time:

O(n)

Space:

O(1)

Learn this next, because it is the most frequently asked interview solution for Majority Element-II.