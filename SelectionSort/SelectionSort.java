class Solution {
    public int[] selectionSort(int[] nums) {
    for(int i=0;i<nums.length;i++){
        int min=i;
        for(int j=i+1;j<nums.length;j++){
            if(nums[min]>nums[j]){
                min=j;
            }
        }
        if(min!=i){
        int swap=nums[i];
        nums[i]=nums[min];
        nums[min]=swap;
        }
    }
    return nums;
    }
}