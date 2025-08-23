// Leetcode: 121. Best Time to Buy and Sell Stock

class Solution {
    public int maxProfit(int[] prices) {
        /*
        // BrutForce Approach
        // TC: O(N^2)
        // SC: O(1)


        // *********
        // Approach
        // 1. for each number calculate profit with all other element
        // 2. Keep maximum profit among all them


        // *********
        // Code
        int maxProfit = 0;
        for(int i = 0; i < prices.length-1; i++) {
            int eachProfit = 0;
            for(int j = i+1; j < prices.length; j++) {
                if(prices[i] < prices[j]) {
                    eachProfit = prices[j] - prices[i];
                    maxProfit = Math.max(maxProfit, eachProfit);
                }
            }
        }

        return maxProfit;
        */

        //--------------------------------------------------
        
        // Optimal approach with one Traversal two pointer or sliding wndow
        // TC: O(N);
        // SC: O(1)


        // *********
        // Approach
        // 1. maxProfit will track max profit among all
        // 2. assume you but at 1st price we got will change later i.e buyPrice
        // 3. run the loop from 2nd to last element
        // 4. if we get bigger number compared to buyPrice,
            // Then calculate profit and if it is greater then existing maxProfit
            // Then update maxProfit with it
        // 5. If we get smaller number compared to buyPrice thenthat will be our new buyPrice


        // *********
        // Code
        int maxProfit = 0;
        int buyPrice = prices[0];

        for(int i = 1; i < prices.length; i++) {
            if(prices[i] > buyPrice) {
                int currentProfit = prices[i] - buyPrice;
                maxProfit = Math.max(maxProfit, currentProfit);
            } else{
                // if we get lower buyprice 
                buyPrice = prices[i];
            }
        }
        return maxProfit;
    }
}