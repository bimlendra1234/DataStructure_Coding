class Solution {
    public int[] productExceptSelf(int[] nums) {
        /*
        // Brut Force Approach

        // TC: O(N^2)
        // SC: O(N) - for resultant array

        int[] res = new int[nums.length];

        for(int i = 0; i < nums.length; i++) {
            int product = 1;
            for(int j = 0; j < nums.length; j++) {
                if(i!= j) {
                    product *= nums[j];
                }
            }
            res[i] = product;
        }
        return res;
        */

        // --------------------------------------------------

        // Optimal Approach

        // TC: O(N)
        // SC: O(N)

        /* Approach
        1. create left array
        2. in Left array fill prefix sum
        3. crete right array
        4. in right array fill postfix sum
        5. create res array and run one final loop
        6. for each index in res, pick product of each element from left and right array
        */
        int n = nums.length;

        int[] left = new int[n];
        left[0] = 1;
        for (int i = 1; i < n; i++) {
            left[i] = left[i-1] * nums[i-1];
        }

        int[] right = new int[n];
        right[n-1] = 1;
        for (int i = n-2; i >= 0; i--) {
            right[i] = right[i+1] * nums[i+1];
        }

        int[] res = new int[n];
        for (int i = 0; i < n; i++) {
            res[i] = left[i]*right[i];
        }

        return res;

        // --------------------------------------------------

        /*
        // Optimal Approach for prefix suffix

        // TC: O(N)
        // SC: O(1) as result in not considered

        //Approach
        // 1. instead of calculating left - prefix and right postfixt
        // 2. do all in res itself
        // 3. from left to right, in res fill left prefix
        // 4. from right to left , multiply prefix with postfix
            // i.e postfix of prev number is (next number * next number * next postfix(current one))
            // i.e    num  :         1,       2,         3,        4'
         // i.e postfix is :   12*2=24    4*3=12     1'*4'=4,      1'

        int[] res = new int[nums.length];
        res[0] = 1;
        for(int i = 1; i < nums.length; i++) {
            res[i] = res[i-1] * nums[i-1];
        }

        int postfix = 1;
        for(int i = nums.length-1; i>=0; i--) {
            res[i] = res[i] * postfix;
            postfix = postfix * nums[i];// next postfix
        }

        return res;
        */
    }
}