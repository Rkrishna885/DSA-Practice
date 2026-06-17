//optimal approch
class Solution {
    public List<List<Integer>> fourSum(int[] nums, int target) {
       List<List<Integer>> sum=new ArrayList<>();
        Arrays.sort(nums);
       for(int i=0;i<nums.length;i++){
        if(i>0&&nums[i]==nums[i-1])continue;
        for(int j=i+1;j<nums.length;j++){
            if(j>0&nums[j]==nums[j-1])continue;
          int left=j+1;
          int right=nums.length-1;
          while(left<right){
           long currentSum= (long)nums[i]+nums[j]+nums[left]+nums[right];
           if(currentSum==target){
            sum.add(Arrays.asList(nums[i],nums[j],nums[left],nums[right]));
            left++;
            right--;
            while(left<right&&nums[left]==nums[left-1])left++;
            while(left<right&&nums[right]==nums[right+1])right--;
           }
           else if(currentSum<target){
            left++;
           }
           else{
            right--;
           }
          }
        }
       }
      
       return sum;
    }
}