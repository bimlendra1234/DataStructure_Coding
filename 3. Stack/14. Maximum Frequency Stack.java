// Leetcode : 895. Maximum Frequency Stack

import java.util.*;

/*
// BrutForce Approach using stack and HM for frequency count
// TC push: O(1)
// SC push: O(1)
// TC pop: O(N)
// SC pop: O(N)


// *********
// Approach
// Find key with highest frequency
// Traverse stack to find the most recent element with that max frequency
    // push all the element of st to temp and in the process recoginze targetToRemove aswell
    // now reduce the current count as well
// rebuild the original stack


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
*/

// -------------------------------------------------------------

// Optimal Approach using two hashmap
// TC push: O(1)
// SC push: O(1)
// TC pop: O(N)
// SC pop: O(N)


// *********
// Approach
/*
Maintain two HM
    one contain freq
    other contain freq and its associated stack that has freq number
In push
    get the count of val and push into the frequency
    if that count do not exist in stack create empty stack with that key and insert it
    if count exist just push into the stack
    and update maxCount if the value of this count is greater then original maxCount
In pop
    find the stack st with max count from stack hashmap
    pop the value and this will be returned as a result lated
    once pop reduced the count from freq HM
    if the st is empty we need to reduce maxCount by 1
        empty means all the element having max Count is already removed
        so time to remove now maxCount-1

*/


// *********
// Code
class FreqStack {
    Map<Integer, Integer> freq; // val and its count
    Map<Integer, Stack<Integer>> stack; // freq and its stack containing that freq
    int maxCount;
    public FreqStack() {
        freq = new HashMap<>();
        stack = new HashMap<>();
        maxCount = 0;
    }
    
    public void push(int val) {
        // Update the frequency
        int valCount = freq.getOrDefault(val,0)+1;
        freq.put(val, valCount);
        // put it into the stack
        if(!stack.containsKey(valCount)) {
                stack.put(valCount, new Stack<>());
            }
            stack.get(valCount).push(val);
        // update the maxCount
        if(valCount > maxCount) {
            maxCount = valCount;
        }
    }
    
    public int pop() {
        // get the stack of max frequency
        Stack<Integer> st = stack.get(maxCount);
        // remove the value from here
        int removedValue = st.pop();
        // reduce t frequency in freq HM as well
        freq.put(removedValue, freq.get(removedValue)-1);
        // if st is empty, reduce the maxCount by 1
        if(st.isEmpty()) {
            maxCount--;
        }
        return removedValue;
    }
}

/**
 * Your FreqStack object will be instantiated and called as such:
 * FreqStack obj = new FreqStack();
 * obj.push(val);
 * int param_2 = obj.pop();
 */