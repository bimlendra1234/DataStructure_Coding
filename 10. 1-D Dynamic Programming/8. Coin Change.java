// Leetcode: 322. Coin Change

// Approach bottom UP
// TC: O(N * A)  (N = coins.length, A = amount)
// SC: O(A)


// *********
// Approach
/*
    1. dp[i] = min coins to form i; init with INF = amount + 1 (unreachable).
    2. Base: dp[0] = 0.
    3. For i = 1..amount:
         for coin in coins:
            if coin <= i and dp[i-coin] != INF:
                dp[i] = min(dp[i], 1 + dp[i-coin])
    4. Return dp[amount] == INF ? -1 : dp[amount].
*/


// Code
class Solution {
    public int coinChange(int[] coins, int amount) {
        
        int INF = amount +1;
        int[] dpMin = new int[amount+1];
        dpMin[0] = 0;

        for(int i =1; i <= amount; i++) {
            dpMin[i] = INF;

            for(int coin : coins) {
                if(coin <= i && dpMin[i-coin] != INF) {
                    dpMin[i] = Math.min(dpMin[i], 1+dpMin[i-coin]);
                }
            }
        }

        return dpMin[amount] == INF ? -1 : dpMin[amount];

    }
}