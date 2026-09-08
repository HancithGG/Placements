class Node:
    def __init__(self, value):
        self.value = value
        self.next = None


def has_cycle(head):
    slow = head
    fast = head

    while fast is not None and fast.next is not None:

        slow = slow.next
        fast = fast.next.next

        if slow == fast:
            return True

    return False


def main():
    # Create nodes
    first = Node(10)
    second = Node(20)
    third = Node(30)
    fourth = Node(40)

    # Connect nodes
    first.next = second
    second.next = third
    third.next = fourth

    # Create a cycle:
    # 40 → 20
    fourth.next = second

    head = first

    if has_cycle(head):
        print("Cycle exists")
    else:
        print("No cycle")


main()
