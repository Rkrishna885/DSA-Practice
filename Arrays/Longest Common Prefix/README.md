Longest Common Prefix (LeetCode 14)
Problem

Given an array of strings, find the longest prefix that is common to all strings.

Example
Input:  ["flower","flow","flight"]
Output: "fl"
Key Observation

A common prefix must appear at the beginning of every string.

For example:

flower
flow
flight

Compare from the start:

f ✓
l ✓
o ✗ (flight has 'i')

So the answer is:

"fl"
Intuition

Assume the first string is the answer.

String prefix = strs[0];

Now check whether every other string starts with this prefix.

If a string does not start with it:

prefix = "flower"
string = "flow"

Shrink the prefix:

flower ✗
flowe  ✗
flow   ✓

Now:

prefix = "flow";

Repeat this process for all strings.

Mental Model

Imagine the prefix as a rope.

flower

Every time a string disagrees with the rope, cut one character from the end.

flower
flowe
flow
flo
fl

Stop cutting when the current string starts with the prefix.

After checking all strings, whatever remains is the answer.

Algorithm
Handle empty array.
Assume first string is the prefix.
For every remaining string:
While the string does not start with the prefix:
Remove the last character from prefix.
If prefix becomes empty, return "".
Return prefix.
Dry Run
Input
["flower","flow","flight"]
Step 1
prefix = "flower"
Step 2

Compare with:

"flow"

Shrink:

flower ✗
flowe  ✗
flow   ✓

Now:

prefix = "flow"
Step 3

Compare with:

"flight"

Shrink:

flow ✗
flo  ✗
fl   ✓

Now:

prefix = "fl"
Final Answer
"fl"
Why startsWith()?

Wrong:

while(prefix != s)

This checks:

Are both strings exactly the same object?

But the problem asks:

Does the current string begin with prefix?

Correct:

while(!s.startsWith(prefix))

Example:

prefix = "fl";
s = "flight";
s.startsWith(prefix) // true

Even though:

prefix.equals(s) // false
Complexity
Time Complexity

Worst case:

O(N × M)

Where:

N = number of strings
M = length of the longest prefix
Space Complexity
O(1)

No extra data structures are used.

Interview Memory Trick

"Start big, shrink until everyone agrees."

Take first string
↓
Assume it is the answer
↓
For every string:
    Does it start with prefix?
        Yes → continue
        No  → shorten prefix
↓
Return remaining prefix

This single sentence is usually enough to reconstruct the entire solution during interviews.