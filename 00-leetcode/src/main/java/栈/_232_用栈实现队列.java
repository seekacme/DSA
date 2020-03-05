package 栈;

import java.util.Stack;

public class _232_用栈实现队列 {

    private Stack<Integer> inStack;
    private Stack<Integer> outStack;

    /** Initialize your data structure here. */
    public _232_用栈实现队列() {
        this.inStack = new Stack<Integer>();
        this.outStack = new Stack<Integer>();
    }

    /** Push element x to the back of queue. */
    public void push(int x) {
        this.inStack.push(x);
    }

    /** Removes the element from in front of queue and returns that element. */
    public int pop() {
        checkOutStack();

        return this.outStack.pop();
    }

    /** Get the front element. */
    public int peek() {
        checkOutStack();

        return this.outStack.peek();
    }

    /** Returns whether the queue is empty. */
    public boolean empty() {
        return this.inStack.isEmpty() && this.outStack.isEmpty();
    }

    private void checkOutStack(){
        /**
         * 当outStack中空，并且inStack不为空，将inStack中的元素添加到outStack中
         */
        while(this.outStack.isEmpty()){
            while(!this.inStack.isEmpty()){
                this.outStack.push(this.inStack.pop());
            }
        }
    }

}
