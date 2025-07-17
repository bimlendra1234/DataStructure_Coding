// Leetcode : 100. Same Tree

// Optimal Approach: checking root then left and right subtree
// Time  : O(N + M)  – visit each node once
// Space : O(max(H, K)) – recursion depth equals taller tree


// *********
// Approach - PreOrder : root + left + right
/*
    1. base case
        check if both root are same
            if both null - true
            if onlu one null - false
            if both val different - false
    
    2. After checking root 
        if left subtree and right subtree same then return true
*/


// *********
// Code
class Solution {
    public boolean isSameTree(TreeNode p, TreeNode q) {
        if(p == null && q == null) {
            return true;
        }
        if(p == null && q != null) {
            return false;
        }
        if(p != null && q == null) {
            return false;
        }
        if(p.val != q.val) {
            return false;
        }
        return isSameTree(p.left, q.left) && isSameTree(p.right, q.right);
    }
}