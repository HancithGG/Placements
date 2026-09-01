def dfs(graph, node, parent, visited):
    visited.add(node)

    for neighbour in graph.get(node, []):
        if neighbour not in visited:
            if(dfs(graph, neighbour, node, visited)):
                return True

        elif neighbour != parent:
            return True
        
    return False

def cycle(graph):
    visited = set()

    for node in graph:
        if node not in visited:
            if(dfs(graph, node, -1, visited)):
                print(True)
                return

    print(False)
    return
            

graph = {
    0: [1],
    1: [0],
    2: [3],
    3: [2],
    4: []
}



cycle(graph)
