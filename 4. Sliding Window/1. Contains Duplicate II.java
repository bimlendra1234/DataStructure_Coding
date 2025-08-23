// Leetcode : 219. Contains Duplicate II

import java.util.*;

class Solution {
    /*
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
    */

    // ----------------------------------------

    // Approach using sliding wndow technique
    // TC: O(N) - for one pass
    // SC: O(N) - for using set


    // *********
    // Approach
    /*
    1. Use a hash set to store the integer
    2. Track window size 
        by start = 0 initially and end will traverse each element one by one
    3. while traversing each element one by one
        if window size if greater then k
            remove left(i.e start) element from set
            increment left(i.e start)
        if windowsize is less then or equal to k
            if already exist in set then return true
            else add into the set
    */


    // *********
    // Code
    public boolean containsNearbyDuplicate(int[] nums, int k) {

        Set<Integer> HS = new HashSet<>();
        int start = 0;

        for (int end = 0; end < nums.length; end++) {
            int windowSize = end - start;
            if (windowSize > k) {
                // remove from hashSet
                HS.remove(nums[start]);
                start = start + 1;
            }

            // if windowSize > k
            if (HS.contains(nums[end])) {
                return true;
            }
            HS.add(nums[end]);
        }
        return false;
    }
}