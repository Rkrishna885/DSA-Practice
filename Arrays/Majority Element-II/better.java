//better Solution
class Solution {
    public List<Integer> majorityElementTwo(int[] nums) {
        HashMap<Integer,Integer> frequencyCounter=new HashMap<>();
        List<Integer> maxElements=new ArrayList<>();
        int threshold=nums.length/3;
        for(int i=0;i<nums.length;i++){
            if(frequencyCounter.containsKey(nums[i])){
                frequencyCounter.put(nums[i],frequencyCounter.get(nums[i])+1);
            }
            else{
                frequencyCounter.put(nums[i],1);
            }
             if(frequencyCounter.get(nums[i])>threshold){
                maxElements.add(nums[i]);
            }
            if(maxElements.size()==2){
                break;
            }
        }
        return maxElements;
    }
}