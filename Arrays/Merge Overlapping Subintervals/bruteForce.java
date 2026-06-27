class Solution {
    public List<List<Integer>> mergeOverlap(List<List<Integer>> intervals) {
     int n=intervals.size();
     Collections.sort(intervals,(a,b)->Integer.compare(a.get(0),b.get(0)));
     List<List<Integer>> ans=new ArrayList<>();
     for(int i=0;i<n;i++){
        int start=intervals.get(i).get(0);
        int end=intervals.get(i).get(1);
        if(!ans.isEmpty()&&end<=ans.get(ans.size()-1).get(1)){
            continue;
        }
        for(int j=i+1;j<n;j++){
            if(intervals.get(j).get(0)<=end){
                end=Math.max(end,intervals.get(j).get(1));
            }
            else{
                break;
            }

        }
        ans.add(Arrays.asList(start,end));
     }
     return ans;
    }
}