// Leetcode : 417. Pacific Atlantic Water Flow


// Approach : Start DFS from Pacific (top & left edges) and Atlantic (bottom & right edges), propagating flow to valid neighbors in all 4 directions.
// TC: O(M*N) : Each cell is visited once for Pacific and once for Atlantic → O(2 * m * n) = O(m * n)
// SC: O(M*N) : For canReachPacific, canReachAtlantic, and recursive call stack


// *********
// Approach
/*
    Idea:
    Use DFS starting from the Pacific and Atlantic edges to mark cells 
    that can reach each ocean. Then, collect cells that can reach both.

    Steps:
    1. Use two boolean matrices (canReachPacific and canReachAtlantic) 
       to track which cells can reach each ocean.

    2. filling this pacific and atlantic matrices using BFS
        
        For Pacific:
        - Start DFS from all cells in the first row and first column.

        For Atlantic:
        - Start DFS from all cells in the last row and last column.

    3. In the DFS helper:
        - For each valid move (height >= previous cell), mark the cell as reachable.
        - Recursively apply DFS in all 4 directions.

    4. After both matrices are filled, iterate over the grid:
        - Add cell (i, j) to the result if it is true in both matrices.
*/


// *********
// Code

import java.util.*;

class Solution {
    int rows;
    int cols;
    int[][] directions = {{0,1}, {0,-1}, {1,0}, {-1,0}};
    int[][] matrix;
    public List<List<Integer>> pacificAtlantic(int[][] heights) {
        rows = heights.length;
        cols = heights[0].length;
        matrix = heights;

        // 1. check null Edge Case
        if (rows == 0 || cols == 0) {
            return new ArrayList<>();
        }
        
        // 2. Using 2 matrics that store height that can reach pacific and atlantic
        boolean[][] CanReachPacific = new boolean[rows][cols];
        boolean[][] CanReachAtlantic = new boolean[rows][cols];

        // 3. filling this pacific and atlantic matrices using BFS
            // Using actual matrics directly, 
            // pacific or atlantic matrix
            // Current cell coordinate(i,j)
            // previous value to which it will compare the result
                // i.e from where it will be called, if less then prev water cant flow
        for(int i = 0; i < cols; i++) {
            // passing top row only - can reach pacific
            DFSHelper(0, i, Integer.MIN_VALUE, CanReachPacific);
            // passing last row only - can reach atlantic
            DFSHelper(rows-1, i, Integer.MIN_VALUE, CanReachAtlantic);
        }

        for(int i = 0; i < rows; i++) {
            // passing first col only - can reach pacific
            DFSHelper(i, 0, Integer.MIN_VALUE, CanReachPacific);
            // passing last col only - can reach atlantic
            DFSHelper(i, cols-1, Integer.MIN_VALUE, CanReachAtlantic);
        }


        // 4. taking cordinate from pacific and atlantic matrices into res if both of them has true on same cell
        List<List<Integer>> res = new ArrayList<>();
        for(int i = 0; i < rows; i++) {
            for(int j = 0; j < cols; j++) {
                if(CanReachPacific[i][j] && CanReachAtlantic[i][j]) {
                    res.add(Arrays.asList(i,j));
                }
            }
        }

        return res;
    }

    public void DFSHelper(int currRow, int currCol, int prevValue, boolean[][] canReach) {
        // Using actual matrics directly, 
        // pacific or atlantic matrix canReach, where we will update the value
        // Current cell coordinate(currRow,currCol)
        // previous value to which it will compare the current result
            // i.e from where it will be called, if less then prev water cant flow

        // 1. Edge case 1. if the index is invalid we will just return
        if(currRow < 0 || currCol < 0 || currRow == rows || currCol == cols) {
            return;
        }

        // 2. Edge case 2. if already visited or curr value in matrix is less then the prev just return
        if(canReach[currRow][currCol] || matrix[currRow][currCol] < prevValue) {
            return;
        }

        // 3. we reach here means cell is valid and curr val is greater then prev value
            // So we can consider this cell in our new matrix
        canReach[currRow][currCol] = true;

        // 4. now pass its all neighbor so that we can mark that true as well
            // marking because i can reach from that cell as well to specific ocean
        for(int[] dir : directions) {
            DFSHelper(currRow + dir[0], currCol + dir[1], matrix[currRow][currCol], canReach);
        }
    }
}