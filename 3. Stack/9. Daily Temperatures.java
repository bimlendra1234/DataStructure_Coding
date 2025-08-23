// Leetcode : 739. Daily Temperatures

import java.util.*;

class Solution {
    public int[] dailyTemperatures(int[] temperatures) {
        
        /*
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
        */

        // -------------------------------------------------------

        // Optimal Approach using stack<Index>
        // TC: O(N)
        // SC: O(N) - for using stack
   

        // *********
        // Approach
        /*
        1. push all the element into stack from back
        2. if peek Temp <= current temp, 
                pop untill we get greater element or the stack is empty
                push that current element index
        3.  if peek Temp > current,
                We found our next greater element index
                distance = peakindex - current index
                update this into res index
                push that current element index as well
        */
        

        // *********
        // Code
        Stack<Integer> st = new Stack<>();
        int[] res = new int[temperatures.length];

        for (int idx = temperatures.length-1; idx >= 0; idx--) {
            int currentTemp =  temperatures[idx];
            // removing all that is lower then current
            while(!st.isEmpty() && temperatures[st.peek()] <= currentTemp) {
                st.pop();
            }
            
            // here when it will definately find greater element
            // i.e when peak is greater then current element
            if(!st.isEmpty()) {
                res[idx] = st.peek() - idx;
            }

            st.push(idx);
        }

        return res;
    }
}