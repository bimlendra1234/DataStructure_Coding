import java.util.Arrays;

class Solution {
    public int firstMissingPositive(int[] nums) {

        // BrutForse Approach with sorting technique 

        // TC: O(NlogN) for sorting
        // SC: O(1)
        
        Arrays.sort(nums);
        int missing = 1; // first positive number

        for(int i = 0; i< nums.length;i++) {
            int current = nums[i];
            if(current > 0 && current == missing) {
                missing++;
            }
        }

        return missing;
     }
}