import java.util.*;

class Solution {
    public int longestConsecutive(int[] nums) {

        /*
        // BrutForce Approach
        // with sorting and and for each element calculating its longest common sequences and taking maximum one

        // TC: O(N^2)
        // SC: O(1)

        // Approach:
        // 1. Sort the array
        // 2. for each element compare all the rest remaining element next to it
        // 3. in for loop for each element , let 1 be maxLongSeq and next target number is nums[i]+1
        // 4. in second loop, If next element is same as nums[i]+1 then increment maxLongSeq
        //        also increment NextSeq to find the continuation next number
        // 5. if number is not same as NextSeq, update final LongestCommonSeq and end that iteration
        // 6. finally after all iteration update LongestCommonSeq and return it


        if(nums.length == 1) return 1;
        if(nums.length == 0) return 0;

        Arrays.sort(nums);

        int LongestCommonSeq = 0;
        for(int i = 0; i < nums.length-1; i++) {
            // longest from 0;
            int maxLongSeq = 1;
            int NextSeq = nums[i]+1;
            for(int j = i+1; j< nums.length;j++) {
                if(nums[j] == NextSeq) {
                    maxLongSeq++;
                    NextSeq++;
                }
                else {
                    LongestCommonSeq = Math.max(LongestCommonSeq, maxLongSeq);
                    continue;
                }
            }
            LongestCommonSeq = Math.max(LongestCommonSeq, maxLongSeq);
        }
        return LongestCommonSeq;
        */

        // --------------------------------------------

        // Optimal Approach using HashMap

        // TC: O(N)
        // SC: O(N)

        /*
        Approach:
        1. Create Hashmap and inilitiaze all elem to false to denote not travelled
        2. for each element check forward consecutive element
            if next num is available in HM and is false
            Increment len count and set target next number
        3. for same element check backward consecutive element as well
            if prev num is available in HM and is false then make it true
            Increment len count and set target prev number number
        4. return maximum length among all above consecutive length
        */

        int maxConsecutiveLength = 0;
        Map<Integer, Boolean> HM = new HashMap<>();

        for (int i = 0; i < nums.length; i++) {
            HM.put(nums[i], false);
        }

        for(int i = 0; i < nums.length; i++) {

            int eachElemConsecutiveCount = 1;

            // Finding Forward Consecutive
            int currentNum = nums[i];
            int nextNum = currentNum + 1;
            while(HM.containsKey(nextNum) && HM.get(nextNum) == false) { // false means not seen
                eachElemConsecutiveCount++;
                HM.put(nextNum, true);
                nextNum++;
            }

            // Finding Backward Consecutive
            int prevNum = currentNum - 1;
            while(HM.containsKey(prevNum) && HM.get(prevNum) == false) { // false means not seen
                eachElemConsecutiveCount++;
                HM.put(prevNum, true);
                prevNum--;
            }

            maxConsecutiveLength = Math.max(maxConsecutiveLength, eachElemConsecutiveCount);
        }

        return maxConsecutiveLength;
    }
}