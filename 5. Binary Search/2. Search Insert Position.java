// Leetcode: 35. Search Insert Position


class Solution {
    public int searchInsert(int[] nums, int target) {

        // Optimal Approach usng BS
        // TC: O(logn)
        // SC: O(1)


        // *********
        // Approach
        /*
        1. if element exist
             do the binarysearch and return mid index where it matched
        2. If element do not exist
            there are three case where it can be put
            a. When element is biggest: put to the right most so return left
                as loop will break when left cross right
            b. When element is smallest: put to the left most so return 0 - as it is first index
                as loop will break when right come left to left
            c. When element is inbetween
                // will always comes to left 
        */


        // *********
        // Code

        /*
        int left = 0;
        int right = nums.length-1;

        while(left<=right) {
            int mid = (left+right)/2;

            if(target > nums[mid]) {
                left = mid+1;
            }
            else if(target < nums[mid]) {
                right = mid-1;
            }
            else if(target == nums[mid]){
                return mid;
            }
        }

        // Note: here always return the left most position
        // We don’t need to manually check for biggest/smallest cases—
        // the standard binary search inherently gives you the right position using the final left.
        if(target > nums[nums.length-1]) {
            return left;
        }
        if(target < nums[0]) {
            return 0; // returned the left most position
        }
        return left;
        */

        // -----------------------------------------------------------------------------------

        // above otimal code when considering this
        // We don’t need to manually check for biggest/smallest cases—
        // the standard binary search inherently gives you the right position using the final left.


        // *********
        // Approach
        /*
        1. if element exist
             do the binarysearch and return mid index where it matched
        2. If element do not exist
            return left as binary search inherently gives the right position using the final left
        */


        // *********
        // Code
        int left = 0;
        int right = nums.length-1;

        while(left<=right) {
            int mid = (left+right)/2;

            if(target > nums[mid]) {
                left = mid+1;
            }
            else if(target < nums[mid]) {
                right = mid-1;
            }
            else if(target == nums[mid]){
                return mid;
            }
        }

        return left;
    }
}