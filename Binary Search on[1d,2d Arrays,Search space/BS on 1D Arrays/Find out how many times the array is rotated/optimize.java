class Solution {
    public int findKRotation(ArrayList<Integer> nums) {
      int low=0,high=nums.size()-1;
       int ans=Integer.MAX_VALUE;
       int ansI=0;
       while(low<=high){
        int mid=(low+high)/2;
        if(nums.get(low)<=nums.get(high)){
            
            if(nums.get(low)<ans){
                ans=nums.get(low);
                ansI=low;
            }
            break;
        }
        if(nums.get(low)<=nums.get(mid)){
               
                if(nums.get(low)<ans){
                    ans=nums.get(low);
                    ansI=low;
                }
                low=mid+1;
            
        }
        else{
            if(nums.get(mid)<ans){
                ans=nums.get(mid);
                ansI=mid;
            }
            high=mid-1;
        }
         
     }
     return ansI;
    }
}