// 1486. XOR Operation in an Array

// *********
// Complexity
// TC: O(N) → iterate through n numbers
// SC: O(1) → only one result variable used


// *********
// Approach
/*
    1. Initialize res = 0.
    2. For each index i from 0 → n-1:
        - numAtI = start + 2*i
        - res = res ^ numAtI
    3. Return res as final XOR of the sequence.
*/


// *********
// Code
class Solution {
    public int xorOperation(int n, int start) {
        
        int res = 0;

        for(int i = 0; i < n ; i++) {
            int numAtI = start + 2 * i;
            res = res ^ numAtI;
        }

        return res;
    }
}