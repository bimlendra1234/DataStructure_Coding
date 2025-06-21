// LeetCode: 225. Implement Stack using Queues

import java.util.*;


/*
// Approach Using One Two queue - other key mainly used while popping
// TC of push : O(N)
// SC of Push: O(N) for using one extra queue
// TC of rest : O(1)
// SC of rest : O(1)


// *********
// Approach
// 1. we need to simulate the operation in queue such that outcome is same as stack using two queue while push
// 2. insert in queue such a way that 
    // outcome in both stack and queue is similar
    // then already same for remove, peek and isEmpty - no need to wory
// 3. Only push in a way that
        // add the element in the queue2
        // untill queue is empty pop abd push all its element to queue2
        // finally swap queue1 and queue2


// *********
// Code
class MyStack {
    private Queue<Integer> queue1;
    private Queue<Integer> queue2;
    public MyStack() {
        queue1 = new LinkedList<>();
        queue2 = new LinkedList<>();
    }
    
    public void push(int x) {
        // here is only the difference, insert in such a way that it is equivalent to stack
        queue2.offer(x);

        // while q1 is not entire empty
        // pop and add in the queue2
        while(queue1.size()!=0) {
            int elem = queue1.poll();
            queue2.offer(elem);
        }

        // swap queue1 and queue2. i.e queue2 become queue1 now
        Queue<Integer> temp = queue1;
        queue1 = queue2;
        queue2 = temp;
    }
    
     public int pop() {
        return queue1.poll();
    }
    
    public int top() {
        return queue1.peek();
    }
    
    public boolean empty() {
        return queue1.isEmpty();
    }
}
*/

// ------------------------------------------------------------------------------------

// Approach Using One Queue
// TC of Push : O(N)
// TC of rest : O(1)
// SC: O(1)


// *********
// Approach
/*
1. we need to simulate the operation in queue such that outcome is same as stack
2. insert in queue such a way that 
    outcome in both stack and queue is similar
    then already same for remove, peek and isEmpty - no need to wory
3. Only push in a way that
    add the element in the queue
    if not empty or greater then 1 till size-1 that all element except added element
        remove other element from queue one by one and add it again
            so that inserted element will come at the top of the queue.
*/


// *********
// Doubt
/*
1. offer(x) : add x in queue
2. poll(): remove from queue
3. peek(): top element in the queue
4. isEmpty(): queue1.size() == 0
*/


// *********
// Code
class MyStack {
    private Queue<Integer> queue1;
    public MyStack() {
        queue1 = new LinkedList<>();
    }
    
    public void push(int x) {
        // add the element in queue
        queue1.offer(x);
        // in the same queue remove and add till that x element.
        // i.e till queuesize-1 time do poll and offer for same element in the queue
        for(int i = 1; i < queue1.size(); i++) {
            int elem = queue1.poll();
            queue1.offer(elem);
        }
    }
    
    public int pop() {
        return queue1.poll();
    }
    
    public int top() {
        return queue1.peek();
    }
    
    public boolean empty() {
        return queue1.size() == 0;
    }
}

/**
 * Your MyStack object will be instantiated and called as such:
 * MyStack obj = new MyStack();
 * obj.push(x);
 * int param_2 = obj.pop();
 * int param_3 = obj.top();
 * boolean param_4 = obj.empty();
 */