class MinStack {

    //Using two stacks to store the values.
    Stack<Integer> pushStack = new Stack<>(); //Stack to store all the values pushed
    Stack<Integer> minStack = new Stack<>();  //Stack to Store all the minimum values
    
    //Leaving constructor empty
    public MinStack() {}
    

    public void push(int val) {

        /*
        
            If it is the first element or 
            //The is the new element (val) that we are pushing, we check if it is smaller than our
            Current element in the minStack.

            For Example: [-1, 1, -2, 3]. And Stack has -1 in it as Minimum and we are at index 2 now
                        0  1   2  3
                                |
                                |
                            Here Now

                |______|          
                |______|   ----> checking is current val <= -1
                |__-1__|                          -2    <= -1 
                                                    True.
            Stack as of now

            So we add -2 to the stack

                |______|          
                |__-2__|  
                |__-1__|
            
            If you are wondering why we have used '<=' equals sign here, 
            thas because, for cases like: [-1,2,-2,-2,-2,1], if we don't add all the similar
            values, then when we pop from the stack we will lose the element.

        */
        pushStack.push(val);
        if(minStack.isEmpty() || pushStack.peek() <= minStack.peek())
            minStack.push(val);
        
        //We push all the values to pushStack without any conditions
        
        
    }
    
    public void pop() {

        //if element to pop is also our current min then we also need to pop it
        //Example : [-1,2,3,-4] --> Current Min : -4. if we need to. pop from the stack
        // we will remove -4. and our dataset will remain to be [-1,2,3].
        //So as we do not have -4 anymore we also pop it from the min stack.
        if(pushStack.peek().equals(minStack.peek()))
        {

            minStack.pop();
        }

        //Normal pop from the values stack
        pushStack.pop();
    }
    
    //For top we check in push Stack
    public int top() {
        return pushStack.peek();
    }
    
    //For peek we check in min Stack
    public int getMin() {
        return minStack.peek();
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