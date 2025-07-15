// *********
// Approach
 /*
    1. if my roor is empty or null 
        create new node with val and just return it
    2. if val is greater then root.val
        do recursion call to the right of root and attach to right
        return root
    3. if val is lesser then root.val
        do recursion call to the left of root
 */


 // *********
 // Code
class Solution {
    public TreeNode insertIntoBST(TreeNode root, int val) {
        if(root == null) {
            return new TreeNode(val);
        }

        if(val > root.val) {
            root.right = insertIntoBST(root.right, val);
        }
        else if(val < root.val) {
            root.left = insertIntoBST(root.left, val);
        }
        return root;
    }
}


// *********
// Dry run in head
/*
Iter 1. insertIntoBST(root, val)
		insertIntoBST(4, 5)    -> will trigger iter 2       : 4 is  returned here (already assigned to the right) from iter 2
		
		later after above get value: return root
					return 4
		
iter 2. root.right = insertIntoBST(root.right, val);
		root.right = insertIntoBST(4.right, val) = insertIntoBST(7, 5)   -> will trigger iter 3      : 7 is returned here (already assigned to the right) from iter 3
		
			later after above get value: return root
							return 4 to iter 1
										
		
iter 3. root.left = insertIntoBST(root.left, val);
		root.left = insertIntoBST(7.left, val)  = insertIntoBST(null, 5) : base case will create node 5 
																									so here 5 is attached to the lefft of 7
		return root
					return 7 to iter 2 call


// Time Complexity: O(logN) on average, O(N) in the worst case (unbalanced tree)
// Space Complexity: O(H) where H is the height of the tree, which is O
 */