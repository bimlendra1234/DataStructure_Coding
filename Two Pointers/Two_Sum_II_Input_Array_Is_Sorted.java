// Leetcode167: Two Sum II - Input Array Is Sorted

class Solution {
    public int[] twoSum(int[] numbers, int target) {

        // Optimal Approach using two pointer, start i.e left and end i.e right

        // TC: O(N)
        // SC: O(1)

        // *********
        // Approach
        /*
            1. use array wher we will store answer index+1
            1. Maintain two pointer one at start and one at the end of the element
            2. if the element at start and end sum is less then target
                then we need to increase both sum, so do left++, (as it is sorted)
            2. if the element at start and end sum is greater then target
                then we need to decrease both sum, so do right--, (as it is sorted
            4. if the element at start and end sum is equal to target
                then store both index plus one at res array
                increment left and decrement right to check other and exit from loop
                (if not incremented left and decremented right then we will be stuck in loop)
            6. finally return the resultant array
        */

        // *********
        // Code
        int[] res = new int[2];

        int left = 0;
        int right = numbers.length-1;

        while(left < right) {
            if(numbers[left]+ numbers[right] < target) {
                left++;
            }
            else if(numbers[left]+ numbers[right] > target) {
                right--;
            }
            else{
                // case when both are equal
                res[0] = left+1;
                res[1] = right+1;
                left++;
                right--;
            }
        }

        return res;
    }
}