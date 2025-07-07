//Leetcode: (My 100th question on problem solving) 875. Koko Eating Bananas

class Solution {
    public int minEatingSpeed(int[] piles, int h) {

        // Optimal approach using Binary Seach
        // TC: O(n*logm) : inside binary search traverse array each time
        // SC: O(1)


        // *********
        // Approach
        /*
        1. find the maxValue in the pile:
            that is our max answer at least cox h>= piles.length
        2. do binary search for possible answer: 1 to maxValue
            take mid(i.e k) value 
            calculate timeTake if we use this mid (or k) to eat each hour

            If timeTake <= h
                that mid is our answer, if minimum update to the res
                now check even if there is any lesser value that exist that is less or equal to h
                    by r = m-1
            If timeTaken > h
                we need to eat more banana
                so we need to increase k 
                    by l = m+1
        3. finally return res.
        */


        // *********
        // Doubt
        /*
        1. why maxValueInPile can be answer
            
            becoz h >= piles.length
            so even if you finish one pile per hour, it sure that you will finish all banana in h hours. 
        ------------------------------------------------------------------------------------------------
        2. Incorrect use of Math.ceil(piles[i] / mid)
            
            piles[i] / mid, it performs integer division before Math.ceil is even called.
            This means Math.ceil is getting a value like 1.0, 2.0, etc., with no fractional part to round up—it's too late.
        */


        // *********
        // Code

        // finding the maximum value in the pile
        int maxValueInPile = 0;
        for(int i = 0; i < piles.length; i++) {
            maxValueInPile = Math.max(maxValueInPile, piles[i]);
        }

        // Using the binary search between possible answer : 1 to maxValueInPile
        int res = maxValueInPile;
        int left = 1;
        int right = maxValueInPile;
        while (left <= right) {
            int mid = left + (right-left)/2;
            long timeTakenForEachMid = 0;
            for(int i = 0; i < piles.length; i++) {
                timeTakenForEachMid += Math.ceil((double)piles[i]/mid);
            }

            if(timeTakenForEachMid <= h) {
                // this is our ans so we can tak min answer here
                // if i am taking less time then check even more less is possible
                res = Math.min(res, mid);
                right = mid-1;
            }else {
                // if(timeTakenForEachMid > h)
                // if i am taking more time then i need to eat more banana
                left = mid+1;
            }
        }
        return res;
    }
}