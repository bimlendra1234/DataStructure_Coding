// Leetcode : Premium : https://neetcode.io/problems/meeting-schedule?list=neetcode150

/**
 * Definition of Interval:
 * public class Interval {
 *     public int start, end;
 *     public Interval(int start, int end) {
 *         this.start = start;
 *         this.end = end;
 *     }
 * }
 */

// one-liner approach : Sort intervals by start → if current.start < prev.max → overlap → false
// TC: O(n log n)   (sorting)
// SC: O(1)         (in-place sort)


// Approach
/*
    1. Sort intervals by start time
    2. Track min and max from the first interval
    3. For each next interval:
        - If start >= min and start < max → overlap → return false
        - Else update min = max(min, start), max = max(max, end)
    4. If no overlap found → return true
*/


// *********
// Code
class Solution {
    public boolean canAttendMeetings(List<Interval> intervals) {

        // sort by start time
        intervals.sort((a, b) -> a.start - b.start);

        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;
        for(int i = 0; i < intervals.size(); i++) {
            Interval oneInterval = intervals.get(i);
            int startTime = oneInterval.start;
            int endTime = oneInterval.end;

            if(i == 0) {
                min = startTime;
                max = endTime;
            }
            else {
                if(startTime >= min && startTime < max) {
                    return false;
                }
                min = Math.max(min, startTime);
                max = Math.max(max, endTime);
            }
        }
        return true;
    }
}
