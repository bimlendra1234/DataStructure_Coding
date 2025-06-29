// Leetcode: 84. Largest Rectangle in Histogram

import java.util.Stack;

class Solution {
    public int largestRectangleArea(int[] heights) {

        // Optimal Approach using stack
        // TC: O(2N) => O(N) for doint one pass to main array and one pass to the stack
        // SC: O(N) for using the stack


        // *********
        // Approach
        /*
        1. if can be extended from left to right
            i.e peak height is smaller then currenti.e right height is bigger then left  
                then push index and height to the stack
        2. if cant be extended from left to right
            i.e peak height is bigger then current i.e rght is smaller then left
                pop the peak element and store its index and height
                calc area as = height * base
                    // base = i- index
                update maxArea if calc area is greater

                extend to left once peek is ppoped to its index
                so start = index that need to be pushed into stack
        3. traverse the remained stack one by one and calc area and
            will get index and height;
            calc area = height * base
                // base = heights.length - index
        */


        // *********
        // Doubts
        /*
        1. st.push(new int[]{start, heights[i]}) is same as below 

        =>  int[] arr = new int[2];
            arr[0] = start;
            arr[1] = heights[i];
            st.push(arr);
        */


        // *********
        // Code
        int maxArea = 0;
        Stack<int[]> st = new Stack<>(); //index and height

        for(int i = 0; i < heights.length; i++) {
            int start = i;
            // if cant be extended i.e next bar is smaller
            while(!st.isEmpty() && heights[i] < st.peek()[1]){
                // need to pop the top
                int[] top = st.pop();
                int index = top[0];
                int height = top[1];
                maxArea = Math.max(maxArea, height * (i-index));
                // adjust the index that need to be pushed if pooped i.e previous index
                // i.e extending to left
                start = index;
            }
            // if can be extended
            st.push(new int[]{start, heights[i]});
        }

        // check if in the remaining stack can generate maxArea
        for(int[] pair : st) {
            int index = pair[0];
            int height = pair[1];
            // (heights.length-index) is extendible base
            maxArea = Math.max(maxArea, height * (heights.length-index)); 
        }

        return maxArea;
    }
}