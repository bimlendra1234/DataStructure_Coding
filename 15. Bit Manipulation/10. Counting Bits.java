// Leetcode : 338. Counting Bits

// *********
// Complexity
// TC: O(nlogn)
// SC: O(N) → result array


// *********
// Approach
/*
1. Create an array res of size n+1 to store count of set bits for each number.
2. For every number from 0 to n:
     - Iterate over all 31 bits.
     - If ith bit is set in num → increment res[num].
3. Return res as the final answer.
*/


// *********
// Code
class Solution {
    public int[] countBits(int n) {
        int[] res = new int[n+1];

        for(int num = 0; num <= n; num++) {
            for(int i = 0; i < 31; i++) {
                if((num & (1<<i)) != 0) {
                    res[num]++;
                }
            }
        }
        return res;
    }
}