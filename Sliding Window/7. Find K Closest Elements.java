// Leetcode: 658. Find K Closest Elements

import java.util.*;

class Solution {
    public List<Integer> findClosestElements(int[] arr, int k, int x) {

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
    }
}