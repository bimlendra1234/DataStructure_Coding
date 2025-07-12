// Leetcode: 143. Reorder List

/*
// BF approach using Array
// TC: O(N)
// SC: O(N)


// *********
// Approach

// 1. Store the linked list in such place so that we can access its quiclely
    // use array
// 2. convert LL into array
// 3. use two pointer one at 1st and other at last
// 4. create res LL
// 5. do while left <= right
    // insert left element at res
    // left++
    // insert right element at res
    // right--
// 6. res LL is our Reorder list


//*********
// No code yet
*/

// ------------------------------------------------------------------------

// Optimal approach using midpoint, reverse second hald and merge both list
// TC: O(N)
// SC: O(1)


// *********
// Approach
/*
1. Find middle of the element - using slow and fast pointer
    here slow is mine midpoint

2. Reverse the second half after midpoint
    curr will be mine midpoint.next and prev will point to null

    with this midPoint.next = null
        we seperated both the list
        now till mid point it will be one list 
        after mid point it will be second list

    prev is the head of second reverse list

3. Merge then (both list) using two pointer, first and second
    i have two list one left i.e head and other right which is reverse one i.e prev
    while loop untill second != null
        because second contain half element

        Merging
            seperate first and remaining of first as : temp 1
            seperate second and remaining of second as : temp2
            after first attach second
            after second attach remaining of first i.e temp1 : this was the rule
            till here merged now change first and second pointer
                now first will be which was after first initially i.e temp1
                now Second will be which was after second initially i.e temp2
*/


// *********
// Code
class Solution {
    public void reorderList(ListNode head) {
        
        // Find middle of the element
        ListNode slow = head;
        ListNode fast = head;
        while(fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        ListNode midPoint = slow; // slow is midpoint here

        // now till mid point it will be one list 
        // after mid point it will be second list

        // reverse the second half
        ListNode prev = null;
        ListNode curr = midPoint.next;
        midPoint.next = null; // Important to break the list here (we seperated both the list here)
        while(curr != null) {
            ListNode temp = curr.next;
            curr.next = prev;
            prev = curr;
            curr = temp;
        }
        // here prev is the head of second reverse list

        // merge then using two pointer
            // i have two list one left i.e head and other right which is reverse one i.e prev
        ListNode first = head;
        ListNode second = prev;
        while(second != null) { // because second contain half element
            ListNode temp1 = first.next;  // seperate first and remaining of first as : temp 1
            ListNode temp2 = second.next; // seperate second and remaining of second as : temp2
            first.next = second; // after first attach second
            second.next = temp1; // after second attach remaining of first
            first = temp1; // now first will be which was after first initially i.e temp1
            second = temp2; // Second will be which was after second initially i.e temp2
        }
    }
}