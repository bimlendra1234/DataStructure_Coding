// Leetcode : 763. Partition Labels

// *********
// Complexity
// TC: O(N) → one pass to map last index + one pass to partition
// SC: O(1) → hashmap holds only 26 chars max


// *********
// Approach
/*
    1. Build a map storing each character’s last index in the string.
    2. Traverse the string:
        - Track the farthest end index of current partition.
        - Increase current size for each character.
        - If current index == farthest end, close partition and reset size.
    3. Collect all partition sizes and return.
*/


// *********
// Code
class Solution {
    public List<Integer> partitionLabels(String s) {

        // 1. Map store character and its last index
        Map<Character, Integer> HMLastIndex = new HashMap<>();
        for(int i = 0; i < s.length(); i++) {
            HMLastIndex.put(s.charAt(i), i);
        }

        // 2. iterate over each character, update end index 
            // and when current char index is equal to end index push into res and reset
        List<Integer> res = new ArrayList<>();
        int currSize = 0;
        int end = 0;
        for(int i = 0; i < s.length(); i++) {
            currSize++;
            end = Math.max(end, HMLastIndex.get(s.charAt(i)));

            if(i == end) {
                res.add(currSize);
                currSize = 0;
            }
        }
        return res;
    }
}