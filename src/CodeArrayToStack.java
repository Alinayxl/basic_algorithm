package src;

public class CodeArrayToStack {
    public static class ArrayToStack {
        Integer[] arr;
        int size;

        public ArrayToStack(int initSize) {
            arr = new Integer[initSize];
            this.size = 0;
        }

        public void push(Integer num) {
            if (this.size == arr.length) {
                throw new ArrayIndexOutOfBoundsException("The Stack is full!!!");
            }
            arr[this.size++] = num;
        }

        public Integer peek() {
            if (this.size == 0) {
                return null;
            }
            return arr[this.size - 1];
        }

        public Integer poll() {
            if (this.size == 0) {
                return null;
            }
            int temp = this.size - 1;
            this.size--;
            return arr[temp];
        }
    }

    public static void main(String[] args) {
        ArrayToStack myStack = new ArrayToStack(100);
        myStack.push(1);
        myStack.push(2);
        myStack.push(3);
        myStack.push(4);
        myStack.push(5);
        System.out.println(myStack.peek());
        System.out.println(myStack.poll());

        System.out.println(myStack.peek());
        System.out.println(myStack.poll());
        System.out.println(myStack.poll());
        System.out.println(myStack.poll());
        System.out.println(myStack.poll()); //5 5 4 4 3 2 1
    }
}

