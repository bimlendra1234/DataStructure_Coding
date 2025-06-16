// Leetcode : 682. Baseball Game


import java.util.Stack;
class Solution {
    public int calPoints(String[] operations) {

        // BrutForce Approach that came out of me - usig stack
        // TC: O(N)
        // SC: O(N) - for using the stack


        // *********
        // Approach
        /*
        1. use stack and store in that as per the instruction following question
            based on, integer, "C", "D" "+"
        2. finally iterate iver the stack and sum up all number inside it.
        3. return the final sum
        */


        // *********
        // Doubt 
        /*
        1. how to check if number is int
            => this was the only case so use in else part
        ---------------------------------
        2. How to traverse in stack
            => same as old method 

            for(int elem : st) {
                sum += elem;
            }
        ---------------------------------
        3. issue is at syntax
            operations.charAt(i) in the string
            in array use => operations[i]
        --------------------------------
        4. Use .equals() to compare strings. => operations[i].equals("C")
            do not use == operator as this operations[i] == "C"
        --------------------------------
        original stack: [5, 10]
        5. why 
            int num1 = st.pop(); // num1 = 10 and stack: [5]
            int num2 = st.pop(); // num2 = 5 and stack: []
            int newRecord = num1+num2; // newRecord = 5+10 = 15
            st.push(num2); // stack: [5]
            st.push(num1); // stack: [5, 10]
            st.push(newRecord); // stack: [5, 10, 15]

            => to mantain original order
        */


        // *********
        // Code
        Stack<Integer> st = new Stack<>(); 
        int sum = 0;

        for (int i = 0; i < operations.length; i++) {
            if(operations[i].equals("C")) {
                st.pop();
            }
            else if(operations[i].equals("+")) {
                int num1 = st.pop();
                int num2 = st.pop();
                int newRecord = num1+num2;
                st.push(num2);
                st.push(num1);
                st.push(newRecord);
            }
            else if(operations[i].equals("D")) {
                int num1 = st.peek();
                int newRecord = num1*2;
                st.push(newRecord);
            }
            else {
                // If it is integer
                int newRecord = Integer.parseInt(operations[i]);
                st.push(newRecord);
            }
        }

        for(int elem : st) {
            sum += elem;
        }
        return sum;
    }
}