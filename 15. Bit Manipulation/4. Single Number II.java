// Leetcode : 137. Single Number II

// Sorting Approach
// *********
// Complexity
// TC: O(N log N) → sorting + O(N/3) scan
// SC: O(1) → in-place sorting, no extra space


// *********
// Approach
/*
    1. Sort the array.
    2. In sorted order, every number should appear in groups of 3.
    3. Traverse array with step size = 3:
        - If nums[i] != nums[i-1], then nums[i-1] is the unique element.
    4. If loop ends, return the last element as the unique number.
*/


// *********
// Code
class Solution {
    public int singleNumber(int[] nums) {
        Arrays.sort(nums);

        for(int i =1; i < nums.length; i = i+3) {
            if(nums[i] != nums[i-1]) {
                return nums[i-1];
            }
        }
        return nums[nums.length-1];
    }
}

// ----------------------------------------------------

// Most Optimal Approach using Bit Manipulation : concept of buckets

// *********
// Complexity
// TC: O(N) → iterate once through nums
// SC: O(1) → only constant variables used


// *********
// Approach
/*
    1. Maintain two bitmasks: 
        - ones → bits seen once
        - twos → bits seen twice
    2. For each num:
        - Update ones: toggle current bit (XOR) but clear if already in twos.
        - Update twos: toggle current bit (XOR) but clear if already in ones.
    3. This ensures that bits appearing 3 times are removed from both masks.
    4. At the end, ones will contain the single number.
*/


// *********
// Code
class Solution {
    public int singleNumber(int[] nums) {
        
        int ones = 0;
        int twos = 0;

        for(int i = 0; i < nums.length; i++) {

            ones = (ones ^ nums[i]) & ~twos;
            twos = (twos ^ nums[i]) & ~ones;
        }

        return ones;
    }
}