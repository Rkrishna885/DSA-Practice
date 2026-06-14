class Solution {
    public List<Integer> majorityElement(int[] nums) {
        int count1 =0,count2=0;
        int element1=Integer.MIN_VALUE,element2=Integer.MIN_VALUE;
        List<Integer> majorityElements=new ArrayList<>();
        for(int i=0;i<nums.length;i++){
            if(count1==0&&nums[i]!=element2){
                count1=1;
                element1=nums[i];
            }
            else if(count2==0&&nums[i]!=element1){
                count2=1;
                element2=nums[i];
            }
            else if(element1==nums[i]){
                count1++;
            }
            else if(element2==nums[i]){
                count2++;
            }
            else{
                count1--;
                count2--;
            }
        }
        count1=0;
        count2=0;
        for(int i=0;i<nums.length;i++){
            if(nums[i]==element1){
                count1++;
            }
            else if(nums[i]==element2)
            count2++;
        }
        int mini = nums.length/3+1;

        if(count1>=mini){
           majorityElements.add(element1);
        }
        if(count2>=mini){
            majorityElements.add(element2);
        }
        Collections.sort(majorityElements); 
        return majorityElements;
    }
}