// Leetcode : 647. Palindromic Substrings

// TC: O(N^2)
// SC: O(1);


// Approach
/*
    Same as Longest Palindrome substring
*/


// Code
class Solution {
    public int countSubstrings(String s) {
        int resCount = 0;

        for(int i = 0; i < s.length(); i++) {
            
            int left = i;
            int right = i;

            // checking odd length
            while(left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)) {
                resCount++;
                left--;
                right++;
            }

            // checking even length
            left = i;
            right = i+1;
            while(left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)) {
                resCount++;
                left--;
                right++;
            }
        }
        return resCount;
    }
}