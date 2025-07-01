// Leetcode : 219. Contains Duplicate II

import java.util.*;

class Solution {

    // Brut force approach using two for loops
    // TC: O(N^2)
    // SC: O(1)


    // *********
    // Approach
    // 1. using two for loop and checking each number with others


    // *********
    // Code
    public boolean containsNearbyDuplicate(int[] nums, int k) {
        for(int i = 0; i < nums.length-1; i++) {
            for (int j = i+1; j < nums.length; j++){
                if(nums[i] == nums[j] && Math.abs(i-j) <= k) {
                    return true;
                }
            }
        }
        return false;
    }
}