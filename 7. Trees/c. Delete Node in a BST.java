// Leetcode: 450. Delete Node in a BST

// TC: O(2Logn) -> O(Logn) : 
        // 2 because once height traversal while finding min and 
        // other height traversal while deleting min from right subtree
// SC: O(height) - O(logN) due to recursion


// *********
// Approach
/*
    1. value not found but if value that need to be deleted is on right side 
        delete from the right;
    2. Value not found but if value that need to be deleted is on left side 
        delete from the left;
    3. once we found the value that need to be deleted
        check two case 
        Case 1: if node that is being deleted have no child or one child
            if left child is null
                return right child so that it is attached to its ancestor
            if right child is null
                return left child so that it is attached to its ancestor
        Case 2: if node that is being deleted have two child
            Find min in the right subtree
            replace node value that is being deleted with min value
            now min exist at 2 place
                so remove from the right
        
*/
class Solution {

    public TreeNode minValNode ( TreeNode root) {
        TreeNode curr = root;

        while(curr != null && curr.left != null) {
            curr = curr.left;
        }
        return curr;

    }

    public TreeNode deleteNode(TreeNode root, int key) {
        if (root == null) {
            return null;
        }

        if(key > root.val) {
            // value not found , delete from right
            root.right = deleteNode(root.right, key);
        }
        else if(key < root.val) {
            // value not found , delete from left
            root.left = deleteNode(root.left, key);
        }
        else {
            // value found here
            if(root.left == null) { // case 1
                return root.right;
            }
            else if(root.right == null) { // case 1
                return root.left;
            }
            else { // case 2
                TreeNode minNode = minValNode(root.right);
                root.val = minNode.val;
                root.right = deleteNode(root.right, minNode.val);
            }
        }
        return root;
    }
}