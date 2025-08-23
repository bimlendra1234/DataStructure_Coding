// Leetcode: 705. Design HashSet

import java.util.*;

/*
// Most Naive approach using array anad boolean value at its index
// TC: O(1)
// SC: O(N)


// *********
// Approach
// 1. take advantage of the fact that => 0 <= key <= 10^6
// 2. For constructor:
    // declare boolean array
    // inside constructor, initialize with the size of 10^6
// 3. For adding key:
    // at key idx set true
// 4. for removing key:
    // at key idx set false
// 5. for contains key:
    // return boolean value at that index


// *********
// Code
class MyHashSet {

    boolean[] arr;
    public MyHashSet() {
        arr = new boolean[1000001]; 
    }
    
    public void add(int key) {
        arr[key] = true;
    }
    
    public void remove(int key) {
        arr[key] = false;
    }
    
    public boolean contains(int key) {
        return arr[key];
    }
}
*/

// ----------------------------------------------------------------------------------

// Actual Implementation approach that need to be understood
    // TC: ?
    // SC: ?

class MyHashSet {

    final int bucketSize = 100;
    List<List<Integer>> bucket; // declaring the data Structure
    public MyHashSet() {
        bucket = new ArrayList<>(bucketSize);  // initializing the data structure
        for(int i = 0; i < bucketSize; i++) {  // no list inside the bucket now
            bucket.add(null);
        }
    }
    
    public void add(int key) {
        int index = key%bucketSize;
        List<Integer> childList = bucket.get(index);

        if(childList == null) {
            List<Integer> newList = new LinkedList<>();
            newList.add(key);
            // .add for initializing
            // .set for updating
            bucket.set(index, newList); 
        } else {
            if(!childList.contains(key)) {
                childList.add(key);
            }
        }
    }
    
    public void remove(int key) {
        int index = key%bucketSize;
        List<Integer> childList = bucket.get(index);
        if(childList != null && childList.contains(key)) {
            childList.remove(Integer.valueOf(key));
        }
     }
    
    public boolean contains(int key) {
        int index = key % bucketSize;
        List<Integer> childList = bucket.get(index);

        return childList != null && childList.contains(key);
    }
}

/**
 * Your MyHashSet object will be instantiated and called as such:
 * MyHashSet obj = new MyHashSet();
 * obj.add(key);
 * obj.remove(key);
 * boolean param_3 = obj.contains(key);
 */