class Solution {
    public int bs(int[] arr,int low,int high,int target){
        if(low>high){
            return -1;
        }
        int mid=(low+high)/2;
        if(arr[mid]==target){
            return mid;
        }
        else if(arr[mid]>target){
           return bs(arr,low,mid-1,target);
        }
        return bs(arr,mid+1,high,target);
    }
    public int search(int[] nums, int target) {
       return bs(nums,0,nums.length-1,target);
    }
}