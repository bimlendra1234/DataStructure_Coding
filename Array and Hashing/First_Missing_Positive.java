import java.util.*;

class Solution {
    public int firstMissingPositive(int[] nums) {

        /*
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
        */

        // ----------------------------------------------------

        // Approach using HashSet

        // TC: O(N)
        // SC: O(N)
        
        // Approach
        // 1. create a HashSet to store all positive numbers
        // 2. iterate through the array and add all positive numbers to the set
        // 3. initialize a variable missing to 1 (the first positive number)
        // 4. while missing is in the set, increment missing by 1
        // 5. return missing

        // Doubt in iterating hash map - similar to array : // HS.contains(missing)
        // or for (int num : HS) {

        // in set we can directly check if the number is present or not
        // in the constant time complexity O(1)
        Set<Integer> HS = new HashSet<>();

        for(int num : nums) {
            if(num > 0) {
                HS.add(num);
            }
        }

        int missing = 1;
        for (int num : HS) {
            if(num == missing){
                missing++;
            }
        }

        return missing;

     }
}