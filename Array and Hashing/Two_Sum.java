class Solution {
    public int[] twoSum(int[] nums, int target) {
        
        /*
        // Brut Force Approach

        // TC - O(N^2) used two for loops 
        // SC - O(1) as no any space used

        int[] ans = new int[2];

        for (int i = 0; i < nums.length - 1; i++) {
            for (int j = i+1; j < nums.length; j++) {
                if(nums[i]+nums[j] == target) {
                    ans[0] = i;
                    ans[1] = j;
                }
            }
        }

        return ans;
        */

        // ---------------------------------------------------

        // Optimal Approach

        // TC - O(N)
        // SC - O(N)

        int[] ans = new int[2];

        Map<Integer, Integer> HM = new HashMap<>();

        for (int i = 0; i < nums.length; i++) {
            int difference = target - nums[i];
            if(HM.containsKey(difference)) {
                int oneIndex = i;
                int otherIndex = HM.get(difference);
                ans[0] = oneIndex;
                ans[1] = otherIndex;
            }
            else {
                HM.put(nums[i], i);
            }
        }

        return ans;

     }
}