// Leetcode: 543. Diameter of Binary Tree

// Approach While calculating height saving res as well with lh+rh
// TC: O(N)
// SC: O(Logn) - for BST and O(Logn) - for normal tree


// *********
// Approach 
/*
    1. The longest path (diameter) can pass through any node.
       At each node, the path = left height + right height.
    diameter =>max(Path of each node)

    2. To calculate height:
        - For a null node, return 0
        - For a non-null node, height = 1 + max(left height, right height)

    3. While calculating height recursively, 
        for each node i am calculating lh and right
        and also updating res with maximum of lh + rh
        and finally returning the height

    4. Final result is stored in 'res' after traversal.
*/


// *********
// Code
class Solution {
    int res = 0;
    public int findHeightOrMaxDepth(TreeNode root) {
        if(root == null) {
            return 0;
        }
        int leftHeight = findHeightOrMaxDepth(root.left);
        int rightHeight = findHeightOrMaxDepth(root.right);
        int height = 1+ Math.max(leftHeight, rightHeight);
        res = Math.max(res, leftHeight+rightHeight);
        return height;
    }

    public int diameterOfBinaryTree(TreeNode root) {
        findHeightOrMaxDepth(root);
        return res;
    }
}