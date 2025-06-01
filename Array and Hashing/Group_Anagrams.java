import java.util.*;

class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {

        // TC: O(N) i.e one for loop
        // SC: O(N) for using the hashmap

        /* 
        // Approach
        1. take a Hashmap to strore sorted string and list of all anagram in array
        2. traverse each string one by one inside the array
        3. now for each string, conver to charArray, sort it and change back to string
        4. now if that sorted string do not contains inside HM then. 
            push sorted string as key and one empty Arraylist
        5. finally push that string as
            in HM get that sorted key value and add it here. now mine HM work is done
        6. now i need to return the result that is List<List<String>> i.e i will have 
            Arraylist and inside that all the list that we get from key and this are all anagram
        7. how to do 6 step is create new ArrayList and inside that put all HM.values();
        */

        Map<String, List> HM = new HashMap<>();
        for (String elem : strs) {
            char[] temp = elem.toCharArray();
            Arrays.sort(temp);

            String sortedTemp = new String(temp);
            if(!HM.containsKey(sortedTemp)) {
                HM.put(sortedTemp, new ArrayList());
            }
            HM.get(sortedTemp).add(elem);
        }

        // forming the result from the Hashmap
        ArrayList res = new ArrayList(HM.values());
        return res;
    }
}