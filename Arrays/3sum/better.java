// better
class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        Set<List<Integer>> st=new HashSet<>();
        for(int i=0;i<nums.length;i++){
            Set<Integer> hashset=new HashSet<>();
            for(int j=i+1;j<nums.length;j++){
                int third=-(nums[i]+nums[j]);
                if(hashset.contains(third)){
                   List<Integer> temp=Arrays.asList(nums[i],nums[j],third);
                   Collections.sort(temp);
                   st.add(temp);
                }
                hashset.add(nums[j]);

            }
        }
        List<List<Integer>> ans=new ArrayList<>(st);
        return ans;
    }

}