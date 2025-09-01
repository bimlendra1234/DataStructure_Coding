// Leetcode : 2279. Maximum Bags With Full Capacity of Rocks

// *********
// Complexity
// TC: O(N LOGN)
// SC: O(N)


// *********
// Approach
/*
    Capacity[] is How many rock a bag can hold to make it fill
    rock[] is how many rock currently a bag has
    additionalRocks is extra rock with us to make some bag full

    o/p -> we need to return count all that bag which is full and can be full with extra additionalRocks

    Approach
    --------
    1. create an array with capacity[i] - rock[i], denotes the amount of rock required to make a bag full
    2. sort the above created array in an increasing order
    3. at First provide the additionalRocks that need less rock to make a bag full
        1st elem in array need lees rock achieved via sorting
    
    4. if rock required is <= additionalRocks
        bag will be fulfilled by additionalRocks
        additionalRocks will be left as additionalRocks-rock required
        and rock required will be 0

    5. if rock required == 0;
        bag is full so increment res full bag count by 1
*/


// *********
// Code
class Solution {
    public int maximumBags(int[] capacity, int[] rocks, int additionalRocks) {
        int n = capacity.length;

        int[] diff = new int[n];
        for(int i = 0; i < n; i++) {
            diff[i] = capacity[i] - rocks[i];
        }
        Arrays.sort(diff);

        int resFullBag = 0;
        for(int i = 0; i < n; i++) {
            if(diff[i] <= additionalRocks) {
                additionalRocks -= diff[i];
                diff[i] = 0;
            }

            if(diff[i] == 0) {
                resFullBag++;
            }
        }
        return resFullBag;
    }
}