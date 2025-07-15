// Leetcode: 226. Invert Binary Tree

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */


 // *********
 // Approach
 /*
    1. if nothing in root then nothing to revert
    2. first inverst left and right pointer
        so that mine entire subtree will be swaped
        element in the subtree is not inverted yet

        // Steps to invert left and right pointers
        save root left node as temp
        assign right node to left 
        assign saved left node i.e temp to right

    3.  now invert left subtree
    4. now invert right subtree
    5. return root
 */


 // *********
 // Code
class Solution {
    public TreeNode invertTree(TreeNode root) {
        
        // Base case
        if(root == null) {
            return root;
        }

        // Invert left and right pointers
        TreeNode temp = root.left;
        root.left = root.right;
        root.right = temp;
        // now invert left subtree
        invertTree(root.left);
        // now invert right subtree
        invertTree(root.right);

        return root;
    }
}