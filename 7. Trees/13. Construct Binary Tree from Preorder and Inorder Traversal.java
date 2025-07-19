// Leetcode: 105. Construct Binary Tree from Preorder and Inorder Traversal

// Approach using recursion, HM to store index of inorder elements which helps to split left and right subtree
// TC: O(N)
// SC: O(N) for recursion stack space


// *********
// Approach
/*    
    1. Preorder traversal gives us the root nodes in order:
       - The first element is always the root of the current subtree.

    2. We find the index of the root value in the inorder array:
       - This helps us split the inorder array into left and right subtrees.
       - Elements to the left of the root in inorder belong to the left subtree.
       - Elements to the right belong to the right subtree.

    3. Recursively construct the left and right subtrees:
       - For the left subtree:
         - The next root is at rootIndex + 1 in preorder.
         - The inorder range is [left, mid - 1].
       - For the right subtree:
         - The root is at rootIndex + size of left subtree = rootIndex + (mid - left + 1).
         - The inorder range is [mid + 1, right].

    4. The base case is when left > right:
       - This means the subtree is empty, so return null.
    
        in our code base case is If the current subtree range is empty, 
        it never enters the recursive call, and that child remains null
*/


// *********
// Code

import java.util.*;

class Solution {
    
    // 3. preorder - entire preorder
       // HM will store inder of each inorder element help to divide Left subtree and right subtree
       // rootIndex - the index in preorder array for the current root
       // left = it is left index which denote start of left subtree - in inorder
       // right = it is right index which denote end of right subtree -  in inodre
    public TreeNode splitTree(int[] preorder, Map<Integer,Integer> HM, int rootIndex, int left, int right) {
        
        // 4. Create the root node using the current rootIndex from preorder
        TreeNode root = new TreeNode(preorder[rootIndex]);

        // 5. Build left and right subtree

        // 5a. Get the index of root in inorder array (called 'mid')
        // now in Inorder: [left to mid-1], [mid = root] [mid+1 to right]
        // so [left to mid-1] = left subtree -> in inorder
        // [mid+1 to right] = right subtree -> in inorder
        int mid = HM.get(preorder[rootIndex]);

        // 5b. create left subtree recursively
        if(mid > left) {
            // root for left tree : will be just next element of root in preorder (rootIndex + 1)
            // range of left subtree = [left, mid-1] this is from inOrder
            root.left = splitTree(preorder, HM, rootIndex+1, left, mid-1);
        }

        // 5c. create right subtree recursively
        if(mid < right) {
            // Root of right subtree is after all elements of left subtree in preorder
            // i.e., rootIndex + size of left subtree = rootIndex + (mid - left + 1)
            // range of right subtree = [mid+1, right] -> in inorder
            root.right = splitTree(preorder, HM, rootIndex+mid-left+1, mid+1, right);
        }

        return root;

    }
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        // 1. HM will store inder of each inorder element
        // which will later help to divide Left subtree and right subtree
        Map<Integer, Integer> HM = new HashMap<>();
        for(int i = 0; i < inorder.length; i++) {
            HM.put(inorder[i], i);
        }

        // 2. Here we will pass entire preorder, 
            //rootIndex that is root from preorder, left range and right range of inorder
        // this will return root with splittd left subtree and right subtree from inorder
        // preorder is passed because 1st elem i.e rootIndex =0 is our root, with this i will create root
        return splitTree(preorder, HM, 0, 0, inorder.length-1);
    }
}

// -------------------------------------------------

// *********
// Overall code view
class Solution {
    
    public TreeNode splitTree(int[] preorder, Map<Integer,Integer> HM, int rootIndex, int left, int right) {
        
        TreeNode root = new TreeNode(preorder[rootIndex]);
        int mid = HM.get(preorder[rootIndex]);
        if(mid > left) {
            root.left = splitTree(preorder, HM, rootIndex+1, left, mid-1);
        }
        if(mid < right) {
            root.right = splitTree(preorder, HM, rootIndex+mid-left+1, mid+1, right);
        }
        return root;
    }

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        
        Map<Integer, Integer> HM = new HashMap<>();
        for(int i = 0; i < inorder.length; i++) {
            HM.put(inorder[i], i);
        }
        return splitTree(preorder, HM, 0, 0, inorder.length-1);
    }
}
