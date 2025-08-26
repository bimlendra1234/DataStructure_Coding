// Leetcode : 57. Insert Interval

// TC: O(n) — single pass
// SC: O(n) — output list in worst case


// *********
// Approach : keep left part → merge overlap → keep right part
/*
    1. Add all intervals ending before newInterval starts (no overlap)
    2. Merge overlapping intervals with newInterval
        - expand start = min(start, current interval start)
        - expand end   = max(end, current interval end)
    3. Add the merged interval
    4. Add all remaining intervals (after overlap)
    5. Convert list → 2D array
*/


// *********
// Code
class Solution {
    public int[][] insert(int[][] intervals, int[] newInterval) {
        
        List<int[]> resList = new ArrayList<>();

        int n = intervals.length;
        int i = 0;

        // 1. Scenario before overlap : Keep as it is into the list
            // end of each interval is strictly less then newInterval start
        while(i < n && intervals[i][1] < newInterval[0]) {
            resList.add(intervals[i]);
            i++;
        }

        // 2. overLaping Scenario : Do actual Merging
            // Start of each interval is less then or equal to new Interval end
        int start = newInterval[0];
        int end = newInterval[1];
        while(i < n && intervals[i][0] <= newInterval[1]) {
            start = Math.min(intervals[i][0], start); // doubt in this as during each interval min can change
            end = Math.max(intervals[i][1], end);
            i++;
        }
        resList.add(new int[]{start, end});

        // 3. Scenario after overlap: Keep as it is into the list
        while(i < n) {
            resList.add(intervals[i]);
            i++;
        }

        // 4. convert list into 2d array and return that
        return resList.toArray(new int[resList.size()][2]);
    }
}