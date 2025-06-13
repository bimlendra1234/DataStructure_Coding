// Leetcode: 15. 3Sum

import java.util.*;

class Solution {
    public List<List<Integer>> threeSum(int[] nums) {

        // BrutForce Approach - will give time limit exceeded
        // TC: O(N^3)
        // SC: O(1)


        // *********
        // Approach
        // 1. For each element, select 2nd element next to it, and 
            // for third travers all, check one by one anf if sum is 3 that is our result
        // 2. basically we will run every combination in 3 loop to find reultant sum 0
        // 3. if found, store that three in a sorted order
            // so that it will be easy in checking the duplicate
        // finally return the resultant array


        // *********
        // Doubt
        // 1. How to remove duplicate from the list
            // by using Arrays.sort(), this only work in array, will not work in list.
            // use Collections.sort() this will work in list - TC: O(NLOGN)


        // *********
        // Code
        List<List<Integer>> res = new ArrayList<>();

        for(int i = 0; i < nums.length-2;i++) {
            for(int j = i+1; j < nums.length-1; j++){
                for(int k = j+1; k < nums.length; k++) {
                    if(nums[i] + nums[j] + nums[k] == 0) {
                        List<Integer> eachList = new ArrayList<>();
                        eachList.add(nums[i]);
                        eachList.add(nums[j]);
                        eachList.add(nums[k]);

                        // in order to avoid duplicate, first sort each resultant list
                        // if that sorted list is not in main result then only it.
                        Collections.sort(eachList);
                        if(!res.contains(eachList)) {
                            res.add(eachList);
                        }
                        
                    }
                }
            }
        }
        return res;
    }
}