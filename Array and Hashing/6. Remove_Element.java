// Leetcode: 27. Remove Element

class Solution {
    public int removeElement(int[] nums, int val) {
        
        // Optimal Approach : Since it is already in place
        // TC - O(N)
        // SC - O(1)


        // *********
        // Approach
        /*
        Thought Approach
        1. Take Your Index K = 0 first
        2. Traverse the array once
        3. Take each number and if it is not equal to value then keep that number at k index
        4. Increment the Kth index
        5. If num is equal to val then it will be skipped.
        6. at last since it does K++ and may not set any number in that index
        7. Also since  mine index start from 0 so that is fine i have 1 extra 
        8. return that K and also mine array is complete val free till k
        */


        // *********
        // Code
        int k = 0;

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != val) {
                nums[k++] = nums[i]; 
            }
        }

        return k;
    }
}