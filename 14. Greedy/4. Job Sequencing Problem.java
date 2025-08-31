// GeeksforGeeks: https://www.geeksforgeeks.org/problems/job-sequencing-problem-1587115620/1

// *********
// Complexity
// TC: O(n log n + n * d)   (d = max deadline)
// SC: O(d) → slots array of size d

// *********
// Approach
/*
    1. Compute maxDeadline to size the time slots (use 1..D; 0 is invalid).
    2. Build an index array [0..n-1] and sort it by profit descending so we don’t touch original arrays.
    3. Iterate jobs in that order; for each job with deadline d:
    4. Try to place it at slot d; if occupied, move left (d-1, d-2, …) until a free slot (>0) is found.
    5. If a free slot exists, mark it occupied, increment job count, add its profit.
    6. Finally return [totalJobsScheduled, totalProfit].
 */

import java.util.*;
class Solution {

    public ArrayList<Integer> jobSequencing(int[] deadline, int[] profit) {
        // code here
        
        // 1. Find max deadline
        int maxDeadline = 0;
        for(int i = 0; i < deadline.length; i++) {
            maxDeadline = Math.max(maxDeadline, deadline[i]);
        }
        
        // 2. create array with maxDeadline size and assign -1 initially
        int[] jobScheduled = new int[maxDeadline+1];
        Arrays.fill(jobScheduled, -1);
        
        // 3. create array to get index of max profit at first
        // sort this array based on the decreasing profit, i.e max proft lies at the first index
        Integer[] sortedProfit = new Integer[profit.length];
        for(int i = 0; i < profit.length; i++) {
            sortedProfit[i] = i;
        }
        Arrays.sort(sortedProfit, (a,b) -> profit[b] - profit[a]);
        
        //4. Now find max job scheduled and maxProfit
        int maxJobScheduled = 0;
        int maxProfit = 0;
        
        for(int i = 0; i < sortedProfit.length; i++) {
            
            // get the index of sorted profit one by one and get its deadline and its profit 
            int maxProfitIDX = sortedProfit[i];
            int eachDeadline = deadline[maxProfitIDX];
            int eachProfit = profit[maxProfitIDX];
            
            // now time to place or assign that job
            while(eachDeadline >0 && jobScheduled[eachDeadline] != -1) {
                // if at the deadline of that job is not -1 check previous one if available
                eachDeadline--;
            }
            
            if(eachDeadline < 1) {
                continue; // in this case we cant assign the job as no deadline left
            }
            
            // we came here that means we have available deadline with -1
            // so assign job (i.e increment jobScheduled count) and calculate the profit
            jobScheduled[eachDeadline] = 1;
            maxJobScheduled++;
            maxProfit += eachProfit;
        }
        
        ArrayList<Integer> resList = new ArrayList<>();
        resList.add(maxJobScheduled);
        resList.add(maxProfit);
        return resList;
    }
}