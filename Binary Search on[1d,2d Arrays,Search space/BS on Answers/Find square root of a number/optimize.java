class Solution {
    public int floorSqrt(int n) {
      long  low=1,high=n;
      while(low<=high){
        long  mid=(low+high)/2;
        long value=mid*mid;
        if(value<=n){
           low=mid+1;
        }
        else{
            high=mid-1;
        }
      }
      return (int)high;
    }
}