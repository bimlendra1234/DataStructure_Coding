// Leetcode: 424. Longest Repeating Character Replacement

import java.util.*;

class Solution {
    public int characterReplacement(String s, int k) {

        // BrutForce Approach using sliding window
        // TC: O(N*26)
        // SC: O(26)


        // *********
        // Approach
        // 1. Maintain hashmap to check freq count of characters in the current window.
        // 2. first element at start = 0
        // 3. Traverse each character (end pointer) one by one.
        // 4. Update the character's frequency count in the hashmap.
            // save maximum frequency count of any character in the current window.
            // maxfc = Math.max(maxfc, count.get(s.charAt(end)));
        // 5. Check if the window is valid:
             // If (window size - most frequent character count) <= k → valid window.
             // (window size - most frequent count) gives the minimum number of replacements needed.
             // If valid, update res with the maximum window size.
        // 6. if invalid window
            // Decrease the frequency count of the character at the 'start' position.
            // Move start pointer right by 1 (shrink the window).
        // 7. After traversal, return res.


        // *********
        // Code
        Map<Character, Integer> count = new HashMap<>();
        int res = 0;

        int start = 0;
        for(int end = 0; end < s.length(); end++) {
            count.put(s.charAt(end), count.getOrDefault(s.charAt(end),0)+1);

            int ws = end-start+1;
            int fc = 0;
            for(char ch : count.keySet()) {
                fc = Math.max(fc, count.get(ch));
            }

            if(ws-fc <= k) { // valid window
                res = Math.max(res, ws);
            } else { // invalid window
                count.put(s.charAt(start), count.get(s.charAt(start))-1);
                start++;
            }
        }
        return res;

        // ---------------------------------------------------------------

        /*
         // Optimal code for above approach - sliding window with hashmap
        // TC: O(N)
        // SC: O(26) - O(1)


        // *********
        // Approach
        
        // 1. Same Above approach
            // just optimized the maxFrequency count so thst we dont have to run this again and again

            // int fc = 0;
            // for(char ch : count.keySet()) {
                // fc = Math.max(fc, count.get(ch));
            // }
        


        // *********
        // Code
        Map<Character, Integer> count = new HashMap<>();
        int res = 0;

        int start = 0;
        int maxfc = 0;
        for(int end = 0; end < s.length(); end++) {
            count.put(s.charAt(end), count.getOrDefault(s.charAt(end),0)+1);

            int ws = end-start+1;
            maxfc = Math.max(maxfc, count.get(s.charAt(end)));

            if(ws-maxfc <= k) { // valid window
                res = Math.max(res, ws);
            } else { // invalid window
                count.put(s.charAt(start), count.get(s.charAt(start))-1);
                start++;
            }
        }
        return res;
         */

         // ---------------------------------------------------------------

        /*
         // Optimal code for above approach - sliding window with array instead of hash map
        // TC: O(N)
        // SC: O(26) - O(1)


        // *********
        // Approach
        // 1. Same Above approach using array instead of hash map
            // just optimized the maxFrequency count so thst we dont have to run this again and again


        // *********
        // Doubt
        // Why subtract 'A'?
            Characters in Java are stored using their ASCII/Unicode values.
            'A' has a value of 65
            'B' is 66
            'C' is 67
            ... and so on up to 'Z' which is 90.
            so, s.charAt(right) - 'A' → converts 'A' to 0, 'B' to 1, ..., 'Z' to 25.


        // *********
        // Code
        int[] freq = new int[26];
        int res = 0;

        int start = 0;
        int maxfc = 0;
        for(int end = 0; end < s.length(); end++) {
            freq[s.charAt(end) - 'A']++;

            int ws = end-start+1;
            maxfc = Math.max(maxfc, freq[s.charAt(end) - 'A']);

            if(ws-maxfc <= k) { // valid window
                res = Math.max(res, ws);
            } else { // invalid window
                freq[s.charAt(start) - 'A']--;
                start++;
            }
        }
        return res;
         */

    }


}