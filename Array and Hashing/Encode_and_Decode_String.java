/* 
    Question

    Encode and Decode Strings

Design an algorithm to encode a list of strings to a single string. The encoded string is then decoded back to the original list of strings.

Please implement encode and decode

Example 1:

Input: ["neet","code","love","you"]

Output:["neet","code","love","you"]
Example 2:

Input: ["we","say",":","yes"]

Output: ["we","say",":","yes"]
Constraints:

0 <= strs.length < 100
0 <= strs[i].length < 200
strs[i] contains only UTF-8 characters.

 */

 // ----------------------------------

 //Solution

import java.util.*;

class Solution {

    // Time Complexity : O(N) for both encode and decode function call
    // Space Complexity : O(M+N) for each encode(its M) and decode(Its N)

    public String encode(List<String> strs) {
        // String builder
        StringBuilder EncodeStr = new StringBuilder();

        // todo append method
        for(String S : strs) {
            EncodeStr.append(S.length()).append('#').append(S);
        }

        // StringBuilder cannot be converted to String
        return EncodeStr.toString();
    }

    //list and arrayList
    public List<String> decode(String str) {
        List<String> res = new ArrayList<>();

        int i = 0;

        while(i < str.length()) {
            int j = i;
            while(str.charAt(j) != '#') {
                j++;
                // at the end j is at delimeter #
            }
            int length = Integer.parseInt(str.substring(i,j)); // j not condidered

            //this will calculated actual string to put inside the arraylist
            i = j+1;
            j = i+length;
            res.add(str.substring(i,j));

            // update final i now
            i = j; // now i will point to new string after 1st string finish completely
        }

        return res;

    }
}
