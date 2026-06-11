//this is optimal one who's nums contains only positives and Zeros
class Solution {
    public int subarraySum(int[] nums, int k) {
        int left=0,right=0;
        long sum=nums[0];
        int maxLength=0;
        int n=nums.length;
        while(right<n){
            while(left<=right&&sum>k){
               sum-=nums[left];
               left++;
            }
            if(sum==k){
                maxLength=Math.max(maxLength,right-left+1);
            }
            right++;
            if(right<n){
                sum+=nums[right];
            }
        }
        return maxLength;
    }
}