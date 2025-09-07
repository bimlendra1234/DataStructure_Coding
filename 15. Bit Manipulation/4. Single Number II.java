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