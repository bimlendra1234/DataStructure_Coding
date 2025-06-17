// Leetcode: 1929. Concatenation of Array

class Solution {
    public int[] getConcatenation(int[] nums) {

        // Approach that came out of me (will only work for 2 repetation)
        // TC: O(N)
        // SC: O(1)


        // *********
        // Approach 
        // 1. run one array loop
            // for each element insert this both at one
                // ans[i] = nums[i]
                // ans[i+n] = nums[i]
        /*


        // *********
        // Code
        int n = nums.length;
        int[] ans = new int[2*n]; // will take space complexity of O(N)

        // Time complexity = O(N)
        for (int i = 0; i < n ; i++) {
            ans[i] = nums[i];
            ans[i+n] = nums[i];
        }
        return ans;
        */

        // ---------------------------------------------------------------

        // More generic approach that can work for even k repetation (in this question k =2)
        // TC: O(N)
        // SC: O(1)


        // *********
        // Approach
        /*
        1. maintaind index=0 where we 1ant to put our value and after putting value do idx++
        2. run the loop for constatnt k number of time
            inside, run loop to traverse array one by one
                ans[idx++] = nums[i]
        3. return ans
        */


        // *********
        // Code
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