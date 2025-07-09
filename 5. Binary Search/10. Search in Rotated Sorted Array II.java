// Leetcode: 81. Search in Rotated Sorted Array II

// Brut Force Approach using without BS but with one traversal
/*
class Solution {
    public boolean search(int[] nums, int target) {
        
        // Brut Force Approach using without BS but with one traversal
        // TC: O(N) - one traversal
        // SC: O(1)


        // *********
        // Approach
        // 1. One traversal and finding the index of a number


        // *********
        // Code
        for(int i = 0; i < nums.length; i++) {
            if(nums[i] == target) {
                return true;
            }
        }
        return false;
    }
}
    */

// ----------------------------------------------------

// Optimal approach using modified BS
class Solution {

    boolean modifiedBS(int left, int right, int[] nums, int target) {

        // base case in case of failure
        if(left > right) {
            return false;
        }

        int mid = left + (right-left) /2;
        // base case in case of success
        if(nums[mid] == target) {
            return true;
        }

        // If unable to identify sorted half: [1,0,1,1,1] so trim this condition by left++ and right--
        // becoz this element we are already checking at the mid
        if(nums[left] == nums[mid] && nums[mid] == nums[right]) {
            return modifiedBS(left+1, right-1, nums, target);
        }
        // either left is sorted
        else if(nums[left] <= nums[mid]) {
            // either target present in left side
            if(nums[left] <= target && target <= nums[mid]) {
                return modifiedBS(left, mid-1, nums, target);
            }
            else{
                // or target present in the right side
                return modifiedBS(mid+1, right, nums, target);
            }
        }
        // right is sorted
        else {
            // either target present in right side
            if(nums[mid] < target && target <= nums[right]) {
                return modifiedBS(mid+1, right, nums, target);
            }
            else{
                // or target present in the left side
                return modifiedBS(left, mid-1, nums, target);
            }
        }
    }

    public boolean search(int[] nums, int target) {
        
        // Optimal approach using modified BS
        // TC: O(logN)
        // SC: O(1)


        // *********
        // Approach
        /*
        1. Used modified BS with recursion
        2. if Sorted, when array divided in two half 
            at least one side will be complete sorted, either left or right
        3. find the mid if its target return the index
        4. always check in the sorted side
        5. If unable to identify sorted half: [1,0,1,1,1]  when nums[left] == nums[mid] && nums[mid] == nums[right]
            so trim this condition by left++ and right--
            becoz this element we are already checking at the mid
        5. check if left side is sorted
            check if target in left if yes, search in the left
            if no search in the right side
        6. check if right side is sorted
            check if target in right if yes, search in the right
            if no search in the left side
        */


        // *********
        // Code
        int left = 0; 
        int right = nums.length-1;
        boolean res = modifiedBS(left, right, nums, target);

        return res;
    }
}