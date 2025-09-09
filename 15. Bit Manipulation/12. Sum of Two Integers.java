// Leetcode : 371. Sum of Two Integers

// *********
// Complexity
// TC: O(1) → Each bitwise operation runs in constant time (limited to 32 bits)
// SC: O(1)


// *********
// Approach
/*
Use bitwise operators to add two integers without using + or -.
- XOR (a ^ b) → gives sum without carry
- AND (a & b) << 1 → gives the carry
- Repeat until carry becomes 0
*/


// *********
// Code
class Solution {
    public int getSum(int a, int b) {
        // b is used as carry
        while(b != 0) {
            int carry = (a & b) << 1; // calculate carry
            a = a ^ b; // add without carry
            b = carry; // update carry
        }
        return a;
    }
}
