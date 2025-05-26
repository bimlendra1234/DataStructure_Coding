import java.util.Arrays;

class Solution {
    public boolean isAnagram(String s, String t) {
         // Brut Force approach
         // TC = O(NlogN) used while sorting both the s1 and t1 string below.
         
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


    }
}