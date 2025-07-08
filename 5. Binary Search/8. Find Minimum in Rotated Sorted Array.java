// Leetcode : 153. Find Minimum in Rotated Sorted Array

class Solution {
    public int findMin(int[] nums) {
        /*
        // Brut Force Approach using without BS but with one traversal
        // TC: O(N) - one traversal
        // SC: O(1)


        // *********
        // Approach
        // 1. One traversal and finding the minimum number


        // *********
        // Code
        int min = Integer.MAX_VALUE;
        for(int i = 0; i < nums.length; i++) {
            min = Math.min(min, nums[i]);
        }
        return min;
        */

        // -------------------------------------------------------------

        // Optimal Approach using using BS
        // TC: O(logN)
        // SC: O(1)


        // *********
        // Approach
        /*
        1. if array already sorted left is our answer
        2. if mid is in left sorted portion when nums[mid] >= nums[left]
            then smallest lies in right side
        3. if mid is in right side portion when nums[mid] < nums[left]
            smallest lies on left
        */

        // *********
        // Code
        int res = nums[0];

        int left = 0;
        int right = nums.length-1;
        while(left <= right) {

            // check if everything is already sorted
            if(nums[left] < nums[right]) {
                res = Math.min(res, nums[left]);
                break;
            }

            int mid = left + (right-left)/2;
            res = Math.min(res, nums[mid]);

            // if mid lies in 1st sorted check smallest to the to right 
            // and eliminate all left
            if(nums[mid] >=  nums[left]) { // = because left and mid
                left = mid+1;
            } 
            else {
                right = mid-1;
            }
        }
        return res;
    }
}