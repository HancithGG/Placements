class Node:
    def __init__(self, data):
        self.data = data
        self.next = None


# ---------------- INSERTION ----------------

def insert_beginning(head, data):
    new_node = Node(data)

    new_node.next = head
    head = new_node

    return head


def insert_end(head, data):
    new_node = Node(data)

    if head is None:
        return new_node

    current = head

    while current.next is not None:
        current = current.next

    current.next = new_node

    return head


def insert_at_position(head, data, position):
    if position == 0:
        return insert_beginning(head, data)

    new_node = Node(data)

    current = head

    for _ in range(position - 1):
        if current is None:
            return head

        current = current.next

    if current is None:
        return head

    new_node.next = current.next
    current.next = new_node

    return head


# ---------------- DELETION ----------------

def delete_beginning(head):
    if head is None:
        return None

    return head.next


def delete_end(head):
    if head is None:
        return None

    # Only one node
    if head.next is None:
        return None

    current = head

    # Reach second-last node
    while current.next.next is not None:
        current = current.next

    current.next = None

    return head


def delete_at_position(head, position):
    if head is None:
        return None

    # Delete first node
    if position == 0:
        return head.next

    current = head

    # Reach node before the target
    for _ in range(position - 1):
        if current.next is None:
            return head

        current = current.next

    # Position doesn't exist
    if current.next is None:
        return head

    # Skip the target node
    current.next = current.next.next

    return head


# ---------------- TRAVERSAL ----------------

def traverse(head):
    current = head

    while current is not None:
        print(current.data, end=" → ")
        current = current.next

    print("None")


# ---------------- MAIN ----------------

def main():

    # Create linked list
    head = Node(10)
    head.next = Node(20)
    head.next.next = Node(30)

    print("Original list:")
    traverse(head)


    # Insert at beginning
    head = insert_beginning(head, 5)

    print("\nAfter inserting 5 at beginning:")
    traverse(head)


    # Insert at end
    head = insert_end(head, 40)

    print("\nAfter inserting 40 at end:")
    traverse(head)


    # Insert at position
    head = insert_at_position(head, 25, 3)

    print("\nAfter inserting 25 at position 3:")
    traverse(head)


    # Delete beginning
    head = delete_beginning(head)

    print("\nAfter deleting beginning:")
    traverse(head)


    # Delete end
    head = delete_end(head)

    print("\nAfter deleting end:")
    traverse(head)


    # Delete at position
    head = delete_at_position(head, 2)

    print("\nAfter deleting position 2:")
    traverse(head)


main()

        System.out.println("After Delete Position");
        list.printList();
    }
}
