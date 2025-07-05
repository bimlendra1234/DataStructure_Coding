// Leetcode: 239. Sliding Window Maximum

import java.util.*;

class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        /*
        // BrutForce approach using queue and finding max in each queue came outof me
        // TC: O(Nk)
        // SC : O(N)


        // *********
        // Approach
        // 1. result array will be of size [nums.length-k+1]
        // 2. use queue so that first in will be first out,
                // to maintain window we will add end and remove start i,e first inserted
        // 3. push each element one by one
            // once queue size is equal to k then
                // find max in that queue each time : can be improvised
                // push that max into res
                // remove the first element -> to maintain WS of k
                // for loop will continue to maintain WS of k, in next iteration next element will be added
        // finally return result


        // *********
        // Code
        if(nums.length == 1 && k == 1) {
            int[] arr = {1};
            return arr;
        }

        int idx = 0;
        int[] res = new int[nums.length-k+1];
        Queue<Integer> qu = new LinkedList<>();
        for(int end = 0; end < nums.length; end++) {
            qu.offer(nums[end]);
            if(qu.size() == k) {
                int max = Integer.MIN_VALUE;
                for(int val : qu) {
                    max = Math.max(max, val);
                }
                res[idx++] = max;
                qu.poll();
            }
        }
        return res;
        */

        // --------------------------------------------------------------

        // BrutForce Approach using two for loops
        // TC: O(Nk)
        // SC: O(N)


        // *********
        // Approach
        // 1. result array will be of size [nums.length-k+1]
        // 2. for each element in nums, find max in the next k elements
        // 3. push that max into res

        // *********
        // Code

        int[] res = new int[nums.length-k+1];

        for(int i = 0; i <= nums.length-k; i++) {
            int max = nums[i];
            for(int j = i; j < i+k; j++) {
                max = Math.max(max, nums[j]);
            }
            res[i] = max;
        }
        return res;
    }
}