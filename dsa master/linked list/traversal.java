class Node {

    int data;
    Node next;

    Node(int data) {
        this.data = data;
        this.next = null;
    }
}

public class LinkedListTraversal {

    Node head;

    // Traverse and print the linked list
    void printList() {

        Node current = head;

        while (current != null) {
            System.out.print(current.data + " ");
            current = current.next;
        }

        System.out.println();
    }

    public static void main(String[] args) {

        LinkedListTraversal list = new LinkedListTraversal();

        // Create nodes
        list.head = new Node(10);

        Node second = new Node(20);
        Node third = new Node(30);
        Node fourth = new Node(40);

        // Connect nodes
        list.head.next = second;
        second.next = third;
        third.next = fourth;

        // Traverse the linked list
        System.out.println("Linked List:");

        list.printList();
    }
}
