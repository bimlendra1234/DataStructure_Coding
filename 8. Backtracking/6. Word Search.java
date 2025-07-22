// Leetcode : 79. Word Search


// Approach using DFS + BACKTRACK : check in each cell if we can find correct word, do fro ech cell
// TC: O(M * N * 4^L)
// SC: O(M*N)


// *********
// Approach
/*
    1. Use hash set to store already visited and found location to avoide already visited cell
    2. visit each cell one by one
    3. In each cell
        call dfs back track fun if any return true just return true

    4. In dfs backtrack fun
        considet the cell char
        then 
            do recursive dfs in up
            do recursive dfs in down
            do recursive dfs in left
            do recursive dfs in right
        if any of above path return true thats it we found complete string
        but if none return true, 
            we couldnt find word so remove from HS as that cell couldnt find word
            and simply return false in that cell,
            
        now other matrix cell will be checked

    Basecase 1: if index of word reach to word.length
        thats our ans . so add it and return true

    BaseCase 2: 
        if went out of bound in matrix or 
        char at current cell != index char at word or
        we found already visited or considered char

            need to return false
*/


// *********
// Code

import java.util.*;
import javafx.util.Pair;

class Solution {
    int rows; 
    int cols;
    Set<Pair<Integer,Integer>> HS;

    public boolean exist(char[][] board, String word) {
        rows = board.length;
        cols = board[0].length;
        HS = new HashSet<>(); // will store already visited and found location to avoide already visited cell

        // 1. visit each cell one by one
        for(int i = 0; i < rows; i++) {
            for(int j=0; j < cols; j++) {
                //2. during each cell check ,call dfs and if found correct path or word return true
                if(dfsBackTrack(i,j,0, word, board)) {
                    return true;
                }
            }
        }
        return false;
    }

    public boolean dfsBackTrack(int currRow, int currCol, int wordIndex, String word, char[][] board) {
        // Base Case 1 : for correct case
        if(wordIndex == word.length()) {
            return true;
        }

        // Base Case 2 : If went in wrong path
        if( currRow < 0 || currCol< 0 || currRow >= rows || currCol >= cols ||
            HS.contains(new Pair<>(currRow,currCol)) ||
            board[currRow][currCol] != word.charAt(wordIndex))
        {
                return false;
        }

        HS.add(new Pair<>(currRow,currCol)); // Consier  initially : this is from where our word start
        boolean res = dfsBackTrack(currRow-1, currCol, wordIndex+1, word, board) ||
                dfsBackTrack(currRow+1, currCol, wordIndex+1, word, board) ||
                dfsBackTrack(currRow, currCol+1, wordIndex+1, word, board) ||
                dfsBackTrack(currRow, currCol-1, wordIndex+1, word, board);
        HS.remove(new Pair<>(currRow,currCol)); // it came here means res is false and last added ch is invalid so remove it
        return res;
    }
}

// --------------------------------------

// Here it wont check each cell, instead it will just check cell that has same ch as 1st char at word

// *********
// Code
class Solution {
    int rows; 
    int cols;
    Set<Pair<Integer,Integer>> HS;

    public boolean exist(char[][] board, String word) {
        rows = board.length;
        cols = board[0].length;
        HS = new HashSet<>(); // will store already visited and found location to avoide already visited cell

        // 1. visit each cell one by one
        for(int i = 0; i < rows; i++) {
            for(int j=0; j < cols; j++) {
                //2. Wont check each cell
                // here it wont check each cell, instead it will just check cell that has same ch as 1st char at word
                if(board[i][j] == word.charAt(0)) {
                    if(dfsBackTrack(i,j,0, word, board)) {
                        return true;
                    }
                }
            }
        }
        return false;
    }

    public boolean dfsBackTrack(int currRow, int currCol, int wordIndex, String word, char[][] board) {
        // Base Case 1 : for correct case
        if(wordIndex == word.length()) {
            return true;
        }

        // Base Case 2 : If went in wrong path
        if( currRow < 0 || currCol< 0 || currRow >= rows || currCol >= cols ||
            HS.contains(new Pair<>(currRow,currCol)) ||
            board[currRow][currCol] != word.charAt(wordIndex))
        {
                return false;
        }

        HS.add(new Pair<>(currRow,currCol)); // Consier  initially : this is from where our word start
        boolean res = dfsBackTrack(currRow-1, currCol, wordIndex+1, word, board) ||
                dfsBackTrack(currRow+1, currCol, wordIndex+1, word, board) ||
                dfsBackTrack(currRow, currCol+1, wordIndex+1, word, board) ||
                dfsBackTrack(currRow, currCol-1, wordIndex+1, word, board);
        HS.remove(new Pair<>(currRow,currCol)); // it came here means res is false and last added ch is invalid so remove it
        return res;
    }
}