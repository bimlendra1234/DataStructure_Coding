// Leetcode: 33. Search in Rotated Sorted Array

// Brut Force Approach using without BS but with one traversal
/*
class Solution {
    public int search(int[] nums, int target) {
        
        // Brut Force Approach using without BS but with one traversal
        // TC: O(N) - one traversal
        // SC: O(1)


        // *********
        // Approach
        // 1. One traversal and finding the index of a number


        // *********
        // Code
        int index = -1;
        for(int i = 0; i < nums.length; i++) {
            if(nums[i] == target) {
                index = i;
            }
        }
        return index;
    }
}

*/

// ----------------------------------------------------

// Optimal approach using modified BS
class Solution {
    // function defined by me
    int modfiedBS(int left, int right, int[] nums, int target) {

        if(left > right) {
            return -1;
        }

        int mid = left + (right-left)/2;
        if(nums[mid] == target){
            return mid;
        }

        // when left side is sorted
        if(nums[left] <= nums[mid]) {
            //if key is in the left half - checking left half
            if(nums[left] <= target && target < nums[mid]) {
                return modfiedBS(left, mid-1, nums, target);
            }
            else {
                // if key is not in the left half - checking right half
                return modfiedBS(mid+1, right, nums, target);
            }
        }
        else {
            // when the right half is sorted

            // when key is in right half - checking right half
            if(nums[mid] < target && target <= nums[right]) {
                return modfiedBS(mid+1, right, nums, target);
            }
            else{
                // when key is not in right half - checking left half
                return modfiedBS(left, mid-1, nums, target);
            }
        }
    }

    public int search(int[] nums, int target) {

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
        int res = modfiedBS(left, right, nums, target);
        return res;
    }
}