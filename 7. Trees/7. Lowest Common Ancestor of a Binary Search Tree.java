// Leetcode: 235. Lowest Common Ancestor of a Binary Search Tree

// Brutforce Approach using recursion
// TC: Balanced BST: O(log N)
// TC: Skewed BST (worst case): O(N)
// SC: Balanced BST: O(log N)
// SC: Skewed BST (worst case): O(N)


// *********
// Approach
/*
    1. if any one of them is root then that is our LCA
    2. If there is split 
        one lies in left and other in right then root is our LCA
    3. If both of them is greater then root then LCA lies on right - recursively
    4. If both of them is lesser then root then LCA lies on left - recursively
*/


// *********
// Code
class Solution {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        TreeNode curr = root;

        // 1. if any one of them is root then that is our LCA
        if(curr.val == p.val || curr.val == q.val) {
            return curr;
        }

        // 2. If there is split 
            // one lies in left and other in right then root is our LCA
        if(
            p.val < curr.val && q.val > curr.val  || 
            q.val < curr.val && p.val > curr.val
            ) {
                return curr;
        }

        // 3. If both of them is greater then root then LCA lies on right
        if(p.val > curr.val && q.val > curr.val) {
                return lowestCommonAncestor(root.right, p, q);
        }

        // 4. If both of them is lesser then root then LCA lies on left
        if(p.val < curr.val && q.val < curr.val) {
                return lowestCommonAncestor(root.left, p, q);
        }

        return curr;
    }
}

// -------------------------------------------------------------

// Same as above but using iterative approach - while loop
// TC: Balanced BST: O(log N)
// TC: Skewed BST (worst case): O(N)
// SC: O(1) - no extra space used


// *********
// Approach
/*
    1. if any one of them is root then that is our LCA
    2. If there is split 
        one lies in left and other in right then root is our LCA
    3. If both of them is greater then root then LCA lies on right - using while loop
    4. If both of them is lesser then root then LCA lies on left - using while loop
 */


 // *********
 // Code
class Solution {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        TreeNode curr = root;

        while(curr != null) {
            // 1. if any one of them is root then that is our LCA
            if(curr.val == p.val || curr.val == q.val) {
                return curr;
            }

            // 2. If there is split 
                // one lies in left and other in right then root is our LCA
            if(
                p.val < curr.val && q.val > curr.val  || 
                q.val < curr.val && p.val > curr.val
                ) {
                    return curr;
            }

            // 3. If both of them is greater then root then LCA lies on right
            if(p.val > curr.val && q.val > curr.val) {
                curr = curr.right;
            }

            // 4. If both of them is lesser then root then LCA lies on left
            if(p.val < curr.val && q.val < curr.val) {
                curr = curr.left;
            }
        }
        return curr;
    }
}