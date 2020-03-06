package dataStructures.linearDataStructures;

class Node {

    int data;
    Node next;

    public Node(int data) {
        this.data = data;
    }

}

// a Singly Linked List
public class LinkedListDS {

    private Node head; // head of list

    // 1. Traverse the list to print data till the last node
    public static void printList(LinkedListDS list) {
        Node current = list.head;
        String listValues = "[";
        while (current != null) {
            listValues += current.data + ", ";
            current = current.next;
        }

        listValues = listValues.substring(0, listValues.length() - 2);
        listValues += "]";
        System.out.println(listValues);
    }

    // 2. Insert a node at the beginning of linked list.
    public static void insertBeginning(LinkedListDS list, int data) {
        Node newNode = new Node(data);
        if (list == null) {
            list = new LinkedListDS();
        }

        newNode.next = list.head;
        list.head = newNode;
    }

    // 3.  Insert a node at the end of linked list.
    public static void insertEnd(LinkedListDS list, int data) {
        Node newNode = new Node(data);
        Node iterator = list.head;
        if (iterator == null) {
            insertBeginning(list, data);
            return;
        }

        Node lastNode = getLastNode(list);

        if (lastNode != null)
            lastNode.next = newNode;
        else insertBeginning(list, data);
    }

    // 4.  Insert a node at the middle of linked list.
    public static void insertMiddle(LinkedListDS list, int data, int index) {
        if (index < 0) return;
        int countNodes = 1;
        Node iterator = list.head;
        if (iterator == null || index == 0) {
            insertBeginning(list, data);
            return;
        }

        while (iterator != null && countNodes < index) {
            iterator = iterator.next;
            countNodes++;
        }

        if (iterator == null) {
            insertEnd(list, data);
            return;
        }

        Node onIndex = iterator.next;
        iterator.next = new Node(data);
        iterator.next.next = onIndex;
    }

    // 5.  Delete the first node from linked list.
    public static void deleteFirst(LinkedListDS list) {
        list.head = list.head.next;
    }

    //6.   Delete the last node from linked list.
    public static void deleteLast(LinkedListDS list) {
        Node prev = list.head;
        if (prev == null)
            return;
        Node nxt = prev.next;
        if (nxt == null) {
            list.head = null;
            return;
        }

        Node nxtOfNxt = nxt.next;

        while (nxtOfNxt != null) {
            prev = prev.next;
            nxt = nxt.next;
            nxtOfNxt = nxt.next;
        }

        prev.next = null;

    }

    // 7.  Delete a node from the linked list by given key.
    public static void delete(LinkedListDS list, int key) {

        Node iterator = list.head;
        if (iterator.data == key) {
            deleteFirst(list);
            return;
        }

        while (iterator != null && iterator.next != null && iterator.next.data != key) {
            iterator = iterator.next;
        }

        if (iterator != null && iterator.next != null) {
            iterator.next = iterator.next.next;
            return;
        }
    }


    private static String printReversed(Node head, String content) {
        if (head == null) {
            return content;
        }

        content += head.data + ", ";

        return printReversed(head.next, content);
    }

    // 8.  Write a Java function to print data of a linked list in a reverse order (hint: use recursion)
    public static void printReversed(Node head) {
        String printable = printReversed(head, "[");
        printable = printable.substring(0, printable.length() - 2) + "]";
        System.out.println(printable);
    }


    //9.    Given a linked list which is sorted, how will you insert in sorted way.
    public static void insertInSortedList(LinkedListDS list, int data) {
        Node newNode = new Node(data);
        Node head = list.head;

        /* Special case for head node */
        if (head == null || head.data >= newNode.data) {
            insertBeginning(list, data);
        } else {

            /* Locate the node before point of insertion. */
            Node current = head;

            while (current != null && current.next != null && current.next.data < newNode.data)
                current = current.next;

            newNode.next = current.next;
            current.next = newNode;
        }
    }

    // 10.  Concatenate two given lists into one big list.
    public static LinkedListDS mergeLists(LinkedListDS x, LinkedListDS y) {
        Node last = getLastNode((x));
        last.next = y.head;
        return x;
    }

    private static Node getLastNode(LinkedListDS list) {
        Node iterator = list.head;

        while (iterator != null && iterator.next != null) {
            iterator = iterator.next;
        }
        return iterator;
    }
}

