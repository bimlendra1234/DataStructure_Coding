// Leetcode: 18. 4Sum

import java.util.*;

class Solution {
    public List<List<Integer>> fourSum(int[] nums, int target) {

        /*
        // BrutForce Approach
        // TC: O(N^4)
        // SC: O(1)


        // *********
        // Approach:
        // 1. Using four loop find each possible combination of 4 value that sum to target
            //store this 4 value in the result only if its not in the list


        // *********
        // Code
        List<List<Integer>> res = new ArrayList<>();

        for(int i = 0; i < nums.length-3;i++) {
            for(int j = i+1; j < nums.length-2;j++) {
                for(int k = j+1; k < nums.length-1; k++) {
                    for(int l = k+1; l < nums.length; l++) {
                        if(nums[i]+nums[j]+nums[k]+nums[l] == target) {
                            List<Integer> eachList = Arrays.asList(nums[i],nums[j],nums[k],nums[l]);

                            // Avoids duplicate element
                            // from this [[2,2,2,2],[2,2,2,2],[2,2,2,2],[2,2,2,2],[2,2,2,2]]
                            // to this [[2,2,2,2]]
                            Collections.sort(eachList);
                            if(!res.contains(eachList)) {
                                res.add(eachList);
                            }
                        }
                    }
                }
            }
        }
        return res;
        */

        // ------------------------------------------------------

        // Optimal Approach Using Sorting, selecting two number and then using two pointer approach.
        // TC: O(N^3)
        // SC: O(1)


        // *********
        // Approach
        /*
        1. Use two for loop,
        2. first loop will select first Number
            eliminate duplicate here as well: in case first number is same as second number and more.

        3. second loop will select second number
            eliminate duplicate here as well: in case second number is same as third number and more.

            inside the same same second loop
                set left to secondNumber +1 and right to last number

                now until left<right do
                    calculate sum each time, do not accumulate sum
                    if(sum < target) left++
                    else if(sum > target) right--;
                    if sum equals to target
                        add it into result arraylist
                        and in order to avoid duplicate 
                            move left pointer right, until left side duplicate is removed
                            also move right pointer left, until right side duplicate is removed.

        4. return result arraylist
        */


        // *********
        // Doubt
        /*
        1. why long sum = (long) nums[left] + nums[right] + firstNum + secondNum;
            -> why (long) at right side because
            Expression of int + int + int + int computes in 32-bit int, can overflow.
            Assigning that result to long does not fix overflow, it just converts overflowed int to long.
            Cast to long before addition to do safe 64-bit math.

            ----------------------------------------------------
        2. Forget to use while
            later even i was calculating sum outside while, 
                -> this was issue because i need fresh sum all the time.
                as i dont need to store the sum
        */


        // *********
        // Code
        List<List<Integer>> res = new ArrayList<>();
        Arrays.sort(nums);

        for(int first = 0; first < nums.length-3; first++) { // select first number
            if(first>0 && nums[first] == nums[first-1]) {
                continue;
            }
            int firstNum = nums[first];

            for(int second = first+1; second < nums.length-2; second++) { // select second number
                if(second>first+1 && nums[second] == nums[second-1]) {
                    continue;
                }

                int secondNum = nums[second];
                int left = second+1;
                int right = nums.length-1;

                // Two Sum approach to find third and fourth number
                // using left and right pointer in sorted attay
                while(left < right) {
                    long sum = (long) nums[left] + nums[right] + firstNum + secondNum;
                    if(sum < target) {
                        left++;
                    }
                    else if(sum > target) {
                        right--;
                    }
                    else{
                        // when sum is equals to requiredTarget
                        List<Integer> eachList = Arrays.asList(firstNum, secondNum, nums[left], nums[right]);
                        res.add(eachList);

                        // below two while loop will avoid the duplicate
                        while(left<right && nums[left] == nums[left+1]) {
                            left++;
                        }
                        while(left<right && nums[right] == nums[right-1]) {
                            right--;
                        }

                        // increment left and decrement right pointer to check other unique element
                        // for left and right number. 
                        left++;
                        right--;
                    }
                }
            }
        }
        return res;
    }
}