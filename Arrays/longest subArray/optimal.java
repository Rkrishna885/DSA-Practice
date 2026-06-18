class Solution {
    public int maxLen(int[] arr) {
       HashMap<Long,Integer> map=new HashMap<>();
       long sum=0;
       int maxLength=0;
       for(int i=0;i<arr.length;i++){
        sum+=arr[i];
        if(sum==0){
            maxLength=i+1;
        }
        if(map.containsKey(sum)){
            maxLength=Math.max(maxLength,i-map.get(sum));
        }
        else{
            map.put(sum,i);
        }
       }                                              
    return maxLength;
    }
}
