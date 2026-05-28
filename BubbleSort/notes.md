Bubble Sort – Quick Notes

Idea:
Push the largest element to the end by comparing adjacent elements.

Steps:

Start from i = 0
Compare neighboring elements:
nums[j] and nums[j+1]
If left is greater than right:
swap(nums[j], nums[j+1])
Continue till the end of the unsorted part
After one pass, the largest element reaches the end
Repeat for remaining elements

Memory trick:

"Compare → Swap → Bubble to End"

or

"Big element bubbles up to the last position"

Visual example:

[7,4,1,5,3]

Pass 1:
7↔4
7↔1
7↔5
7↔3

[4,1,5,3,7]

Pass 2:
[1,4,3,5,7]

Pass 3:
[1,3,4,5,7]

Template to remember:

for(i=0;i<n;i++){

    for(j=0;j<n-i-1;j++){

        if(nums[j]>nums[j+1]){

            swap(nums[j],nums[j+1]);

        }
    }
}

Complexities:

Time: O(n²)
Space: O(1)
Stable: Yes
In-place: Yes

One-line interview answer:

Bubble sort repeatedly compares adjacent elements and swaps them so the largest element moves to its correct position after each pass.