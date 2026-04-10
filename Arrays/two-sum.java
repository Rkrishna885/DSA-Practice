// Problem: Two Sum
// Platform: LeetCode
// Approach: Brute Force (Nested Loops)
// Time Complexity: O(n^2)
// Space Complexity: O(1)

// Example:
// Input: nums = [2,7,11,15], target = 9
// Output: [0,1]

class Solution {
    public int[] twoSum(int[] nums, int target) {
        int[] arr = new int[2];

        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[i] + nums[j] == target) {
                    arr[0] = i;
                    arr[1] = j;
                    return arr;
                }
            }
        }
        return new int[]{-1, -1};
    }
}