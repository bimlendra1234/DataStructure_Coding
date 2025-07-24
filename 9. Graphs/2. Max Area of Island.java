// Leetcode : 695. Max Area of Island

// Approach : Same as Number of island but just returned max 1 in each island
// TC: O(M*N)
// SC: O(M*N)


// *********
// Approach : same as number of island just instead or returning nothing return total 1 in each island
/*
    1. pass one by one all that grid that start with 1 
        =>our at least 1 possible island

    2. Base Case: 
         when found water just return back

    3. if not water
        At the place where we are, since it will be counted so make it 0 i.e water
        return =>  self count(i.e 1) + count in (up) + count in (Left) + count in (right) + count in (down)

    4. next time when we will pass other location, We will count those with value 1 as seperate island
        and do all thing again
*/


// *********
// Code
class Solution {
    int rows;
    int cols;
    public int maxAreaOfIsland(int[][] grid) {
        rows = grid.length;
        cols = grid[0].length;
        int totalIsland = 0;
        int maxArea = 0;

        for(int i = 0; i < rows; i++) {
            for (int j = 0 ; j < cols; j++) {
                // here i can access each cell one by one.
                if(grid[i][j] == 1) {
                    int eachIslandArea = bfsHelper(i,j,grid);
                    maxArea = Math.max(maxArea, eachIslandArea);
                    totalIsland++;
                }

            }
        }
        return maxArea;
    }

    public int bfsHelper(int row, int col, int[][] grid) {
        // Base case 1
        if(row < 0 || col < 0 || row == rows || col == cols || grid[row][col] == 0) {
            return 0;
        }

        grid[row][col] = 0;
        int count = 1 + bfsHelper(row-1, col, grid) +
                        bfsHelper(row+1, col, grid) +
                        bfsHelper(row, col-1, grid) +
                        bfsHelper(row, col+1, grid);
        return count;
    }
}