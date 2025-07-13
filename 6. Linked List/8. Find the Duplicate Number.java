// Leetcode: 287. Find the Duplicate Number

import java.util.Arrays;

class Solution {
    public int findDuplicate(int[] nums) {

        /*
        // BrutForce approach using two for loop
        // TC: O(N^2)
        // SC: O(1)


        // *********
        // Approach
        // Use two for loop 
                // and check each number with all other remaining number
                    // if same then thats a duplicate 
        

        // *********
        // Code
        int res = -1;
        for (int i = 0; i < nums.length -1; i++) {
            for(int j = i+1; j < nums.length; j++) {
                if(nums[i] == nums[j]) {
                    res = nums[i];
                }
            }
        }
        return res;
        */

        // --------------------------------------------

        /*
        // Approach using sorting and one traversal
        // TC: O(NLOGN) for sorting
        // SC: O(1)


        // *********
        // Approach 
        // 1. using sorting and one traversal


        // *********
        // Code
        Arrays.sort(nums);

        int res = -1;
        for(int i = 0 ; i < nums.length-1; i++) {
            if(nums[i] == nums[i+1]) {
                res = nums[i];
            }
        }
        return res;
        */

        // --------------------------------------------

        // Optimal Approach using concept to identify LL cycle and applying fast and slow pointer
            // and the starting point of cycle is our duplicate
        // TC: O(N)
        // SC: O(1)


        // *********
        // Approach
        /*
        1. First find that it is a part of LL cycle
        eg:     0 1 2 3 4
               [1,3,4,2,2]

        LL representation and the value where we start cycle is our duplicate
        0 → 3 → 2 → 4
                ↑   ↓
                ←←←←←

        2. Use fast and slow pointer to detect cycle
        3. when both meet break and 
            start one new pointer slow2 at start
                increment both slow and slow2 by 1
                when they meet that is our duplicate
                return that number
        */


        // *********
        // Code
        int slow = 0;
        int fast = 0;
        // since we know that cucle definetly exist
        while(true) {
            slow = nums[slow];
            fast = nums[nums[fast]];
            if(slow == fast) {
                break;
            }
        }

        int slow2 = 0;
        while(true) {
            slow = nums[slow];
            slow2 = nums[slow2];
            if(slow == slow2) {
                return slow;
            }
        }
    }
}