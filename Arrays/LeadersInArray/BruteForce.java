class Solution {
    public List<Integer> leaders(int[] nums) {
      List<Integer> leaderArray=new ArrayList<>();
      for(int i=0;i<nums.length-1;i++){
        int count=0;
        for(int j=i+1;j<nums.length;j++){
           if(nums[i]>nums[j]){
            count++;
        } 
        }
        if(count==nums.length-1-i){
            leaderArray.add(nums[i]);
        }
      }
      leaderArray.add(nums[nums.length-1]);
    

      return leaderArray;
    }
}