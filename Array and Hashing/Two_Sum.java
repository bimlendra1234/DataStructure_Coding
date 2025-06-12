// Leetcode: 1. Two Sum

import java.util.*;

class Solution {
    public int[] twoSum(int[] nums, int target) {
        
        /*
        // Brut Force Approach

        // TC - O(N^2) used two for loops 
        // SC - O(1) as no any space used

        int[] ans = new int[2];

        for (int i = 0; i < nums.length - 1; i++) {
            for (int j = i+1; j < nums.length; j++) {
                if(nums[i]+nums[j] == target) {
                    ans[0] = i;
                    ans[1] = j;
                }
            }
        }

        return ans;
        */

        // ---------------------------------------------------
        
        // Optimal Approach Using HashMap

        // TC - O(N)
        // SC - O(N)

        // *********
        // Approach
        /*
        1. use hashmap(HM) to store number and its index
        2. use for loop to traverse each element
            a. For each element, find difference that will add up to target i.e target - nums[i]
            b. if this difference exist in HM, boom we got our both element
                one element is current in for loop so take this index
                other element is in HM, and its value is the index take that
                store both index in the resultant array - ans
            c. If the element do not exist in the HM
                then put loop element and its index in the HM (Note: not the difference).
        3. Finally return the resultant array - res
        */

        // *********
        // Code
        int[] ans = new int[2];

        Map<Integer, Integer> HM = new HashMap<>();

        for (int i = 0; i < nums.length; i++) {
            int difference = target - nums[i];
            if(HM.containsKey(difference)) {
                int oneIndex = i;
                int otherIndex = HM.get(difference);
                ans[0] = oneIndex;
                ans[1] = otherIndex;
            }
            else {
                HM.put(nums[i], i);
            }
        }
        return ans;
     }
}