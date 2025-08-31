// Leetcode : 452. Minimum Number of Arrows to Burst Balloons

// TC: O(Nlogn)
// SC: O(1)


// *********
// Approach
/*
    1. sort by the ones that ends first: thats a gredy
    2. since start now is one that finish first so select it and take 1 count
    3. if there is an overlap : arrowing hitting at lastEnd point will burst both ballon, so no need to increment the count
    4. if no overlap , just increment one count and update the last end point of current end
*/


// *********
// Code
class Solution {
    public int findMinArrowShots(int[][] points) {
        
        // 1. sort by first end: thats a gredy
        // Arrays.sort(points, (a,b) -> a[1]-b[1]); // thia wont work will give issue in -ve case

        // (a,b) -> swap if (a[1]-b[1]) return 1 ; if return -1 dont swap.
        // eg: (2,4) (6,8) -> if 4 is less then 8 do not swap
        Arrays.sort(points, (a,b) -> (a[1]<=b[1]?-1:1));

        // 2. since start now is one that finish first so select it
        int minArrow = 1;
        int lastEnd = points[0][1];

        for(int i = 1; i < points.length; i++) {
            int currentStart = points[i][0];
            int currentEnd = points[i][1];

            if(currentStart <= lastEnd) { // this is an overlap
                // arrowing hitting at lastEnd point will burst both ballon
                continue;
            }

            else if(currentStart > lastEnd) {
                minArrow++;
                lastEnd = currentEnd;
            }
        }

        return minArrow;
    }
}