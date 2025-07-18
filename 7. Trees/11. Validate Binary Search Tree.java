// Leetcode : 98. Validate Binary Search Tree


// Approach using BFS traversal: preoredr => root, left, right
// TC: O(N) - visiting each node exactly once.
// SC: = O(log N) for balanced BST
    // = O(N) for skewed BST


// *********
// Approach
/*
    1. understand that each element will lie with in their specific range
        root range = [-inf, +inf]
        Left range = [-inf, root]
        right range = [root, +inf]

        if element have value outside their range its not a BST

    2. check if root is valid that is inn between -inf to inf
        call isValid(root, Integer.MIN_VALUE, Integer.MAX_VALUE) our answer

    3. inside isValid function accept root , left range and right range

        a if root is null then its valid bst also its a base case
        b check if root: if it is itself invalid 
        c check if left ST lie within its range and right ST lie with in its range
        
        this denotes if root is not invalid and both LeftST and RightST is within their range then it is valid BST
*/


// *********
// Code
class Solution {

    public boolean isValid(TreeNode root, long leftRange, long rightRange) {
        
        // base condition to break the loop
        if(root == null) { // null root is valid BST
            return true;
        }

        // check the root
        if(!(leftRange < root.val && root.val < rightRange)) {
            return false;
        }

        // check left subtree if its valid and check right subtree if it is valid
            // value fall within their range
        return  isValid(root.left, leftRange, root.val) && isValid(root.right, root.val, rightRange);
    }  

    public boolean isValidBST(TreeNode root) {
        
        // root range = [-inf, +inf]
        // Left reange = [-inf, root]
        // right range = [root, +inf]
        return isValid(root, Long.MIN_VALUE, Long.MAX_VALUE);
    }     
}
