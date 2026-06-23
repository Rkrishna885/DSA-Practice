//better approch
class Solution {
    public int subarraysWithXorK(int[] nums, int k) {
      int count=0;
      
      for(int i=0;i<nums.length;i++){
        int xOR=0;
        for(int j=i;j<nums.length;j++){
            xOR=xOR^nums[j];
           if(xOR==k)count++;
        }
         
      }
      return count;
    }
}