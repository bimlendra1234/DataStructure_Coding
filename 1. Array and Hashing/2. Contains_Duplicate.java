// Leetcode: 217. Contains Duplicate

import java.util.*;
class Solution {
    public boolean containsDuplicate(int[] nums) {
        /*
        // Brut Force approach
        // TC: O(N^2)
        // SC: O(1)


        // *********
        // Approach
        //1. using two for loop
            // and checking each number in the array 

        
        // *********
        // Code
        for (int i = 0; i < nums.length-1; i++) {
            for (int j = i+1; j < nums.length; j++) {
                if (nums[i] == nums[j]) {
                    return true;
                }
            }
        }
        return false;
        */

        // ---------------------------------------------

        // Optimal Approach using hashset
        // TC: O(N)
        // SC: O(N) - for hashset


        // *********
        // Approach
        // 1. using hashset
        // 2. enter each number using 1 for loop
        // 3. if already contains any element return true
            // that is duplicate is there


        // *********
        // Code
        Set<Integer> mySet = new HashSet<>();

        for (int i = 0; i < nums.length; i++) {
            if(mySet.contains(nums[i])) {
                return true;
            } else {
                mySet.add(nums[i]);
            }
        }
        return false;
     }
}