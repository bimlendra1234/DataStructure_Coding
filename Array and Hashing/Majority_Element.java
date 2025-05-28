import java.util.*;
class Solution {
    public int majorityElement(int[] nums) {
        
        /*
        // Brut Force Approach With Non Optimized Hash MAP

        // TC - O(N)
        // SC - O(N)

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

        
        // Optimal Approach

        // TC - O(N)
        // SC - O(1)

        /*
        // Boyer-Moore Voting Algorithm - only work if there is confirm majority number
        
        1. using two variable count = 0 and value = 0
        2. Do single traversal
        3. while looking each number
        4. else on looking each number, if count = 0, change the value to that number and increment the count
        5. if other number is different just decrement the count by 1 ,
        6. if the number is same increment the count by 1.
        6. Finally return the value that is basically the majority number
        */

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