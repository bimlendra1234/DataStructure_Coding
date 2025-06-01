import java.util.*;

/*
// using inbuilt function
class Solution {
    public int[] sortArray(int[] nums) {

        Arrays.sort(nums);
        return nums;
    }
}
*/

// -------------------------------

// Optimal Approach using Merge Sort

// TC: O(NlogN) for sorting
// SC: O(N) for using extra space for left and right array

class Solution {
    public void merge(int[] left, int[] right, int[] nums) {
        int numsLength = nums.length; int k = 0;
        int leftLength = left.length; int i = 0;
        int rightLength = right.length; int j = 0;

        while (i < leftLength && j < rightLength) {
            if(left[i] < right[j]) {
                nums[k] = left[i];
                i++;
                k++;
            }
            // right[j] < left[i]
            else {
                nums[k] = right[j];
                j++;
                k++;
            }
        }

        while(i < leftLength) {
            // when only left element is left
            nums[k] = left[i];
            i++;
            k++;
        }

        while(j< rightLength) {
            // when only right element is left
            nums[k] = right[j];
            j++;
            k++;
        }
    }

    public int[] sortArray(int[] nums) {

        int n = nums.length;

        if(n<2) {
            return nums;
        }

        int mid = n/2;

        int[] left = new int[mid];
        for(int i = 0; i< mid; i++) {
            left[i] = nums[i];
        }

        int[] right = new int[n-mid];
        for(int i = mid; i < n; i++) {
            right[i-mid] = nums[i];
        }
        sortArray(left);
        sortArray(right);
        merge(left,right,nums);

        return nums;
    }
}