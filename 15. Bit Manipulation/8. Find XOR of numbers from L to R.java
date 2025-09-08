// Geeks For Geeks : Find XOR of numbers from L to R

// https://www.geeksforgeeks.org/problems/find-xor-of-numbers-from-l-to-r/1

// *********
// Complexity
// TC: O(1) → direct formula using mod 4
// SC: O(1)


// *********
// Approach
/*
    1. fun(n) → gives XOR of all numbers from 1 to n
       - Pattern repeats every 4 numbers:
         if n % 4 == 0 → n
         if n % 4 == 1 → 1
         if n % 4 == 2 → n+1
         if n % 4 == 3 → 0
    2. To get XOR of range [l..r]:
       XOR(l..r) = XOR(0..l-1) ^ XOR(0..r)
                 = fun(l-1) ^ fun(r)

    Implement XOR range query using prefix XOR formula
    Add utility to compute XOR(0..n) with mod-4 pattern
    Optimize XOR of [l..r] using fun(r) ^ fun(l-1)
*/


// *********
// Code
class Solution {
    public static int fun(int n) {
        if(n%4 == 1) return 1;
        else if(n%4 == 2) return n+1;
        else if(n%4 == 3) return 0;
        else {
            return n; // if(n%4 == 0)
        }
    }
    public static int findXOR(int l, int r) {
        return fun(l-1) ^ fun(r);
    }
}