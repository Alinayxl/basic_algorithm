package src;

public class CodeArrayToQueue {
    public static class ArrayToQueue {
        private Integer[] arr;
        private Integer start;
        private Integer end;
        private Integer size;

        public ArrayToQueue(Integer initSize) {
            if (initSize < 0) {
                throw new IllegalArgumentException("the size is less than zero!!");
            }
            arr = new Integer[initSize];
            this.size = 0;
            this.start = 0;
            this.end = 0;
        }

        public void push(Integer num) {
            if (this.size == arr.length) {
                throw new ArrayIndexOutOfBoundsException("The queue is full!!");
            }
            arr[this.end] = num;
            this.size++;
            this.end = (this.end == arr.length - 1) ? 0 : (this.end + 1);
        }

        public Integer poll() {
            if (this.size == 0) {
                throw new ArrayIndexOutOfBoundsException("The queue is Empty!!");
            }
            int temp = this.start;
            this.start = (this.start == arr.length - 1) ? 0 : (this.start + 1);
            this.size--;
            return arr[temp];

        }

        public Integer peek() {
            if (this.size == 0) {
                return null;
            }
            return arr[this.start];
        }
    }

    public static void main(String[] args) {
        ArrayToQueue myQueue = new ArrayToQueue(100);
        myQueue.push(1);
        myQueue.push(2);
        myQueue.push(3);
        myQueue.push(4);
        myQueue.push(5);
        System.out.println(myQueue.peek());
        System.out.println(myQueue.poll());

        System.out.println(myQueue.peek());
        System.out.println(myQueue.poll());
        System.out.println(myQueue.poll());
        System.out.println(myQueue.poll());
        System.out.println(myQueue.poll()); // 1 1 2 2 3 4 5

    }
}

