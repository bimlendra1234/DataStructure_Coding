// Leetcode : 1046. Last Stone Weight

// Build max-heap via negation: O(N)
// Pop/push per smash: O(log N) and we do it ~N times
// TC: O(N Logn)
// SC: O(N)


// *********
// Approach : using a min-heap with negated values to simulate a max-heap
/*
    1. Push all stones as negatives into a min-heap (acts like max-heap).
        From the given array create max heap using minHeap
        just for each number negiate it so that positive number if negiate it will come at top
        while pop just negiate it ti take positive number

    2. While size > 1: pop two heaviest (negate back), smash them.
        until heap size is greater then 1
        pop top two elem and put the difference in heap again with negative sign

            If unequal, push (heavier - lighter) back as negative.
            If equal, both vanish (do nothing).

    4. at last if only one elem is left return it with -sign 

    5. if none left return 0 

*/

// *********
// CODE
class Solution {
    public int lastStoneWeight(int[] stones) {
        PriorityQueue<Integer> minHeaptoMaxHeap = new PriorityQueue<>();

        for(int stone : stones) {
            minHeaptoMaxHeap.offer(-stone);
        }

        while(minHeaptoMaxHeap.size()>1) {
            int weight1 = -minHeaptoMaxHeap.poll(); // will pop 1st heaviest
            int weight2 = -minHeaptoMaxHeap.poll(); // will poll other heaviest

            if(weight1 > weight2) {
                int collosionWeight = Math.abs(weight1 - weight2);
                minHeaptoMaxHeap.offer(-collosionWeight);
            }
        }

        return minHeaptoMaxHeap.size() == 1 ? (- minHeaptoMaxHeap.peek()) : 0;
    }
}