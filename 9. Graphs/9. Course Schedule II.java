// Leetcode : 210. Course Schedule II

// Approach: For each course, visit all its prerequisites first using DFS, and add the course to the result after finishing its dependencies; return empty if a cycle is found.
// TC: O(N+P)
// SC: O(N+P)


// *********
// Approach
/*
    1. Create a HashMap<Integer, List<Integer>> to store course -> its list of prerequisites
        - For each course from 0 to numCourses - 1, initialize empty list
        - For each pair [a, b] in prerequisites, add b to list of a (a depends on b)

    2. Maintain two Sets:
        - visitingSet: stores nodes in current DFS path (for cycle detection)
        - alreadyVisitedSet: stores nodes already processed

    3. Create result array of size numCourses, and a global index pointer

    4. For each course i from 0 to numCourses - 1:
        - If it is not already visited, call DFS helper
        - If DFS detects a cycle, return empty array

    5. In DFS helper:
        - If course is already in visitingSet → cycle → return false
        - If already visited → return true
        - Else:
            - Add to visitingSet
            - DFS on all prerequisites
            - After recursion, remove from visitingSet
            - Mark as visited
            - Add course to result[index++] (post-order)

    6. Return result array
*/


// *********
// Code 

import java.util.*;

class Solution {
    int index = 0;
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        Map<Integer, List<Integer>> HM = new HashMap<>();

        for(int i = 0; i < numCourses; i++) {
            HM.put(i, new ArrayList<>());
        }

        for(int[] eachPrereq : prerequisites) {
           HM.get(eachPrereq[0]).add(eachPrereq[1]); 
        }

        Set<Integer> visitingSet = new HashSet<>();
        Set<Integer> alreadyVisitedSet = new HashSet<>();
        int[] res = new int[numCourses];
        for(int i = 0; i < numCourses; i++) {
            if(dfsHelper(i, res, HM, visitingSet, alreadyVisitedSet) == false) {
                return new int[0];
            }
        }

        return res;
    }

    public boolean dfsHelper(int currCourse , int[] res, Map<Integer, List<Integer>> HM, Set<Integer> visitingSet, Set<Integer> alreadyVisitedSet) {
        
        // BC - 1 : is Cycle
        if(visitingSet.contains(currCourse)) {
            return false;
        }

        // BC - 2 : already visited
        if(alreadyVisitedSet.contains(currCourse)) {
            return true;
        }

        visitingSet.add(currCourse);
        for(int eachPreReq : HM.get(currCourse)) {
            if(dfsHelper(eachPreReq, res, HM, visitingSet, alreadyVisitedSet) == false) {
                return false;
            }
        }
        visitingSet.remove(currCourse);
        alreadyVisitedSet.add(currCourse);
        res[index++] = currCourse;
        return true;
    }
}