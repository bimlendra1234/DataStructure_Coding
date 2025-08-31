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
        
        // Sort based on end time
        Arrays.sort(intervals, (a,b) -> a[1]-b[1]);

        int removedOverlappingCount = 0;

        // here selected the first and updating last end for comparing next
        int lastEnd = intervals[0][1];

        for(int i = 1; i < intervals.length; i++) {
            int startTime = intervals[i][0];
            int endTime = intervals[i][1];

            // overlap -> remove one with larger end; keep smaller end to reduce future conflicts
            if(startTime < lastEnd) {
                removedOverlappingCount++;
            }

            // no overlap -> move the window , we can also write in else condition
            if(startTime >= lastEnd) {
                lastEnd = endTime;
            }

        }
        return removedOverlappingCount;
    }
}