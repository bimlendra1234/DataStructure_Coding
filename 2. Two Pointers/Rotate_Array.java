// Leetcode: 189. Rotate Array

/*
// BrutForce Approach using extra array space
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
*/

// ----------------------------------------------------

// Optimal Approach Using reverse and two pointer

class Solution {

    // Extra Function that I created
    public void reverseArray(int left, int right, int[] nums){
        while(left<right) {
            int temp = nums[left];
            nums[left] = nums[right];
            nums[right] = temp;
            left++;
            right--;
        }
    }

    public void rotate(int[] nums, int k) {

        // Optimal Approach Using reverse and two pointer
        // TC: O(N)
        // SC: O(1)


        // *********
        // Approach
        /*
        let say array is [1,2,3,4,5,6,7] and k = 3 (i.e shift each element by two time)
        all reversal logic in the same array nums

        1. reverse entire array so, 
            [1,2,3,4,5,6,7] => [7,6,5,4,3,2,1]
        2. reverse upto k (if index start from 0 so k-1) array (i.e 0 to k-1) so, 
            [7,6,5] => [5,6,7]
        3. reverse remaining k to last element (i.e nums.length-1) so, 
            [4,3,2,1] => [1,2,3,4]
        4. so the final array nums will be
            [5,6,7,1,2,3,4]
        */


        // *********
        // Code

        // if k is greater the array length that means it will reverse in same array multiple time.
        k = k%nums.length; // let say k =2

        // reverse the entire nums: 1,2,3,4,5 => 5,4,3,2,1
        reverseArray(0, nums.length-1, nums);

        // reverse first k element : 5,4 => 4,5
        // also reverse k to all element: 3,2,1 => 1,2,3
        reverseArray(0, k-1, nums);
        reverseArray(k, nums.length-1, nums);
    }
}