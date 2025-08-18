// Leetcode : 703. Kth Largest Element in a Stream

// *********
// Time & Space Complexity
// add() → O(log k)
// constructor → O(n log k)
// Space → O(k) for heap


// *********
// Approach
/*
    1. Use a Min-Heap (PriorityQueue in Java) of size k.
    2. Keep only k largest elements in the heap:
        - If heap size < k → always insert.
        - Else, insert only if new val > heap.peek() (smallest among top-k).
        - If heap exceeds size k → remove smallest (poll).
    3. The top of the heap (peek) is always the kth largest element.
*/


// *********
// Code
class KthLargest {

    PriorityQueue<Integer> MH;
    int k;
    public KthLargest(int k, int[] nums) {
        this.k = k;
        MH = new PriorityQueue<>();
        for(int num : nums) {
            add(num);
        }
    }
    
    public int add(int val) {
        if(MH.size() < k || val > MH.peek()) {
            MH.offer(val);
            if(MH.size() > k) {
                MH.poll();
            }
        }
        return MH.peek();
    }
}

/**
 * Your KthLargest object will be instantiated and called as such:
 * KthLargest obj = new KthLargest(k, nums);
 * int param_1 = obj.add(val);
 */

 /*
 Time Complexity

    Constructor
        You loop through all n numbers in nums.
        Each call to add() can at worst do:
        offer(val) → O(log k) (heapify up)
        maybe poll() → O(log k) (heapify down)
        So each element takes O(log k).
        Total = O(n log k).

    add(val)
        Case 1: if heap size < k → just offer() → O(log k).
        Case 2: if val > peek → offer() + maybe poll() → O(log k) + O(log k) = O(log k).
        Case 3: if val ≤ peek and size==k → do nothing → O(1).
        Worst case = O(log k).

    So:
    add() → O(log k) per call.
    Constructor → O(n log k).
    ---------------------------------------
    
    Space Complexity
        Heap stores at most k elements.
        No other significant data structures.

    So: O(k) space.
 */