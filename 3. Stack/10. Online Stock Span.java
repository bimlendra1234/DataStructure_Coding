// Leetcode : 901. Online Stock Span

import java.util.*;

// Approach using monotonic stack
// TC: O(N)
// SC: O(N) - for using stack and List => O(2N) => O(N)


// *********
// Approach
/*
1. Maintain monotonic stack<Index> and list to store the array of price
2. traverse to the left till we get greater element
    once found greater element then span = elementIndex - greaterElementIndex
    for 0th index span is 1 as not left greater element
3. when stack is not empty && peak element is less then the current
    pop peak element
    push current element index
4. when stack is not empty i.e we found the greater element
    span = elementIndex - greaterElementIndex
    push current element index
5. when stack is empty that means we couldnt find the greater element at the left
    so entire element is the span
    span = currentIndex+1 
        => +1 because it was o based index
    push the current index
6. finally return the span
*/


// *********
// Doubt
/*
1.  Use .get() method instead of array indexing in the list to find index
        instead of lt[st.peek()] use lt.get(st.peek())
        
    also use lt.size() instead of lt.length
--------------------------------------------------------------------------
2. why priceIndex + 1 when no greater price before today that is no greater on the left
    so entire element is the span
    Span become count of elements, not index

    + 1 because: priceIndex is 0-based
*/


// *********
// Code
class StockSpanner {
    Stack<Integer> st;
    List<Integer> lt;
    public StockSpanner() {
        st = new Stack<>();
        lt = new ArrayList();
    }
    
    public int next(int price) {
        lt.add(price);
        int priceIndex = lt.size()-1;
        int span;

        while(!st.isEmpty() && lt.get(st.peek()) <= price) {
            st.pop();
        }
        // here found the greater element
        if(!st.isEmpty()) {
            span = priceIndex - st.peek(); // (lt.length-1) = priceIndex
        }
        else{
            // when (st.isEmpty())
            // span is entire as there is no any greater element
            span = priceIndex + 1;  // (lt.length-1) = priceIndex
        }

        st.push(priceIndex);
        return span;
    }
}

/**
 * Your StockSpanner object will be instantiated and called as such:
 * StockSpanner obj = new StockSpanner();
 * int param_1 = obj.next(price);
 */