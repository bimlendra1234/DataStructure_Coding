// Leetcode: 69. Sqrt(x)

class Solution {
    public int mySqrt(int x) {

        // Approach using Binary Search
        // TC: O(logX)
        // SC: O(1)


        // *********
        // Approach
        /*
        1. sq roox of x : will lie between 1 to x
        2. left = 1; right = x
        3. use BS approach
        4. while left <= right
        5. find mid 
            that mid can make value = mid *mid , now check if this is our solution , if yes mid is our sq root
            if value > target
                right = mid-1
            if value < target
                left = mid+1
        6. if exact answer do not exist
            then loop will break when right come left of left (i.e right left)
        7. so right is our answer because we need to fine lowest nearest value
        */


        // ********
        // Doubts
        /*
        1. int target = mid*mid gave TLE 
            but long target = (long) mid*mid; worked fine

            mid is int , if mid is very large then multiply can overflow the int range 
            so change it into long so that it will work fine as there will be no overflow.
        */


        // *********
        // Code
        int left = 1;
        int right = x;

        while(left <= right) {
            int mid = left + (right-left)/2;
            long target = (long) mid*mid;

            if(target > x) {
                right = mid-1;
            }
            else if(target < x) {
                left = mid+1;
            }
            else {
                return mid;
            }
        }
        return right;
    }
}