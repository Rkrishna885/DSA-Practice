class Solution {
    public int requiredNum(int[] nums,int mid){
        int ans=0;
        for(int num:nums){
            if(num%mid==0){
                ans+=num/mid;
            }
            else{
                ans+=(num/mid)+1;
            }
        }
        
        return ans;
    }
    public int smallestDivisor(int[] nums, int threshold) {
        int low=1,high=0;
        int ans=-1;
        for(int num:nums){
            if(num>high){
                high=num;
            }
        }
        while(low<=high){
            int mid=(low+high)/2;
            int smallest=requiredNum(nums,mid);
            if(smallest<=threshold){
                high=mid-1;
                ans=mid;
            }
            else{
                low=mid+1;
            }
        }
        return ans;
    }
}