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
    }
}