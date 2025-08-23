import java.util.*;

class Solution {
    public int[] topKFrequent(int[] nums, int k) {

        // Optimal Approach

        // TC: O(N) as not more the 1 for loop
        // SC: O(N) for creating Extra Hash Map

        /*
        Approach
        1.  Take a Hashmap and inside it put number and its total count
        2.  Create array (i.e []) that contain list of integer (i.e List<Integer>) inside it
        3.  its like in the above array, value from HM (i.e count) will be the index and 
            key will be inside array element
        4.  if multiple key have the same count the store those key in the form of integer list
        5.  create resultant array, traverse the 3rd step array from back till k time
        6.  if the value is not null push one by one inside resultant array
        */

        if(nums.length == 1 && k==1) {
            return nums;
        }

        Map<Integer, Integer> HM = new HashMap<>();
        for(int i = 0; i < nums.length; i++) {
            HM.put(nums[i], HM.getOrDefault(nums[i],0)+1);
        }

        // create one array where we use index as HM value and value in array as corresponding key

        // take list and inside that there will be list if all key having same value.
        
        // instead of array integer use below one List<Integer>[]
        // Integer[] countBucket = new Integer[nums.length]; // this will not work
        
        // array (i.e []) that contain list of integer (i.e List<Integer>)
        List<Integer>[] countBucket = new List[nums.length+1];

        // doubt in how to travers the array
        for(int key : HM.keySet()) { // need to master this
            int val = HM.get(key);
            if(countBucket[val] == null) {
                countBucket[val] = new ArrayList<>();
            }
            countBucket[val].add(key);
        }

        int[] res = new int[k];
        int index = 0;
        for(int i = countBucket.length-1; i>=0 && index < k; i--) {
            if(countBucket[i] != null) {
                // assign element one by one from the inside list value in index
                for(int elem: countBucket[i]) { 
                    res[index++] = elem;
                }
            }
        }
        return res;
    }
}