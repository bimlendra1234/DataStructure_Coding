// Leetcode : 22. Generate Parentheses

import java.util.*;

// Approach using backtracking and recursion
// TC: O((4^n)/(square root n))
// SC: O(N)

// *********
// Approach
/*
1. when both count is 0 that is our valid case add to result list string
2. until open != 0
    keep adding (
    and do recursion cal with open-1 and all same
    after recursion call remove one by one last character from stack
3. when close > open i.e we’ve already opened more than we’ve closed
    keep adding ')'
    and do recursion cal with close-1 and all same
    after recursion call remove one by one last character from stack
*/


// ********
// Doubt
/*
1. add a ')' if close > open (i.e., we’ve already opened more than we’ve closed).
---------------------------------------------------------------------------------
2. still doubt in this
    stack.deleteCharAt(stack.length() - 1);  // Remove last char 
--------------------------------------------------------------------------------
3. removing character from stringbuilder
    stack.deleteCharAt(position)
--------------------------------------------------------------------------------
4. Catalan number formula:
The number of valid sequences of n pairs of parentheses is known as the Catalan number Cₙ
Cₙ = (1/𝑛+1)(2n choose n)
*/

class Solution {
    private void backTrack(int open, int close, StringBuilder stack, List<String> res) {
        // edge case when valid case
        if(open == 0 && close ==0) {
            res.add(stack.toString());
            return;
        }
        // choice for opening bracket
        if (open != 0) {
            stack.append('(');
            backTrack(open-1, close, stack, res);
            stack.deleteCharAt(stack.length() - 1);  // Remove last char 

        }

        // choice for closing bracket
        if( close > open ) {
            stack.append(')');
            backTrack(open, close-1, stack, res);
            stack.deleteCharAt(stack.length() - 1);  // Remove last char 
        }
    }
    public List<String> generateParenthesis(int n) {
        int open = n;
        int close = n;
        List<String> res = new ArrayList<>();
        StringBuilder stack = new StringBuilder();
        backTrack(open, close, stack, res);
        return res; 
    }
}