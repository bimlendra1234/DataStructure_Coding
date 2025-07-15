// Leetcode: 102. Binary Tree Level Order Traversal

// TC: O(N)
// SC: O(N)


// *********
// Approach
/*
    1. Using BFS: Level order traversal
    2. use queue data st and start at root 
        qu.add(root)
    3. run while untill queue is not empty
        maintain level size for now
        maintain level list as well to add all level element into res
        run the loop till that size
            pop elem, 
            save it val in level elem 
            and push left and right child if any
        after loop add level element into res
    4. go back to while loop that will be our next level
        do all level until queue is empty
    5. finally return the result that we gathered level by level using for loop above
*/


// *********
// Code

import java.util.*;

class Solution {
    public List<List<Integer>> levelOrder(TreeNode root) {
        
        if (root == null) {
            return new ArrayList<>();
        }
        
        List<List<Integer>> res = new ArrayList<>();
        Queue<TreeNode> qu = new LinkedList<>();
        qu.add(root);

        while(!qu.isEmpty()) {
            int levelSize = qu.size();
            List<Integer> levelElement = new ArrayList<>();
            for(int i = 0; i < levelSize; i++) {
                TreeNode node = qu.poll();
                levelElement.add(node.val);
                if(node.left != null) {
                    qu.add(node.left);
                }
                if(node.right != null) {
                    qu.add(node.right);
                }
            }
            res.add(levelElement);
        }
        return res;
    }
}