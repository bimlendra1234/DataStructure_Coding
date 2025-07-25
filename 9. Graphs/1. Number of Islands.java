// Leetcode: 200. Number of Islands

// Approach using dfs search and making land to water during each visit
// TC: O(M*N)
// SC: O(M*N)


// *********
// Approach
/*
    1. pass one by one all that grid that start with 1 
        =>our at least 1 possible island

    2. Base Case: 
         when found water just return back

    3. if not water
        At the place where we are, since it will be counted so make it 0 i.e water
        go until where you can reach, up, down, left and right convert all those to water via same function
            consider all it in one single island

    4. next time when we will pass other location, We will count all those with value 1 as seperate island
        and do all thing again
*/


// *********
// Code
class Solution {
    int rows;
    int cols;
    public int numIslands(char[][] grid) {
        rows = grid.length;
        cols = grid[0].length;
        int totalIsland = 0;
        for(int i =0; i < rows; i++) {
            for (int j = 0; j < cols; j ++) {
                // 1. pass one by one all that grid that start with 1 => possible island
                if(grid[i][j] == '1') {
                    dfsBackTrack(i,j, grid);
                    totalIsland++;
                }
            }
        }
        return totalIsland;
    }

    public void dfsBackTrack(int row, int col, char[][] grid) {
        if(Math.min(row,col) < 0 || row == rows || col == cols || grid[row][col] == '0') {
            return; // 2. when found water return back
        }

        // At the place where we are, since it will be counted so make it 0 i.e water
        // go until where you can reach, up, down, left and right convert all those to water via same function
        // from next time we will pass other location, and will count if not water
        grid[row][col] = '0';
        dfsBackTrack(row -1, col, grid); 
        dfsBackTrack(row +1, col, grid);
        dfsBackTrack(row, col-1, grid);
        dfsBackTrack(row, col+1, grid);
    }
}

// ------------------------------------------------------------------------------

// Approach using BFS search and making land to water during each visit
// TC: O(M*N)
// SC: O(M*N)


// *********
// Approach
/*
    1. pass one by one all that grid that start with 1 
        =>our at least 1 possible island

    2. add one by one all the cell in queue

    3. while queue is not empty
        - pop the cell from queue
        - checkin all 4 directions
            - if it is land, convert it to water and add it to queue
*/


// *********
// Code
class Solution {
    int[][] directions = {{0,1}, {0,-1}, {1,0}, {-1,0}}; // diff that will add to actual row and col
                    //   right   left    down    up
    int rows;
    int cols;
    public int numIslands(char[][] grid) {
        rows = grid.length;
        cols = grid[0].length;
        int totalIsland = 0;
        for(int i = 0; i < rows; i++) {
            for (int j = 0 ; j < cols; j++) {
                if(grid[i][j] == '1') {
                    totalIsland++;
                    // mark all its reachible neighbour as 0, so that it wont be counted again
                    BFS(i,j,grid);
                }
            }
        }
        return totalIsland;
    }

    public void BFS(int row, int col, char[][] grid) {
        Queue<int[]> qu = new LinkedList<>();
        qu.add(new int[]{row, col});
        grid[row][col] = '0';

        while(!qu.isEmpty()) {
          int[] temp  = qu.poll();
          int r = temp[0];
          int c = temp[1];

          for(int[] dir : directions) {
            int newRow = r + dir[0];
            int newCol = c + dir[1];
            if(!(newRow < 0 || newCol < 0 || newRow == rows || newCol == cols || grid[newRow][newCol] == '0')) {
                grid[newRow][newCol] = '0'; // mark it as visited
                // and add its child in the queue
                qu.offer(new int[]{newRow, newCol});
            }
          }
        }
    }
}