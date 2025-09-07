// Leetcode : 136. Single Number

// BrutForce Approach using HashMap

// *********
// Complexity
// TC: O(N) → iterate once to fill hashmap + O(N) to scan hashmap
// SC: O(N) → hashmap stores frequency of elements


// *********
// Approach
/*
    1. Create a hashmap to store frequency of each number.
    2. Iterate over nums → update count in hashmap.
    3. Iterate over hashmap keys → return the element with frequency = 1.
    4. If none found, return -1.
*/


// *********
// Code
class Solution {
    public int singleNumber(int[] nums) {
        
        Map<Integer, Integer> HM = new HashMap<>();
        for(int i = 0 ; i < nums.length; i++) {
            HM.put(nums[i], HM.getOrDefault(nums[i],0)+1);
        }

        for(int key : HM.keySet()) {
            int val = HM.get(key);
            if(val == 1) {
                return key;
            }
        }
        return -1;
    }
}