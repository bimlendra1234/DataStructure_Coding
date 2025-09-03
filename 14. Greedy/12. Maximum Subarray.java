// Leetcode : 53. Maximum Subarray

// *********
// Complexity
// TC: O(n) → single pass
// SC: O(1) → only variables used


// *********
// Approach
/*
    1. Initialize currMax and maxSoFar with nums[0]
    2. For each element from index 1 to n-1:
        - Extend the subarray or start new: currMax = max(nums[i], currMax+nums[i])
        - Update overall maximum: maxSoFar = max(maxSoFar, currMax)
    3. Return maxSoFar
*/


// *********
// Code
class Solution {
    public int maxSubArray(int[] nums) {

        int currMax = nums[0];
        int maxSoFar = nums[0];

        for(int i = 1 ; i < nums.length; i++) {
            currMax = Math.max(nums[i], currMax+nums[i]);
            maxSoFar = Math.max(maxSoFar, currMax);
        }
        return maxSoFar;
    }
}