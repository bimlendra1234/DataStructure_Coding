// Leetcode : 100. Same Tree

// DFS recursion Approach: checking root then left and right subtree
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

// -------------------------------------------------------------

// BFS Iterative Approach: using queue
// Time  : O(N + M)  – visit each node once
// Space : O(N + M) in worst case – if both trees are full and completely different shape
// Space : O(max width of both trees) in typical BFS – i.e., O(min(N, M)) in balanced cases


// *********
// Approach - BFS iterative - level order traversal
/*
    1. Use queue DS
        add root1
        add root2

    2. run while loop until q is empty 
        poll first
        poll second

        // check for first and 2nd equality
            if both null -> continue and check other
            if one null and other not || both has different value
                not same tree

        // Add corresponding children
            first left child of both
            then right child of both

    3. if in while loop we didnt find any issue then its a same tree
*/


// *********
// Code
class Solution {
    public boolean isSameTree(TreeNode p, TreeNode q) {
        Queue<TreeNode> qu = new LinkedList<>();
        qu.add(p);
        qu.add(q);

        while(!qu.isEmpty()) {
            TreeNode first = qu.poll();
            TreeNode second = qu.poll();

            // check for 1st and 2nd equality
            if(first == null && second == null) {
                continue;
            }
            else if(first == null || second == null || first.val != second.val) {
                return false;
            }

            // add corresponding children
            qu.add(first.left);
            qu.add(second.left);
            qu.add(first.right);
            qu.add(second.right);
        }

        return true;
    }
}