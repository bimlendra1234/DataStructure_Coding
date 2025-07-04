// Leetcode : 76. Minimum Window Substring

import java.util.*;

class Solution {
    public String minWindow(String s, String t) {

        // Approach using sliding window technique
        // TC: O(N) - one traversal
        // SC: O(N) for two HM


        // *********
        // Approach
        /*
        1. maintain two HM(tHM , sHM) to store count of t and each window s
        2. put all count in t
        3. maintain minLength and its index of WS that has our answer
        4. initially have = 0; need = tHM.length()
        5. Sliding window with start = 0 and one traversal using for loop - end
        6. put end elem and its count in sHM
        7. check if that end element exist in tHM and count is same in both HM of this end element
            if count in both HM same then increase have by 1
        8. now check have == need (do until we get either min result or this break so we can add next and check)
            if true the we got our result
            if ws is less the minLength that is our smallest result
            so save that index start, end and 
            also save minLength = ws

            now shrink ws and check other min answer is possible
            remove start elem from sHM
                if removed check if that removed elem exist in tHM and its count in sHM is less then in tHM
                    then reduce have count by -1
                increase the start by 1    
        9. if we never found answer then
            this value never get change : resLengthMin = Integer.MAX_VALUE so return empty string

            otherwise return s.substring(resIndex[0], resIndex[1]+1)
        */


        // *********
        // Code
        if (t.isEmpty()) return "";
        
        Map<Character, Integer> tHM = new HashMap<>();
        for(int i = 0; i < t.length(); i++) {
            char ch = t.charAt(i);
            tHM.put(ch, tHM.getOrDefault(ch,0)+1);
        }

        Map<Character, Integer> sHM = new HashMap<>();
        int have = 0, need = tHM.size();
        int[] resIndex = new int[2]; // will store min index
        int resLengthMin = Integer.MAX_VALUE; // will store min length of ans window
        
        // Slidind window
        int start=0;
        for(int end = 0; end < s.length(); end++) {
            char ch = s.charAt(end);
            sHM.put(ch, sHM.getOrDefault(ch,0)+1);

            // now check if this ch count in sHM is less then or equal to in tHM
            // if yes then increment need count by 1
            // not this sHM.get(ch) >= tHM.get(ch) but == because have compare distinct count in both
            if(tHM.containsKey(ch) && sHM.get(ch).equals(tHM.get(ch))) {
                have++;
            }

            // now check if have == need
            // do below until we find min length
            while(have == need) {
                // save the result if it the minimum length then above
                int ws = end-start+1; // this windowsize have all the answer
                if(ws < resLengthMin) {
                    // save min length and its index - as this is the minimum one
                    resLengthMin = ws;
                    resIndex[0] = start;
                    resIndex[1] = end;
                }
                
                // shrink from start to check if even other min are possible
                sHM.put(s.charAt(start), sHM.getOrDefault(s.charAt(start),0)-1);
                // after removing start check if this specific condition become invalid 
                // then we need to reduce have by 1
                if(tHM.containsKey(s.charAt(start)) && sHM.get(s.charAt(start)) < tHM.get(s.charAt(start))) {
                    have--;
                }
                start++;
                
            }
        }
        // if we never found answer then
        // this value never get change : resLengthMin = Integer.MAX_VALUE
        return resLengthMin == Integer.MAX_VALUE ? "" : s.substring(resIndex[0], resIndex[1]+1);
    }
}