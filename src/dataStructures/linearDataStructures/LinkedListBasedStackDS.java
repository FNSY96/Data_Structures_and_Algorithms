package dataStructures.linearDataStructures;

class StackNode {
    int data;
    StackNode next;

    StackNode(int data) {
        this.data = data;
    }
}

public class LinkedListBasedStackDS implements StackInterface {
    private StackNode top;

    public void push(int val) {
        StackNode newNode = new StackNode(val);
        newNode.next = this.top;
        top = newNode;
    }

    public int top() {
        if (isEmpty()) {
            System.out.println("WARNING: STACK IS EMPTY");
            return Integer.MIN_VALUE;
        }
        return this.top.data;
    }

    public int pop() {
        if (isEmpty()) {
            System.out.println("WARNING: STACK IS EMPTY");
            return Integer.MIN_VALUE;
        }
        int data = this.top.data;
        this.top = this.top.next;
        return data;
    }

    public boolean isEmpty() {
        return top == null;
    }

}
