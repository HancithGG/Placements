class Node {

    int data;
    Node next;

    Node(int data) {
        this.data = data;
        this.next = null;
    }
}

public class LinkedListOperations {

    Node head;

    // ----------------------------
    // Insert at Beginning
    // ----------------------------
    void insertAtBeginning(int data) {

        Node newNode = new Node(data);

        newNode.next = head;

        head = newNode;
    }

    // ----------------------------
    // Insert at End
    // ----------------------------
    void insertAtEnd(int data) {

        Node newNode = new Node(data);

        if (head == null) {
            head = newNode;
            return;
        }

        Node current = head;

        while (current.next != null) {
            current = current.next;
        }

        current.next = newNode;
    }

    // ----------------------------
    // Insert at Position
    // Position starts from 0
    // ----------------------------
    void insertAtPosition(int position, int data) {

        if (position == 0) {
            insertAtBeginning(data);
            return;
        }

        Node newNode = new Node(data);

        Node current = head;

        for (int i = 0; i < position - 1 && current != null; i++) {
            current = current.next;
        }

        if (current == null) {
            System.out.println("Invalid Position");
            return;
        }

        newNode.next = current.next;

        current.next = newNode;
    }

    // ----------------------------
    // Delete from Beginning
    // ----------------------------
    void deleteBeginning() {

        if (head == null)
            return;

        head = head.next;
    }

    // ----------------------------
    // Delete from End
    // ----------------------------
    void deleteEnd() {

        if (head == null)
            return;

        if (head.next == null) {
            head = null;
            return;
        }

        Node current = head;

        while (current.next.next != null) {
            current = current.next;
        }

        current.next = null;
    }

    // ----------------------------
    // Delete at Position
    // ----------------------------
    void deleteAtPosition(int position) {

        if (head == null)
            return;

        if (position == 0) {
            head = head.next;
            return;
        }

        Node current = head;

        for (int i = 0; i < position - 1 && current.next != null; i++) {
            current = current.next;
        }

        if (current.next == null) {
            System.out.println("Invalid Position");
            return;
        }

        current.next = current.next.next;
    }

    // ----------------------------
    // Print List
    // ----------------------------
    void printList() {

        Node current = head;

        while (current != null) {

            System.out.print(current.data + " ");

            current = current.next;
        }

        System.out.println();
    }

    // ----------------------------
    // Main Method
    // ----------------------------
    public static void main(String[] args) {

        LinkedListOperations list = new LinkedListOperations();

        list.insertAtEnd(10);
        list.insertAtEnd(20);
        list.insertAtEnd(30);

        System.out.println("Original List");
        list.printList();

        list.insertAtBeginning(5);

        System.out.println("After Insert Beginning");
        list.printList();

        list.insertAtEnd(40);

        System.out.println("After Insert End");
        list.printList();

        list.insertAtPosition(2, 15);

        System.out.println("After Insert Position");
        list.printList();

        list.deleteBeginning();

        System.out.println("After Delete Beginning");
        list.printList();

        list.deleteEnd();

        System.out.println("After Delete End");
        list.printList();

        list.deleteAtPosition(2);

        System.out.println("After Delete Position");
        list.printList();
    }
}
