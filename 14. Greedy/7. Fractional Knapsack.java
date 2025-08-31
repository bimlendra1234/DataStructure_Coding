// Geeks For Geeks : Fractional Knapsack : https://www.geeksforgeeks.org/problems/fractional-knapsack-1587115620/1

// *********
// Complexity
// TC: O(n log n) → sorting by ratio + O(n) loop
// SC: O(n) → ratio index array


// *********
// Approach
/*
    1. Calculate value/weight ratio for each item.
            Store indices of items in an array.
            
    2. Sort items in decreasing order of ratio (greedy choice).
            Sort indices based on value/weight ratio in decreasing order (profit per weight).
            
    3. Traverse items one by one:
            If item weight > remaining capacity → take fraction and stop.
            Else → take the full item and reduce capacity.
            
    4. Keep adding value until capacity is filled.
    
    5. Return the total maximum value.
*/


// *********
// Code
class Solution {
    public double fractionalKnapsack(int[] val, int[] wt, int capacity) {
        // code here
        
        // 1. create ration array that hold kam weigt mai jyada profit and sort in decreasing order
        int n = val.length;
        Integer[] ratio = new Integer[n];
        for(int i = 0; i < n; i++) {
            ratio[i] = i;
        }
        
        Arrays.sort(ratio, (a,b) -> Double.compare( (double) val[b]/wt[b] , (double) val[a]/wt[a]) );
        
        double maxValue = 0.0;
        for(int i = 0; i < ratio.length; i++) {
            // fetch the index
            int idx = ratio[i];
            if(wt[idx] >= capacity) {
                maxValue += capacity * ((double)val[idx]/wt[idx]);
                capacity = 0;
            }
            else {
                // item weight < capacity , pick the entire value
                maxValue += val[idx];
                capacity -= wt[idx];
            }
            
            if(capacity == 0) {
                break;
            }
        }
        return maxValue;
    }
}
