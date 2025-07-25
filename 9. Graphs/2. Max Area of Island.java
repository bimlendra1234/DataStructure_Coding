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
                    int eachIslandArea = DFSHelper(i,j,grid);
                    maxArea = Math.max(maxArea, eachIslandArea);
                    totalIsland++;
                }

            }
        }
        return maxArea;
    }

    public int DFSHelper(int row, int col, int[][] grid) {
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

// ------------------------------------------------------------------------------

// Approach : Using BFS

class Solution {
    int[][] directions = {{0,1}, {0,-1}, {1,0}, {-1,0}}; 
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
                    int eachIslandArea = BFS(i,j,grid);
                    maxArea = Math.max(maxArea, eachIslandArea);
                    totalIsland++;
                }

            }
        }
        return maxArea;
    }

    public int BFS(int row, int col, int[][]grid) {
        Queue<int[]> qu = new LinkedList<>();
        qu.offer(new int[]{row,col});
        grid[row][col] = 0; // mark as visited
        int res = 1; // counted after marking visited

        while(!qu.isEmpty()) {
            int[] temp = qu.poll();
            int r = temp[0];
            int c = temp[1];

            for(int[] dir : directions) {
                int newRow = r + dir[0];
                int newCol = c + dir[1];

                if(!(newRow < 0 || newCol < 0 || newRow == rows || newCol == cols || grid[newRow][newCol] == 0)) {
                    res ++; // increment count
                    grid[newRow][newCol] = 0; // mark as visited
                    qu.add(new int[]{newRow, newCol});
                }
            }
        }
        return res;
    }
}