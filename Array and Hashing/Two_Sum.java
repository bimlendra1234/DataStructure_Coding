class Solution {
    public int[] twoSum(int[] nums, int target) {
        
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
     }
}