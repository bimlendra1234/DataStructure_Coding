/*
// Brut force Approach - came out of me

// TC: O(M*N) - for m rows and N column
// SC: O(1) - for storing the matrix element
class NumMatrix {
    int[][] mul;
    public NumMatrix(int[][] matrix) {
        // initializing this matrix in argument
        mul = matrix;
    }
    
    public int sumRegion(int row1, int col1, int row2, int col2) {
        System.out.println(mul[row1][col1]);
        System.out.println(mul[row2][col2]);

        int colDiff = col2-col1; // add all the element from col1 to col1+colDiff
        int rowDiff = row2-row1; // add all element from row1 to row1+rowDiff
        int sum = 0;

        // Time Complexity : O(M*N)
        // M for first loop, N for second loop
        for (int i = row1; i <= row2; i++) {
            for(int j = col1; j <= col2; j++) {
                sum += mul[i][j];
            }
        }
        return sum;
    }
}
*/

//-------------------------------------------------------------------------------

// Optimal Approach using prefix sum

// TC: O(1)
// SC: O(M*N)

class NumMatrix {

    // 1. declare prefix sum matrix
    int[][] matrixSum;
    public NumMatrix(int[][] matrix) {
        int row = matrix.length;
        int col = matrix[0].length;

        // 2. initialize prefix sum matrix with one extra row and one extra column with 0
        matrixSum = new int[row+1][col+1];

        // 3. now fill prefix sum in matrixSum
        for(int i = 0; i < row; i++) {
            int prefixSumValue = 0;
            for(int j = 0; j < col; j++) {
                prefixSumValue += matrix[i][j]; // sum of all row value
                int above = matrixSum[i+1-1][j+1];// current value is i+1, j+1 is matrixsum so in row do -1
                matrixSum[i+1][j+1] =  prefixSumValue + above;
            } 
        }
    }
    
    public int sumRegion(int row1, int col1, int row2, int col2) {
        //4. we need to work on matrixSum matrix now where we have one extra row and col
        row1++; col1++; row2++; col2++;

        int bottomRight = matrixSum[row2][col2];//exact value in prefix sum
        int above = matrixSum[row1-1][col2];
        int left = matrixSum[row2][col1-1];
        int topLeft = matrixSum[row1-1][col1-1];

        // in mine range take bottomRight value
        // substract upper value from mine range
        // substract left value from mine range
        // now top right is substracted two time so add it once
        int sumRegionValue = bottomRight-above-left+topLeft;

        return sumRegionValue;
    }
}

/**
 * Your NumMatrix object will be instantiated and called as such:
 * NumMatrix obj = new NumMatrix(matrix);
 * int param_1 = obj.sumRegion(row1,col1,row2,col2);
 */