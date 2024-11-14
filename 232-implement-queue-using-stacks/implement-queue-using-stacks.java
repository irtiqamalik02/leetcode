class MyQueue {

    Stack<Integer> stack1 ;
    Stack<Integer> stack2 ;
    // private static final int DEFAULT_SIZE = 100;
    // protected int size;

    public MyQueue() {
        stack1 = new Stack<>();
        stack2 = new Stack<>();
        
    }
    
    public void push(int x) {
        //insert is O(1)
        stack1.push(x);
    }
    
    public int pop() {
        //pop is O(N); can make it O(1) by storing in another stack but then insert will be O(N)
        while(!stack1.isEmpty()){
            stack2.push(stack1.pop());
        }

        int poppedElement = stack2.pop();

        while(!stack2.isEmpty()){
            stack1.push(stack2.pop());
        }

        return poppedElement;
    }
    
    public int peek() {
        while(!stack1.isEmpty()){
            stack2.push(stack1.pop());
        }
        int peekElement = stack2.peek();
        while(!stack2.isEmpty()){
            stack1.push(stack2.pop());
        }
        return peekElement;
    }
    
    public boolean empty() {
        return stack1.isEmpty();
    }
}

/**
 * Your MyQueue object will be instantiated and called as such:
 * MyQueue obj = new MyQueue();
 * obj.push(x);
 * int param_2 = obj.pop();
 * int param_3 = obj.peek();
 * boolean param_4 = obj.empty();
 */