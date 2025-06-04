class Solution {
    public int search(int[] nums, int target) {
        
        // Normal Approach without Binary Search
        
        // TC: O(N)
        // SC: O(1)

        for(int i = 0; i < nums.length; i++) {
            if(nums[i] == target) {
                return i;
            }
        }
        return -1;

    }
}