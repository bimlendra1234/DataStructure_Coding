import java.util.*;

class MyHashSet {

    /*
    // Most basic approach but noot good
    // TC: O(1)
    // SC: O(N)

    // taking advantage of the fact that we know 0 <= key <= 10^6

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
    */

    // ---------------------------

    // Actual Implementation approach that need to be understood
    // TC: ?
    // SC: ?

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