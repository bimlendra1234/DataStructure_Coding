// Leetcode : 199. Binary Tree Right Side View


// Approach using Level order search, BFS and saving last element in level
// TC: O(N)
// SC: O(N)


// *********
// Approach
/*
1. Do BFS traversal,
    and during each level just save the last element
*/


// *********
// Code

import java.util.* ;

class Solution {
    public List<Integer> rightSideView(TreeNode root) {

        if(root == null) {
            return new ArrayList<>();
        }
        
        List<Integer> res = new ArrayList<>(); //
        Queue<TreeNode> qu = new LinkedList<>();
        qu.add(root);

        while(!qu.isEmpty()) {
            int quSize = qu.size();
            int rightElemIndex = quSize-1; // right side element at last index of level element

            for(int i = 0; i < quSize; i++) {
                TreeNode temp = qu.poll();

                // only inserting the right side element
                if(i == rightElemIndex) {
                    res.add(temp.val);
                }

                // push the child of removing element
                if(temp.left != null) {
                    qu.add(temp.left);
                }
                if(temp.right != null) {
                    qu.add(temp.right);
                }
            }
        }

        return res;
    }
}