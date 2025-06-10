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

        /*
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
        */

        // ----------------------------------------------------

        // Optimal Approach using Marking as -ve (using array as inpace)

        // TC: O(N)
        // SC: O(1)

        /*
        Approach
        1. preprocess the input array
            if elem <= 0 or >= len+1 then replace elem as lenOfArray+1
        2. mark each index or seat as -ve that means it is already occupied
            Seat = elem -1;
            only mark seat element as -ve if it is already positive
            if elem == lenOfArray+1 thrn ignore
        3. traverse array from first to last and find first positive number
            we get element as index+1 that is our answer so return it
            +ve means that element is missing as not marked
        4.  now since we process all element from 0 to length-1 that is last element
            that means all position in -ve marked 
            so all element from [1 to len] i.e possible answer is present
            so finally our answer will be len+1 
        */

        int lenOfArray = nums.length;
        // preprocessing
        for(int i = 0; i < nums.length; i++) {
            if(nums[i] <= 0 || nums[i] >= lenOfArray+1) {
                nums[i] = lenOfArray+1;
            }
        }

        // Marking as -ve
        for(int i = 0; i < nums.length; i++) {
            int elem = Math.abs(nums[i]);
            if(elem == lenOfArray+1) {
                continue;
            }
            int seat = elem - 1;
            // check because if occour twice then we do not change this sign
            if(nums[seat] > 0) {
                nums[seat] = -nums[seat];
            }
        }

        // find 1st positive number . that is missing number
        for (int i = 0; i < nums.length; i++) {
            if(nums[i] > 0) {
                int seat = i;
                int element = seat+1;
                return element;
            }
        }

        return lenOfArray+1;
     }
}