// Leetcode : 110. Balanced Binary Tree


// Brute Force
// Time Complexity: O(N²) : O(N) nodes × O(N) time to calculate height = O(N²)
// Space Complexity: O(H)


// *********
// Approach
/*
    1. helper function height calculate the height of a subtree.

    2. For each node (starting from the root):
        Compute height of left and right subtrees.
        If |leftHeight - rightHeight| > 1, return false.
    
    3. Recursively check if all the left and right subtrees are balanced.
*/


// *********
// Code
class Solution {
    public int height(TreeNode root) {
        if(root == null) {
            return 0;
        }
        int leftheight = height(root.left);
        int rightHeight = height(root.right);
        return 1 + Math.max(leftheight,rightHeight); 
    }

    public boolean isBalanced(TreeNode root) {
        if(root == null) {
            return true;
        }

        int leftheight = height(root.left);
        int rightHeight = height(root.right);
        if(Math.abs(leftheight - rightHeight) > 1) {
            return false;
        }
        // till above rooth is already checked
        // now check each root left and root right
        return isBalanced(root.left) && isBalanced(root.right);
    }
}

// -------------------------------------------------------------