// Leetcode : 704. Binary Search

class Solution {
    public int search(int[] nums, int target) {
        
        /*
        // Brut Force Approach without Binary Search
        // TC: O(N)
        // SC: O(1)


        // *********
        // Approach
        // 1. one traverse and check if it exist


        // *********
        // Code
        for(int i = 0; i < nums.length; i++) {
            if(nums[i] == target) {
                return i;
            }
        }
        return -1;
        */

        // -----------------------------------------------------------------------------
        
        // Optimal Approach using binary search
        // TC: O(lonN)
        // SC: O(1)

        // *********
        // Approach
        /*
        1. find the mid element
        2. if target is greater then mid element,
            our target lie in the 2nd half so remove 1st half. i.e start = mid+1 to end
        3. if target is less then mid element,
            our target lie in the 1st half so remove 2nd half. i.e start to end = mid-1;
        4. if target is equal to the mid element,
            we found out target which is midelement itself
            so return the midelement index
        */


        // *********
        // Code
        int start = 0;
        int end = nums.length-1;

        while(start <= end) {
            int mid = (start+end)/2;
            if(target > nums[mid]) {
                start = mid+1;
            }
            else if(target < nums[mid]) {
                end = mid-1;
            }
            else {
                // if target == nums[mid]
                return mid;
            }
        }
        return -1;
    }
}