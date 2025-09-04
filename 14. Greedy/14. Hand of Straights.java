// Leetcode: 846. Hand of Straights

// *********
// Complexity
// TC: O(N log N) → inserting all keys in PQ + iterating over hand
// SC: O(N) → hashmap + PQ


// *********
// Approach
/*
    1. If total cards not divisible by groupSize → return false
    2. Count frequency of each card using HashMap
    3. Use a minHeap (PriorityQueue) to always pick the smallest card
    4. For each smallest card, try to build a group of size = groupSize
       - Check if all consecutive cards exist in HashMap
       - Decrease count, and if 0 → remove from heap
       - If missing any card or order mismatch → return false
    5. If all groups are formed successfully → return true
*/


// *********
// Code
class Solution {
    public boolean isNStraightHand(int[] hand, int groupSize) {
        // check even divisiblility is possible or not
        if(hand.length % groupSize != 0) {
            return false;
        }
        
        // 1. count the frequency of the element into the hashmap
        Map<Integer, Integer> HM = new HashMap<>();
        for(int elem : hand) {
            HM.put(elem, HM.getOrDefault(elem,0) +1);
        }

        // 2. Use min heap to pick min elem for each group
        PriorityQueue<Integer> PQ = new PriorityQueue<>(HM.keySet());

        // 3. form groups
        while(!PQ.isEmpty()) {
            int firstElement = PQ.peek(); // first min element in minHeap
            for(int i = firstElement; i < firstElement+groupSize; i++) {
                // check in HM if exist reduce 1 count
                    // if not in the HM return false
                // if count is 0 -> remove from the heap
                    // if count is 0 and is not the peek element in PQ return false
                if(!HM.containsKey(i)) {
                    return false;
                }
                HM.put(i, HM.get(i)-1);
                if(HM.get(i) == 0) {
                    if(i != PQ.peek()) {
                        return false;
                    }
                    PQ.poll();
                }
            }
        }
        return true;
    }
}