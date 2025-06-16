// Leetcode: 42. Trapping Rain Water

class Solution {
    public int trap(int[] height) {

        // Brut Force Approach, using prefix and suffix extra array
        // TC: O(N)
        // SC: O(N) - For extra prefix and suffix extra array


        // *********
        // Approach
        // 1. use the prefix to calculate leftMax at any element including i
            // traverse from left to right
            // find max value at left , including i as well

        // 2. use suffix to calculate rightMax at any element including i
            // traverse from right to left
            // // find max value at right , including i as well

        // 3. in for loop
            // at anyIndex, find min of (leftMax, rightMax) at that index
            // so amount of water hold value = Min(leftMax, rightMax) - height[i]

        // 4. add all the water hold and finally return it.


        // *********
        // Doubt
        // 1. Why this rightMax[i]) -height[i] is never negative beow
            // Because of how leftMax[] and rightMax[] are constructed.
            // leftMax[i] is the tallest bar on the left including i
            // rightMax[i] is the tallest bar on the right including i
        

        // *********
        // Code

        // Using prefix for leftMax 
        int[] leftMax = new int[height.length];
        leftMax[0] = height[0];
        for(int i = 1; i < leftMax.length; i++){
            leftMax[i] = Math.max(leftMax[i-1], height[i]);
        }

        // use suffix for right max
        int[] rightMax = new int[height.length];
        rightMax[rightMax.length-1] = height[height.length-1];
        for(int i = height.length-2; i>=0; i--) {
            rightMax[i] = Math.max(rightMax[i+1], height[i]);
        }

        // Water collected at each ith bar:
        // Formula: min(leftMax[i], rightMax[i]) - height[i]
        int waterTrapped = 0;
        for(int i = 0; i< height.length; i++) {
            waterTrapped += Math.min(leftMax[i], rightMax[i]) - height[i];
        }

        return waterTrapped;
    }
}