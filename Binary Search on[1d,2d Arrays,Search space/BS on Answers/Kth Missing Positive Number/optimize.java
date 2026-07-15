class Solution {
    public int calculateNum(int[] arr,int k){
        int count =0;
        int j=0;
        for(int i=1;i<=arr[k];i++){
           if(i==arr[j]){
            j++;
           }
           else{
            count++;
           }
          
        }
        return count;
    }
    public int findKthPositive(int[] arr, int k) {
    int low=0,high=arr.length-1;
    
    while(low<=high){
        int mid=(low+high)/2;
        int missing_count=calculateNum(arr,mid);
        if(missing_count<k){
            low=mid+1;
        }
        else{
            high=mid-1;
        }
    }
    return low+k;
    }
}