// Leetcode: 155. Min Stack

import java.util.*;


// Using two stacks, one to keep track of the minimum element and other to keep track of all elements.
// Time Complexity: O(1) for all operations
// Space Complexity: O(N) for using two stacks


// *********
// Approach
/*
1. Use two stacks
2. One stack to keep all elements
3. Second stack to keep track of the minimum element
4. When pushing an element, if it is less than or equal to the current minimum, push it onto the min stack
5. When popping an element, pop from both stacks
6. The top of the min stack will always give the minimum element
7. The top of the main stack will give the last pushed element
8. The getMin() function will return the top of the min stack
9. The top() function will return the top of the main stack
10. The pop() function will remove the top element from both stacks
11. The push() function will add an element to both stacks 
    if it is the new minimum then it will be added to the min stack
    If the new element is greater than the current minimum, the current minimum i.e minSt.peek() will be pushed again onto the min stack
*/


// *********
// Doubt
/*
1. why push in both stack even when val is greater then minStack peek()?
    => because we need to keep track of the minimum element at all times
        if we don't push the current minimum again, we will lose track of it when we pop the stack
----------------------------------------------------------------------------
2. why we did pop from both the stack?
    => because we need to maintain the integrity of both stacks
        when we pop an element from the main stack, we also need to pop the corresponding minimum element from the min stack
*/


// *********
// Code
class MinStack {
    private Stack<Integer> st;
    private Stack<Integer> minSt;
    public MinStack() {
        st = new Stack<>();
        minSt = new Stack<>();
    }
    
    public void push(int val) {
        st.push(val);
        if(minSt.isEmpty() || val <= minSt.peek()) {
            minSt.push(val);
        } else {
            minSt.push(minSt.peek());
        }
    }
    
    public void pop() {
        st.pop();
        minSt.pop();
    }
    
    public int top() {
        return st.peek();
    }
    
    public int getMin() {
        return minSt.peek();
    }
}

/**
 * Your MinStack object will be instantiated and called as such:
 * MinStack obj = new MinStack();
 * obj.push(val);
 * obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.getMin();
 */