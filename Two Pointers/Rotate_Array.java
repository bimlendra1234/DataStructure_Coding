// Leetcode: 189. Rotate Array

class Solution {
    public void rotate(int[] nums, int k) {

        // BrutForce Approach using extra array space
        // TC: O(N)
        // SC: O(N) for extra temp array


        // *********
        // Approach
        // 1. take extra array where we put at the specific element
                // extra array so that element at main array wont get override
        // 2. calculate the index where we put element by logic
                //Logic
                    // element should be revolved around index 0 to 6
                        //since total 7 element so %by 7 i.e modulo by totalLength = 7
                    // each element index increased by kth time and fit on index 0 to 6
                        // so, rotatedIndex = (originalIndex+k)%totalLength
        // 3. assign each element of main array at temp array in the above rotated index
        // 4. assign temp to main 
            // Note: nums = temp won't work because Java passes array references by value — 
                //this reassigns the local copy, not the original array.
            // insted use for loop update one by one element from temp to main


        // *********
        // Doubt
        // 1. nums = temp does not update the original array as Java passes references by value.
                // Reassigning nums = temp only updates the local copy of the reference.
            // sol - To modify the original array: use for loop and update one by one


        // *********
        // Code
        int[] temp = new int[nums.length];

        for(int i =0; i < nums.length;i++) {
            int rotatedIndex = (i+k)%nums.length;
            temp[rotatedIndex] = nums[i];
        }

        for(int i = 0; i < temp.length; i++) {
            nums[i] = temp[i];
        }
    }
}