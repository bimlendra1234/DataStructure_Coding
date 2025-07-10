// Leetcode: 410. Split Array Largest Sum


// Approach using BS
// TC: O(nLOGm) : n= array total length, m = total number between min possible value and max possible value
// SC : O(1)


// *********
// Approach
/*
1. The largest element in the array is the minimum possible value (minPossible).
   - Because no subarray sum can be smaller than the largest single element.
2. The sum of the entire array is the maximum possible value (maxPossible).
   - This is the case when we take the entire array as one subarray (no splits).
3. Perform Binary Search between minPossible and maxPossible.
4. For each mid value (which represents the candidate maximum subarray sum),
   check if it's possible to split the array into ≤ k subarrays such that
   the largest sum of any subarray is ≤ mid.

   - If it is possible:
       This means mid could be the answer, but we try to find a smaller possible value.
       So, shrink the search space by moving right = mid.

    - If not possible:
       This means mid is too small to allow a valid split.
       So, increase the minimum by moving left = mid + 1.

5. Continue the search until left == right.
6. 6. The answer is left (or right), which represents the minimum largest subarray sum
   achievable with at most k splits.
*/


// *********
// Code

class Solution {
    // function written by me
    boolean canBeSplitted(int midSum, int[] nums, int k) {
        int subArrayCount = 1;
        int total = 0;
        for(int num: nums) {
            total += num;

            if(total > midSum) {
                subArrayCount++; // array split added once got sum more then midSum
                total = num; // start from that number by adding which sum excedded then midSum
            }
            if(subArrayCount > k) {
                return false;
            }
        }
        return true;
    }

    public int splitArray(int[] nums, int k) {
        //1.  max in the array is minPossible value
        int maxValInArray = 0;
        //2.  sum of all array is, maxPossible value
        int totalSumArray = 0;

        for(int num : nums) {
            maxValInArray = Math.max(maxValInArray, num);
            totalSumArray += num;
        }

        //3. now perform BS between minPossible value and maxPossible value
        int left = maxValInArray;
        int right = totalSumArray;
        int res = 0;
        while(left < right) {
            int mid = left + (right-left)/2; 
            // this mid is possible sum, now we will split array into k parts and will see if we get max this mid sum
            // if we get, that is fine now even check if we can get less then this mid sum
            if(canBeSplitted(mid, nums, k)) {
                right = mid;
            }
            else {
                // if cant be splitted
                // them mid is not a possible answer we need higher value then mid
                left = mid+1;
            }
        }
        return left;
    }
}