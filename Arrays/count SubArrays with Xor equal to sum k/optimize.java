//optimal approch
class Solution {
    public int subarraysWithXorK(int[] nums, int k) {
      int XR=0;
      Map<Integer,Integer> map=new HashMap<>();
      map.put(0,1);
      int count =0;
      for(int i=0;i<nums.length;i++){
        XR=XR^nums[i];
        int x=XR^k;
        count+=map.getOrDefault(x,0);
        map.put(XR,map.getOrDefault(XR,0)+1);
      }
      return count;
      
    }
}