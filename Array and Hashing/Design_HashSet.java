class MyHashSet {
    // Most basic approach but noot good
    boolean[] arr;
    public MyHashSet() {
        // Initialize data structure here.
        // Using boolean array of size 1000001 to store presence of keys
        // as keys are in the range [0, 1000000].
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

/**
 * Your MyHashSet object will be instantiated and called as such:
 * MyHashSet obj = new MyHashSet();
 * obj.add(key);
 * obj.remove(key);
 * boolean param_3 = obj.contains(key);
 */