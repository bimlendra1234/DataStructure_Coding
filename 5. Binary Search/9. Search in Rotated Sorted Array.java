// Leetcode: 33. Search in Rotated Sorted Array

class Solution {
    public int search(int[] nums, int target) {
        
        // Brut Force Approach using without BS but with one traversal
        // TC: O(N) - one traversal
        // SC: O(1)


        // *********
        // Approach
        // 1. One traversal and finding the index of a number


        // *********
        // Code
        int index = -1;
        for(int i = 0; i < nums.length; i++) {
            if(nums[i] == target) {
                index = i;
            }
        }
        return index;
    }
}