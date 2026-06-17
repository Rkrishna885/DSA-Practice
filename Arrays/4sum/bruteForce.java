//bruteForce approch
class Solution {
    public List<List<Integer>> fourSum(int[] nums, int target) {
      Set<List<Integer>> sum=new HashSet<>();
      for(int i=0;i<nums.length;i++){
        for(int j=i+1;j<nums.length;j++){
            for(int k=j+1;k<nums.length;k++){
                for(int l=k+1;l<nums.length;l++){
                   long currentSum=(long)nums[i]+nums[j]+nums[k]+nums[l];
                    if(currentSum==target){
                        sum.add(Arrays.asList(nums[i],nums[j],nums[k],nums[l]));
                    }
                }
            }
        }
      }  
      List<List<Integer>> ans=new ArrayList<>(sum);
      return ans;
    }

}