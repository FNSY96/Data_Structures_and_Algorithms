package dataStructures.linearDataStructures;

public class ArrayBasedStackDS implements StackInterface {
    private final int MAX = 1000;
    private int topIndex = -1;
    private int[] stackArray = new int[MAX]; // Maximum size of Stack

    public void push(int val) {
        if (topIndex + 1 >= this.MAX) {
            System.out.println("WARNING: STACK OVERFLOW");
            return;
        }
        stackArray[++this.topIndex] = val;
    }

    public int top() {
        if (this.isEmpty()) {
            System.out.println("WARNING: STACK IS EMPTY");
            return Integer.MIN_VALUE;
        }
        return this.stackArray[this.topIndex];
    }

    public int pop() {
        if (this.isEmpty()) {
            System.out.println("WARNING: STACK IS EMPTY");
            return Integer.MIN_VALUE;
        }
        return this.stackArray[this.topIndex--];
    }

    public boolean isEmpty() {
        return this.topIndex < 0;
    }
}