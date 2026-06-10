class Solution {
    public int longestSubarray(int[] nums, int k) {
       int longest=0;
       for(int i=0;i<nums.length;i++){
        long sum=0;
        for(int j=i;j<nums.length;j++){
            sum+=nums[j];
            if(sum==k){
               longest= Math.max(longest,j-i+1);
            }
            
        }
       }
       return longest;
    }
}