// Leetcode: 994. Rotting Oranges

// Approach Use BFS to rot all adjacent fresh oranges level by level, incrementing time after each level until no fresh orange remains.
// TC: O(M*N)
// SC: O(M*N)


// **********
// Approach
/*
    1. Push all rotten oranges (value == 2) into the queue.
    2. Count all fresh oranges (value == 1).

    3. While fresh > 0 and the queue is not empty:
        - For each level (i.e., one minute):
            a. Process all nodes currently in the queue (current level size).
            b. For each rotten orange:
                i.   Check all 4 directions (up, down, left, right).
                ii.  If the neighboring cell is a fresh orange (1),
                     - Convert it to rotten (2),
                     - Decrease fresh count,
                     - Add the cell to the queue.

        - After each level, increment the time.

    4. If fresh == 0, return the total time taken.
       Otherwise, return -1 (some oranges couldn't rot).
*/


// *********
// Code

import java.util.*;

class Solution {
    int[][] direction = {{0,1},{0,-1},{1,0},{-1,0}};
    int rows;
    int cols;
    public int orangesRotting(int[][] grid) {
        rows = grid.length;
        cols = grid[0].length;
        Queue<int[]> queue = new LinkedList<>();
        int fresh = 0;
        for(int i = 0; i <rows; i++) {
            for (int j = 0; j < cols; j++) {
                if(grid[i][j] == 2) {
                    queue.offer(new int[]{i,j});
                }
                if(grid[i][j] == 1) {
                    fresh++;
                }
            }
        }
        return BFSHelper(queue, grid, fresh);
    }

    public int BFSHelper(Queue<int[]> queue, int[][] grid, int fresh) {

        int res = 0;

        while(fresh > 0 && !queue.isEmpty()) {
            int queueSize = queue.size();
            for(int i = 0; i < queueSize; i++) {
                int[] temp = queue.poll();
                int row = temp[0];
                int col = temp[1];

                for(int[] dir : direction) {
                    int newRow = row + dir[0];
                    int newCol = col + dir[1];
                    if(newRow>=0 && newCol>=0 && newRow<rows && newCol<cols && 
                        grid[newRow][newCol] != 0 && 
                        grid[newRow][newCol] != 2) 
                    {
                        fresh--;
                        grid[newRow][newCol] = 2;
                        queue.offer(new int[]{newRow,newCol});
                    }
                }
            }
            res++;
        }
        return fresh == 0 ? res : -1;
    }
}