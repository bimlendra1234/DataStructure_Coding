// Leetcode: 104. Maximum Depth of Binary Tree


// TC: O(N)
// SC: O(N)


// *********
// Approach
/*
    1. using BFS traversal
        i am counting each level
    2. return the level counted
*/


// *********
// Code

import java.util.*;

class Solution {
    public int maxDepth(TreeNode root) {
        
        if (root == null) {
            return 0;
        }

        Queue<TreeNode> qu = new LinkedList<>();
        qu.add(root);
        int level = 0;

        while(!qu.isEmpty()) {
            level ++;
            int qSize = qu.size();
            for(int i = 0; i < qSize; i++) {
                TreeNode node = qu.poll();
                if(node.left != null) {
                    qu.add(node.left);
                }
                if(node.right != null) {
                    qu.add(node.right);
                }
            }
        }
        return level;
    }
}

// -------------------------------------------------------------------

// Using DFS (recursive): postorder approach (left-right-root) to compute max depth
// TC: O(N)
// SC: O(N)

class Solution {
    public int maxDepth(TreeNode root) {
        if(root == null) {
            return 0;
        }

        return 1 + Math.max(maxDepth(root.left), maxDepth(root.right));
    }
}