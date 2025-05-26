class Solution {
    public int[] getConcatenation(int[] nums) {
        /*
        // Brut Force approach
        // In BF Approach - TC = O (N^2)

        int n = nums.length;
        int[] ans = new int[2*n]; // will take space complexity of O(N)

        // Time complexity = O(N)
        for (int i = 0; i < n ; i++) {
            ans[i] = nums[i];
            ans[i+n] = nums[i];
        }
        return ans;
        */

        int n = nums.length;
        int[] ans = new int[2*n]; // will take space complexity of O(N)
        int idx = 0;
        //since it is repeating for k=2 number of time so,
        // Time complexity = O(2N) = O(N)
        for (int numOfRunTime =0; numOfRunTime<2; numOfRunTime++) {
            for (int i = 0; i < n; i++) {
                ans[idx++] = nums[i];
            }
        }
        return ans;
    }
}