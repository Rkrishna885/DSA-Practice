class Solution {
    public int findPlaces(int[] nums,int mid){
     int count=1;
     int fixed=nums[0];
     for(int i=1;i<nums.length;i++){
        if(nums[i]-fixed>=mid){
            fixed=nums[i];
            count++;
        }
     }
     return count;
    }
    public int aggressiveCows(int[] nums, int k) {
     Arrays.sort(nums);
     int ans=0;
     int low=1,high=nums[nums.length-1]-nums[0];
     while(low<=high){
        int mid=(low+high)/2;
        int maxPossible=findPlaces(nums,mid);
        if(maxPossible<k){
            high=mid-1;
        }
        else{
            low=mid+1;
            ans=mid;
        }
     }

     return ans;


    }
}
