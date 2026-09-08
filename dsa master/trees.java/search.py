

      /*
                 50
               /    \
             30      70
            / \     / \
          20 40   60 80
        */

class Node:
    def __init__(self, value):
        self.value = value
        self.left = None
        self.right = None


def search_bst(root, value):
    current = root

    while current is not None:

        if value == current.value:
            return True

        elif value < current.value:
            current = current.left

        else:
            current = current.right

    return False
      
      #----------------
      # recursive 

def main():
    # Create BST
    root = Node(50)

    root.left = Node(30)
    root.right = Node(70)

    root.left.left = Node(20)
    root.left.right = Node(40)

    root.right.left = Node(60)
    root.right.right = Node(80)

    # Search
    value = 60

    if search_bst(root, value):
        print(value, "found")
    else:
        print(value, "not found")


main()
        
