class Solution {
    public List<Integer> majorityElementTwo(int[] nums) {
        int  maxcount=0;
        List<Integer> maxElements=new ArrayList<>();
        for(int i=0;i<nums.length;i++){
            maxcount=0;
            for(int j=0;j<nums.length;j++){   
              if(nums[i]==nums[j]){
                maxcount++;
              }
            }
            if(maxcount>=3){
                if(!maxElements.contains(nums[i])){
                maxElements.add(nums[i]);
                }
            }
            if(maxElements.size()==2){
                break;
            }
        }
        return maxElements;
    }
}