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

// Optimal Approach: while calculating height, we are checking if it is balanced, if anytime -1 that means not balanced
// Time Complexity: O(N) : we calculated height of each nodes
// Space Complexity: O(H)


// *********
// Approach - PostOrder : left+right+rot
/*
    1. helper function height calculate the height of a subtree.

        // while calculating height of any node
            if we found Math.abs(leftHeight-rightHeight) > 1
                return -1

            if any call receive -1 then it will further return -1
                But if height receive is correct the it will return actual correct height
    
    2. in the actual function 
        We will receive height 
            if its -1 return false else return true
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
        if(Math.abs(leftheight-rightHeight) > 1) {
            return -1;
        }

        // if any call receive -1 then it will further return -1 instead off actual height
            // which denotes we already found that at some place it is not balanced 
        if(leftheight == -1 || rightHeight == -1) {
            return -1;
        }
        else {
            return 1 + Math.max(leftheight,rightHeight); 
        }
    }

    public boolean isBalanced(TreeNode root) {
        if(root == null) {
            return true;
        }

        int val = height(root) ;
        if(val == -1) {
            return false;
        }
        return true;
    }
}