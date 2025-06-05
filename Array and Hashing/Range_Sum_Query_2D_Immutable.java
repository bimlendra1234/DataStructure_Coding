// Brut force Approach - came out of me

// TC: O(M*N) - for m rows and N column
// SC: O(N) - for storing the matrix element
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

/**
 * Your NumMatrix object will be instantiated and called as such:
 * NumMatrix obj = new NumMatrix(matrix);
 * int param_1 = obj.sumRegion(row1,col1,row2,col2);
 */