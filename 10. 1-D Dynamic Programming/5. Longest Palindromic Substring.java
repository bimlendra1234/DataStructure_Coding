// Leetcode : 5. Longest Palindromic Substring

// Time Complexity: O(N²)
/*Reasoning:
You loop over each character once: for (int i = 0; i < s.length(); i++) → O(N)

For each character, you perform two while-loop palindrome expansions (odd and even), and in the worst case, each expansion can go up to O(N) (i.e., the entire string is a palindrome).

So total = O(N) * O(N) = O(N²)
*/

// Space Complexity: O(1)
/*
Reasoning:
No extra data structures used (only a few primitive variables: resLength, resIndex, left, right)
*/


// *********
//Approach : Using two Pointers going left and right from the center.
/*
    1. Initialize resLength = 0, resIndex = 0 to track the longest palindrome seen so far
    2. Loop through each index `i` in the string:
    
        Case 1: Check for odd length palindrome
            - Initialize left = i, right = i (centered at i)
            - While within bounds and s[left] == s[right], update resLength and resIndex if current length > resLength
            - Move left--, right++

        Case 2: Check for even length palindrome
            - Initialize left = i, right = i+1 (centered between i and i+1)
            - Same as above: while valid and chars match, update resLength and resIndex if current > previous
            - Move left--, right++

    3. After checking all positions, return the substring from resIndex to resIndex + resLength
    4. Substring takes from resIndex to resIndex+resLength (exclusive) — correct as per Java’s definition
*/


// *********
// Code
class Solution {
    public String longestPalindrome(String s) {
        int resLength = 0;
        int resIndex = 0;

        // going through each character one by one
        for(int i = 0; i < s.length(); i++) {

            // checking odd length
            int left = i;
            int right = i;
            while(left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)) {
                if(right-left+1 > resLength) {
                    resLength = right-left+1;
                    resIndex = left;
                }
                left--;
                right++;
            }

            // checking even length
            left = i;
            right = i+1;
            while(left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)) {
                if(right-left+1 > resLength) {
                    resLength = right-left+1;
                    resIndex = left;
                }
                left--;
                right++;
            }
        }
        return s.substring(resIndex, resIndex+resLength);
    }
}