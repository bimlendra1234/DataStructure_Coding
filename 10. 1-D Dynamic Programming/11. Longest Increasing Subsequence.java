// Leetcode : 300. Longest Increasing Subsequence

// Optimal Bottom up DP approach
// TC: O(N*N)
// SC: O(N)


// *********
// Approach
/*

    Each element in the DPArray represents the length of the LIS ending at that index.
    If the element at “j” < the element at “i”, then the length of the LIS at “i” 
        is at least 1 greater than the length of the LIS at “j”.
    If the element at “j” > the element at “i”, then don’t do anything.

    1. start first (i.e end) pointer
    2. start second (i.e start) pointer
        if end elem is greater then start
        only update value if dpelem at start +1 is greater then dpelem at end
    3. traverse dp array and fin max element
*/


// *********
// Code
class Solution {
    public int lengthOfLIS(int[] nums) {
        int[] dp = new int[nums.length];

        // 1. start first (i.e end) pointer
        for(int i = 1; i < nums.length; i++) {

            // 2. start second (i.e start) pointer
            for(int j = 0; j<i; j++) {
                if(nums[i] > nums[j]) { // end elem is greater then start
                    // only update value if dpelem at start +1 is greater then dpelem at end
                    if(dp[j]+1 > dp[i]) {
                        dp[i] = dp[j]+1;
                    }
                }
            }
        }

        // 3. traverse dp array and fin max element
        int maxLength = 0;
        for(int i = 0; i < dp.length; i++) {
            maxLength = Math.max(maxLength, dp[i]);
        }
        return maxLength+1;
    }
}