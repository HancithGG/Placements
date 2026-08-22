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

