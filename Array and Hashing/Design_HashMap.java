// linked list node class
// Extra I created
class ListNode {
    // these are the three thing that will be hold inside the map later
    // key -> val -> next
    int key, val;
    ListNode next;

    public ListNode(int key, int val, ListNode next) {
        this.key = key;
        this.val = val;
        this.next = next;
    }

    public ListNode() {
        this(-1, -1, null);

        // also can be written as
        // this.key = -1;
        // this.val = -1;
        // this.next = null;
            
    }
}

class MyHashMap {

    // Implementation using Linked List

    // TC: ?
    // SC: ?

    // getting the index of any key that is key in key value pair


    final int HASH_Size = 1000;
    //declaring the datastructure
    private ListNode[] map;

    public MyHashMap() {
        //initializing the datastructure
        map = new ListNode[HASH_Size]; // all element null now
        for (int i = 0; i < HASH_Size; i++) {
            map[i] = new ListNode(); // all initialized with default constructor -1,-1,null
        }
    }
    
    //extra i created
    public int getIndex(int key) {
        return (key % HASH_Size);
    }
    
    public void put(int key, int value) {
        int index = getIndex(key);
        ListNode current = map[index];
        while(current.next != null) {
            if(current.next.key == key) {
                current.next.val = value;
                return;
            }
            current = current.next; 
        }
        current.next = new ListNode(key,value,null);
    }
    
    public int get(int key) {
        int index = getIndex(key);
        ListNode current = map[index];
        while(current.next != null) {
            if(current.next.key == key) {
                return current.next.val;
            }
            current = current.next;
        }
        return -1;
    }
    
    public void remove(int key) {
        int index = getIndex(key);
        ListNode current = map[index];
        while(current.next != null) {
            if(current.next.key == key) {
                current.next = current.next.next;
                return;
            }
            current = current.next;
        }
    }
}

/**
 * Your MyHashMap object will be instantiated and called as such:
 * MyHashMap obj = new MyHashMap();
 * obj.put(key,value);
 * int param_2 = obj.get(key);
 * obj.remove(key);
 */