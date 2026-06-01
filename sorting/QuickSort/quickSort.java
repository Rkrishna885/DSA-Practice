class Solution {
    public int partition(int[] arr,int low, int high){
     int pivot=arr[low];
     int i=low;
     int j=high;
     while(i<j){
        while(arr[i]<=pivot&&i<=high-1){
            i++;
        }
        while(arr[j]>=pivot&&j>=low+1){
            j--;
        }
        if(i<j){
            int temp=arr[i];
            arr[i]=arr[j];
            arr[j]=temp;
        } 
       }
      int temp=arr[j];
        arr[j]=arr[low];
        arr[low]=temp;
        return j;
    }
    public void qS(int[] arr,int low,int high){
        if(low<high){
           int  partitionIndex=partition(arr,low,high);
            qS(arr,low,partitionIndex-1);
            qS(arr,partitionIndex+1,high);
        }
    }
    
    public int[] quickSort(int[] nums) {
     int low=0;
     int high=nums.length-1;
     qS(nums,low,high);

     return nums;
    }
}