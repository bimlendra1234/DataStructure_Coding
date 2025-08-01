// Leetcode: 70. Climbing Stairs

// Approach using bottom UP DP
// TC: O(N)
// SC: O(N)


// *********
// Approach
/*
    1. Base cases:
        - Only 1 way to reach step 1 → [1]
        - 2 ways to reach step 2 → [1+1], [2]
    2. For step i (i ≥ 3), total ways = ways to reach (i−1) + ways to reach (i−2)
    3. Fill dp[] from 3 to n
*/


// *********
// Code
class Solution {
    public int climbStairs(int n) {
        if(n == 1) {
            return 1;
        }

        // initialize memoization table
        int[] dp = new int[n+1];
        dp[1]=1;
        dp[2]=2;

        // fill all the way from 3rd to nth stair
        // To reach 7 = way to reach 6 + way to reach 5
        // dp[n] = dp[n-1]+dp[n-2] : so that we can go in 1 step and 2 step to 7
        for(int i = 3; i <=n; i++) {
            dp[i] = dp[i-1]+dp[i-2]; // // take 1 step from i-1 or 2 steps from i-2
        }
        return dp[n];
    }
}