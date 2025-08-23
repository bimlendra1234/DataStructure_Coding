import java.util.*;

class Solution {
    public int subarraySum(int[] nums, int k) {
        /*
        // BrutForec Approach using two for loop

        // TC: O(N^2)
        // SC: O(1)

        // Approach
        // 1. check for each element if it is in correct subarray

        int subArray = 0;

        for(int i = 0; i < nums.length; i++) {
            int sum = 0;
            for(int j = i; j < nums.length; j++) {
                sum += nums[j];
                if(sum == k) {
                    subArray++;
                }
            }
        }
        return subArray;
        */

        // ----------------------------------------------------

        // Optimal Approach using hashmap prefixSum and count

        // TC: O(N)
        // SC: O(N)

        /*
        Approach
        1. take totalSubArray that is final result to be returned
        2. find prefix sum at each index
        3. if that prefix sum -k is at HM, take that value and add it to res totalSubArray
            Was there a prefix sum earlier such that if I subtract it from my current sum, I get k? 
            If yes, then I’ve found a subarray that sums to k.
        4. in both case weather prefix sum -k availab or not at the HM
            add prefixsum and +1 count in the hashmap
        5. return res totalSubArray
        */

        /* 
        doubt
        why we did int diff = prefixSum-k; and store in hashmap with its count
        ans: To find: 
        Was there a prefix sum earlier such that if I subtract it from my current prefix sum, I get k?
            If yes, and that prefixSum - k exists in the HashMap (HM),
            Then I’ve found one or more subarrays that end at the current index and sum to k.
            The count stored in the HashMap for prefixSum - k is the number of such subarrays.
        */ 
        Map<Integer, Integer> HM = new HashMap<>();

        int totalSubArray = 0;
        int prefixSum = 0;
        HM.put(0,1);

        for(int i = 0; i < nums.length; i++) {
            prefixSum += nums[i];
            int diff = prefixSum-k;
            // check if this diff is present in HM, if yes take value and increment subarray count by that #
            // if not present increment by zero
            totalSubArray += HM.getOrDefault(diff,0);

            // finally also add that prefixSum in HM , if already there increment value count
            HM.put(prefixSum, HM.getOrDefault(prefixSum, 0) + 1);
        }

        return totalSubArray;

    }
}