import java.util.*;

class Solution {
    public void sortColors(int[] nums) {
        
        /*
        // Inbuilt Array sorting Approach
        // TC: O(n log n)
        // SC: O(1) if we consider the input array as the output
        Arrays.sort(nums);
        */

        // ------------------------------------------------------

        /*
        // BF approach

        // TC: O(N^2)
        // SC: O(1)

        // Approach
        // 1. run for loop and take each element at once
        // 2. from that element, next to all forwardtill last, find minimam element 
        // 3. if element considered at step 1 is greater then minimum element
        // 4. then swap element considered and minimum element
        
        for(int i = 0; i < nums.length-1; i++) {
            int valToReplace = nums[i];
            int minNumber = Integer.MAX_VALUE;
            int minIndex = i+1;
            for(int j = i+1; j < nums.length;j++) {
                if(nums[j] <= minNumber) {
                    minNumber = nums[j];
                    minIndex = j;
                }
            }
            if(nums[i]>nums[minIndex]) {
                int temp = nums[i];
                nums[i] = nums[minIndex];
                nums[minIndex] = temp;
            }
        }
        */

        // ------------------------------------------------

        // Optimal Approach

        // TC: O(N)
        // SC: O(1)

        /*
        // Approach
        1. use one for loop and in that process
        2. count number of 0, 1 and 2;
        3. replace the num array with that much number of 0, then 1 and then 2.
        */
        int red = 0;
        int white = 0;
        int blue = 0;
        for(int i =0; i < nums.length; i++) {
            if(nums[i] == 0) {
                red++;
            }
            else if(nums[i] == 1) {
                white++;
            }
            else {
                blue++;
            }
        }

        // Debugging
        System.out.println("red: " + red);
        System.out.println("white: " + white);
        System.out.println("blue: " + blue);
        
        for (int i = 0; i < red; i++) {
            nums[i] = 0;
        }

        for (int i =red; i < white+red; i++) {
            nums[i] = 1;
        }

        for (int i = white+red; i < white+red+blue; i++) {
            nums[i] = 2;
        }
    }
}