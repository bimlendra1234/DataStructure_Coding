// Leetcode : 2220. Minimum Bit Flips to Convert Number

// BrutForce Approach : Comparing each bit

// *********
// Complexity
// TC: O(n) → n = max length of binary strings
// SC: O(n) → padded strings stored

// *********
// Approach
/*
    1. Convert start and goal into binary strings
    2. Find the max length between both
    3. Pad both strings with leading zeros so indices align
    4. Iterate from right to left, compare each bit
    5. Increment flipCount when bits differ
    6. Return flipCount
*/

// *********
// Code
class Solution {
    public int minBitFlips(int start, int goal) {
        
        String startBinary = Integer.toBinaryString(start);
        String goalBinary = Integer.toBinaryString(goal);

        int n = 0;
        if(startBinary.length() > goalBinary.length()) {
            n = startBinary.length();
        }
        else {
            n = goalBinary.length();
        }

        /*
            String.format("%5s", "101")
            result = "  101"   (2 spaces + "101")
            " 101" → "00101"
        */

        // Pad left with zeros so indices align
        startBinary = String.format("%" + n + "s", startBinary).replace(' ', '0');
        goalBinary  = String.format("%" + n + "s", goalBinary).replace(' ', '0');

        int lastPointer = n-1;
        int flipCount = 0;
        for(int i = lastPointer; i >=0; i--) {
            if(i < startBinary.length() && i < goalBinary.length()) {
                if(startBinary.charAt(i) != goalBinary.charAt(i)) {
                    flipCount++;
                }
            }
        }
        return flipCount;
    }
}