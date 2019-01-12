package src;

import java.util.ArrayDeque;
import java.util.Queue;

public class CodeTwoQueueToStack {
    public static class TwoQueueStack {
        private static Queue<Integer> queue ;
        private static Queue<Integer> tempQueue ;

        public TwoQueueStack() {
            this.queue = new ArrayDeque<Integer>();
            this.tempQueue = new ArrayDeque<Integer>();
        }

        public void push(int num) {
            this.queue.add(num);
        }

        public int pop() {
            try {
                if (this.queue.isEmpty() && this.tempQueue.isEmpty()) {
                    throw new RuntimeException("The queue is Empty!!");
                }else if (this.tempQueue.isEmpty()){
                    while (this.queue.size() > 1) {
                        this.tempQueue.add(this.queue.poll());
                    }
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
            int result = this.queue.poll();
            swap();
            return result;
        }

        public int peek() {
            try {
                if (this.queue.isEmpty() && this.tempQueue.isEmpty()) {
                    throw new RuntimeException("The queue is Empty!!");
                }else if (this.tempQueue.isEmpty()){
                    while (this.queue.size() > 1) {
                        this.tempQueue.add(this.queue.poll());
                    }
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
            int result = this.queue.poll();
            this.tempQueue.add(result);
            swap();
            return result;
        }

        public void swap(){
            Queue<Integer> tmp = this.tempQueue;
            this.tempQueue = this.queue;
            this.queue = tmp;
        }

    }

    public static void main(String[] args) {
        TwoQueueStack myStack = new TwoQueueStack();
        myStack.push(1);
        myStack.push(2);
        myStack.push(3);
        System.out.println(myStack.peek());
        System.out.println(myStack.pop());
        myStack.push(4);
        System.out.println(myStack.pop());
        System.out.println(myStack.pop());
        System.out.println(myStack.pop());
        System.out.println(myStack.pop());   // 3 3 4 2 1
    }
}

