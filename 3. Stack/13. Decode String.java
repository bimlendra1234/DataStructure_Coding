// Leetcode: 394. Decode String

import java.util.*;

// Approach using Stack
// TC: O(N)
// SC: O(N)


// *********
// Approach
/*
traverse entire string
if its number keep in the number stack
if its other then number and closing bracket push to stStrg
if once found closing bracket pop until you get closing
    once found closing pop from stNum as well 
    repeat char that number of time and push back to stStrg
last remain will be our result.
*/


// *********
// Doubt
/*
k = (k*10) +(c-'0') // creating entire num if it has 2 digit in it
-------------------
// insert(0, ...): Inserts each popped character at the beginning of temp.
    temp.insert(0, stStr.pop());
--------------------
String.valueOf(ch)); // push ch as a string
--------------------
ch.isDigit() => Character.isDigit(ch)
*/


// *********
// Code
class Solution {
    public String decodeString(String s) {
        // one stack to hold all other character
        Stack<String> stStrg = new Stack<>();

        // other stack to hold the number
        Stack<Integer> stNum = new Stack<>();
        int k = 0;

        for(char ch : s.toCharArray()) {
            // if number push into stNum
            if (Character.isDigit(ch)) {
                k = (k*10) +(ch-'0'); // ?
                continue;
            }

            if(ch == '[') {
                stNum.push(k); // push number
                k=0; // reset to 0
                stStrg.push(String.valueOf(ch)); // push '['
                continue;
            }

            if(ch != ']') {
                // found other then number and closing bracket
                stStrg.push(String.valueOf(ch)); // ? push ch as a string
                continue;
            }

            // when encounters the character ']'
            StringBuilder temp = new StringBuilder();
            while(!stStrg.peek().equals("[")) {
                // insert(0, ...): Inserts each popped character at the beginning of temp.
                temp.insert(0, stStrg.pop());
            }
            stStrg.pop(); // remove "["

            // creating newString that will be replaced in string stack
            StringBuilder replacement = new StringBuilder();
            int count = stNum.pop();
            for(int i =0; i< count; i++) {
                replacement.append(temp);
            }
            stStrg.push(replacement.toString());
        }

        StringBuilder res = new StringBuilder();
        while(!stStrg.isEmpty()) {
            res.insert(0, stStrg.pop());
        }
        return res.toString();
    }
}