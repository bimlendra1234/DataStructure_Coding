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
        1. Use hashmap for each character and boolean trueto know if already exist
        2. if ch not in HM, put in the HM with true and calculate window size
            update longestSubString to window size f it is greater then longestSubString
        3. if ch already in HM that means there is now duplicate
        4. run the while loop till this ch:true is in HM
            inside, now shring the window by
            setting start element to false in HM and increase start
        5. outside while loop at last, set CH: true to denote its already seen
        6. finally return longestSubString
        */
        

        // *********
        // Code
        
        // Hashmap that will take Each character and boolean
        Map<Character, Boolean> HM = new HashMap<>();

        int longestSubString = 0;
        int start = 0;

        for(int end = 0; end < s.length(); end++) {
            char ch = s.charAt(end);
            if(!HM.getOrDefault(ch,false)) {
                HM.put(ch, true);
                longestSubString = Math.max(longestSubString, end-start+1);
            }
            else{
                while(HM.get(ch)) {
                    HM.put(s.charAt(start),false);
                    start++;
                }
                HM.put(ch,true);
            }
        }
        return longestSubString;
    }
}