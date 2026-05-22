Selection Sort – Quick Notes

Idea:
Find the smallest element from the unsorted part and place it at the correct position.

Steps:

Start from index i = 0
Assume current element is minimum:
min = i
Search remaining array:
j = i + 1 → n-1
If smaller element found:
min = j
Swap current element and minimum:
swap(nums[i], nums[min])
Repeat until array ends

Memory trick:

"Find Min → Swap → Move Forward"

or

Select smallest → Put in front → Repeat

Visual example:

[5,3,4,1,2]

Pass 1:
Find min = 1
[1,3,4,5,2]

Pass 2:
Find min = 2
[1,2,4,5,3]

Pass 3:
Find min = 3
[1,2,3,5,4]

Pass 4:
Find min = 4
[1,2,3,4,5]

Template to remember:

for(i=0;i<n;i++){
    min=i;

    for(j=i+1;j<n;j++){
        if(nums[j]<nums[min]){
            min=j;
        }
    }

    swap(nums[i], nums[min]);
}

Complexities:

Time: O(n²)
Space: O(1)
Stable: No
In-place: Yes

For interviews, remember one sentence:

Selection sort reduces the unsorted part by selecting the minimum element and placing it in its correct position.