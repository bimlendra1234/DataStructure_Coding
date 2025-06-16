// Leetcode: 42. Trapping Rain Water

class Solution {
    public int trap(int[] height) {
        /*
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
        */

        // -----------------------------------------------------------------

        // Optimal Approach Using two pointer Method
        // TC: O(N)
        // SC: O(1)


        // *********
        // Approach
        /*
        doing above brutforce approach usng two pointer method
            calculating leftMax using left pointer
            calculating rightMax using right pointer
        
        1. maintain left pointer to left most element
            also that is our leftMax element for now

        2. maintain right pointer to right most element
            also that is our rightMax element for now

        3. which pointer to move
            // which ever (leftMax or rightMax) is minimum (whichever side moved calculate that side only)

            a. if leftMax < rightMax
                do left++
                update leftMax to max (leftMax, height[left])
                calculate waterCollected at that pointer as => leftMax - height[left];

            b. else if rightMax < leftMax
                do right--
                update rightMax to max(rightMax, height[right])
                calculate waterCollected at that pointer as => rightMax - height[right]
        */


        // *********
        // Code
        int left = 0; int leftMax = height[left];
        int right = height.length-1; int rightMax = height[right];
        int waterTrapped = 0;
        
        while (left < right) {
            if(leftMax <= rightMax) {
                left++;
                leftMax = Math.max(leftMax, height[left]);
                waterTrapped += leftMax - height[left];
            }
            else {
                // when rightMax < leftMax
                right--;
                rightMax = Math.max(rightMax, height[right]);
                waterTrapped += rightMax - height[right];
            }
        }

        return waterTrapped;
    }
}