
// Leetcode : 39. Combination Sum

// Approach using backtracking
// TC: O(2^T) in the worst case (when candidates = [1], you can have 2^T combinations to explore).
// SC: O(T) for recursion call stack


// *********
// Approach
/*
    1. Pick the number
        add the number in currComb
        recursively pick the same number again and again until we reach target
            this will not change our index and it will change our total by total + current element

    2. Do not pick the previous number anytime again
        remove the last added element in currComb
        recursively pick all other remaining number except lastly added
            this will change our index as index+1 (all remaining element that we will add)
            and total sum will not include the last number that we added 
                so total will be just total (not total + current element)
*/


// *********
// Code

import java.util.*;

class Solution {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> resComb = new ArrayList<>();
        List<Integer> currComb = new ArrayList<>();
        backTrack(0, candidates, 0, target, currComb, resComb);
        return resComb;
    }

    public void backTrack(int index, int[] candidates, int total, int target, List<Integer> currComb, List<List<Integer>>resComb) {

        // Base case 1
        if(total == target) {
            resComb.add(new ArrayList<>(currComb));
            return;
        }

        // Base case 2
        if(index == candidates.length || total > target) {
            return;
        }

        // Pick the same number
        currComb.add(candidates[index]);
        backTrack(index, candidates, total + candidates[index], target, currComb, resComb); // recursively try to add same number

        // Do not pick the same number
        currComb.remove(currComb.size()-1); // remove the last # that we added
        backTrack(index+1, candidates, total, target, currComb, resComb); // add all other number except previously added number
    }
}