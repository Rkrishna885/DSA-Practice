//better approch
class Solution {
    public List<List<Integer>> fourSum(int[] nums, int target) {
        Set<List<Integer>> st=new HashSet<>();
        int n=nums.length;
        for(int i=0;i<n;i++){
            for(int j=i+1;j<n;j++){
                Set<Integer> hashset=new HashSet<>();
                for(int k=j+1;k<n;k++){
                   long fourth = target - ((long)nums[i] + nums[j] + nums[k]);
                    if(hashset.contains((int)fourth)){
                        List<Integer> temp=Arrays.asList(nums[i],nums[j],nums[k],(int)fourth);
                        Collections.sort(temp);
                            st.add(temp);
                    }
                    hashset.add(nums[k]);
                }
            }
        }

       
        return new ArrayList<>(st);
    }
}