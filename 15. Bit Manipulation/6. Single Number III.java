// Leetcode : 260. Single Number III

// BrutForce approach using hashMap
class Solution {
    public int[] singleNumber(int[] nums) {
        
        Map<Integer, Integer> HM = new HashMap<>();
        for(int i = 0 ; i < nums.length; i++) {
            HM.put(nums[i], HM.getOrDefault(nums[i],0)+1);
        }

        int[] res = new int[2];
        int i = 0;
        for(int key : HM.keySet()) {
            int val = HM.get(key);
            if(val == 1) {
                res[i++] = key;
            }
        }
        return res;
    }
}

// ----------------------------------------------------

// Optimal Approach using concept ofbuckets and bits manipulation

// *********
// Complexity
// TC: O(N) → one pass to XOR + one pass to split into buckets
// SC: O(1) → only constant extra variables used


// *********
// Approach
/*
    1. XOR all numbers → result = xor of the two unique numbers (since duplicates cancel out).
    2. Find rightmost set bit from xor (different bit between the two unique numbers).
    3. Partition numbers into two buckets:
        - If bit set → XOR into bucket1
        - Else → XOR into bucket2
    4. Each bucket cancels duplicates inside it → leaving one unique number each.
    5. Return {bucket1, bucket2}.
*/


// *********
// Code
class Solution {
    public int[] singleNumber(int[] nums) {
        
        long xorr = 0;
        for(int i = 0; i < nums.length; i++) {
            xorr = xorr ^ nums[i]; // all will be 0 except // xor of two distinct numbers remains
        }

        long rightMostThatisSet = (xorr & (xorr-1)) ^ xorr;
        int bucket1 = 0;
        int bucket2 = 0;

        for(int i = 0; i < nums.length; i++) {
            if((rightMostThatisSet & nums[i]) != 0) {
                bucket1 = bucket1 ^ nums[i];
            }
            else {
                bucket2 = bucket2 ^ nums[i];
            }
        }

        return new int[]{bucket1, bucket2};


    }
}