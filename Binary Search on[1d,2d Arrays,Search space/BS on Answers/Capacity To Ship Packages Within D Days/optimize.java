class Solution {
    public int getDaysNeeded(int[] weights,int mid){
        int count=1;
        int sum=0;
        for(int weight:weights){
            if(sum+weight<=mid){
                sum+=weight;
            }
            else{
                sum=weight;
                count++;
            }
        }
        return count;
    }
    public int shipWithinDays(int[] weights, int days) {
        int sum = 0;
        int low = 0;
        for(int weight:weights){
            sum+=weight;
            if(weight>low){
                low=weight;
            }
        }
        int high=sum;
        if(weights.length==days)return low;
        if(days==1)return sum;
        while(low<=high){
            int mid=(low+high)/2;
            int daysNeeded=getDaysNeeded(weights,mid);
            if(daysNeeded<=days){
                high=mid-1;
            }
            else{
                low=mid+1;
            }
        }
        return low;
    }
}