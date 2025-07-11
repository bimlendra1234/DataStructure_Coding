// Leetcode: 21. Merge Two Sorted Lists

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
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {

        // Approach using two pointer and comparision
        // TC: O(N)
        // SC: O(1) if result is not being counted.

        // *********
        // Approach
        /*
        1. Maintain two pointer at the start of each listNode
        2. Create res pointing to -inf this will move
            returnNode to head of above pointer so that finally we can return returnNode.next
        3. Unless both are not null
            compare two pointer value and whichever is less put in res
                increase less pointer 
                increase res pointer
        4. once any one is finish
            attach the remaining one to the res.
        */


        // *********
        // Code
        ListNode res = new ListNode(Integer.MIN_VALUE);
        ListNode returnNode = res;
        
        ListNode head1 = list1;
        ListNode head2 = list2;

        while(head1 != null && head2 != null) {
            if(head1.val <= head2.val) {
                res.next = head1;
                res = res.next;
                head1 = head1.next;
            }
            else {
                res.next = head2;
                res = res.next;
                head2 = head2.next;
            }
        }

        // attach the entire remaining node
        if(head1 != null) {
            res.next = head1;
        }
        else {
            // (head2 != null)
            res.next = head2;
        }

        return returnNode.next;
    }
}