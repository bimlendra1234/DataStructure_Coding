// Leetcode: 49. Group Anagrams

import java.util.*;

class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {

        // *********
        // Complexity
        // TC: O(N * K log K) → N = number of strings, K = max length of each string
            //     → for each string, sorting takes O(K log K)
        // SC: O(N * K) → storing all strings in HashMap buckets


        // *********
        // Approach
        /*
            1. Use a HashMap<String, List<String>>.
            2. For each string:
            - Convert to char array and sort it → acts as the key.
            - Insert the original string into the list mapped to this key.
            3. Finally, return all the values of the HashMap as the result list.
*/


        // *********
        // Code
        Map<String, List<String>> HM = new HashMap<>();
        for (String elem : strs) {
            char[] temp = elem.toCharArray();
            Arrays.sort(temp);

            String sortedTemp = new String(temp);
            if(!HM.containsKey(sortedTemp)) {
                HM.put(sortedTemp, new ArrayList<String>());
            }
            HM.get(sortedTemp).add(elem);
        }

        // forming the result from the Hashmap
        List<List<String>> res = new ArrayList<>(HM.values());
        return res;
    }
}