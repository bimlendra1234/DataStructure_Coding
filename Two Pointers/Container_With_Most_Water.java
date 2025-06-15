// Leetcode: 11. Container With Most Water

class Solution {
    public int maxArea(int[] height) {

        // BrutForce Approach 
            // by calculating max area of each verticle line with other and taking max among all
        // TC: O(N^2)
        // SC: O(1)

        // *********
        // Approach
        // 1. Fore each vertical line, calculate area with respect to all other vertical line
        // 2. Among all area take the maximum one
        // Way to calculate area
            // TotalHeight * TotalBase
            // TotalHeight => minimum of two vertical line (as that much it can hold water)
            // TotalBase => index of 2nd vertical line - index of 1st vertical line.


        // *********
        // Code
        int maxArea = Integer.MIN_VALUE;

        for(int i = 0; i < height.length-1; i++) {
            for(int j=i+1; j < height.length;j++) {
                int min = Math.min(height[i],height[j]);
                int totalHeight = min;
                int totalBase = j-i;
                int area = totalHeight*totalBase;
                maxArea = Math.max(maxArea,area);
            }
        }

        return maxArea;
    }
}