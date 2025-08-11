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

// -----------------------------------------------------------------------------------------

// Optimal Approach With DP
// TC: O(N)
// SC: O(1)


// *********
// Approach
/*
    1. Maintain:
        maxProdSoFar → maximum product ending at current index
        minProdSoFar → minimum product ending at current index
        (minProdSoFar is needed because a negative number can turn a small product into the largest)
    2. If nums[i] is 0:
        reset both maxProdSoFar and minProdSoFar to 1 
        (subarray can't extend past a 0 in product terms)
    3. Store temporary max before updating minProdSoFar 
        because maxProdSoFar's previous value is needed in min calculation
    4. Update maxProdSoFar and minProdSoFar by:
        - nums[i] alone
        - nums[i] * previous maxProdSoFar
        - nums[i] * previous minProdSoFar
    5. Update maxProd with the maximum product found so far
*/


// *********
// Code
class Solution {
    public int maxProduct(int[] nums) {
        int maxProd = nums[0];    // final result
        int maxProdSoFar = 1;     // max product ending at current index
        int minProdSoFar = 1;     // min product ending at current index

        for(int i = 0 ; i < nums.length; i++) {

            // reset when encountering zero
            if(nums[i] == 0) {
                maxProdSoFar = 1;
                minProdSoFar = 1;
                maxProd = Math.max(maxProd, 0); // handle zero itself as subarray
                continue;
            }

            int temp = nums[i] * maxProdSoFar;  // store before updating minProdSoFar
            maxProdSoFar = Math.max(Math.max(nums[i] * maxProdSoFar, nums[i] * minProdSoFar), nums[i]);
            minProdSoFar = Math.min(Math.min(temp, nums[i] * minProdSoFar), nums[i]);
            
            maxProd = Math.max(maxProd, maxProdSoFar);
        }

        return maxProd;
    }
}