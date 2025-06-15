// Leetcode: 11. Container With Most Water

class Solution {
    public int maxArea(int[] height) {
        /*
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
        */

        // ----------------------------------------------------------------
        
        // Optimal Approach using two pointer method
        // TC: O(N)
        // SC: O(1)


        // *********
        // Approach
        /*
        1. Maintain two pointer left at 0 and right at last element
        2. calculte area between these two
            set initial area to min value, along the process store the max area 
        3. now for shifting the pointer
            if left < right, do left++
            if right <= left, do right--
        4. finally return max area, that we saved long all the area.
        */


        // *********
        // Doubt
        /*
        1. why only till left<right?

            Area = min(height[left], height[right]) × (right - left)
            So, I always do
                Keep width high (initially large)
                and Increase min height by moving the shorter side inward

            This strategy ensures that every better area that could possibly exist is considered, 
            and nothing is missed.

        ------------------------------------------------------------------------------
        2. how to understand when to do left++ and right--, i.e shifting the pointer.?

             Always move the pointer at the shorter height, 
             because only that gives a chance of increasing minHeight 
                (the limiting factor for area) i.e MinHeight * base.

            Moving the larger pointer doesn't help because the shorter height limits the container.

            When height[left] < height[right] => do left++ 
                Because left is the bottleneck; move it to possibly get a taller line

            When height[left] >= height[right] => do right-- 
                Because right is the bottleneck; move it to possibly get a taller line
        */


        // *********
        // Code
        int left = 0;
        int right = height.length-1;

        int area = Integer.MIN_VALUE;
        while(left < right) {
            int min = Math.min(height[left], height[right]);
            int base = right-left;
            area = Math.max(area, min*base);
            
            if(height[left]< height[right]) {
                left++;
            }
            else {
                // in case if height[left]>= height[right]
                right--;
            }
        }
        return area;
    }
}