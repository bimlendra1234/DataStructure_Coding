// Leetcode: 198. House Robber

// TC: O(N)
// SC: O(N)


// *********
// Approach
/*
    1. dpMaxLoot[i] = Math.max(dpMaxLoot[i-2] + nums[i], dpMaxLoot[i-1])

        select max of (last house(i.e n) + all the max till (n-2) ) or max till (n-1))

        n-2,  n-1, n : either select => max loot till n-2 + loot at n or maxt loot till n-1n-1 : which ever is max 
*/  


class Solution {
    public int rob(int[] nums) {
        if (nums.length < 2) {
            return nums[0];
        }

        int[] dpMaxLoot = new int[nums.length];
        dpMaxLoot[0] = nums[0];
        dpMaxLoot[1] = Math.max(nums[0], nums[1]);

        for(int i = 2; i < nums.length; i++) {
            dpMaxLoot[i] = Math.max(dpMaxLoot[i-2] + nums[i], dpMaxLoot[i-1]);
        }

        return dpMaxLoot[nums.length-1];
    }
}