// Leetcode: 1011. Capacity To Ship Packages Within D Days

class Solution {
    // Function created by Me
    boolean canShipALL(int cap, int[] weights, int days) {
        // *********
        // Approach
        /*
        check if the given capacity (cap) is enough to ship all weights within the given number of days
        The capacity (cap) represents how much we can carry in one day.
            traverse each weight and subtract it from the current day’s remaining capacity.
            If the current capacity is not enough to carry the next weight (i.e., it would go negative):
                This means we need to use another ship → which is equivalent to adding one more day.
                We reset the current capacity back to the original capacity (because we are starting a new day/ship).
            After processing all weights, we check:
                If the total number of days (or ships) used is less than or equal to the actual days given 
                    → return true    (the capacity is enough).
                Otherwise → return false.
        */
        int totalTakenDays = 1;
        int currentCap = cap; 
        // traverse array and check if this cap is enough to send all weight in given days
        for(int weight: weights) {
            if(currentCap-weight < 0) {
                totalTakenDays++;
                currentCap = cap;

            }
            currentCap -= weight;
        }

        // It is correct to use <= because finishing earlier than required is still valid.
        return totalTakenDays <= days ? true: false;
    }


    public int shipWithinDays(int[] weights, int days) {

        // Approach using BS
        // TC: O(N*logN)
        // SC: O(1)


        // *********
        // Approach
        /*
        1. min possibe capicity is max weight in the array
            Because:
            Every package must be shipped as a whole (no splitting).
            Packages must be shipped in order (no rearranging).
            So the ship must be big enough to at least carry the largest package.
        2. max possible capacity is total weight inside array
            Because 
            carries everything in 1 day
            1<= days given always true
        3. Do BS b/n min possibe cappicity and max possible capacity
            which ever is min answer that is our answer
        4. during BS
            let say mid -> cap is our min weight
            now check if that cap is enought to ship all weight in given days

            if enough
                check if other min exist
            if not enough
                we need to increase our capacity 
        5. check if the given capacity (cap) is enough to ship all weights within the given number of days
        */


        // *********
        // Code
        int maxWeight = 0;
        int totalWeight = 0;
        for(int weight : weights) {
            maxWeight = Math.max(maxWeight, weight);
            totalWeight += weight;
        }

        // min possibe cappicity is max weight in the array
        // max possible capacity is total weight inside array
        // Do BS between this min possibe cappicity and max possible capacity
        int res = totalWeight;
        int left = maxWeight;
        int right = totalWeight;
        while(left <= right) {
            int cap = left + (right-left)/2;
            // if this much cap can ship all weight in given days
            if(canShipALL(cap, weights, days)) {
                // this is one of our answer, so save it if minimum
                // explore if other min cap possible
                res = Math.min(res, cap);
                right = cap-1;
            }
            else{
                // if this much cap cant ship all weight in given days
                    //increase the cap
                left = cap+1;
            }
        }
        return res;
    }
}