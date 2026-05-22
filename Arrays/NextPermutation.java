// Problem: Next Permutation
// Platform: LeetCode
// Approach: Find breakpoint, swap, reverse

class Solution {
    public void nextPermutation(int[] nums) { 
        
        int i = nums.length - 2;

        while(i >= 0 && nums[i] >= nums[i+1]){
            i--;
        }

        if(i >= 0){
            int j = nums.length - 1;

            while(nums[j] <= nums[i]){
                j--;
            }

            int temp = nums[j];
            nums[j] = nums[i];
            nums[i] = temp;
        }

        int start = i + 1;
        int end = nums.length - 1;

        while(start < end){
            int temp = nums[start];
            nums[start] = nums[end];
            nums[end] = temp;
            start++;
            end--;
        }
    }
}