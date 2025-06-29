// Leetcode : 895. Maximum Frequency Stack

import java.util.*;

// BrutForce Approach using stack and HM for frequency count
// TC push: O(1)
// SC push: O(1)
// TC pop: O(N)
// SC pop: O(N)


// *********
// Approach
/*
Find key with highest frequency
Traverse stack to find the most recent element with that max frequency
    push all the element of st to temp and in the process recoginze targetToRemove aswell
    now reduce the current count as well
rebuild the original stack
*/


// *********
// Code
class FreqStack {
    Stack<Integer> st;
    HashMap<Integer, Integer> HM;
    public FreqStack() {
        st = new Stack<>();
        HM = new HashMap<>();
    }
    
    public void push(int val) {
        HM.put(val, HM.getOrDefault(val,0)+1);
        st.push(val);
    }
    
    public int pop() {
        // Step 1: Find key with highest frequency
        int maxCount = 0;
        for(int key : HM.keySet()) {
            maxCount = Math.max(maxCount, HM.get(key));
        }

        Stack<Integer> temp = new Stack<>();
        int targetToRemove = -1;
        // push all the element of st to temp and in the process recoginze targetToRemove aswell
        while(!st.isEmpty()) {
            int current = st.pop();
            temp.push(current);
            if(HM.get(current) == maxCount) {
                targetToRemove = current;
                // now reduce the current count as well
                HM.put(current, HM.get(current)-1);
                break;
            }
        }

        // rebuild the original stack
        while(!temp.isEmpty()) {
            int curr = temp.pop();
            if(curr == targetToRemove) {
                continue;
            }
            st.push(curr);
        }
        return targetToRemove;
    }
}

/**
 * Your FreqStack object will be instantiated and called as such:
 * FreqStack obj = new FreqStack();
 * obj.push(val);
 * int param_2 = obj.pop();
 */