package src;

import java.util.Stack;

public class CodeGetMinStack {
    public static class GetMinStack {
        private Stack<Integer> stackMin;
        private Stack<Integer> stackData;

        public GetMinStack() {
            this.stackData = new Stack<Integer>();
            this.stackMin = new Stack<Integer>();
        }
        public void push(int num) {
            if (this.stackMin.isEmpty()) {
                this.stackMin.push(num);
            } else if (num <= this.stackMin.peek()) {
                this.stackMin.push(num);
            } else {
                this.stackMin.push(this.stackMin.peek());
            }
            this.stackData.push(num);
        }

        public int pop() {
            if (this.stackData.isEmpty()) {
                throw new RuntimeException("The Stack is Empty!!!");
            }
            this.stackMin.pop();
            return this.stackData.pop();
        }

        public int getMin() {
            if (this.stackData.isEmpty()) {
                throw new RuntimeException("The Stack is Empty!!");
            }
            return this.stackMin.peek();
        }
    }

    public static void main(String[] args) {
        GetMinStack myStack = new GetMinStack();
        myStack.push(4);
        myStack.push(9);
        myStack.push(8);
        myStack.push(1);
        System.out.println("最小值:" + myStack.getMin());
        System.out.println(myStack.pop());
        System.out.println("最小值:" + myStack.getMin());
    }
}

