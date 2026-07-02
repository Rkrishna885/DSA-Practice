class Solution {
    public List<List<Integer>> mergeOverlap(List<List<Integer>> intervals) {
        int n=intervals.size();
        Collections.sort(intervals,(a,b)->Integer.compare(a.get(0),b.get(0)));
        List<List<Integer>> ans=new ArrayList<>();
        for(int i=0;i<n;i++){
            if(ans.isEmpty() || intervals.get(i).get(0)>ans.get(ans.size()-1).get(1)){
                ans.add(intervals.get(i));
            }else{
                Integer currentMaxEnd=Math.max(ans.get(ans.size()-1).get(1),intervals.get(i).get(1));
                ans.get(ans.size()-1).set(1,currentMaxEnd);
            }
        }
        return ans;
    }
}