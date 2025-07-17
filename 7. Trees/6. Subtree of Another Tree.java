// Leetcode: 572. Subtree of Another Tree

// DFS recursion Approach: checking root then left and right subtree
// Time  : O(M*N)
// Space : O(M+N) – recursion depth equals taller tree


// *********
// Approach
/*
    check if root is same as subtree
    then check if left subtree is same as subtree or
    also chec if right subtree is same as subtree
*/


// *********
// Code
class Solution {
    public boolean isSameTree(TreeNode p, TreeNode q) {
        if(p == null && q == null) {
            return true;
        }
        else if(p == null || q == null || p.val != q.val) {
            return false;
        }
        return isSameTree(p.left, q.left) && isSameTree(p.right,q.right);
    }

    public boolean isSubtree(TreeNode root, TreeNode subRoot) {

        if(root == null) {
            return false;
        }
        if(isSameTree(root, subRoot)) {
            return true;
        }
        return isSubtree(root.left, subRoot) || isSubtree(root.right, subRoot);
    }
}