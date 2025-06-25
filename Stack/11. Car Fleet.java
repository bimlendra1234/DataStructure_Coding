// Leetcode : 853. Car Fleet

import java.util.*;

class Solution {
    public int carFleet(int target, int[] position, int[] speed) {

        // Stack approach using pair speed and time
        // TC: O(NLOGN) - for sorting
        // SC: O(2N) - O(N) - for using extra stack and pair


        // *********
        // Approach
        /*
        1. create pair that will store both position and speed of each car
        2. sort posiotinSpeedPair based on the position
        3. maintain a stack
            will store time to reach target, only in a stack
            if two car in a fleet then it will store single car and remove other
        4. iterate from last 
            calculate time to target and push into the stack
            also 
                If time of current i.e peek <= below of peek 
                    so its a fleet so remove or pop the the current pushed and do not push it into stack
        5. finally return the stack.size
        */


        // *********
        // Doubt
        /*
        1. how to sort pair based on position?
            => Arrays.sort(posiotinSpeedPair, (a,b) -> Integer.compare(b[0], a[0]));
        -----------------------------------------------------------------------------
        2. used to access the second-to-top element of the stack
            i.e element below the peak
            stFleet.get(stFleet.size()-2)

        Java’s Stack is 0-based indexed when accessed by index (like a list or array)
        */

        // create pair that will store both position and speed of each car
        int[][] posiotinSpeedPair = new int[position.length][2];
        for(int i = 0; i < speed.length; i++) {
            posiotinSpeedPair[i][0] = position[i];
            posiotinSpeedPair[i][1] = speed[i];
        }

        // sort posiotinSpeedPair based on the position
        Arrays.sort(posiotinSpeedPair, (a,b) -> Integer.compare(b[0], a[0]));

        // will store time to reach target, only in a fleet
        // if two car in a fleet then it will store single car
        Stack<Double> stFleet = new Stack<>();

        for(int[] p : posiotinSpeedPair) {
            double currentTimeToTarget = (double)(target-p[0])/p[1];
            stFleet.push(currentTimeToTarget);

            // this means do not push or remove if that is fleet to the below one
            // if time of current i.e peek <= below of peek so its a fleet so remove the current and do not push it
            if(stFleet.size() >= 2 && stFleet.peek()<= stFleet.get(stFleet.size()-2)) {
                stFleet.pop();
            }
        }

        return stFleet.size();
    }
}