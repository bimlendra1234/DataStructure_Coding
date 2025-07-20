// Leetcode: 78. Subsets

// Approach using back Tracking
// TC: O(N 2^N) 
    // at the leaf node we will have 2^N subset with max size of subset containing N element
// SC: O(N)


// *********
// Approach
/*
    1. define var subset that will hold final answer
    2. define currSet that will hold individual set for each index
    3. call helper fun where we will pass first index, array, empty currSet and subset 
        which will ach as global variable in case of recursion
    4. Inside the helper function
        // include the index number in currSet
                add indexed num in currset
                With this indexed number in current set 
                    Do recursion call to include and not include all other remaining number

        // do not include the indexed number in currset
                remove the indexed number added above in the currSet
                Without this indexed number in current set
                    Do recursion call to include and not include all other remaining number

        // once we reach i == nums.length in any recursion call
                then we have processed all element in that recursion call
                So add that in our subset

                and return just return from that recursion call

    5. finally return the subset that contain all our result.
*/


// *********
// Code
class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> subSet = new ArrayList<>();
        List<Integer> currSet = new ArrayList<>();

        helper(0, nums, currSet, subSet);
        return subSet;
    }

    public void helper(int index, int[] nums, List<Integer> currSet, List<List<Integer>> subSet) {

        if(index >= nums.length) {
            subSet.add(new ArrayList<>(currSet));
            return;
        }
        // include the index element
        currSet.add(nums[index]); // last element that we added
        helper(index+1, nums, currSet, subSet); // do for all with including

        // Do not include the index element
        currSet.remove(currSet.size()-1); //remove the last elemet that we just added
        helper(index+1, nums, currSet, subSet);// do for all with including
    }
}