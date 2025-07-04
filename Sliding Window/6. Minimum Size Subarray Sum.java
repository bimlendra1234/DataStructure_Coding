// Leetcode : 209. Minimum Size Subarray Sum

class Solution {
    public int minSubArrayLen(int target, int[] nums) {

        // Optimal Approaching using sliding windiw technique
        // TC: O(N+N) one N for start amd one N for end traversal i.e O(N)
        // SC: O(1)


        // *********
        // Approach
        /*
        1. maintain start, sum and minLen all to 0
        2. for loop that is end
        3. add each element one by one in sum
        4. untill sum is greater or equals to target
            // at first update minLen to windowsize i.e when minLen=0 only once
            // then set minLen to min of (minLen, windowSize)
            // then shrink sum by substracting start element
            // and increment start in order to check next subset
        5. return minLen
            if its value never change then it will be 0 that is no subset
            if something then we git min Subset that is our answer.
        */
        

        // *********
        // Code
        int minSubArrayLen = 0;  // wont change if no solution

        int start = 0; 
        int sum = 0;
        for(int end = 0; end < nums.length; end++) {
            sum += nums[end];

            while(sum >= target) {

                if(minSubArrayLen == 0) { // for the first time
                    minSubArrayLen = end-start+1;
                }

                minSubArrayLen = Math.min(minSubArrayLen, end-start+1); // save min len
                sum -= nums[start]; // remove start from sum -> shrink window 
                start++; // start++ -> shrink window 
            }
        }
        return minSubArrayLen;
    }
}