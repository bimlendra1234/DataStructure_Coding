// Leetcode: 81. Search in Rotated Sorted Array II


class Solution {
    public boolean search(int[] nums, int target) {
        
        // Brut Force Approach using without BS but with one traversal
        // TC: O(N) - one traversal
        // SC: O(1)


        // *********
        // Approach
        // 1. One traversal and finding the index of a number


        // *********
        // Code
        for(int i = 0; i < nums.length; i++) {
            if(nums[i] == target) {
                return true;
            }
        }
        return false;
    }
}