import java.util.*;

class Solution {
    public int majorityElement(int[] nums) {
        
        // Brut Force Approach 

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
    }
}