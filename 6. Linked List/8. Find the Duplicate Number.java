// Leetcode: 287. Find the Duplicate Number

import java.util.Arrays;

class Solution {
    public int findDuplicate(int[] nums) {

        /*
        // BrutForce approach using two for loop
        // TC: O(N^2)
        // SC: O(1)


        // *********
        // Approach
        // Use two for loop 
                // and check each number with all other remaining number
                    // if same then thats a duplicate 
        

        // *********
        // Code
        int res = -1;
        for (int i = 0; i < nums.length -1; i++) {
            for(int j = i+1; j < nums.length; j++) {
                if(nums[i] == nums[j]) {
                    res = nums[i];
                }
            }
        }
        return res;
        */

        // --------------------------------------------

        // Approach using sorting and one traversal
        // TC: O(NLOGN) for sorting
        // SC: O(1)


        // *********
        // Approach 
        // 1. using sorting and one traversal


        // *********
        // Code
        Arrays.sort(nums);

        int res = -1;
        for(int i = 0 ; i < nums.length-1; i++) {
            if(nums[i] == nums[i+1]) {
                res = nums[i];
            }
        }
        return res;
    }
}