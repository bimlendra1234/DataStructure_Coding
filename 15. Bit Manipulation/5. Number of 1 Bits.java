// Leetcode : 191. Number of 1 Bits

// *********
// Complexity
// TC: O(31) → constant time, check each bit position
// SC: O(1) → only counter variable used


// *********
// Approach
/*
    1. Initialize count = 0.
    2. Loop over 31 bits (for signed int in Java).
    3. For each bit, check if (n & (1 << i)) is non-zero → bit is set.
    4. If set, increment count.
    5. Return count.
*/


// *********
// Code
class Solution {
    public int hammingWeight(int n) {
        
        int count = 0;
        for(int i = 0; i < 31; i++) {
            if((n & 1<<i) != 0) {
                count++;
            }
        }
        return count;
    }
}