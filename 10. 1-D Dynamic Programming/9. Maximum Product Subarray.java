// Leetcode : 152. Maximum Product Subarray

// Approach: Brute Force
// TC: O(N^2)
// SC: O(1)

// *********
// Approach : Brute Force Check each subarray
/*
    1. Initialize resProd with the first element of array.
    2. Outer loop: pick starting index i
    3. Inner loop: multiply elements from i to j to get product of subarray nums[i..j]
    4. Update resProd whenever a bigger product is found.
    5. Return resProd as the maximum product of any subarray.
*/

class Solution {
    public int maxProduct(int[] nums) {

        int resProd = nums[0]; // stores maximum product found so far

        
        for(int i = 0; i < nums.length; i++) {
            int curr = nums[i];
            resProd = Math.max(resProd, curr); // single element case

            // Check all subarrays starting from index i+1
            for(int j = i+1; j < nums.length; j++) {
                curr *= nums[j];
                resProd = Math.max(resProd, curr);
            }
        }

        return resProd;
    }
}