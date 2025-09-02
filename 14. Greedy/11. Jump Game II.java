// Leetcode : 45. Jump Game II

// *********
// Complexity
// TC: O(n) → single pass through the array
// SC: O(1) → only variables used


// *********
// Approach
/*
    1. Maintain:
        - minJumpCount → number of jumps taken so far
        - maxJumped → farthest index we can reach currently
        - end → boundary of current jump

    2. Iterate through nums (till n-2 because reaching last index is enough):
        - Update maxJumped = max(maxJumped, i + nums[i])
        - If i == end:
            → We've exhausted the range of current jump
            → Increase minJumpCount
            → Move end to maxJumped (next boundary)
        - If end >= last index, break early
*/


// *********
// Code
class Solution {
    public int jump(int[] nums) {
        int minJumpCount = 0;
        int maxJumped = 0;
        int end = 0;

        for(int i = 0; i < nums.length-1; i++) {
            maxJumped = Math.max(maxJumped, i + nums[i]);

            if(i == end) {
                minJumpCount++;
                end = maxJumped;
            }

            if(end >= nums.length-1) {
                break;
            }
        }
        return minJumpCount;
    }
}