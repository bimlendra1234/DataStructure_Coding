// Leetcode : 268. Missing Number

// BrutForce Approach using sorting

// *********
// Complexity
// TC: O(N log N) → sorting + O(N) scan
// SC: O(1) → in-place sorting, no extra space

// *********
// Approach
/*
    1. Sort the array.
    2. Traverse the sorted array:
        - If nums[i] != i, return i as the missing number.
    3. If all indices match, return n (length of array) as the missing
         number.
*/

// *********
// Code
class Solution {
    public int missingNumber(int[] nums) {
        Arrays.sort(nums);
        for(int i = 0; i < nums.length; i++) {
            if(nums[i] != i) {
                return i;
            }
        }
        return nums.length;
    }
}

// ----------------------------------------------------

// Optimal Approach using Maths

// *********
// Complexity
// TC: O(N)
// SC: O(1)


// *********
// Approach
/*
1. The array has numbers from 0 to n with one missing.
2. Expected sum of first n natural numbers = n*(n+1)/2.
3. Calculate the actual sum of the array.
4. Missing number = expectedSum - actualSum.
*/


// *********
// Code
class Solution {
    public int missingNumber(int[] nums) {
        
        int n = nums.length;
        int sum = 0;
        for(int i = 0; i < nums.length; i++) {
            sum += nums[i];
        }
        return ((n*(n+1)) / 2) - sum;
    }
}

// ----------------------------------------------------

// Most Optimal Approach using Bit Manipulation (XOR)

// *********
// Complexity
// TC: O(N)
// SC: O(1)


// *********
// Approach
/*
1. Use XOR property: a ^ a = 0 and a ^ 0 = a.
2. XOR all indices [0..n] with array elements.
3. All pairs cancel out, leaving only the missing number.
*/


// *********
// Code
class Solution {
    public int missingNumber(int[] nums) {
        
        int ans = nums.length; // to include the nth index
        for(int i = 0; i < nums.length; i++) {
            ans = ans ^ i ^ nums[i];
        }
        return ans;
    }
}