// Leetcode : 213. House Robber II

// Bottom up approach
// TC: O(N)
// SC: O(2N) -> O(N)


// *********
// Approach
/*
    Similar to house robber 1 but arrange in circular fashion so
        last is neighbor to first

    Case 1: If robbing 1st house, not allowed last house.
                creatae new array and in that remove last house
                using the same technique as house robber 1 find max loot here let say max1

    Case 2: If robbing last house, not allowed first house.
                create new array and in that remove 1st house
                using the same technique as house robber 1 find max loot here as well let say max2

    Finally return Math.max(max1, max2).
*/


// *********
// Code
class Solution {
    public int rob(int[] nums) {
         int n = nums.length;
         if(n<2) {
            return nums[0];
         }

         int[] skipFirst = new int[n-1]; // will skip first
         int[] skipLast = new int[n-1]; // will skip last

         // Fill both the array
         for(int i = 0 ; i < n-1; i++) {
            skipFirst[i] = nums[i+1];
            skipLast[i] =  nums[i];
         }

         int max1SkipFirst = HouseRob1(skipFirst);
         int max2SkipLast = HouseRob1(skipLast);

         return Math.max(max1SkipFirst, max2SkipLast);
    }

    public int HouseRob1 (int[] nums) {
         int n = nums.length;
         if(n<2) {
            return nums[0];
         }

         int[] dpMaxCost = new int[n];
         dpMaxCost[0] = nums[0];
         dpMaxCost[1] = Math.max(nums[0], nums[1]);

         // lets fill max1
         for(int i = 2 ; i < n; i++) {
            dpMaxCost[i] = Math.max((nums[i]+dpMaxCost[i-2]),dpMaxCost[i-1]); 
         }

         return dpMaxCost[n-1];
    }
}