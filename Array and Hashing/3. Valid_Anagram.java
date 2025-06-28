// Leetcode : 242. Valid Anagram

import java.util.*;

class Solution {
    public boolean isAnagram(String s, String t) {
        
        /*
         // Brut Force approach
         // TC = O(NlogN + MLogM) used while sorting both the s1 and t1 string below.
         // SC = O(1)
         

         // *********
         // Approach
         //1. convert to char Array
         //2. Sort both the Array
         //3. change both back to string
         //4. compare both the string


         // *********
         // Code
         char[] s1 = s.toCharArray();
         Arrays.sort(s1);
         String sString = new String(s1);

         char[] t1 = t.toCharArray();
         Arrays.sort(t1);
         String tString = new String(t1);

         if (sString.equals(tString)) {
            return true;
         }

         return false;
         */

        // -----------------------------------
        
        // Optimal Approach using two hashmap
        // TC = O(N+M)
        // SC = O(N+M) or O(1) since we have at most 26 different character


        // *********
        // Approach
        /*
        1. track 2 hashmap for both s and t
        2. put each character count in HM for both string
        3. Finally Compare value of both the hashmap i.e similar like strings
        4. return true if both are same else return false
        */


        // *********
        // Code
        if(s.length() != t.length()) {
            return false;
        }

        Map<Character, Integer> sCountHM = new HashMap<>();
        Map<Character, Integer> tCountHM = new HashMap<>();

        // put each character count in HM for both string
        for (int i =0; i< s.length(); i++) {
            sCountHM.put(s.charAt(i), sCountHM.getOrDefault(s.charAt(i), 0) + 1);
            tCountHM.put(t.charAt(i), tCountHM.getOrDefault(t.charAt(i), 0) + 1);
        }

        // Compare value of both the hashmap i.e similar like strings
        return sCountHM.equals(tCountHM);


    }
}