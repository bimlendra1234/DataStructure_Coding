// Leetcode: 230. Kth Smallest Element in a BST

// Approach using inorder traversal
// TC: O(N)
// SC: O(N)


// *********
// Approach
/*
    1. Do inorder traversal
    2. save the element during inorder in res array
    3. show the kth element fro the res array
*/


// *********
// Code

import java.util.*;

class Solution {

    public void inOrder(TreeNode root, List<Integer> resArray) {
        if(root == null) {
            return;
        }
        inOrder(root.left, resArray);
        resArray.add(root.val);
        inOrder(root.right, resArray);
    }

    public int kthSmallest(TreeNode root, int k) {
        List<Integer> res = new ArrayList<>();
        inOrder(root, res);

        int kthSmallest = 0;
        for(int  i= 0; i < k; i++) {
            if(i == k-1) {
                kthSmallest = res.get(i);
            }
        }

        return kthSmallest;
    }
}