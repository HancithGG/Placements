

      /*
                 50
               /    \
             30      70
            / \     / \
          20 40   60 80
        */

class Node {
    int data;
    Node left, right;

    Node(int value) {
        data = value;
        left = right = null;
    }
}

class Trees {

    // Recursive search
    boolean searchRecursive(Node root, int target) {
        if (root == null)
            return false;

        if (root.data == target)
            return true;

        if (target < root.data)
            return searchRecursive(root.left, target);

        return searchRecursive(root.right, target);
    }

    // Iterative search
    boolean searchIterative(Node root, int target) {
        Node current = root;

        while (current != null) {
            if (current.data == target)
                return true;

            if (target < current.data)
                current = current.left;
            else
                current = current.right;
        }

        return false;
    }
}

public class Main {
    public static void main(String[] args) {
        // Manually building the BST
        Node root = new Node(50);
        root.left = new Node(30);
        root.right = new Node(70);

        root.left.left = new Node(20);
        root.left.right = new Node(40);

        root.right.left = new Node(60);
        root.right.right = new Node(80);

        Trees t = new Trees();

        // Test searches
        System.out.println("Recursive search for 40: " + t.searchRecursive(root, 40));
        System.out.println("Recursive search for 90: " + t.searchRecursive(root, 90));

        System.out.println("Iterative search for 60: " + t.searchIterative(root, 60));
        System.out.println("Iterative search for 25: " + t.searchIterative(root, 25));
    }
}


        
