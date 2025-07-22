// Leetcode : 46. Permutations

// Approach using BackTracking
// TC: (N * N!)
    // n length have n! perm and we traversed array n time
// SC: O(N) - for recursion stack space


// **********
// Approach
/*
    1. Iterating over the num one by one using for loop
    2. picking the element - add num in templist
        generating all its possible perm, do not include same num again
    3. go back and remove the previously picked elem - BT
        choose next element using for loop done automatically
            and generating all its possible perm, do not include same num again
*/


// *********
// Code

import java.util.*;

class Solution {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> resList = new ArrayList<>();
        List<Integer> tempList = new ArrayList<>();
        backTrack(resList, tempList, nums);
        return resList;
    }

    public void backTrack(List<List<Integer>> resList, List<Integer> tempList, int[] nums) {
        // Base case
        if(tempList.size() == nums.length) {
            resList.add(new ArrayList<>(tempList));
            return;
        }
    
        //1.  iterate over each element one by one
        for(int num: nums) {
            if(tempList.contains(num)) { // b. here we will skip the same element again if already in templist
                continue;
            }
            // 2. Pick the element
            tempList.add(num);
            // 3. generating all its possible perm
            backTrack(resList, tempList, nums); // a. while generating it should not contain same element again

            // remove last inserted i.e got back and try all this again automatically using for loop
            tempList.remove(tempList.size()-1);
        }
    }
}

// --------------------------------------

// *********
// Overall Code View

class Solution {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> resList = new ArrayList<>();
        List<Integer> tempList = new ArrayList<>();
        backTrack(resList, tempList, nums);
        return resList;
    }

    public void backTrack(List<List<Integer>> resList, List<Integer> tempList, int[] nums) {
        
        if(tempList.size() == nums.length) {
            resList.add(new ArrayList<>(tempList));
            return;
        }
    
        for(int num: nums) {
            if(tempList.contains(num)) {
                continue;
            }

            tempList.add(num);
            backTrack(resList, tempList, nums);

            tempList.remove(tempList.size()-1);
        }
    }
}