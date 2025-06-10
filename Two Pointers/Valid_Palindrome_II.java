class Solution {
    // thsi is External function created by Me
    public boolean isPalindrome(int left, int right, String s) {
        int l = left;
        int r = right;
        while(l<r) {
            if(s.charAt(l) != s.charAt(r)) {
                return false;
            }else{
                l++;
                r--;
            }
        }
        return true;
    }

    public boolean validPalindrome(String s) {

        // Optimal Approach using two pointer

        // TC: O(N);
        // SC: O(1);

        /* 
        Approach
        1. Do a normal palindrome check
        2. if both left and right same do left++ and right--
        3. if there is conflict that any one is not same
            need to decide which one to delete
            even after deleting any one, if any one remain is true then our work is done here
            we will return true
        4. first lets delete left char and check other right remain is valid palindrome
        5. Second lets delete right char and check other left remain is valid palindrome.


        /*
        Doubt: which char to remove if both left and right do not math

        remove both one by one
        and check when removed left then other right remain is valid
        also check when removed right then other left remain is valid
        */

        int left = 0; 
        int right = s.length()-1;

        while(left<right) {
            if(s.charAt(left) != s.charAt(right)) {
                // if any of this is true, then return true
                // when removed left, other right remain is valid? : isPalindrome(left+1, right)
                // when removed right, other left remain is valid? : isPalindrome(left, right-1)
                return isPalindrome(left+1, right, s) || isPalindrome(left, right-1, s);
            } else {
                left++;
                right--;
            }
        }
        return true;
    }
}