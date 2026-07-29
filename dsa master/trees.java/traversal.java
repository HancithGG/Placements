import java.util.Stack;

class Node {

    int data;
    Node left;
    Node right;

    Node(int data) {
        this.data = data;
        this.left = null;
        this.right = null;
    }
}

public class TreeTraversals {

    // -------------------------
    // Recursive Preorder
    // ROOT → LEFT → RIGHT
    // -------------------------
    static void preorderRecursive(Node root) {

        if (root == null) {
            return;
        }

        System.out.print(root.data + " ");

        preorderRecursive(root.left);

        preorderRecursive(root.right);
    }

    // -------------------------
    // Recursive Inorder
    // LEFT → ROOT → RIGHT
    // -------------------------
    static void inorderRecursive(Node root) {

        if (root == null) {
            return;
        }

        inorderRecursive(root.left);

        System.out.print(root.data + " ");

        inorderRecursive(root.right);
    }

    // -------------------------
    // Recursive Postorder
    // LEFT → RIGHT → ROOT
    // -------------------------
    static void postorderRecursive(Node root) {

        if (root == null) {
            return;
        }

        postorderRecursive(root.left);

        postorderRecursive(root.right);

        System.out.print(root.data + " ");
    }

    // -------------------------
    // Iterative Preorder
    // -------------------------
    static void preorderIterative(Node root) {

        if (root == null) {
            return;
        }

        Stack<Node> stack = new Stack<>();

        stack.push(root);

        while (!stack.isEmpty()) {

            Node current = stack.pop();

            System.out.print(current.data + " ");

            if (current.right != null) {
                stack.push(current.right);
            }

            if (current.left != null) {
                stack.push(current.left);
            }
        }
    }

    // -------------------------
    // Iterative Inorder
    // -------------------------
    static void inorderIterative(Node root) {

        Stack<Node> stack = new Stack<>();

        Node current = root;

        while (current != null || !stack.isEmpty()) {

            while (current != null) {

                stack.push(current);

                current = current.left;
            }

            current = stack.pop();

            System.out.print(current.data + " ");

            current = current.right;
        }
    }

    // -------------------------
    // Iterative Postorder
    // -------------------------
    static void postorderIterative(Node root) {

        if (root == null) {
            return;
        }

        Stack<Node> stack1 = new Stack<>();
        Stack<Node> stack2 = new Stack<>();

        stack1.push(root);

        while (!stack1.isEmpty()) {

            Node current = stack1.pop();

            stack2.push(current);

            if (current.left != null) {
                stack1.push(current.left);
            }

            if (current.right != null) {
                stack1.push(current.right);
            }
        }

        while (!stack2.isEmpty()) {

            System.out.print(stack2.pop().data + " ");
        }
    }

    public static void main(String[] args) {

        /*
                 1
               /   \
              2     3
             / \   / \
            4   5 6   7
        */

        Node root = new Node(1);

        root.left = new Node(2);
        root.right = new Node(3);

        root.left.left = new Node(4);
        root.left.right = new Node(5);

        root.right.left = new Node(6);
        root.right.right = new Node(7);

        System.out.println("Recursive Preorder:");
        preorderRecursive(root);

        System.out.println();

        System.out.println("Recursive Inorder:");
        inorderRecursive(root);

        System.out.println();

        System.out.println("Recursive Postorder:");
        postorderRecursive(root);

        System.out.println();

        System.out.println();

        System.out.println("Iterative Preorder:");
        preorderIterative(root);

        System.out.println();

        System.out.println("Iterative Inorder:");
        inorderIterative(root);

        System.out.println();

        System.out.println("Iterative Postorder:");
        postorderIterative(root);
    }
}
