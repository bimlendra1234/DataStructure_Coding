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

// ----------------------------------------------------

// *********
// Complexity
// TC: O(31) → shift until all bits checked
// SC: O(1) → only counter variable used


// *********
// Approach
/*
    1. Use (n & 1) to check last bit → adds 1 if set.
    2. Right shift n (n >> 1) to move to next bit.
    3. Repeat until n becomes 0.
    4. Count keeps track of number of 1 bits.
*/

/*
    1. n & 1 => return 1 for odd and return 1 for even
    2. n/2 => n>>1
*/

// *********
// Code
class Solution {
    public int hammingWeight(int n) {
        
        /*
        int count = 0;
        while(n>1) {
            if(n%2 == 1) { // this means checking odd
                count++;
            }
            n = n/2; // dividing by 2
        }
        if(n == 1) {
            count++;
        }
        return count;
        */

        int count = 0;
        while(n>1) {
            count += n&1; // // this means checking odd
            n = n >> 1; // dividing by 2
        }
        if(n == 1) {
            count++;
        }
        return count;
    }
}