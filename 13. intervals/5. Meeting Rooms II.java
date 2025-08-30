// Leetcode Premium : Meeting Rooms II : https://neetcode.io/problems/meeting-schedule-ii?list=neetcode150

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


// *********
// Complexity
// TC: O(n log n)  → sorting starts & ends + O(n) two-pointer sweep
// SC: O(n)        → start[] and end[] arrays


// *********
// Approach
/*
    1) Split starts and ends into two arrays and sort both.
    2) Walk with two pointers:
       - If start[i] < end[j] ⇒ a meeting begins before the earliest one ends → need a new room → count++ and i++.
       - Else (start[i] >= end[j]) ⇒ one meeting has ended → free a room → count-- and j++.
    3) Track max count seen at any time; that's the min rooms required.
    4) Important tie rule: when start == end, we should free first, then start (no extra room).
       Using the condition (start[i] < end[j]) makes equality fall into the "end first" branch.
*/


// *********
// Code
class Solution {
    public int minMeetingRooms(List<Interval> intervals) {
        int n = intervals.size();
        int[] start = new int[n];
        int[] end = new int[n];

        for(int i = 0; i < n; i++) {
            start[i] = intervals.get(i).start;
            end[i] = intervals.get(i).end;
        }

        Arrays.sort(start);
        Arrays.sort(end);

        int startPointer = 0;
        int endPointer = 0;
        int count = 0;
        int res = 0;

        // if at the same index , unless start < end, each meeting will increment
        while(startPointer < n && endPointer < n) {

            // a new meeting starts before the earliest end → need a room
            if(start[startPointer] < end[endPointer]) {
                startPointer++;
                count++;
            } 
            else { // a meeting ends (handles start == end here as well) → free a room
                endPointer++;
                count--;
            }
            res = Math.max(res, count);
        }
        return res;
    }
}
