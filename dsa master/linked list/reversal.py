class Node:
    def __init__(self, data):
        self.data = data
        self.next = None

def reverse_Recursive(head):
    if head.next is None or head is None:
        return head

    newnode = reverse_Recursive(head.next)

    head.next.next = head
    head.next = None

    return newnode

def reverse_iterative(head):
    if head is None:
        return None

    previous = None
    current = head

    while current is not None:
        nextnode = current.next
        current.next = previous

        previous = current
        current = nextnode
    return previous

def traversal(head):
    current = head
    while current is not None:
        print(current.data, end="->")
        current = current.next

    

head = Node(10)
head.next = Node(20)
head.next.next = Node(3)

head = reverse_Recursive(head)
head = reverse_iterative(head)
traversal(head)
