 /*
                 1
               /   \
              2     3
             / \   / \
            4   5 6   7
        */

class Node:
    def __init__(self, value):
        self.value = value
        self.left = None
        self.right = None


def preorder_iterative(root):
    if root is None:
        return

    stack = [root]

    while stack:
        current = stack.pop()

        print(current.value, end=" ")

        if current.right is not None:
            stack.append(current.right)

        if current.left is not None:
            stack.append(current.left)


def inorder_iterative(root):
    stack = []
    current = root

    while current is not None or stack:

        while current is not None:
            stack.append(current)
            current = current.left

        current = stack.pop()
        print(current.value, end=" ")

        current = current.right


def postorder_iterative(root):
    if root is None:
        return

    stack1 = [root]
    stack2 = []

    while stack1:
        current = stack1.pop()
        stack2.append(current)

        if current.left is not None:
            stack1.append(current.left)

        if current.right is not None:
            stack1.append(current.right)

    while stack2:
        current = stack2.pop()
        print(current.value, end=" ")
        
#---------------------
# recursive 
#--------------

def preorder(root):
    if root is None:
        return

    print(root.value, end=" ")
    preorder(root.left)
    preorder(root.right)


def inorder(root):
    if root is None:
        return

    inorder(root.left)
    print(root.value, end=" ")
    inorder(root.right)


def postorder(root):
    if root is None:
        return

    postorder(root.left)
    postorder(root.right)
    print(root.value, end=" ")

def main():
    root = Node(1)

    root.left = Node(2)
    root.right = Node(3)

    root.left.left = Node(4)
    root.left.right = Node(5)

    root.right.left = Node(6)
    root.right.right = Node(7)

    print("Preorder:")
    preorder_iterative(root)

    print("\nInorder:")
    inorder_iterative(root)

    print("\nPostorder:")
    postorder_iterative(root)


main()
