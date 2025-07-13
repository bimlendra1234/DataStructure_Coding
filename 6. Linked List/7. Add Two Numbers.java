// Leetcode: 2. Add Two Numbers


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

// Approach using sum and creating new node, as well as carru over
// TC: O(max(M,N))
// SC: O(max(M,N))


// *********
// Approach
// 1. two pointer (cur1, cur2) to traverse l1 and l2
// 2. create dummy node that will target res
    // cur3 pointer to traverse res
// 3. while both list has some element
    // it will identify initial carry over
    // sum will be : initial carry + cur1 + cur2
    // next carry will be: sum /10;
    // value remain that create new node : sum%10
    // increment cur1, cur2, cur3
// 4. while single list list has some element and other finished
    // sum will be : initial carry + cur1 + cur2
    // next carry will be: sum /10;
    // value remain that create new node : sum%10
    // increment cur3, left pointer
// 5. at last if any carryover is remain
    // create new node with that value and assign it into cur3.next
// 6. return dummy.next



// *********
// Code
class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode cur1 = l1; // pointer to traverse l1
        ListNode cur2 = l2; // pointer to traverse l2
        ListNode dummy = new ListNode(0); // empty node pointing to res
        ListNode cur3 = dummy; // // pointer to traverse res i.e dummy

        int carry = 0;
        while(cur1 != null && cur2 != null) {
            int sum = cur1.val + cur2.val + carry;
            carry = sum/10;
            int toUse = sum%10;
            cur3.next = new ListNode(toUse);
            cur1 = cur1.next;
            cur2 = cur2.next;
            cur3 = cur3.next;
        }

        while(cur1 != null) {
            int sum = cur1.val + carry;
            carry = sum/10;
            int toUse = sum%10;
            cur3.next = new ListNode(toUse);
            cur1 = cur1.next;
            cur3 = cur3.next;
        }

        while(cur2 != null) {
            int sum = cur2.val + carry;
            carry = sum/10;
            int toUse = sum%10;
            cur3.next = new ListNode(toUse);
            cur2 = cur2.next;
            cur3 = cur3.next;
        }

        if(carry != 0) {
            cur3.next = new ListNode(carry);
        }

        return dummy.next;
    }
}