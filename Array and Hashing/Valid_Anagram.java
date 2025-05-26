import java.util.*;

class Solution {
    public boolean isAnagram(String s, String t) {
        
        /*
         // Brut Force approach
         
         // TC = O(NlogN + MLogM) used while sorting both the s1 and t1 string below.
         // SC = O(1)
         
         // convert to char Array
         // Sort both the Array

         // change both back to string
         // compare both the string

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
        
        // Optimal Approach

        // TC = O(N+M)
        // SC = O(N+M) or O(1) since we have at most 26 different character

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