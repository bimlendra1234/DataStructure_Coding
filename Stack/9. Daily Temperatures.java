// Leetcode : 739. Daily Temperatures

import java.util.*;

class Solution {
    public int[] dailyTemperatures(int[] temperatures) {
        
        // BrutForce Approach using two for loop
        // TC: O(N^2)
        // SC: O(1)
   

        // *********
        // Approach
        // 1. for each element check one by one all in remaining array
            // using two for loop
        // 2. when (temperatures[j] > temperatures[current])
            // increase count 
            // set that count in res array in that index
            // break from the loop
        // 3. when (temperatures[j] <= temperatures[current])
            // just increase the count
            // but do not set at the index
                // only set count at index when we will find higher temperature.
        

        // *********
        // Code
        int[] res = new int[temperatures.length];
        res[res.length-1] = 0;

        for (int i = 0; i < temperatures.length-1; i++) {
            int count = 0;
            for (int j = i+1; j < temperatures.length; j++) {
                if (temperatures[j] <= temperatures[i]) {
                    count++;
                }
                else{
                    // when (temperatures[j] > temperatures[i])
                    count++;
                    res[i] = count;
                    break;
                }
            }
        }

        return res;
    }
}