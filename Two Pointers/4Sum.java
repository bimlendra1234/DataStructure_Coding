// Leetcode: 18. 4Sum

import java.util.*;

class Solution {
    public List<List<Integer>> fourSum(int[] nums, int target) {

        // BrutForce Approach
        // TC: O(N^4)
        // SC: O(1)


        // *********
        // Approach:
        // 1. Using four loop find each possible combination of 4 value that sum to target
            //store this 4 value in the result only if its not in the list


        // *********
        // Code
        List<List<Integer>> res = new ArrayList<>();

        for(int i = 0; i < nums.length-3;i++) {
            for(int j = i+1; j < nums.length-2;j++) {
                for(int k = j+1; k < nums.length-1; k++) {
                    for(int l = k+1; l < nums.length; l++) {
                        if(nums[i]+nums[j]+nums[k]+nums[l] == target) {
                            List<Integer> eachList = Arrays.asList(nums[i],nums[j],nums[k],nums[l]);

                            // Avoids duplicate element
                            // from this [[2,2,2,2],[2,2,2,2],[2,2,2,2],[2,2,2,2],[2,2,2,2]]
                            // to this [[2,2,2,2]]
                            Collections.sort(eachList);
                            if(!res.contains(eachList)) {
                                res.add(eachList);
                            }
                        }
                    }
                }
            }
        }
        return res;
    }
}