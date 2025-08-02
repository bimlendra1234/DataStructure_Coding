// Leetcode : 746. Min Cost Climbing Stairs

// TC: O(N)
// SC: O(N)

// Approach
/*
    to reach n = MIN (cost at n-1 + minCost to reach n-1) or (cost at n-2 + minCost to reach n-2)

    cost    = [10,15,20] : loop will run till cost.length i.e 0,1,2,3
    minCost = [0 , 0, -, -]
    minCost = [0 , 0, min((15+0) or (10+0)), min((20+minCost[20]) or (15+minCost[15])]
*/

class Solution {
    public int minCostClimbingStairs(int[] cost) {
        if (cost.length == 0) {
            return 0;
        }

        int[] minCost = new int[cost.length+1];
        minCost[0] = 0;
        minCost[1] = 0;

        for(int i = 2; i <=cost.length; i++) {
            minCost[i] = Math.min((cost[i-1] + minCost[i-1]) , (cost[i-2] + minCost[i-2]));
        }

        return minCost[minCost.length-1];
    }
}