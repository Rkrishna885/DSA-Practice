class Solution {
    public List<Integer> leaders(int[] nums) {
        List<Integer> leaderArray = new ArrayList<>();

        int maxRight = nums[nums.length - 1];
        leaderArray.add(maxRight); // add last element

        for (int i = nums.length - 2; i >= 0; i--) {
            if (nums[i] > maxRight) {
                maxRight = nums[i];
                leaderArray.add(nums[i]);
            }
        }

        // reverse the list
        int start = 0;
        int end = leaderArray.size() - 1;
        while (start < end) {
            int temp = leaderArray.get(start);
            leaderArray.set(start, leaderArray.get(end));
            leaderArray.set(end, temp);
            start++;
            end--;
        }

        return leaderArray;
    }
}

