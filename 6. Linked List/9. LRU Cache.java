// Leetcode: 146. LRU Cache

import java.util.*;

// Optimal approach using Circular linked list and Hashmap<key, Node>
// TC: O(1)
// SC: O(N)


// *********
// Approach
/*
0. Use two data structure
    a. Doubly linked list with pointer to head and tail
        so that we have flexibility to add at head and delete at tail in constant time complexity
        Least recently used will be at tail that need to be removed
        Most frequently use will be at head.
    b. Hashmap<key, Node>
    at the begining head and tail will point to each other with 0 values in it, which is our cll

1. For ->  get(key)
    if key do not exist return -1 
    if key exist
        find the node using key, save it as well let say saved in fetchedNode
        remove fetchedNode from the C-linked list
        insert fetchedNode at the head
        return fetchedNode.val
2. For - Put(key, value)
    a. If key already present in the hash map
            find the existing node
            remove from the cLL
            remove from the map as well
            create new node with key val
            insert at the head
            put in the HM
    b. If HM is completely filled
            remove the node pointing by tail from cLL
            remove from the HM
            create new node with key val
            insert at the head
            put in the HM
    c. if key value not present in the HM and HM space is available
            create new node with key val
            insert at the head
            put in the HM
*/


// *********
// Code
class Node {
    int key;
    int val;
    Node next;
    Node prev;

    public Node(int key, int val) {
        this.key = key;
        this.val = val;
        this.next = null;
        this.prev = null;
    }
}


class LRUCache {

    // use two data structure
            // 1. Doubly linked list with pointer to head and tail
            // 2. Hashmap<key, Node>
        
    Map<Integer, Node> HM;
    Node head;
    Node tail;
    int capacity;

    public LRUCache(int capacity) {  
        this.capacity = capacity;
        this.HM = new HashMap<>();
        this.head = new Node(0,0);
        this.tail = new Node(0,0);
        this.head.next = this.tail;
        this.tail.prev = this.head;
    }

    public void insertAtHead(Node newNode) {
        Node temp = head.next;
        head.next  = newNode;

        temp.prev = newNode;

        newNode.next = temp;
        newNode.prev = head;
    }

    public void remove(Node node) {
        Node next = node.next;
        Node prev = node.prev;

        prev.next = next;
        next.prev = prev;
    }
    
    public int get(int key) {
        // if key exist in HM
        if(HM.containsKey(key)) {
            Node fetchNode = HM.get(key);
            remove(fetchNode);
            insertAtHead(fetchNode);
            return fetchNode.val;
        }
        return -1; // if key do not exist in HM
    }
    
    public void put(int key, int value) {
        //1. If key already exist in the HM already
        if(HM.containsKey(key)) {
            Node existingNode = HM.get(key);
            remove(existingNode);
            HM.remove(key);
        }

        //2. if capacity is full
        if(HM.size() >= capacity) {
            Node toRemove = tail.prev;
            remove(tail.prev);
            HM.remove(toRemove.key);
        }

        //3. if key do not exist
        Node newNode = new Node(key, value);
        insertAtHead(newNode);
        HM.put(key, newNode);
    }
}

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */