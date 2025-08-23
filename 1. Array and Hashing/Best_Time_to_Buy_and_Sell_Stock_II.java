class Solution {
    public int maxProfit(int[] prices) {
        
        // Optimal Approach

        // TC: O(N)
        // SC: O(1)

        /*
        Approach:
        1.basically cummilate your profit on the price increase i.e
        2. when the price goes up (everytime )sum it in your profit 
        3. if price goes down ignore it all the time.
        */

        int cummulativeProfit = 0;
        for(int i = 0; i< prices.length-1; i++) {
            int currentPrice = prices[i];
            int nextPrice = prices[i+1];

            if(nextPrice > currentPrice) {
                int profit = nextPrice - currentPrice;
                cummulativeProfit += profit;
            }
        }
        return cummulativeProfit;
    }
}