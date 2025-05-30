import java.util.Arrays;

class Solution {
    public String longestCommonPrefix(String[] strs) {

        // BF Approach : Solution that came out of ME

        // TC : O(N^2) => 
            // N for traversing array once and N for inside traversing each string once
        // SC : O(1)

        /* Solution Approach
        1. if array has only one element return that
        2. need to find the maxPrefix common in all the string
        3. Traverse array once from 0th index to 2nd last index; not the last one - first for loop
        4. take two string at each traversal, S1 at ith index and S2 at (ith+1) index
        5. track common prefix among this two s1 and s2 string
        6. inside the first for loop, out of s1 and s2 which ever has min length, do for loop for that length
        7. in s1 and s2 begining from start if at each index char match then increment count
        8. if anywhere, char do not match at similar index break from the loop
        9. update the maxPrefix with min value among maxPrefix and commonPrefix among s1 and s2
            because we want the min prefix that is common among all
        10. new we have number of char that has common prefix in all element in array that is maxPrefix
        11. take any element in main array and return that much(i.e. maxPrefix) character from that 
            perticular element
        */

        /*// Code
        if(strs.length == 1) {
            return strs[0];
        }

        int maxPrefix = Integer.MAX_VALUE;
        for (int elem = 0; elem < strs.length-1; elem++) {

            String s1 = strs[elem];
            String s2 = strs[elem+1];

            int n = s2.length();
            if(s1.length() < s2.length()) {
                n = s1.length();
            }

            int commonPrefix = 0;
            for (int i = 0; i < n; i++) {
                if(s1.charAt(i) == s2.charAt(i)) {
                    commonPrefix++;
                }
                else {
                    break;
                }
            }
            maxPrefix = Math.min(maxPrefix, commonPrefix);
        }

        String res = "";
        for (int i = 0; i < maxPrefix; i++) {
            res = res + strs[0].charAt(i);
        }

        return res;
        */
        
        //---------------------------------------------------

        // Optimal Approach Using sorting

        // TC : O(NlogN) used for sorting
        // SC : O(1)

        String res = new String();

        Arrays.sort(strs);
        String first = strs[0];
        String last = strs[strs.length-1];

        int n = first.length();
        if(last.length()< first.length()) {
            n = last.length();
        }

        for(int i = 0; i < n; i++) {
            if(first.charAt(i) == last.charAt(i)) {
                res = res + first.charAt(i);
            } else {
                break;
            }
        }

        return res;
    }
}