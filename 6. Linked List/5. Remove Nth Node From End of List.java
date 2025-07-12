// Leetcode: 19. Remove Nth Node From End of List

/*
// Other Approach
// 1. Reverse linked list and delete nth node
*/

// -----------------------------------------------------------

// Approach using two pointer at the gap n
    // so that left pointer stand before what we need to delete
// TC: O(N)
// SC: O(1)


// *********
// Approach
/*
1. Maintain two pointer first and second with the gap of n+1
    so that our first pointer stand just before the element we need to delete
2. To maintain gap of n+1, use dummy node that will point to head
    its like dummy at idx 0
    head at idx 1
3. So at begining first point to dummy and second point to head: which is 0 gap between them
    now move the second to n gap as well
        using while n!= 0
            second = second.next;
            gap--;
    so total gap between them is N now
4. untill second reach to null
    increment both by 1
5. now first is at place just before that need to be deleted
6. delete (next to first) node by 
    first.next = first.next.next
7. we need to return head so returnn dummyNode.next
*/


// *********
// Code 
class Solution {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode dummy = new ListNode(0);
        dummy.next = head;

        ListNode first = dummy;
        ListNode second = head;
        int gap = n; 
        // when total gap is n :  first ends up just before the node that we want to delete.
        while(gap != 0) {
            second = second.next;
            gap--;
        }

        while(second != null) {
            first = first.next;
            second = second.next;
        }

        first.next = first.next.next;
        return dummy.next;
    }

  
    // Definition for singly-linked list.
    public class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }
}