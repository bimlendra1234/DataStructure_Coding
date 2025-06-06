import java.util.*;

class Solution {
    public boolean isValidSudoku(char[][] board) {

        // Brut Force approache
        // TC: O(1) but O(N^2) if boad size was N
        // SC: O(N)

        // Doubt
        /*
        int row = (square/3) * 3 + i;
        int col = (square%3) * 3 + j;
        */

        /*
        Approach
        1. use hash set for each row, column and 3*3 region
        2. check duplicate in each row, col and 3*3 region
        3. if duplicate return false imidately
        4. finally return true i.e no duplicate
        */
        // check row
        for(int row = 0; row < 9; row++) {
            Set<Character> seen = new HashSet<>();
            for(int i = 0; i < 9; i++) { // i is column
                if(board[row][i] == '.') { continue;}
                if(seen.contains(board[row][i])) { return false;} // if duplicate
                seen.add(board[row][i]);
            }
        }

        // check column
        for(int col = 0; col < 9; col++) {
            Set<Character> seen = new HashSet<>();
            for(int i = 0; i < 9; i++) { // i is row
                if(board[i][col] == '.') { continue;}
                if(seen.contains(board[i][col])) { return false;} // if duplicate
                seen.add(board[i][col]);
            }
        }

        // check square region
        for(int square = 0; square < 9; square++) {
            Set<Character> seen = new HashSet<>();
            for(int i = 0; i < 3; i++) {
                for (int j = 0; j < 3; j++) {
                    // each element will be mapped inside square 
                    // i.e find row and column of each number inside this 9 square
                    int row = (square/3) * 3 + i;
                    int col = (square%3) * 3 + j;
                    if(board[row][col] == '.') { continue;}
                    if(seen.contains(board[row][col])) { return false;} // if duplicate
                    seen.add(board[row][col]);
                }
            }
        }

        return true; // if all fine and no duplicate
    }
}