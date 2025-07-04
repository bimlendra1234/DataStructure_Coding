// Leetcode: 658. Find K Closest Elements

import java.util.*;

class Solution {
    public List<Integer> findClosestElements(int[] arr, int k, int x) {
        /*
        // Approach using Map not sliding window
        // TC: O(NlogN) due to collection sorting
        // SC: O(N)


        // *********
        // Approach
        // 1. Find the distance of each element wih x 
        // 2. Use TreeMap to store diff: list of value having similar difference 
        // 3. return the first k value from the map
        // 4. sort that k value and return that result


        // *********
        // Code
        Map<Integer, List<Integer>> TM = new TreeMap<>();

        for(int i =0; i < arr.length; i++) {
            int diff = Math.abs(x-arr[i]);
            if(!TM.containsKey(diff)) {
                TM.put(diff, new ArrayList<>());
            }
            TM.get(diff).add(arr[i]);
        }

        List<Integer> res = new ArrayList<>();
        for(int key : TM.keySet()) {
            List<Integer> val = TM.get(key);
            for(int elem : val) {
                if(res.size() < k){
                    res.add(elem);
                }
            }
        }
        Collections.sort(res);
        return res;
        */

        // ----------------------------------------------------------

        // Approach using Binary search and sliding window
        // TC: O(log(n−k)+k)
        // SC: O(1)


        // *********
        // Approach
        /*
         1. Use binary search to find the closest element to x
         2. Use two pointers to find the k closest elements
         3. left pointer will point to the start of the window
         4. the right pointer will point to the end of the window not at last 
              //so that we can have window at last
         5. The left pointer will be incremented to mid+1
              // if the mid is closer to x than the element just outside the window
         6. otherswise The right pointer will be decremented to mid
         7. The final result will be the elements in the window from left to left+k
         */


        // *********
        // Code

        // left pointer will point to the start of the window and 
        // the right pointer will point to the end of the window not at last so that we can have window at last
        int left = 0;
        int right = arr.length-k;

        while(left < right) {
            int mid = (left+right/2);

            //check mid elem and outside window which one is closer to target
            if(x-arr[mid] > arr[mid+k] -x) {
                // The left pointer will be incremented to mid+1
                // if the mid is closer to x than the element just outside the window
                left = mid+1;
            } else {
                // otherswise The right pointer will be decremented to mid
                right = mid;
            }
        }
        // answer is my window: Left+k
        List<Integer> res = new ArrayList<>();
        for(int i = left ; i < left+k; i++) {
            res.add(arr[i]);
        }
        return res;
    }
}