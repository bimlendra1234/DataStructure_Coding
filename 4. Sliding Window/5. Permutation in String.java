// Leetcode: 567. Permutation in String

import java.util.*;

class Solution {
    public boolean checkInclusion(String s1, String s2) {

        // Approach using sliding window technique and count
        // TC: O(N)
        // SC: O(26)-> O(1)


        // *********
        // Approach:
        /*
        1. Maintain two arrays: tempArr1 for s1 character counts and tempArr2 for s2 character counts.
        2. Fill tempArr1 with the counts of characters from s1.
        3. Use Sliding Window (SW) technique on s2:
        4. Initialize 'start' as 0 for the window's starting index in s2.
        5. Traverse s2 using a for loop with 'end' pointer:
            ➔ For each character at 'end', increase its count in tempArr2.
                until WS is not equal to s1.length()
            ➔ Once the window size (ws = end - start + 1) equals s1.length():
                a. Compare tempArr1 and tempArr2:
                    ➔ If both are equal → return true (found a valid permutation).
                b. Otherwise:
                    ➔ Decrease the count of character at 'start' in tempArr2 (sliding out of window).
                        added end element already above
                    ➔ Increment 'start' to shrink the window back to correct size.
        6. If no matching window is found after the loop, return false.
        */


        // *********
        // Doubt
        /*
        1. instead of count Array: index(character) -> count(value)
            int[] tempArr1 = new int[26];  
            
            => we can also use hashmap => ch: count
            Map<Character, Integer> HM = new HashMap<>();
        */


        // *********
        // Code

        // store count for s1
        int[] tempArr1 = new int[26];
        for(int i =0; i < s1.length(); i++) {
            tempArr1[s1.charAt(i)-'a']++;
        }

        // store count for s2
        int[] tempArr2 = new int[26];
        int start = 0;
        for(int end = 0; end< s2.length(); end++) {
            int ws = end-start+1;
            tempArr2[s2.charAt(end)-'a']++; // push each element count in temArray2

            if(ws == s1.length()) { // once window size is equal to s1.length()
                if(Arrays.equals(tempArr1, tempArr2)) {
                    return true; // check both array are same if yes return true
                }
                // other wise here added end as above, removed start, increased start by 1
                // i.e shrinked the window size to 2 and slided forward
                tempArr2[s2.charAt(start)-'a']--;
                start++;
            }
        }
        return false;
    }
}