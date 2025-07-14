// Leetcode : 138. Copy List with Random Pointer


/*
// Definition for a Node.
class Node {
    int val;
    Node next;
    Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}
*/

class Solution {
    public Node copyRandomList(Node head) {

        // Approach using newNode in between, update random, seperation of two list
        // TC: O(N)
        // SC: O(1)


        // *********
        // Approach
        /*
        1. create new node in between by copying value
            update pointer such that it is in between
        2. update the random pointer of newly created node
            curr.next : newly created node
            curr.random: old pointer
            curr.random.next: point to new node as well
        3. Seperate new and original list using 4 pointer
            // whatever was in the newCurr.next will go in curr.next
                and move current to next
            // whatever was in curr.next will go in newCurr.next
                and move new current
        4. return head of new list
        */


        // *********
        // Code
        if(head == null) {
            return head;
        }
        
        Node curr = head;
        // create new node in between and insert them in between two original pointer
        while(curr != null) {
            Node copyNode = new Node(curr.val);
            copyNode.next = curr.next;
            curr.next = copyNode;
            curr = copyNode.next;
        }

        // update the pointer of newly created node
        curr = head;
        while(curr != null) {
            if(curr.random != null) {
                curr.next.random = curr.random.next; // curr.random.next: this is new copy node; curr.next : new copy node
            }
            curr = curr.next.next;
        }

        // seperate the the original and new copied linkedlist
        // with the help of 4 pointer
        // 1. head    3. curr
        // 2. newHead 4. newCurr
        curr = head;
        Node newHead = curr.next;
        Node newCurr = newHead;
        while(curr != null) {
            // whatever was in the newCurr.next will go in curr.next
            curr.next = newCurr.next;
            curr = curr.next;

            // whatever was in curr.next will go in newCurr.next
            if(curr != null) {
                newCurr.next = curr.next;
                newCurr = newCurr.next;
            }
        }

        return newHead;
    }
}
