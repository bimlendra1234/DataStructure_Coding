class Solution {
    public String mergeAlternately(String word1, String word2) {

        /*
         * leetcode 1768. Merge Strings Alternately
         
         * You are given two strings word1 and word2.
         * Return a string of the form word1[0] + word2[0] + word1[1] + word2[1] + ...
         * + word1[n - 1] + word2[n - 1] where n is the length of the shorter string.
         * If a string is longer than the other, append the additional letters onto the end of the result.
         
         Example 1:
         * Input: word1 = "abc", word2 = "pqr"
         * Output: "apbqcr"
         * Explanation: The merged string will be merged as so:
         * word1:  a   b   c
         * word2:  p   q   r
         * merged: a p b q c r
         */

        // Approach using two pointer

        // TC: O(N+M) N for 1st string and M for 2nd string
        // SX: O(N+M) creating a string of size N i.e word1.length() and M i.e word2.length()

        /*
        Approach
        1. Maintain two pointer one at the left string start
            and other at the right string start
        2. create one res string that will of length word1.length() + word2.length();
        3. if left pointer is less then or equals to right pointer
            append left character and increase it by 1
        4. if right pointer is les then left pointer 
            append right character and increment it by one
        5. if left pointer is greater or equals to word1.length() 
            that means nothing in word1 left now so append all character of word2
        6. if right pointer is greater or equals to word2.length() 
            that means nothing in word2 left now so append all character of word1
        */
        
        int idx1 = 0;
        int idx2 = 0;

        String res = new String();
        int totalLen = word1.length() + word2.length();

        for(int i = 0; i < totalLen; i++) {
            if(idx2 >= word2.length()) {
                res += word1.charAt(idx1);
                idx1++;
            }
            else if (idx1 >= word1.length()){
                res += word2.charAt(idx2);;
                idx2++;
            }
            else if(idx1 <= idx2) {
                res += word1.charAt(idx1);
                idx1++;
            }
            else {
                // if(idx2 < idx1)
                res += word2.charAt(idx2);;
                idx2++;
            }
        }
        return res;
    }
}