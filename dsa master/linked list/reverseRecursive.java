class Node {

    int data;
    Node next;

    Node(int data) {
        this.data = data;
        this.next = null;
    }
}

public class RecursiveLinkedListReversal {

    Node head;

    // Insert at end
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

    // Recursive reversal
    Node reverseRecursive(Node current) {

        // Base case
        if (current == null || current.next == null) {
            return current;
        }

        // Reverse the remaining list
        Node newHead = reverseRecursive(current.next);

        // Reverse the current connection
        current.next.next = current;

        // Break the old connection
        current.next = null;

        return newHead;
    }

    void printList() {

        Node current = head;

        while (current != null) {

            System.out.print(current.data + " ");

            current = current.next;
        }

        System.out.println();
    }

    public static void main(String[] args) {

        RecursiveLinkedListReversal list =
                new RecursiveLinkedListReversal();

        list.insertAtEnd(10);
        list.insertAtEnd(20);
        list.insertAtEnd(30);
        list.insertAtEnd(40);

        System.out.println("Original List:");
        list.printList();

        list.head = list.reverseRecursive(list.head);

        System.out.println("Reversed List:");
        list.printList();
    }
}
