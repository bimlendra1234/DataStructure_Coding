// Leetcode: 141. Linked List Cycle

/**
 * Definition for singly-linked list.
 * class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
class Solution {
    public boolean hasCycle(ListNode head) {

        // Approach using two pointer, one fast and other slow
        // TC: O(N)
        // SC: O(1)


        // *********
        // Approach
        /*
        1. Maintain two pointer, fast and slow pointing to head at start
        2. until fast and fast.next is not null
            slow will run at 1 speed
            fast will run at twice speed
            if slow and fast meet thats a loop
        3. if fast.next reach no null
            thats not a loop
        */


        // *********
        // Code
        
        ListNode slow = head;
        ListNode fast = head;

        while(fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;

            if(slow == fast) {
                return true;
            }
        }

        return false;
    }
}