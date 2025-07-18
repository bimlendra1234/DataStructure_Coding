// Leetcode: 1448. Count Good Nodes in Binary Tree

// Approach using preorder: root left, right
// TC: O(N)
// SC: O(N)


// *********
// Approach using preorder: root left, right
/*
    1. if root os null then we have 0 good nodes

    2. check root if its good node
        when rootVal > maxSoFar that is good note (initially maxSoFar is minimum negative -inf)
        update maxSoFar if rootVal > maxSoFar
        increment our res

    3. then check total good nodes in leftSubtree
    4. also check total good nodes in right subtree 
*/


// *********
// Code
class Solution {
    
    public int count (TreeNode root, int maxSoFar) {
        int res = 0;
        
        if(root == null) {
            return 0;
        }

        // check root if its good node
        if(root.val >= maxSoFar) { 
            maxSoFar = root.val;
            res++;
        }

        // check total good nodes in leftSubtree and right subtree
        res += count(root.left, maxSoFar); // this will not change maxSoFar that will be ppassed below as it will have its own rec stack 
        res += count(root.right, maxSoFar);
        return res;
    }

    public int goodNodes(TreeNode root) {
        return count(root, Integer.MIN_VALUE);
    }
}