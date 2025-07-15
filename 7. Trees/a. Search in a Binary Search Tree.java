// LeetCode: 700. Search in a Binary Search Tree

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

// TC: O(logN)
// SC: O(H)-> O(LogN)

// *********
// Approach
 /*
    1. If root itself is null, return null
    2. val > root.val then search in the right subtree
    3. val < root.val then search in the left subtree
    4. if val is same as root.val then return root
 */


 // *********
 // Code
class Solution {
    public TreeNode searchBST(TreeNode root, int val) {
        
        if(root == null) {
            return null;
        }

        if(val > root.val) {
            return searchBST(root.right, val);
        }
        else if(val < root.val) {
            return searchBST(root.left, val);
        }
        else{
            // here val is same as root
            return root;
        }
    }
}