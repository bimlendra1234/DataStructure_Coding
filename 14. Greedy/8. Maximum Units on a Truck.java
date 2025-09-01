// Leetcode : 1710. Maximum Units on a Truck


// Exactly Same as Fractional Knapsack : ratio already given as numberOfUnitsPerBoxi

class Solution {
    public int maximumUnits(int[][] boxTypes, int truckSize) {
        
        // ratio already given as numberOfUnitsPerBoxi
        // 1. So sort it in decreasing order : greedy as large unit at first
        Arrays.sort(boxTypes, (a,b) -> b[1]-a[1]);

        int resMaxUnit = 0;
        for(int[] box: boxTypes) {
            if(box[0] >= truckSize) { // consume entire truck with max size
                resMaxUnit += (truckSize * box[1]);
                truckSize = 0; 
            }
            else {
                resMaxUnit += (box[0] * box[1]);
                truckSize -= box[0];
            }

            if(truckSize == 0) {
                break;
            }
        }
        return resMaxUnit;
    }
}