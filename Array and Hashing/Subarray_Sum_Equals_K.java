class Solution {
    public int subarraySum(int[] nums, int k) {

        // BrutForec Approach using two for loop

        // TC: O(N^2)
        // SC: O(1)

        // Approach
        // 1. check for each element if it is in correct subarray

        int subArray = 0;

        for(int i = 0; i < nums.length; i++) {
            int sum = 0;
            for(int j = i; j < nums.length; j++) {
                sum += nums[j];
                if(sum == k) {
                    subArray++;
                }
            }
        }
        return subArray;
    }
}