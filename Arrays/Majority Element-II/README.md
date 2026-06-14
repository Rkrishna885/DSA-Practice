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


# Approach 3: Optimal Solution (Boyer-Moore Voting Algorithm)

## Intuition

In the previous approaches:

* **Brute Force** → Count frequency for every element.
* **HashMap** → Store frequencies in extra space.

Can we do better?

Yes.

Since an element must appear **more than n/3 times**, there can be **at most 2 majority elements**.

This observation allows us to keep track of only:

* Candidate 1
* Candidate 2
* Their counts

instead of storing frequencies for all elements.

---

# Key Observation

For Majority Element-II:

```text
frequency > n/3
```

There can never be more than 2 valid answers.

### Proof

Suppose there are 3 elements:

```text
A > n/3
B > n/3
C > n/3
```

Then:

```text
A + B + C > n
```

which is impossible.

Therefore:

```text
Maximum majority elements = 2
```

---

# Boyer-Moore Voting Idea

Think of it as a cancellation process.

Whenever we encounter:

```text
candidate1
candidate2
different element
```

we cancel one vote from both candidates.

Only elements with very high frequency can survive this cancellation process.

---

# Step 1: Find Potential Candidates

Maintain:

```java
element1
element2

count1
count2
```

### Rules

#### Case 1

If count1 becomes 0:

```java
element1 = currentElement
count1 = 1
```

---

#### Case 2

If count2 becomes 0:

```java
element2 = currentElement
count2 = 1
```

---

#### Case 3

Current element equals candidate1:

```java
count1++
```

---

#### Case 4

Current element equals candidate2:

```java
count2++
```

---

#### Case 5

Current element matches neither candidate:

```java
count1--
count2--
```

This represents vote cancellation.

---

# Step 2: Verify Candidates

The first pass only finds **possible candidates**.

They may not actually occur more than n/3 times.

So we perform another traversal and count their actual frequencies.

---

# Code

```java
class Solution {
    public List<Integer> majorityElement(int[] nums) {

        int count1 = 0, count2 = 0;

        int element1 = Integer.MIN_VALUE;
        int element2 = Integer.MIN_VALUE;

        List<Integer> majorityElements =
                new ArrayList<>();

        for(int i = 0; i < nums.length; i++) {

            if(count1 == 0 && nums[i] != element2) {

                count1 = 1;
                element1 = nums[i];
            }

            else if(count2 == 0 && nums[i] != element1) {

                count2 = 1;
                element2 = nums[i];
            }

            else if(element1 == nums[i]) {

                count1++;
            }

            else if(element2 == nums[i]) {

                count2++;
            }

            else {

                count1--;
                count2--;
            }
        }

        count1 = 0;
        count2 = 0;

        for(int i = 0; i < nums.length; i++) {

            if(nums[i] == element1) {
                count1++;
            }

            else if(nums[i] == element2) {
                count2++;
            }
        }

        int mini = nums.length / 3 + 1;

        if(count1 >= mini) {
            majorityElements.add(element1);
        }

        if(count2 >= mini) {
            majorityElements.add(element2);
        }

        Collections.sort(majorityElements);

        return majorityElements;
    }
}
```

---

# Dry Run

### Input

```java
nums = [1,2,1,1,3,2,2]
```

### Initial State

```text
element1 = -
element2 = -

count1 = 0
count2 = 0
```

---

### Read 1

```text
count1 = 0
```

Assign:

```text
element1 = 1
count1 = 1
```

---

### Read 2

```text
count2 = 0
```

Assign:

```text
element2 = 2
count2 = 1
```

---

### Read 1

Matches element1

```text
count1 = 2
```

---

### Read 1

Matches element1

```text
count1 = 3
```

---

### Read 3

Matches neither candidate

```text
count1--
count2--
```

Result:

```text
count1 = 2
count2 = 0
```

---

### Read 2

Matches element2

```text
count2 = 1
```

---

### Read 2

Matches element2

```text
count2 = 2
```

---

### End of First Pass

Potential candidates:

```text
element1 = 1
element2 = 2
```

---

# Verification Pass

Count actual frequencies.

```text
1 → 3 times
2 → 3 times
```

Threshold:

```text
n = 7

n/3 = 2

Need frequency > 2
```

Both satisfy.

Result:

```java
[1,2]
```

---

# Why Verification Pass is Necessary

Consider:

```java
nums = [1,2,3,4]
```

After the first pass you may get:

```text
candidate1 = 4
candidate2 = 3
```

But:

```text
4 occurs once
3 occurs once
```

Neither is a majority element.

Without verification, the answer would be wrong.

Therefore:

```text
Second pass is mandatory.
```

---

# Complexity Analysis

### Time Complexity

First traversal:

```text
O(n)
```

Second traversal:

```text
O(n)
```

Total:

```text
O(2n)
```

Simplified:

```text
O(n)
```

---

### Space Complexity

Only storing:

```text
count1
count2
element1
element2
```

Extra space:

```text
O(1)
```

---

# Comparison of All Approaches

| Approach              | Time Complexity | Space Complexity |
| --------------------- | --------------- | ---------------- |
| Brute Force           | O(n²)           | O(1)             |
| HashMap (Better)      | O(n)            | O(n)             |
| Boyer-Moore (Optimal) | O(n)            | O(1)             |

---

# Interview Notes

### Majority Element-I

Condition:

```text
frequency > n/2
```

Possible majority elements:

```text
1
```

Use:

```text
Boyer-Moore with one candidate
```

---

### Majority Element-II

Condition:

```text
frequency > n/3
```

Possible majority elements:

```text
2
```

Use:

```text
Boyer-Moore with two candidates
```

---

### Most Important Formula

For Majority Element-II:

```text
Maximum majority elements = 2
```

because:

```text
3 × (n/3) > n
```

which is impossible.

This observation is the foundation of the optimal Boyer-Moore Voting Algorithm solution.
