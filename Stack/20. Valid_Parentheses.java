// Leetcode : 20. Valid Parentheses


import java.util.Stack;

class Solution {
    public boolean isValid(String s) {

        // BrutForce Approach that came out of me using stack
        // TC: O(N)
        // SC: O(N) => for using extra space for stack


        // *********
        // Approach
        /*
        1. Use stack
        2. when you get opening braces, push into the stack
        3. if other then opening , i.e if you get closing braces
            if size is 0 => thats invalid because nothing to close
            if input is ')' and peek is '(' => then its valid and do pop peak element
            if input is '}' and peek is '{' => then its valid and do pop peak element
            if input is ']' and peek is '[' => then its valid and do pop peak element
            rest all case is invalid
        4. finally check if all is  popped and if stack size is 0 then its valide
        5. if stack size is not 0 then its invalid.
        */


        // *********
        // Doubt
        /*
        1. I was using st.peek() before even checking size
            when size of stack was 0 abd if i tried to access peek element
                it throw error EmptyStackException

            => So check stack size before using peek element
        --------------------------------------------------------------------
        2. How to check stack size
            => as usual by 
                st.size()
        --------------------------------------------------------------------
        3. checking if stack is empty
            => st.isEmpty()
                if empty the return true otherwise return false
        */
        

        // *********
        // Code
        Stack<Character> st = new Stack<>();

        for(int i =0; i < s.length(); i++) {
            char eachChar = s.charAt(i);

            if(eachChar == '(' || eachChar == '[' || eachChar == '{') {
                st.push(eachChar);
            }
            else {
                if(st.size() == 0) {
                    return false;
                }
                char peekElement = st.peek(); 
                // st.peek(): this will throw run time error if the stack is empty so check before

                if(eachChar == ')' && peekElement == '(') {
                    st.pop();
                }
                else if(eachChar == ']' && peekElement == '[') {
                    st.pop();
                }
                else if(eachChar == '}' && peekElement == '{') {
                    st.pop();
                }
                else {
                    // if other invalid case return false immidiately
                    return false;
                }
                
            }
        }

        if(st.size() == 0) {
            return true;
        }
        return false;
    }
}