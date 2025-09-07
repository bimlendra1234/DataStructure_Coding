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

// ----------------------------------------------------

// Optimal Approach using XOR operation

// *********
// Complexity
// TC: O(N) → iterate through nums once
// SC: O(1) → only one integer variable used


// *********
// Approach
/*
    1. Initialize XOR = 0.
    2. For each element in nums:
        - Do XOR with current element.
        - Property: a ^ a = 0 and a ^ 0 = a.
    3. At the end, all duplicate numbers cancel out → only unique element remains.
*/


// *********
// Code
class Solution {
    public int singleNumber(int[] nums) {
        
        int XOR = 0;

        for(int i = 0; i < nums.length; i++) {
            // XOR of two number is zero i.e a^a = 0
            XOR = XOR ^ nums[i];
        }
        return XOR;
    }
}