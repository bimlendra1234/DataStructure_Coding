// Leetcode : 150. Evaluate Reverse Polish Notation

import java.util.*;

class Solution {
    public int evalRPN(String[] tokens) {

        // Approach using stack
        // TC: O(N)
        // SC: O(N) - For using stack


        // *********
        // Approach
        /*
        1. if i get number then push in the stack
        2. if i get valid operators are '+', '-', '*', and '/'
            pop two number and do the operation
            also push the result into stack
        3. finally at last when length of stack is 1, return that
        */


        // *********
        // Doubts
        /*
        1. instead of tokens[i] == "+" use .equals() in the string case
        ---------------------------------------------------------------
        2. what is Reverse Polish notation
            It is format: operand operand operator (for example: 4 5 +)
        */
        

        // *********
        // Code
        Stack<Integer> st = new Stack<>();
        for(int i = 0; i < tokens.length; i++) {

            if(tokens[i].equals("+") || tokens[i].equals("-") || tokens[i].equals("*") || tokens[i].equals("/") ) {
                int num1 = st.pop();
                int num2 = st.pop();

                if(tokens[i].equals("+")) {
                    st.push(num2+num1);
                }
                else if(tokens[i].equals("-")) {
                    st.push(num2-num1);
                }
                else if(tokens[i].equals("*")) {
                    st.push(num2*num1);
                }
                else {
                    // when tokens[i].equals("/"
                    st.push(num2/num1);
                }
            }
            else{
                // if it is integer just push into the stack
                st.push(Integer.parseInt(tokens[i]));
            }
        }

        return st.peek();
    }
}