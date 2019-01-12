package src;

import java.util.Stack;

public class CodeTwoStackToQueue {
    public static class TwoStackQueue {
        private Stack<Integer> stackPush;
        private Stack<Integer> stackPop;

        public TwoStackQueue() {
            this.stackPush = new Stack<Integer>();
            this.stackPop = new Stack<Integer>();
        }

        public void add(int num) {
            this.stackPush.push(num);
        }

        //获取队首元素并删除
        public int poll() {
            try {
                if (this.stackPush.empty() && this.stackPop.empty()) {
                    throw new RuntimeException("The queue is empty!");
                } else if (this.stackPop.empty()) {
                    while (!this.stackPush.empty()) {
                        this.stackPop.push(this.stackPush.pop());
                    }
                }

            } catch (Exception e) {
                e.printStackTrace();
            }
            return this.stackPop.pop();
        }

        //获取队首元素但不删除
        public int peek() {
            try {
                if (this.stackPush.empty() && this.stackPop.empty()) {
                    throw new RuntimeException("The queue is empty!");
                } else if (this.stackPop.empty()) {
                    while (!this.stackPush.empty()) {
                        this.stackPop.push(this.stackPush.pop());
                    }
                }
            } catch (Exception e) {
                e.printStackTrace();
            }

            return this.stackPop.peek();

        }
    }
    public static void main(String[] args) {
        TwoStackQueue myQueue = new TwoStackQueue();
        myQueue.add(1);
        myQueue.add(2);
        myQueue.add(3);
        System.out.println("myQueue.peek():" + myQueue.peek());
        System.out.println("myQueue.poll1():" + myQueue.poll());
        myQueue.add(4);
        System.out.println("myQueue.poll2():" + myQueue.poll());
        System.out.println("myQueue.poll3():" + myQueue.poll());
        System.out.println("myQueue.poll4():" + myQueue.poll());
        System.out.println("myQueue.poll5():" + myQueue.poll());  // 1 1 2 3 4
    }
}

