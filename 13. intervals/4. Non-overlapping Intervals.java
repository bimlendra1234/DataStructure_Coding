// Leetcode : 435. Non-overlapping Intervals

// *********
// Complexity
// TC: O(n log n) → sort + O(n) scan
// SC: O(1) → only counters, no extra DS


// *********
// Approach
/*
    1. Sort intervals by start (if equal, by end)
    2. Track current `end` boundary
    3. For each interval:
        - If overlap (start < end) → increment count and keep smaller end
        - Else (no overlap) → move window by updating end
    4. Return total count (number of removals)
*/


// *********
// Code
class Solution {
    public int eraseOverlapIntervals(int[][] intervals) {
        Arrays.sort(intervals, (a,b) -> {
            if(a[0] == b[0]) {
                return a[1]-b[1];
            }
            return a[0]-b[0];
        });

        int count = 0;

        int start = intervals[0][0];
        int end = intervals[0][1];

        for(int i = 1; i < intervals.length; i++) {
            int startTime = intervals[i][0];
            int endTime = intervals[i][1];

            // overlap -> remove one with larger end; keep smaller end to reduce future conflicts
            if(startTime < end) {
                count++;
                end = Math.min(end, endTime);
            }

            // no overlap -> move the window
            if(startTime >= end) {
                start = startTime;
                end = endTime;
            }

        }
        return count;
    }
}