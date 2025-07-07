// Leetcode: 74. Search a 2D Matrix

class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {

        // Brutforce approach using two for loop
        // TC: O(M*N) i.e M - rows and N - columns
        // SC: O(1)


        // *********
        // Approach
        // 1. use two for loop for rows and column
        // 2. checking each position inside the loop


        // *********
        // Code
        for(int row = 0; row < matrix.length; row++) {
            for(int col = 0; col < matrix[0].length; col++) {
                if(matrix[row][col] == target) {
                    return true;
                }
            }
        }
        return false;
    }
}