// Leetcode: 74. Search a 2D Matrix

class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {

        /*
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
        */

        // --------------------------------------------------------

        // Optimal Approach using Binary Search
        // TC: O(LogM*LogN) => O(Log(M*N))i.e M - rows and N - columns
        // SC: O(1)


        // *********
        // Approach
        /*
        1. Find exact row using binary search where the element lies
        2. if no such row exist return false immidately
        3. once find exact row do BS and find target there
        */


        // *********
        // Code
        int rows = matrix.length;
        int cols = matrix[0].length;

        // find the row where element lies
        int top = 0;
        int bottom = rows-1;
        while(top <= bottom) {
            int midRow = top + (bottom-top)/2;

            if (target > matrix[midRow][cols-1]) { // greater then right most element in that row => top=mid+1
                top = midRow+1;
            }
            else if(target < matrix[midRow][0]) { // smaller then left most element in that row => bottom=mid-1
                bottom = midRow-1;
            }
            else{
                // if we found match in midRow
                // Now do BS there and fin the target outside loop coz we now the row.
                break;
            }
        }

        // if the targer do not exist in any row, directly return false
        if(!(top <= bottom)) {
            return false;
        }

        // target exist in that midRow above : after break statement it will come here
        // do BS in this row here and find the target
        int foundRow = top + (bottom-top)/2;
        int left = 0;
        int right = cols-1;
        while(left <= right) {
            int mid = left + (right-left)/2;

            if(target > matrix[foundRow][mid]) {
                left = mid+1;
            }
            else if(target < matrix[foundRow][mid]) {
                right = mid-1;
            }
            else{
                // found the target in that row after break statement
                return true;
            }
        }
        return false;
    }
}