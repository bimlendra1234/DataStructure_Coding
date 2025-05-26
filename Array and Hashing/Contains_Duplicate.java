import java.util.*;

class Solution {
    public boolean containsDuplicate(int[] nums) {
        /*
        Brut Force approach
        In BF Approach - TC = O (N^2)
        
        for (int i = 0; i < nums.length-1; i++) {
            for (int j = i+1; j < nums.length; j++) {
                if (nums[i] == nums[j]) {
                    return true;
                }
            }
        }
        return false;
        */

        // Optimal Approach - time and space = O(N)

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