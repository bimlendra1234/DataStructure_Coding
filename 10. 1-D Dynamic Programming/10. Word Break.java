// Leetcode : 139. Word Break

// Optimal Approach using DP
// TC: O(N * T) ignoring substring creation cost
//      N = length of s
//      T = maxLen = maximum length of any word in dict
// SC: O(N + D)
//      N = dp array
//      D = space for dictionary words in HashSet


// *********
// Approach
/*
    1. Put wordDict into a HashSet for O(1) lookups.
    2. Find maxLen = length of longest word in dict.
       This helps prune inner loop because no need to check longer substrings.
    3. dpPos[i] = true if s[0..i) can be formed using words in dict.
       Base case: dpPos[0] = true (empty string can always be formed).
    4. For each end index i from 1..N:
          Check start index j from i-1 down to max(0, i - maxLen).
          If dpPos[j] is true and s[j..i) is in dict:
              Mark dpPos[i] = true and break (one valid split is enough).
    5. Return dpPos[N] as final answer.
*/


// *********
// Code
class Solution {
    public boolean wordBreak(String s, List<String> wordDict) {
        
        // 1. create hash set of word dict for quick lookup
        Set<String> wordSet = new HashSet<>(wordDict);

        // 2. find max len in dict
        int maxLen = 0;
        for (String st : wordDict) {
            maxLen = Math.max(maxLen, st.length());
        }

        // 3. create dp array
        boolean[] dpPos = new boolean[s.length() + 1];
        dpPos[0] = true; // 4. empty string is valid

        // 5. fill dp table
        for (int i = 1; i <= s.length(); i++) {
            for (int j = i - 1; j >= Math.max(0, i - maxLen); j--) {
                if (dpPos[j] && wordSet.contains(s.substring(j, i))) {
                    dpPos[i] = true;
                    break; // Found a valid split
                }
            }
        }

        return dpPos[s.length()];
    }
}