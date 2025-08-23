// Leetcode : 71. Simplify Path

import java.util.*;

class Solution {
    public String simplifyPath(String path) {
        
        // Approach using stack
        // TC: O(N)
        // SC: O(2N) - arr and stack => O(N)


        // *********
        // Approach
        /*
        1. split the string based on /
        2. push the element into stack one by one only if
            it is not .
            it is not epty string
            it is not ..
        3. pop from stack 
            if it is .. && if stack is not empty 
        */

        // *********
        // Doubt
        /*
        1. how to split based on /
            String[] arr = path.split("/");
        -------------
        2. Know when to pop and when to push into the stack
            .. => then go back to previous filder
        -------------
        3. How to create stringbuilder
            String[] str = new StringBuilder();
        -------------
        4. Iterate over stack
            for(String S : Stack) {}
        */


        // *********
        // Code
        String[] arr = path.split("/");
        Stack<String> st = new Stack<>();

        for(String i : arr) {
            // pop into stack
            // not if at first we got .. thats why we use !st.isEmpty()
            if(!st.isEmpty() && i.equals("..")) {
                st.pop();
            }
            // push into stack
            else if(!i.equals("") && !i.equals("..") && !i.equals(".")) {
                st.push(i);
            }
        }

        StringBuilder str = new StringBuilder();
        for(String s: st) {
            str.append("/");
            str.append(s);
        }

        return str.length() == 0 ? "/" : str.toString();
    }
}