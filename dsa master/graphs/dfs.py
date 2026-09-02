def dfs_recursive(graph, node, visited):
    
    
    visited.add(node)
    print(node, end=" ")

    for neighbour in graph.get(node, []):
        if neighbour not in visited:
            dfs_recursive(graph, neighbour, visited)

# Example usage
graph = {
    0: [1, 2],
    1: [0, 3],
    2: [0, 4],
    3: [1],
    4: [2]
}

print("DFS starting from node 0:")
visited = set()
dfs_recursive(graph, 0)

# dfs iterative
def dfs_iterative(graph, start):
    visited = set()
    stack = [start]

    while stack:
        node = stack.pop()                                                                  take this as input            0
        if node not in visited:                                                                                         1    2        cycle dfs
            visited.add(node)
            print(node, end=" ")
            # Add neighbors to stack
            # reversed() keeps traversal order similar to recursion
            for neighbour in reversed(graph.get(node, [])):
                if neighbour not in visited:
                    stack.append(neighbour)
                    
dfs_iterative(graph, 0)
