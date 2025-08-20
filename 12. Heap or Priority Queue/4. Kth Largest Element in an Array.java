// Leetcode : 215. Kth Largest Element in an Array

// TC: O((N+K) log N)
// SC : O(N)

// *********
// Approach
/*
    1. Create a minHeap (PriorityQueue) but push negative values,
       so the smallest negative represents the largest positive.

    2. Insert all nums[i] into heap with -nums[i].

    3. Pop k times → each poll removes one largest element.
       The k-th popped element is our answer.

    4. Return that element.
*/

/*
    Approach : Build a min-heap of all values using negation (push -num), then pop k times and negate back; the k-th pop is the k-th largest.

    Time & Space
        Time: O(n log n + k log n) = O((n+k) log n)
        (you insert all n elements into the heap → each offer is log n; then k polls are log n each.)

    Space: O(n) for storing all elements in the heap.
*/

// *********
// Code
class Solution {
    public int findKthLargest(int[] nums, int k) {
        
        PriorityQueue<Integer> maxHeapWithNegation  = new PriorityQueue<>();

        // 1. Insert all nums with negation
        for(int num : nums) {
            maxHeapWithNegation.offer(-num);
        }

        // 2. Poll k times
        int res = 0;
        for(int i = 0; i < k ; i ++) {
            int num = -maxHeapWithNegation.poll();
            if(i == k-1) {
                res = num;
            }
        }
        return res;
    }
}

// -------------------------------------------------------------------------

// Optimal Approach

// TC: Nlog K
// SC : O(K)

// *********
// Approach
/*
    1. Use a minHeap (smallest element stays at top).

    2. Insert every num into the heap.

    3. If heap size > k → remove the smallest element.
        → ensures heap always keeps only k largest numbers.

    4. After processing all elements:
        - heap contains k largest elements.
        - the smallest among them (at top) = k-th largest overall.

    5. Return heap.peek().
*/

/*
    Time & Space Complexity

    Time:
        Each offer/poll is O(log k) (heap size never exceeds k).
        For n elements → O(n log k) total.

    Space:
        Heap stores at most k elements → O(k).
*/

// *********
// Code
class Solution {
    public int findKthLargest(int[] nums, int k) {
        
        PriorityQueue<Integer> minHeap  = new PriorityQueue<>();

        for(int num : nums) {
            minHeap.offer(num);
            if(minHeap.size() > k) {
                minHeap.poll();
            }
        }

        return minHeap.peek();
    }
}