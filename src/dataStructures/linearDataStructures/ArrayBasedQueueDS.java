package dataStructures.linearDataStructures;

public class ArrayBasedQueueDS implements QueueInterface {
    private final int MAX = 1000;
    private int headIndex, tailIndex;
    private int[] queueArray = new int[MAX]; // Maximum size of Queue


    public void enqueue(int val) {
        if (isFull()) {
            System.out.println("WARNING: QUEUE IS FULL");
            return;
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
        return queueArray[headIndex++];
    }

    public boolean isEmpty() {
        return headIndex == tailIndex;
    }

    private boolean isFull() {
        return tailIndex >= this.MAX && !reset();
    }

    private boolean reset() {
        if (tailIndex == headIndex && headIndex >= this.MAX - 1) {
            tailIndex = 0;
            headIndex = 0;
            return true;
        }
        return false;
    }
}
