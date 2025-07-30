// LeetCode : 207. Course Schedule

// Approach: Build HM course -> prerequisites Adj list, use DFS with a visited set to detect cycles, marking courses as complete if all dependencies are resolvable.
// TC: O(V+E) : Each course and its prerequisite edge is visited at most once during DFS traversal.
// SC: O(V+E) : Space is used for the adjacency list, recursion stack, and visited set, all proportional to the number of courses and prerequisites.


// *********
// Approach
/*
    1. Create HashMap (course -> list of prerequisites).
    2. Use a HashSet to to track node currently being visited and detect cycle
    3. For each course, call DFS to check if it can be completed.
        if any course return false means that cant be taken instantly return false
        if false not returned then finally return true.
    4.  Implementing canTakeCourseDFS helper fun
            BC 1:  if currCourse already in visitSet, thats a cycle return false
            BC 2:  if in HM, CurrCourse has Empty list that means it can be taken
            came here means: has other dependent
                1st add into visitSet
                using for loop call dfs on its adj list from HM
                    if any child cant be taken i.re being visited again -> Cycle return false
                cam here means child can be taken 
                    so remove from the visitSet, 
                    make HM prereq as empty list and 
                    return true
*/


// *********
// Code

import java.util.*;

class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        
        // 1. Create HM and fill course -> its preReq
        Map<Integer, List<Integer>> HM = new HashMap<>(); // map : course -> adjList(i.e prerequisite)
        
        // filling key(numcourses) and empty list in HM
        for(int i = 0; i < numCourses; i++) {
            HM.put(i, new ArrayList<>());
        }

        // filling the adjacency list in HM (i.e filling prereq for the course)
        for(int[] preReq : prerequisites) {
            HM.get(preReq[0]).add(preReq[1]);
        }

        // 2. use set to track node currently being visited
        Set<Integer> visitSet = new HashSet<>();

        // 3. call each course one by one using dfs 
            // if any course return false means that cant be taken instantly return false
            // if false not returned then finally return true.
        for(int i = 0; i < numCourses; i++) {
            if(!canTakeCourseDFS(i, HM, visitSet)) {
                return false;
            }
        }
        return true;
    }

    public boolean canTakeCourseDFS(int currCourse, Map<Integer, List<Integer>> HM, Set<Integer> visitSet) {
        // Base Case 1:  if currCourse already in visitSet, thats a cycle return false
        if(visitSet.contains(currCourse)) {
            return false;
        }

        // Base Case 2:  if in HM, CurrCourse has Empty list that means it can be taken
        if(HM.get(currCourse).isEmpty()) {
            return true;
        }

        // came here means: has other dependent
            // 1st add into visitSet
            // using for loop call dfs on its adj list from HM
                // if any child cant be taken return false
            // cam here means child can be taken 
                // so remove from the visitSet, 
                // make HM prereq as empty list and 
                // return true
        visitSet.add(currCourse);
        for(int eachPreReq : HM.get(currCourse)) {
            if(!canTakeCourseDFS(eachPreReq, HM, visitSet)) {
                return false;
            }
        }
        visitSet.remove(currCourse);
        HM.put(currCourse, new ArrayList<>());
        return true;

    }
}