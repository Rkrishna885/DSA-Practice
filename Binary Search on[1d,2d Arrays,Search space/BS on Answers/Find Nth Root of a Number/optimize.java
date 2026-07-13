class Solution {
    public int NthRoot(int N, int M) {
       int low=0,high=M;
       while(low<=high){
        int mid=(low+high)/2;
        long ans=1;
        boolean exceeded=false;
        for(int i=0;i<N;i++){
            ans*=mid;
            if(ans>M){
                exceeded=true;
                break;
            }
        }
        if(ans==M&&!exceeded){
            return mid;
        }
        else if(ans<M&&!exceeded){
            low=mid+1;
        }
        else{
            high=mid-1;
        }
       }
       return -1;
    }
}
