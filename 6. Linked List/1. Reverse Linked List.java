// Leetcode : 206. Reverse Linked List

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public ListNode reverseList(ListNode head) {

        // using iterative method
        // TC: O(N)
        // SC: O(1)

        // *********
        // Approach
        // 0. prev to null and current to head initially
        // 1. save all element after current in temp as it will be pointed to prev
        // 2. point current next to prev
        // 3. update prev and new current
                // old current will be prev
                // new current will be onne that was removed earlier i.e temp
        // 4. once current reach to null,
            // prev will point to last node which will be our head now.


        // *********
        // Code
        ListNode prev = null; 
        ListNode curr = head;

        while(curr != null) {
            ListNode temp = curr.next; // save the node before pointing to prev. this will be my current later
            curr.next = prev; // point node next to prev // all done now
            prev = curr; // set done to prev
            curr = temp; // this will be my new current start node where i will work again
        }

        // when curr goes to null
        // prev is at the last
        return prev;
    }
}