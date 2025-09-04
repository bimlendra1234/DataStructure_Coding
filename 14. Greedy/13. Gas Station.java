// Leetcode : 134. Gas Station

// *********
// Complexity
// TC: O(n) → one pass for totals + one pass for start index
// SC: O(1)


// *********
// Approach
/*
    1. Check feasibility:
        - If totalGas < totalCost → trip not possible → return -1
    2. Traverse stations once:
        - Keep track of currentGas (net gain at each step)
        - If currentGas < 0 → reset startIndex = i+1, currentGas = 0
    3. Return startIndex (guaranteed valid because totalGas ≥ totalCost)
*/


// *********
// Code
class Solution {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        
        int n = gas.length;

        // 1. check if trip is even possible or not
        int totalGas = 0;
        int totalCost = 0;

        for(int i = 0; i < n; i++) {
            totalGas += gas[i];
            totalCost += cost[i];
        }


        if(totalGas < totalCost) { // have is less then required
            return -1;
        }

        // 2. strat from 0th position and determine if we can reach last or not
        int currentGas = 0;
        int startIndex = 0;
        for(int i = 0; i < n; i++) {
            
            currentGas += (gas[i] -  cost[i]);

            if( currentGas < 0) {
                startIndex = i+1;
                currentGas = 0;
            }
        }

        return startIndex;
    }
}

/*
Why No Full Circle Simulation Is Needed

        By scanning once, we identify the only possible valid starting index.

        The proof is by contradiction:

            If totalGas ≥ totalCost, then some start must succeed.
            The greedy reset ensures we skip all impossible starts.
            The one we return is guaranteed to finish the circle (since globally there is enough gas).

So the trick is:

    Global check ensures enough fuel overall.
    Greedy reset ensures we skip all wrong starts.
    The returned index is mathematically guaranteed to work without simulating the wrap-around.
*/