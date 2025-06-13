// Leetcode: 15. 3Sum

import java.util.*;

class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        /*
        // BrutForce Approach - will give time limit exceeded
        // TC: O(N^3)
        // SC: O(1)


        // *********
        // Approach
        // 1. For each element, select 2nd element next to it, and 
            // for third travers all, check one by one anf if sum is 3 that is our result
        // 2. basically we will run every combination in 3 loop to find reultant sum 0
        // 3. if found, store that three in a sorted order
            // so that it will be easy in checking the duplicate
        // finally return the resultant array


        // *********
        // Doubt
        // 1. How to remove duplicate from the list
            // by using Arrays.sort(), this only work in array, will not work in list.
            // use Collections.sort() this will work in list - TC: O(NLOGN)


        // *********
        // Code
        List<List<Integer>> res = new ArrayList<>();

        for(int i = 0; i < nums.length-2;i++) {
            for(int j = i+1; j < nums.length-1; j++){
                for(int k = j+1; k < nums.length; k++) {
                    if(nums[i] + nums[j] + nums[k] == 0) {
                        List<Integer> eachList = new ArrayList<>();
                        eachList.add(nums[i]);
                        eachList.add(nums[j]);
                        eachList.add(nums[k]);

                        // in order to avoid duplicate, first sort each resultant list
                        // if that sorted list is not in main result then only it.
                        Collections.sort(eachList);
                        if(!res.contains(eachList)) {
                            res.add(eachList);
                        }
                        
                    }
                }
            }
        }
        return res;
        */

        // -------------------------------------------------

        // Optimal Approach using Sorting and two pointer approach
        // TC: O(N^2)
        // SC: O(1)


        // *********
        // Approach
        /*
        1. Sort the main Arrays in ascending Order
        2. Select the first number at ith index
        3. Now use two pointer, and apply 2 sum approach in sorted array
            one pointer at left = ith+1 index and right = other pointer at the last element
            (goal is to find nums[i] + nums[left] + nums[right] == 0)
        */


        // *********
        // Doubt
        /*
        1. why this condition 
        if(i >0 && nums[i] == nums[i-1]) {
                continue;
        }
        To skip duplicate triplets caused by using the same number at index i multiple times.

        --------------------------------
        2. why left<right in both below: 
        while(left<right && nums[left] == nums[left+1]) {
            left++;
        }

        while(left<right && nums[right] == nums[right-1]) {
            right--;
        }
        did left < right inside even it is present at outside because
        ensures left + 1 is still a valid index.
        ensures right - 1 is still ≥ left and is valid index.

        --------------------------------
        3. Instead to this
            List<Integer> eachList = new ArrayList<>();
            eachList.add(currentNum);
            eachList.add(nums[left]);
            eachList.add(nums[right]);
            res.add(eachList);

           It can be written as
            List<Integer> triplet = Arrays.asList(nums[i], nums[left], nums[right]);
            result.add(triplet);

        */
        

        // *********
        // Code
        List<List<Integer>> res = new ArrayList<>();
        Arrays.sort(nums);

        for(int i = 0; i < nums.length-2; i++) {

            if(i >0 && nums[i] == nums[i-1]) {
                continue;
            }

            int currentNum = nums[i];
            int left = i+1;
            int right = nums.length-1;

            while(left<right) {
                int twoSum = nums[left]+nums[right];
                int target = - currentNum;
                
                if(twoSum < target) {
                    left++;
                }
                else if(twoSum > target) {
                    right--;
                }
                else {
                    // when two sum is equals to target
                    List<Integer> eachList = new ArrayList<>();
                    eachList.add(currentNum);
                    eachList.add(nums[left]);
                    eachList.add(nums[right]);
                    res.add(eachList);

                    // below logic make the code much slower as it will sort in each iteration
                    /*
                    Collections.sort(eachList);
                    if(!res.contains(eachList)) {
                        res.add(eachList);
                    }
                    */

                    // instead arrande left and right smartly
                    while(left<right && nums[left] == nums[left+1]) {
                        left++;
                    }

                    while(left<right && nums[right] == nums[right-1]) {
                        right--;
                    }

                    left++;
                    right--;
                }
            }
        }
        return res;
    }
}