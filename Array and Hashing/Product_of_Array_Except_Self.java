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
    }
}