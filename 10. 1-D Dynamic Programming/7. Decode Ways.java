// Leetcode: 91. Decode Ways

// Bottom Up Approach
// TC: O(N)
// SC: O(N)


// *********
// Approach
/*
    1. declare memoization array and initialize it
        - dpMem[0] = 1      (empty string has 1 way)
        - dpMem[1] = 1 or 0 (if s.charAt(0) == '0', then 0 else 1)
    
    2. Fill rest of the table as
        - takes only one character → if valid (1 to 9), add dpMem[i-1]
        - takes two character     → if valid (10 to 26), add dpMem[i-2]

        // Formula:
        dpMem[i] = (if oneDigit valid → dpMem[i-1]) + (if twoDigit valid → dpMem[i-2])

    3. return last element of dpMem table
        - return dpMem[n]
*/


// *********
// Code
class Solution {
    public int numDecodings(String s) {
        
        int n = s.length();
        // 1. declare memoization array and initialize it
        int[] dpMem = new int[n+1];
        dpMem[0] = 1;
        dpMem[1] = s.charAt(0) == '0' ? 0 : 1;

        // 2. Fill rest of the table as
            // takes only one character - dpMem[n-1]
            // takes two character - dpMem[n-2]
        for(int i = 2; i <= n ; i++) {
            int oneDigit = Integer.valueOf(s.substring(i-1, i));
            int twoDigit = Integer.valueOf(s.substring(i-2,i));

            if(oneDigit >= 1) {
                dpMem[i] += dpMem[i-1];
            }

            if(twoDigit >= 10 && twoDigit <= 26) {
                dpMem[i] += dpMem[i-2];
            }
        }

        return dpMem[dpMem.length-1];
    }
}