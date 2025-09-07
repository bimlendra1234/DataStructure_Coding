// Leetcode : 78. Subsets

// Using bit Operation
// *********
// Complexity
// TC: O(2^N * N) → generate all subsets and check each element
// SC: O(2^N * N) → to store all subsets


// *********
// Approach
/*
    1. Use bit masking to represent subsets.
    2. For each number from 0 to (2^N - 1):
        - Each bit position represents inclusion/exclusion of nums[i].
    3. If the bit is set, include that element in current subset.
    4. Add the generated subset to result.
*/


// *********
// Code
class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        
        List<List<Integer>> res = new ArrayList<>();
        int n = nums.length;
        int numOfSubset = 1 << n;

        for(int num = 0; num < numOfSubset; num++) { // // iterate through 2^N subsets => TC: O(2^N)
            List<Integer> eachSet = new ArrayList<>();
            // check each bit → include/exclude
            for(int i = 0; i < n; i++) { // check each n bit is set mean 1 or not set means 0 => TC: O(N)
                if((num & (1<<i)) != 0) {
                    eachSet.add(nums[i]);
                }
            }
            res.add(eachSet);
        }
        return res;
    }
}