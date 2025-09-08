// Leetcode : 29. Divide Two Integers

// *********
// Complexity
// TC: O(log²N) → for each subtraction we may scan powers of 2 (logN), and at most logN subtractions
// SC: O(1)


// *********
// Approach
/*
1. Handle special cases:
   - If dividend == divisor → return 1
   - If dividend == MIN_VALUE and divisor == -1 → return MAX_VALUE (overflow)
2. Determine the sign based on dividend/divisor signs.
3. Convert both dividend and divisor to positive longs to avoid overflow.
4. While dividend (n) >= divisor (d):
      - Find the maximum shift (count) such that (d << (count+1)) ≤ n.
      - Add 1<<count to answer.
      - Subtract (d << count) from n.
5. Clamp to MAX/MIN if ans exceeds 2^31.
6. Return answer with the correct sign.
*/


// *********
// Code
class Solution {
    public int divide(int dividend, int divisor) {
        
        if (dividend == divisor) {
            return 1;
        }

        // determine sign
        boolean sign = true;
        if((dividend >= 0 && divisor < 0) || (dividend < 0 && divisor > 0)) {
            sign = false;
        }

        long n = Math.abs((long)dividend);
        long d = Math.abs((long)divisor);
        long ans = 0;

        while(n >= d) {
            int count = 0;
            // finding max power that can be removed
            while(n >= (d << (count+1))) {
                count++;
            }
            ans += (1L << count);
            n -= d * (1L << count);
        }

        if(ans >= (1L << 31) && sign == true) {
            return Integer.MAX_VALUE;
        }

        if(ans >= (1L << 31) && sign == false) {
            return Integer.MIN_VALUE;
        }

        return sign ? (int)ans : (int)-ans;
    }
}