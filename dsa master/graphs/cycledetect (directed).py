def dfs(graph, current, visited, in_path):

    visited.add(current)
    in_path.add(current)

    for neighbor in graph[current]:

        # Not visited → explore
        if neighbor not in visited:

            if dfs(graph, neighbor, visited, in_path):
                return True

        # Already in current DFS path → cycle
        elif neighbor in in_path:
            return True

    # Backtracking
    in_path.remove(current)

    return False


def has_cycle(graph):

    visited = set()
    in_path = set()

    for node in graph:

        if node not in visited:

            if dfs(graph, node, visited, in_path):
                return True

    return False


def main():

    graph = {
        0: [1],
        1: [2],
        2: [3],
        3: [2]
    }

    if has_cycle(graph):
        print("Cycle exists")
    else:
        print("No cycle")


main()
