class Solution {
    public int floorSqrt(int n) {
    long ans=1;
      for(long i=1;i<n;i++){
        if(i*i<=n){
            ans=i;
        }
        else{
            break;
        }
      }
      return (int)ans;
    }
}