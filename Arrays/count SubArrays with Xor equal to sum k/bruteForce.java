//better approch
class Solution {
    public int subarraysWithXorK(int[] nums, int k) {
      int count=0;
      
      for(int i=0;i<nums.length;i++){
        
        for(int j=i;j<nums.length;j++){
            int xOR=0;
            for(int l=i;l<=j;l++){
                xOR=xOR^nums[l];
            }
            
           if(xOR==k)count++;
        }
         
      }
      return count;
    }
}