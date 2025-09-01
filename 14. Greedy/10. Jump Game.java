// Leetcode : 55. Jump Game

// *********
// Complexity
// TC: O(n) → single pass through array
// SC: O(1) → constant extra space


// *********
// Approach
/*
    1. Keep track of the farthest index reachable so far (maxIndex)
    2. Iterate through array while i ≤ maxIndex
    3. Update maxIndex = max(maxIndex, i + nums[i])
    4. If at any point maxIndex ≥ last index → return true
    5. If loop ends without reaching → return false
*/


// *********
// Code
class Solution {
    public boolean canJump(int[] nums) {
        int maxIndex = 0;
        int i = 0;
        while(i <= maxIndex) {
            maxIndex = Math.max(maxIndex, i+nums[i]);
            if(maxIndex >= nums.length-1) {
                return true;
            }
            i++;
        }
        return false; // loop ended without reaching last index
    }
}