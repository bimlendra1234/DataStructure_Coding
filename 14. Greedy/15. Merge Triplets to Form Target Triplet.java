// Leetcode : 1899. Merge Triplets to Form Target Triplet

// *********
// Complexity
// TC: O(N) → iterate all triplets once
// SC: O(1) → only constant size array used


// *********
// Approach
/*
    1. Track max value we can achieve for each of the 3 positions.
    2. For each triplet:
        - Only consider if it doesn’t exceed the target in any position.
        - Update max values accordingly.
    3. At the end, check if max values match the target.
*/


// *********
// Observation
/*
    at the same index in each element and target => if the value is greater then target value
        then that triplet is of no use for us 

    At each index (0, 1, 2), if a triplet’s value exceeds the target’s value at the same index →
    that triplet can never help us form the target, because merging only takes maximums.

    So such a triplet is of no use and we just skip it.

    That’s why in your code we only consider triplets where:
    triplet[0] <= target[0] && triplet[1] <= target[1] && triplet[2] <= target[2]

    This ensures we only use “valid” triplets that can contribute to reaching the target without overshooting.
*/


// *********
// Code
class Solution {
    public boolean mergeTriplets(int[][] triplets, int[] target) {
        int[] maxValue = new int[3];

        for(int[] triplet : triplets) {
            if(triplet[0] <= target[0] && triplet[1] <= target[1] && triplet[2] <= target[2]) {
                maxValue[0] = Math.max(maxValue[0], triplet[0]);
                maxValue[1] = Math.max(maxValue[1], triplet[1]);
                maxValue[2] = Math.max(maxValue[2], triplet[2]);
            }
        }

        if(maxValue[0] == target[0] && maxValue[1] == target[1] && maxValue[2] == target[2]) {
            return true;
        }
        return false;
    }
}