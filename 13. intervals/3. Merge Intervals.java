// Leetcode: 56. Merge Intervals

// *********
// Complexity
// TC: O(n log n) → sort + O(n) sweep
// SC: O(n) for output list


// *********
// Approach
/*
    1. Sort intervals by start time
    2. Maintain startTime and endTime for the current merged interval
    3. For each interval:
        - If overlapping (eachStart <= endTime) → extend endTime
        - Else (non-overlap) → add current [startTime, endTime] to result and reset
    4. Add the last interval at the end
    5. Return the result as 2D array
*/


// *********
// Code

class Solution {
    public int[][] merge(int[][] intervals) {

        // sort based on start time
        Arrays.sort(intervals, (a,b) -> a[0]-b[0]);
        
        List<int[]> res= new ArrayList<>();
        int startTime = intervals[0][0];
        int endTime = intervals[0][1];

        for(int i =1; i < intervals.length; i++) {
            int eachStart = intervals[i][0];
            int eachEnd = intervals[i][1];

            // overlaping scenario → extend
            if(eachStart <= endTime) {
                // startTime = Math.min(startTime, eachStart); // start time is already min as it is sorted
                endTime = Math.max(endTime, eachEnd);
            }

            // non overlaping scenario → flush and reset
            if(eachStart > endTime) {
                res.add(new int[]{startTime, endTime});
                startTime = eachStart;
                endTime = eachEnd;
            }
        }
        // add last interval
        res.add(new int[]{startTime, endTime});

        return res.toArray(new int[res.size()][2]);
    }
}