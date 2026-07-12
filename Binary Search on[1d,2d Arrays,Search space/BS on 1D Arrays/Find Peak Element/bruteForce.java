class Solution {
    public int findPeakElement(int[] arr) {
     for(int i=0;i<arr.length-1;i++){
        if((i==0||arr[i-1]<arr[i])&& (i==arr.length-1||arr[i+1]<arr[i])){
            return i;
        }
     }  
     return -1;
    }
}