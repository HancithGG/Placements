class Node {

    int data;
    Node next;

    Node(int data) {
        this.data = data;
        this.next = null;
    }
}

public class CycleDetection {

    Node head;

    // Detect cycle using Floyd's Algorithm
    boolean hasCycle() {

        Node slow = head;
        Node fast = head;

        while (fast != null && fast.next != null) {

            // Slow moves one step
            slow = slow.next;

            // Fast moves two steps
            fast = fast.next.next;

            // They meet if a cycle exists
            if (slow == fast) {
                return true;
            }
        }

        return false;
    }

    public static void main(String[] args) {

        CycleDetection list = new CycleDetection();

        Node first = new Node(10);
        Node second = new Node(20);
        Node third = new Node(30);
        Node fourth = new Node(40);

        list.head = first;

        first.next = second;
        second.next = third;
        third.next = fourth;

        // Create a cycle:
        // 40 → 30
        fourth.next = third;

        if (list.hasCycle()) {
            System.out.println("Cycle exists");
        } else {
            System.out.println("No cycle");
        }
    }
}
