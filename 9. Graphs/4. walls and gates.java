// Leetcode 286 walls-and-gates : Question => https://neetcode.io/solutions/walls-and-gates

// Approach using BFS
// TC: O(M*N) * number of gates
// SC: O(M*N)


// *********
// Approach
/*
    1. Use a queue to perform multi-source BFS.
       First, add all gate locations (cells with value 0) to the queue.
    2. While the queue is not empty:
        a. Pop the front element to get the current cell's (row, col).
        b. Explore all 4 directions from this cell (up, down, left, right).
        c. For each neighbor:
            - Check if it's within bounds.
            - Ensure it's not a wall (i.e., value != -1).
            - Update the neighbor's value to current cell value + 1 
                only if the existing value is greater (i.e., it’s an empty room or has a longer path).
            - Add this neighbor to the queue to continue BFS from there.
*/


// Code

import java.util.*;

class Solution {
    public void islandsAndTreasure(int[][] grid) {
        int[][] directions = {{0,1}, {0,-1}, {1,0}, {-1,0}}; 
        int rows = grid.length;
        int cols = grid[0].length;
        Queue<int[]> queue = new LinkedList<>();

        // 1. push all gates into the queue
        for(int i = 0; i < rows; i++) {
            for(int j = 0; j < cols; j++) {
                if(grid[i][j] == 0) {
                   queue.offer(new int[]{i,j}); 
                }
            }
        }

        while(!queue.isEmpty()) {
            int[] temp = queue.poll();
            int row = temp[0];
            int col = temp[1];

            for(int[] dir : directions) { // check up left right bottom
                int newRow = row + dir[0];
                int newCol = col + dir[1];

                if(newRow >= 0 && newCol >= 0  &&  // not less out of bound
                        newRow < rows && newCol < cols &&  // not greater out of bound
                        grid[newRow][newCol] != -1 &&  // is not wall
                        grid[newRow][newCol] > grid[row][col]+1) // // only update if the value is greater
                {
                    grid[newRow][newCol] = grid[row][col] +1;
                    queue.offer(new int[]{newRow,newCol});
                }

            }
        }
    }
}
