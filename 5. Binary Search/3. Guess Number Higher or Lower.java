// Leetcode : 374. Guess Number Higher or Lower

/** 
 * Forward declaration of guess API.
 * @param  num   your guess
 * @return 	     -1 if num is higher than the picked number
 *			      1 if num is lower than the picked number
 *               otherwise return 0
 * int guess(int num);
 */

public class Solution extends GuessGame {

    // Approach using BS
    // TC: O(logn)
    // SC: O(1)


    // *********
    // Approach
    /*
    1. left to 1 and tight to n
    2. inside while loop l<=r
    3. guessNum = mid = l+r/2
    4. guess api will give weather my guess is higher , lower or exact
        if higher then right = guessNum-1;
        if lower then left = guessNum +1;
        if guess matched then return guessNum
    */


    // ********
    // Doubts
    /*
    1. when used this (left+right)/2 it gave Time Limit Exceeded
        but with this (left + (right - left) / 2) it worked fine

        With (left+right)/2:
        => because int has a fixed size (32-bit signed).
        If left and right are both very large (close to Integer.MAX_VALUE), 
            their sum left + right can overflow of int range,
        and cant fit inside guess api that accept int value

        With (left + (right - left) / 2):
        => But right - left will never overflow because it's the difference between two numbers in a valid range.
        Adding left after halving ensures that the mid-point is still correctly located.
        It’s mathematically equivalent to (left + right) / 2, but safer for large values.
    */


    // *********
    // Code
    public int guessNumber(int n) {
        int left = 1;
        int right = n;

        while(left <= right) {
            // int guessNum = (left+right)/2; // with this it gave Time Limit Exceeded
            int guessNum = (left + (right - left) / 2); // // safer to avoid overflow
            int target =  guess(guessNum);

            if(target == -1) {
                right = guessNum-1;
            }
            else if(target == 1) {
                left = guessNum+1;
            }
            else{
                return guessNum;
            }
        }
        return -1;
    }
}
// Note: The guess API is assumed to be defined in the GuessGame class, which is not shown here.