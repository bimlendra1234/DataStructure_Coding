class Solution {
    public void reverseString(char[] s) {

        // Optimal Approach - Using two pointer technique

        // TC: O(N)
        // SC: O(1)

        /*
        Approach
        1. Keep oe pointer at the 0th index i.e first element 
        2. and other pointer at last element or at len-1 index
        3. run while loop till left cross right
        4. swap the two element pointed by two pointer left and right using three variable.
        */

        int left = 0;
        int right = s.length-1;

        while(left<right) {
            char temp = s[left];
            s[left] = s[right];
            s[right] = temp;
            left++;
            right--;
        }
    }
}