class Node:

    def __init__(self, data):
        self.data = data
        self.next = None


def travesal(head):
    current = head

    while current is not None:
        print(current.data, end=" ")
        current = current.next

def main():
    first = Node(10)
    second = Node(20)
    third = Node(30)

    first.next = second
    second.next = third

    head = first

    travesal(head)
    
main()
