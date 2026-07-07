
class Solution {
    public int firstOccurance(int[] arr,int target){
        int first=-1;
        int low=0,high=arr.length-1;
        while(low<=high){
            int mid=(low+high)/2;
            if(arr[mid]==target){
               first=mid;
               high=mid-1;
            }
            else if(arr[mid]<target){
                low=mid+1;
            }
            else{
                high=mid-1;
            }
        }
        return first;
    }
    public int lastOccurance(int[] arr,int target){
        int last=-1;
        int low=0,high=arr.length-1;
        while(low<=high){
            int mid=(low+high)/2;
            if(arr[mid]==target){
               last=mid;
               low=mid+1;
            }
            else if(arr[mid]<target){
                low=mid+1;
            }
            else{
                high=mid-1;
            }
        }
        return last;
    }
    
    public int[] searchRange(int[] nums, int target) {
    int first=-1,last=-1;
    first=firstOccurance(nums,target);
    if(first==-1) return new int[]{-1,-1};
    return new int[]{first,lastOccurance(nums,target)};
    }
}