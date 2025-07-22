// Leetcode : 90. Subsets II

// Approach using back Tracking : Same as subset problem but just need to ignore the duplicate
// TC: O(N 2^N) 
    // at the leaf node we will have 2^N subset with max size of subset containing N element
// SC: O(N)


// *********
// Approach : Exact same as subset problem but just need to ignore the duplicate
/*
    Sort the array so that duplicate element are placed next to each other

    1. Pick the number
        Do recursion call and create subset with all other next remaining element

    2. Do not Pick the number
        remove the Last added number
            just remove the duplicate if it is there
        Do recursion call and create subset with all other next remaining element
                
    Base case: if index is same as nums.length
        that is our one suset res
*/


// *********
// Code

import java.util.*;

class Solution {
    
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        List<List<Integer>> resList = new ArrayList<>();
        List<Integer> tempList = new ArrayList<>();
        Arrays.sort(nums);
        backTrack(0, nums, tempList, resList);
        return resList;
    }

    public void backTrack(int index, int[] nums, List<Integer> tempList, List<List<Integer>>resList) {

        // Base case
        if(index == nums.length) {
            resList.add(new ArrayList<>(tempList));
            return;
        }

        // Pick the number
        tempList.add(nums[index]);
        backTrack(index+1, nums, tempList, resList);

        // Do not pick the number
        tempList.remove(tempList.size()-1);
        while(index < nums.length-1 && nums[index] == nums[index+1]) {
            index++; // here i just ignored the duplicate
        }
        backTrack(index+1, nums, tempList, resList);
    }    
}