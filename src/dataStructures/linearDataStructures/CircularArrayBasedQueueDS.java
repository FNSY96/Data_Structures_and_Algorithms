package dataStructures.linearDataStructures;

public class CircularArrayBasedQueueDS implements QueueInterface {

    private final int MAX = 1000;
    private int headIndex, tailIndex;
    private int[] queueArray = new int[MAX]; // Maximum size of Queue

    public void enqueue(int val) {
        if (isFull()) {
            System.out.println("WARNING: QUEUE IS FULL");
            return;
        }

        if (tailIndex >= this.MAX) {
            tailIndex %= this.MAX;
        }

        queueArray[tailIndex++] = val;
    }

    public int front() {
        if (isEmpty()) {
            System.out.println("WARNING: QUEUE IS EMPTY");
            return Integer.MIN_VALUE;
        }
        return queueArray[headIndex];
    }

    public int dequeue() {
        if (isEmpty()) {
            System.out.println("WARNING: QUEUE IS EMPTY");
            return Integer.MIN_VALUE;
        }
        int data = queueArray[headIndex];
        headIndex++;
        headIndex %= this.MAX;
        return data;
    }

    public boolean isEmpty() {
        return headIndex == tailIndex;
    }

    private boolean isFull() {
        return tailIndex == this.MAX && headIndex == 0 || tailIndex - headIndex == -1;
    }


}
