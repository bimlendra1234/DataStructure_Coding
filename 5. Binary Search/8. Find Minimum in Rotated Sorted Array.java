// Leetcode : 153. Find Minimum in Rotated Sorted Array

class Solution {
    public int findMin(int[] nums) {

        // Brut Force Approach using without BS but with one traversal
        // TC: O(N) - one traversal
        // SC: O(1)


        // *********
        // Approach
        // 1. One traversal and finding the minimum number


        // *********
        // Code
        int min = Integer.MAX_VALUE;
        for(int i = 0; i < nums.length; i++) {
            min = Math.min(min, nums[i]);
        }
        return min;
    }
}