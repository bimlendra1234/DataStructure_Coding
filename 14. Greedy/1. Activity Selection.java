// Leetcode: https://www.geeksforgeeks.org/problems/activity-selection-1587115620/1

// TC: O(N log N) + O(N) ~ O(N log N)
// SC: O(N)


// *********
// Approach: Sort the activities by their finish time.
/*
    1. Sort the activities by their finish time.
    2. Select the first activity and its finish time as last finish time and increment the count.
    3. For each subsequent activity, if its start time is greater than the last finish time
       of the last selected activity, select it and update the last finish time and increment the count.
    4. Return the count of selected activities.
 */


 // *********
 // Code:
import java.util.*;

class Solution {
    public int activitySelection(int[] start, int[] finish) {
        // code here
        int n = finish.length;
        List<Integer> sortedEnd = new ArrayList<>();
        
        for(int i = 0; i < n; i++) {
            sortedEnd.add(i);
        }
        
        Collections.sort(sortedEnd, (a,b) -> (finish[a] - finish[b]));
        // Arrays.sort(order, Comparator.comparingInt(i -> finish[i]));
        
        int maxActivity = 1; // 0th already selected
        int lastEnd = finish[sortedEnd.get(0)];
        
        for(int i = 1; i < n; i ++) {
            int idx = sortedEnd.get(i);
            
            if(start[idx] > lastEnd) {
                lastEnd = finish[idx];
                maxActivity++;
            }
        }
        return maxActivity;
    }
}
