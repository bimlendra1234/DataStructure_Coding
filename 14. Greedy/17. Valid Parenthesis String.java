// Leetcode : 678. Valid Parenthesis String

// *********
// Complexity
// TC: O(N) → single pass over string
// SC: O(1) → only counters used


// *********
// Approach
/*
    1. Maintain two counters: leftMin (minimum possible open) and leftMax (maximum possible open).
    2. For '(' → increment both counters.
    3. For ')' → decrement both counters.
    4. For '*' → treat it as both '(' and ')' → decrement leftMin and increment leftMax.
    5. If leftMax < 0 at any point → too many ')' → invalid.
    6. Reset leftMin to 0 if it goes negative (since it can't be less than 0).
    7. At the end, if leftMin == 0 → valid string, else invalid.
*/


// *********
// Code
class Solution {
    public boolean checkValidString(String s) {
        int leftMin = 0;
        int leftMax = 0;

        for(int i = 0; i < s.length(); i++) {
            if(s.charAt(i) == '(') {
                leftMin++;
                leftMax++;
            }

            else if(s.charAt(i) == ')') {
                leftMin--;
                leftMax--;
            }
            else {
                leftMin--;
                leftMax++;
            }

            if(leftMax < 0) { // s = "(()"
                return false;
            }
            if(leftMin < 0) { // s= "(*))"
                leftMin = 0;
            }
        }
        if(leftMin == 0) {
            return true;
        }
        return false;
    }
}