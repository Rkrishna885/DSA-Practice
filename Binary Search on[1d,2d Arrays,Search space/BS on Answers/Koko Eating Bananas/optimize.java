class Solution {
    public long canEatAll(int mid,int[] piles){
        long totalTime=0;
        for(int i=0;i<piles.length;i++){
            totalTime += (long)(piles[i] + mid - 1) / mid;
        }
        return totalTime;
    }
    public int minEatingSpeed(int[] piles, int h) {
        int low=1;
        int high=0;
        int ans=0;
        for(int pile:piles){
            high=Math.max(high,pile);
        }
       while(low<=high){
        int mid=(low+high)/2;
        long requriedTime=canEatAll(mid,piles);
        if(requriedTime<=h){
            ans=mid;
            high=mid-1;
        }
        else{
            low=mid+1;
        }
       }
       return ans;
    } 
}