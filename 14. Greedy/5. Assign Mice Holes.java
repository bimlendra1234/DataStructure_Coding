// Geeks for Geeks : Assign Mice Holes : https://www.geeksforgeeks.org/problems/assign-mice-holes3053/0

// *********
// Complexity
// TC: O(NlogN) → sorting both arrays
// SC: O(1) → only variables used


// *********
// Approach
/*
    1. Sort both mices[] and holes[] arrays
    2. Assign ith mouse to ith hole (greedy works because sorting minimizes maximum distance)
        Assign mice to the nearest holes
    3. Track the max |mice[i] - holes[i]| across all pairs
    4. Return this max as minimum time required
*/


/*
    By sorting:

        Order preserved → both mice and holes are lined up from left → right.
        Greedy pairing works → each mouse takes the nearest hole in its order, no crossing-over.
        Why no crossing?
        If a mouse on the left skipped its nearest hole and went further right, then a right-side mouse would be forced to travel left → distances only get worse.
        Hence, the optimal assignment is always “pair them in order after sorting.”
*/

// *********
// Code
class Solution {
    public int assignHole(int[] mices, int[] holes) {
        // code here
        Arrays.sort(mices);
        Arrays.sort(holes);
        
        int maxTime = 0;
        for(int i = 0; i < mices.length; i++) {
            maxTime = Math.max(maxTime, Math.abs(mices[i] - holes[i]));
        }
        return maxTime;
    }
};