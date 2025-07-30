// Leetcode : 130. Surrounded Regions

// Approach Mark all boundary-connected 'O's and their neighbors as 'T', convert remaining 'O's to 'X', then revert 'T's back to 'O'.
// TC: O(M*N) : O(M × N) for the DFS + O(M × N) for final two scans = O(M × N)`
// SC: O(M*N) : due to recursion stack in worst case


// *********
// Approach
/*
    Phase 1: Mark boundary-connected 'O's as 'T'
        - Traverse the first & last rows and columns
        - If cell is 'O', perform DFS on 4 neighbor to mark all connected 'O's as 'T'
        - These are regions that cannot be surrounded, as they touch the border
        - Those regions that can be surrounded remain 'O'

    Phase 2: Convert all remaining 'O's to 'X'
        - These are the surrounded regions (not connected to the border)

    Phase 3: Convert all 'T's back to 'O'
        - Restore the unflippable regions originally marked in Phase 1

    DFSUnSurroundedRegion(row, col, board):
        - Base cases: if out of bounds or not 'O', return
        - Otherwise, mark cell as 'T'
        - Recurse in 4 directions
*/


// *********
// Code

class Solution {
    int[][] directions = {{0,1},{0,-1},{1,0},{-1,0}};
    int rows;
    int cols;
    public void solve(char[][] board) {
        
        rows = board.length;
        cols = board[0].length;

        // Phase 1 : marking T
        // 1. pass all the border region and check if we find any 0, marks its dfs to T as well
        
        // passing 1st row and last row, if 0 that wont get surrounded
        for(int i = 0; i < cols; i++) {
            if(board[0][i] == 'O') {             //passing  first row
                DFSUnSurroundedRegion(0, i, board);
            }

            if(board[rows-1][i] == 'O') {             //passing  last row
                DFSUnSurroundedRegion(rows-1, i, board);
            }
        }

         // passing 1st col and last col, if 0 that wont get surrounded
         for(int i = 0 ; i < rows; i++) {
            if(board[i][0] == 'O') {             //passing  first col
                DFSUnSurroundedRegion(i, 0, board);
            }

            if(board[i][cols-1] == 'O') { //passing  last col
                DFSUnSurroundedRegion(i, cols-1, board);
            }
         }

         // Phase 2: visit each cell one by one and mark remaining 0 (means can be surrounded) to X
         for (int i = 0; i < rows; i++) {
            for (int j = 0 ; j < cols; j++) {
                if(board[i][j] == 'O') {
                    board[i][j] = 'X';
                }
            }
         }

         // Phase 3: visit each cell one by one and mark T (means can be surrounded) to 0 : to Original
         for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if(board[i][j] == 'T') {
                    board[i][j] = 'O';
                }
            }
         }
    }

    public void DFSUnSurroundedRegion(int row, int col, char[][] board) {

        // Base case 1: Invalid bound
        if(Math.min(row,col) < 0 || row >= rows || col >= cols) {
            return;
        }

        // Base case 2: X means already surrounded
        if(board[row][col] != 'O') {
            return;
        }

        // we came here that means cell val is 'O' and it is in boundry so make that to T
        board[row][col] = 'T';
        // pass all neighbor dir of above if any 0 thats to cant be surrounded we need to make it 'T'
        for(int[] dir : directions) {
            DFSUnSurroundedRegion(row+dir[0], col+dir[1], board);
        }
    }
}