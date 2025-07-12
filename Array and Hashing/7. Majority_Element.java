// Leetcode: 169. Majority Element

import java.util.*;

class Solution {
    public int majorityElement(int[] nums) {
        
        /*
        // Brut Force Approach With Non Optimized Hash MAP
        // TC - O(N)
        // SC - O(N)


        // *********
        // Approach
        // 1. Create a HashMap to store the count of each element
        // 2. Traverse the array and populate the HashMap with counts
        // 3. find the element with count greater than N/2 in The HashMap
        // 4. return the key of that element in the hashmap


        // *********
        // Code
        Map<Integer,Integer> HM = new HashMap<>();

        for (int i = 0; i < nums.length; i++) {
            HM.put(nums[i], HM.getOrDefault(nums[i],0)+1);
        }

        // Traverse the HM
        // Get the maximum Value

        int maxValue = Integer.MIN_VALUE;
        for (Map.Entry<Integer,Integer> entry : HM.entrySet()) {
            if(entry.getValue() >= maxValue && entry.getValue() > nums.length/2) {
                maxValue = entry.getValue();
            }
        }

        // corresponding to that maximum value return the key that is number with majority element.
        for (Map.Entry<Integer,Integer> entry : HM.entrySet()) {
            if(entry.getValue() == maxValue) {
                return entry.getKey();
            }
        }

        return -1;
        */

        // -------------------------------------------------------------------------------------------

        /*
        // Brut Force Approach With Optimized Hash MAP
        // TC - O(N)
        // SC - O(N)


        // *********
        // Code
        Map<Integer,Integer> HM = new HashMap<>();

        // get the max count while inserting itself as well
        // also while doing the same take key value and store it as well with max value.
        int maxValue = Integer.MIN_VALUE;
        int majorityElement = nums[0];


        for (int i = 0; i < nums.length; i++) {
            HM.put(nums[i], HM.getOrDefault(nums[i],0)+1);

            if(HM.get(nums[i]) > maxValue && HM.get(nums[i]) > nums.length/2) {
                maxValue = HM.get(nums[i]); // associated value of key
                majorityElement = nums[i];  // associated key
            }
        }

        return majorityElement;
        */

        // -------------------------------------------------------------------------------------------

        
        // Optimal Approach using Boyer Moore algo
        // TC - O(N)
        // SC - O(1)


        // *********
        // Approach
        /*
        1. maintain majorityElementValue and its count during traversal
            It denotes what is 
                majorityElementValue : at specific position
                count: majorityElement count greater by what number then other at specific position
        2. do one traversal
            If element is same as majorityElement value
                increment the count : it say by what num that majority element is more
            If element is not same as majorityElement value
                if count is 0 : this element become the majority now
                    then update res with that num
                    and increment its count
                if count is not zero : already there are some majority element with positive count
                    so reduce the count
        */


        // *********
        // Code
        int count = 0;
        int majorityElement = 0;

        for (int i = 0; i < nums.length; i++) {
            if (majorityElement == nums[i]) {
                count++;
            }
            else {
                if (count == 0) {
                    majorityElement = nums[i];
                    count++;
                }
                else {
                    count--;
                }
            }
        }
        return majorityElement;
    }
}