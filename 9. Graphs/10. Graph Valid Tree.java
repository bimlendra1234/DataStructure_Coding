// LeetCode Premium : Graph Valid Tree :  https://neetcode.io/problems/valid-tree?list=neetcode150

// Approach: Use DFS to detect any cycle and ensure all n nodes are visited to confirm the graph is acyclic and fully connected, i.e., a valid tree.
// TC: O(V+E)
// SC: O(V+E)


// *********
// Approach
/*

    1. Initialize an adjacency list HM of size n to store undirected edges.
        - For every edge [u, v], add v to u’s list and u to v’s list.

    2. Use a visitSet to keep track of all visited nodes.

    3. Start DFS from node 0 with parent -1.

    4. Inside DFSHelper:
        a. If current node is already visited → return false (cycle detected).
        b. Mark node as visited.
        c. For each neighbor:
            i. If neighbor is the previous node → skip (don’t go backward).
            ii. If recursive DFS returns false → propagate false.

    5. After DFS:
        - If any cycle was detected → return false.
        - Else, check if all nodes were visited → return (visitSet.size() == n).

    6. If both no cycle and fully connected → return true (valid tree).
*/

// *********
// Code
class Solution {
    public boolean validTree(int n, int[][] edges) {
        // 1. Creating Adjacency list
        Map<Integer, List<Integer>> HM = new HashMap<>();

        for(int i = 0 ; i < n ; i++) {
            HM.put(i, new ArrayList<>());
        }

        for(int[] eachNeighbor : edges) {
            HM.get(eachNeighbor[0]).add(eachNeighbor[1]);
            HM.get(eachNeighbor[1]).add(eachNeighbor[0]);
        }
        // 2. visit set to detect loop
        Set<Integer> visitSet = new HashSet<>();
        
        // 3. pass the 1st oth node with prev -1 and dfs based on adjList
        if(!DFSHelper(0,-1, HM, visitSet)) {
            // if return false means loop so return false;
            return false;
        }

        return n == visitSet.size();  // checking size as well if visitSet contain all node or not
    }

    public boolean DFSHelper(int currNode, int prev, Map<Integer, List<Integer>> HM, Set<Integer> visitSet) {

        if(visitSet.contains(currNode)) {
            return false;
        }

        visitSet.add(currNode);
        // for all adjlist call its neighbor
        for(int eachNeighbor : HM.get(currNode)) {
            if(prev == eachNeighbor) {
                continue;
            }

            if(!DFSHelper(eachNeighbor,currNode, HM, visitSet)) {
                return false;
            }
        }

        return true;
    }
}
