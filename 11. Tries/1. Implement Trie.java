// Leetcode : 208. Implement Trie (Prefix Tree)

// *********
// Approach
/*
    1. Insert - O(word length i.e L)
        start from root
        take each char of word that need to be inserted
            find char idx
            check in root children if that idx has node or null
                if has null create new node at that idx
                if char is last one - mak EOW as true
            if already has node just change the root to that children idx
            

    ---------
    2. Search - O(word length i.e L)
        start from root
        take each char of word that need to be Searched
            find char idx
            check in root children if that idx has null - that means not present
                just return false
            also check if char is last word and EOW is false
                just return false
        came here means exist so change root to that children idx to search other value

    -------------
    3. Start With - O(word length i.e L)
        Same as Search but just dont check EOW condition
*/


// *********
// Code

class Node {
    boolean isEOW;
    Node[] children;

    public Node() {
        children = new Node[26];
        isEOW = false;
    }
}

class Trie {
    Node root;
    public Trie() {
        root = new Node();
    }
    
    public void insert(String word) {
        Node temp = root;
        for(int i =0 ; i < word.length(); i++) {
            int idx = word.charAt(i) - 'a';
            if(temp.children[idx] == null) {
                temp.children[idx] = new Node();
            }

            if(i == word.length()-1) {
                temp.children[idx].isEOW = true;
            }

            temp = temp.children[idx];
        }
    }
    
    public boolean search(String word) {
        Node temp = root;
        for(int i = 0; i < word.length(); i++) {
            int idx = word.charAt(i) - 'a';

            if(temp.children[idx] == null) { // not present
                return false;
            }

            // if last word does not have true EOW
            if(i == word.length()-1 && temp.children[idx].isEOW == false) {
                return false;
            }
            temp = temp.children[idx];
        }
        return true;
    }
    
    public boolean startsWith(String prefix) {
        Node temp = root;
        for(int i = 0 ; i < prefix.length(); i++) {
            int idx = prefix.charAt(i) -'a';

            if(temp.children[idx] == null) {
                return false;
            }
            temp = temp.children[idx];
        }
        return true;
    }
}

/**
 * Your Trie object will be instantiated and called as such:
 * Trie obj = new Trie();
 * obj.insert(word);
 * boolean param_2 = obj.search(word);
 * boolean param_3 = obj.startsWith(prefix);
 */