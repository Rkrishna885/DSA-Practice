class Solution {
    public void insertion(int[] arr,int n, int i){
       if(n==i)return;
       int j=i;
       while(j>0&&arr[j-1]>arr[j]){
        int temp=arr[j];
        arr[j]=arr[j-1];
        arr[j-1]=temp;
        j--;
       }
       insertion(arr,n,i+1);
    }
    public int[] insertionSort(int[] nums) {
       insertion(nums,nums.length,1);
       return nums;
    }
}