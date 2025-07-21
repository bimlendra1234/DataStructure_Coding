// Leetcode: 40. Combination Sum II

// Approach using Backtracking: 
// TC: O(N * 2^N) => tatal comb = 2^N, max size of one comb = N 
// SC: O(N) Size of recursive call stack = N


// *********
// Approach
/*
    Sort the number so that we can eliminate duplicate count
        so that duplicate number are adjescent to each other
            so that we can eliminate this easily sing below while loop
    
    1. Pick the number
        add the number in currComb
        recursively pick the other number again until we reach target - do not pick same number here agaain
            this will  change our index here to index+1 and it will change our total by total + current element

    before creating another list of comb
        eliminate chosing the same number that we have done already
        using while loop, if current number is same as next number just increase the index

    2. Do not pick the previous number anytime again
        remove the last added element in currComb
        recursively pick all other remaining number except lastly added
            this will change our index as index+1 (all remaining element that we will add)
            and total sum will not include the last number that we added 
                so total will be just total (not total + current element)

    Base Case1:
    if we found total = target
        add the currComb in our res and return

    Base Case 2:
    if index is outof bound or total>target
        return
*/


// *********
// Code

import java.util.*;

class Solution {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>> resComb = new ArrayList<>();
        List<Integer> currComb = new ArrayList<>();
        Arrays.sort(candidates); // for removing the duplicate sort
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
        backTrack(index+1, candidates, total + candidates[index], target, currComb, resComb); 

        // Do not pick the same number
        currComb.remove(currComb.size()-1); 

        // will increment index count once found next element same as current element
        while(index < candidates.length-1 && candidates[index] == candidates[index+1]) {
            index++;
        }

        backTrack(index+1, candidates, total, target, currComb, resComb);
    }
}