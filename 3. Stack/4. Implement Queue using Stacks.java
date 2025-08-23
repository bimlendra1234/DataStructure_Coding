// Leetcode : 232. Implement Queue using Stacks

import java.util.*;

// Approach Using One Two stack - other stack mainly used while pushing
// TC of push : O(N)
// SC of Push: O(N) for using one extra Stack
// TC of rest : O(1)
// SC of rest : O(1)


// *********
// Approach
// 1. we need to simulate the operation in stack such that outcome is same as queue using two stack while push
// 2. insert in queue such a way that 
    // outcome in both stack and queue is similar
    // then already same for remove, peek and isEmpty - no need to wory
// 3. Only push in a way that
        // first put all element from st1 to st2
        // then put the actual element in st2
        // finally put all element from st2 to st1


// *********
// Code
class MyQueue {
    Stack<Integer> st1;
    Stack<Integer> st2;
    public MyQueue() {
        st1 = new Stack<>();
        st2 = new Stack<>();
    }
    
    public void push(int x) {
        // first put all element from st1 to st2
        while(!st1.isEmpty()) {
            st2.push(st1.pop());
        }
        // put the actual element in st2
        st2.push(x);
        // now put all element from st2 to st1
        while(!st2.isEmpty()) {
            st1.push(st2.pop());
        }
    }
    
    public int pop() {
        return st1.pop();
    }
    
    public int peek() {
        return st1.peek();
    }
    
    public boolean empty() {
        return st1.isEmpty();
    }
}

// -------------------------------------------------------------

/**
 * Your MyQueue object will be instantiated and called as such:
 * MyQueue obj = new MyQueue();
 * obj.push(x);
 * int param_2 = obj.pop();
 * int param_3 = obj.peek();
 * boolean param_4 = obj.empty();
 */