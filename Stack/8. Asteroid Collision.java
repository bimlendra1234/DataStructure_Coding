// Leetcode : 735. Asteroid Collision

import java.util.*;

// Optimal Approach using Stack
// TC: O(N)
// SC: O(N) - For using Stack


// *********
// Approach
/*
1. put element into the stack only in the case if there is no collision
2. confirmed colision when when stack is not empty and current element is negative and peek of stack is positive
    find diff between this current -ve elem and peek +ve elem
        if current -ve won i.e diff < 0
            remove peek +ve 
            insert -ve elem
                consecutive prev stack crash will be handeled by while
        if peek +ve won i.e diff > 0
            do not insert -ve elem
        if both same i.e diff = 0 (i.e both will get collapsed)
            remove peek +ve element
            do not insert -ve current element
3. return the stack as array.
*/


// *********
// Doubt
/*
1. why i am doing elem = 0;
    => it denote that this particular element do not deserve to go into the stack
--------------------------------------------------------------------------------
2. Understand the case when there will be confirmed colision
    => !st.isEmpty() && elem < 0 ; st.peek() > 0
        i.e when stack is not empty and current element is negative and peek of stack is positive
--------------------------------------------------------------------------------------------------
3. suppose -ve elem won in collision now that need to be inserted in stack
    how this will handle collide with other existing element into the stack

    => push that current -ve element into the stack after all calculation and ush only in case of no ther collision
    MOSTLY HANDLED BY WHILE LOOP
*/


// *********
// Code
class Solution {
    public int[] asteroidCollision(int[] asteroids) {
        Stack<Integer> st = new Stack<>();

        for(int elem : asteroids) {
            // confirmed collision
            while(!st.isEmpty() && elem < 0 && st.peek() > 0) {
                int diff = elem + st.peek();
                // current -ve elem won then remove +ve top
                // also will have to push -ve but wait do at the last when elem !=0
                if(diff < 0) {
                    st.pop();
                }
                // peek +ve elem won then no need to insert this -ve elem
                else if(diff > 0) {
                    elem = 0;
                }
                else {
                    // both have same weight i.e dif = 0 , they both need to finish and nothing will go into stack
                    elem = 0;
                    st.pop();
                }
            }

            // push elem into stack if element deserved to go into stack. i.e elem != 0
            if(elem != 0) {
                st.push(elem);
            }
            
        }

        int[] res = new int[st.size()];
        int idx = 0;
        for(int elem : st) {
            res[idx++] = elem;
        }
        return res;
    }
}