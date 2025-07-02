// Leetcode : 704. Binary Search

class Solution {
    public int search(int[] nums, int target) {
        
        // Brut Force Approach without Binary Search
        // TC: O(N)
        // SC: O(1)


        // *********
        // Approach
        // 1. one traverse and check if it exist


        // *********
        // Code
        for(int i = 0; i < nums.length; i++) {
            if(nums[i] == target) {
                return i;
            }
        }
        return -1;
    }
}