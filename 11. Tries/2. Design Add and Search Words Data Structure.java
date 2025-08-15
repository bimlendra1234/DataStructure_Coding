// Leetcode : 211. Design Add and Search Words Data Structure

// Time Complexity:
        // addWord()  : O(n) 
            // → n = length of the word
        // search()   : O(n) in normal case
                     // O(26^d * n) in worst case
                       // → d = number of '.' in pattern
                       // → branching factor of 26 at each '.'

// Space Complexity:
        // O(t + n)
            // → t = total TrieNodes created in the Trie
            // → n = length of the current word being processed


// *********
// Approach
/*
    1. Use a Trie data structure:
         - Each node contains:
             → children[26] : reference to next char nodes
             → isEow        : flag to mark end of word

    2. addWord(word):
         - Start from root node
         - For each char in word:
             → Calculate index = char - 'a'
             → If children[index] is null → create new node
             → Move to children[index]
         - After processing all chars → mark isEow = true

    3. search(word):
         - Call dfs(word, root, startIndex = 0)

    4. dfs(word, node, j):
         - Traverse from index j till end:
             a) If current char == '.':
                 → Try all 26 children
                 → If any child dfs(...) returns true → return true
                 → Else return false
             b) Else:
                 → Calculate index = char - 'a'
                 → If children[index] is null → return false
                 → Move to children[index]
         - After loop ends → return node.isEow (must be a valid word end)
*/


// *********
// Code
class Node {
    boolean isEow;
    Node[] children;

    public Node() {
        children = new Node[26];
        isEow = false;
    }
}

class WordDictionary {
    Node root;
    
    public WordDictionary() {
        root = new Node();
    }
    
    public void addWord(String word) {
        Node temp = root;
        for(int i = 0; i < word.length(); i++) {
            int idx = word.charAt(i) - 'a';

            if(temp.children[idx] == null) {
                temp.children[idx] = new Node();
            }

            if(i == word.length()-1) {
                temp.children[idx].isEow = true;
            }

            temp = temp.children[idx];
        }
    }
    
    public boolean search(String word) {
        return dfs(word, root, 0);
    }

    public boolean dfs(String word, Node root, int j) {
        Node temp = root;
        for(int i = j; i < word.length(); i++) {

            if(word.charAt(i) == '.') {
                // need to check all path and backtrack.
                for(Node child : temp.children) {
                    if(child != null && dfs(word, child, i+1)) {
                        return true;
                    }
                }
                return false;
            }

            else 
            {
                int idx = word.charAt(i) - 'a';
                if(temp.children[idx] == null) {
                    return false;
                }

                temp = temp.children[idx];
            }
        }
        return temp.isEow;
    }
}

/**
 * Your WordDictionary object will be instantiated and called as such:
 * WordDictionary obj = new WordDictionary();
 * obj.addWord(word);
 * boolean param_2 = obj.search(word);
 */