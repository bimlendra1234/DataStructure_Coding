// Leetcode : 3. Longest Substring Without Repeating Characters

import java.util.*;

class Solution {
    public int lengthOfLongestSubstring(String s) {

        // Optimal Approach Using Sliding Window Technique
        // TC: O(N)
        // SC: O(N) for hashMap


        // *********
        // Approach
        /*
        1. Use Hashmap for each character and boolean true to know if it already exist
        2. if ch not in HM, put in the HM with true and calculate window size
            update longestSubString to window size if it is greater then longestSubString
        3. if ch already in HM that means there is now duplicate
        4. run the while loop till this ch:true is in HM
            inside, remove element one by one from start until that duplicate element is removed
                i.e it become false
            increase start
        5. outside while loop at last, set CH: true to denote its already seen
            it denotes that it is not duplicate now
        6. finally return longestSubString
        */
        

        // *********
        // Code
        
        // take HM to identify if element already exist in the substring
        Map<Character, Boolean> HM = new HashMap<>();
        int longestLen = 0;

        int start = 0;
        for (int end = 0; end < s.length(); end++) {
            char endCharacter = s.charAt(end);

            // if ch do not contain in HM
            if (!HM.getOrDefault(endCharacter, false)) {
                HM.put(endCharacter, true);
                int windowSize = end - start + 1;
                longestLen = Math.max(longestLen, windowSize);

            } else {
                // if ch contain in HM
                // remove ch begining from start untill duplicate is removed from HM
                // i.e it becomes false inside HM
                while (HM.get(endCharacter)) {
                    HM.put(s.charAt(start), false);
                    start = start + 1;
                }
                // now add that end character so that its in new substring, old one is already removed
                HM.put(endCharacter, true);
            }
        }
        return longestLen;
    }
}