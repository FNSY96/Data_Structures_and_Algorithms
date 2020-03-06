package dataStructures.linearDataStructures;

class QueueNode {
    int data;
    QueueNode next;

    QueueNode(int data) {
        this.data = data;
    }
}

public class LinkedListBasedQueueDS implements QueueInterface {
    private QueueNode head, tail;

    public void enqueue(int val) {
        QueueNode newNode = new QueueNode(val);
        if (isEmpty()) {
            tail = newNode;
            head = tail;
            return;
        }
        tail.next = newNode;
        tail = tail.next;
    }

    public int front() {
        if (isEmpty()) {
            System.out.println("WARNING: QUEUE IS EMPTY");
            return Integer.MIN_VALUE;
        }
        return head.data;
    }

    public int dequeue() {
        if (isEmpty()) {
            System.out.println("WARNING: QUEUE IS EMPTY");
            return Integer.MIN_VALUE;
        }
        int data = head.data;
        head = head.next;
        return data;
    }

    public boolean isEmpty() {
        return head == null;
    }

}
