// Leetcode premium: Number of Connected Components in an Undirected Graph : https://neetcode.io/problems/count-connected-components?list=neetcode150

// Approach : Traverse each unvisited node using DFS and mark all reachable nodes, incrementing the count for each new traversal to get the number of connected components.
// TC: O(V+E) : visit each node and edge once during DFS.
// SC: O(V+E) : for adjacency list, visited sets, and recursion stack.


// *********
// Approach
/*
    1. HM to store node and its adjacency list
        - key: node
        - value: list of connected neighbors
    2. Use two sets:
        - visitingSet: to track nodes currently in the DFS call stack (helps prevent cycles)
        - alreadyVisitedSet: to track nodes that have been fully processed
    3. Loop through all nodes from 0 to n-1
        - If the node is not in alreadyVisitedSet:
            - increment connected component count
            - call DFS to mark all connected nodes
    4. DFS Helper function:
        - If node is in visitingSet, return (already being processed)
        - Add node to visitingSet
        - For each neighbor:
            - Skip if it's the previous node (optional for undirected graph)
            - If neighbor not in alreadyVisitedSet, recurse
        - Remove node from visitingSet
        - Add node to alreadyVisitedSet
*/


// *********
// Code

import java.util.*;

class Solution {
    public int countComponents(int n, int[][] edges) {
        // 1. HM To store node and its adjacency list
        Map<Integer, List<Integer>> HM = new HashMap<>();
        for(int i = 0; i < n; i++) {
            HM.put(i, new ArrayList<>());
        }
        for(int[] tempList : edges) {
            HM.get(tempList[0]).add(tempList[1]);
            HM.get(tempList[1]).add(tempList[0]);
        }

        // 2. visiting set to denote the node being visited
        Set<Integer> visitingSet = new HashSet<>();
        Set<Integer> alreadyVisitedSet = new HashSet<>();

        // 3. call each node that is not being visited,
            // once inside any node mark all its connected component as visited
        int connectedComponent = 0;
        for(int i = 0; i < n; i++) {
            if(!alreadyVisitedSet.contains(i)) {
                connectedComponent++;
                DFSHelper(i, -1, HM, visitingSet, alreadyVisitedSet);
            }
        }

        return connectedComponent;
    }

    public void DFSHelper(int currNode, int prev, Map<Integer, List<Integer>> HM, Set<Integer> visitingSet, Set<Integer> alreadyVisitedSet) {
        if(visitingSet.contains(currNode)) {
            return;
        }

        visitingSet.add(currNode);
        for(int neighbor : HM.get(currNode)) {

            if(neighbor == prev) {
                continue;
            }

            if(!alreadyVisitedSet.contains(neighbor)) {
                DFSHelper(neighbor, currNode, HM, visitingSet, alreadyVisitedSet);
            }
        }

        visitingSet.remove(currNode);
        alreadyVisitedSet.add(currNode);
    }
}
