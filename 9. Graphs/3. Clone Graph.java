// Leetcode: 133. Clone Graph

/*
// Definition for a Node.
class Node {
    public int val;
    public List<Node> neighbors;
    public Node() {
        val = 0;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val) {
        val = _val;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val, ArrayList<Node> _neighbors) {
        val = _val;
        neighbors = _neighbors;
    }
}
*/


// Approach using DFS
// TC: O(V*E)
// SC: O(V)


// *********
// Approach
/*
    1. go through each node one by one
    2. create new node for old node and add into the HM.
        keep the track of node that has already been created
        So that while visiting neighbor,
            If already cloned just add it
            if not clone then clone it and add into neighbors
*/

import java.util.*;

class Solution {
    public Node cloneGraph(Node node) {
        if(node == null) {
            return null;
        }
        Map<Node, Node> HM = new HashMap<>();
        return DFSCloneUtils(node, HM);
    }

    public Node DFSCloneUtils(Node node, Map<Node, Node> HM) {
        //1. create copy of old node and store into HM
        Node newNode = new Node(node.val); // neighbor are empty
        HM.put(node, newNode);

        // 2 Assign all the neighbor of new node from old nodes
        for(Node neighbor : node.neighbors) {
            // 2.a if not cloned , then first clone and then add into neighbor
            if(!HM.containsKey(neighbor)) {
                DFSCloneUtils(neighbor, HM);
            }
            // 2.b if already cloned just add neighbor
            newNode.neighbors.add(HM.get(neighbor));
        }

        return newNode;
    }
}