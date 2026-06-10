// better Solution with hash map
class Solution {
    public int longestSubarray(int[] nums, int k) {
        HashMap<Long,Integer> map=new  HashMap<>();
        long sum=0;
        int maxLength=0;
        for(int i=0;i<nums.length;i++){
            sum+=nums[i];
            if(sum==k){
                maxLength=i+1;
            }
            if(map.containsKey(sum-k)){
                maxLength=Math.max(maxLength,i-map.get(sum-k));
            }
            if(!map.containsKey(sum)){
                map.put(sum,i);
            }
        }
        return maxLength;
    }
}