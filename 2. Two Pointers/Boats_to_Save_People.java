// Leetcode : 881. Boats to Save People


import java.util.Arrays;

class Solution {
    public int numRescueBoats(int[] people, int limit) {
        
        // Optimal Approach : greedy with two pointer: start with heaviest person possible
        // TC: O(NlogN) - for sorting
        // SC: O(1)


        // *********
        // Approach
        /*
        1. Sort the array so that left side is light weight person and right side is heavy weight person
        2. maintain two pointer
            one left - most light person
            other right - most heavy person
        3. do a while loop till left <= right
            a. if both light and heavy person can fit in boat
                then fit them, use one boat and do left++ and right--;
            b. if both light and heavy person can't fit
                then just fit heavy person (i.e use one boat) and do right--
            c. if only one person is remaining (in case left == right ), that is the heavy one
                fit that only heavy person(i.e use one boat) and do right-- 
        4. finally return the total boat used.
        */


        // *********
        // Doubt
        /*
        1. I missed this point while reading the question

            in the constrains it says 1 <= people[i] <= limit
                that means heaviest people in the boat is not greater then limit
                    it will be either less or equal to limit
                    so always all the people can fit in the boat
        ----------------------------------------------------------
        2. in the condition, (while(left <= right)) => why left = right
            this means when left=right, only one person is left
                and that need one seperate boat
        */

        // *********
        // Code
        Arrays.sort(people);

        int left = 0; // most light weight person
        int right = people.length-1; // most heavy weight person
        int totalBoatRequired = 0;

        while(left <= right) {
            if(people[right]+people[left] <= limit) {
                totalBoatRequired++;
                left++;
                right--;
            }
            else {
                // when people[right]+people[left] > limit (it will also work in teh condition left = right)
                // just fit heavy person from rightside in the boat
                // and move to another heavy person i.e right --;
                totalBoatRequired++;
                right--;
            }
        }
        return totalBoatRequired;
    }
}