from collections import deque


def bfs(graph, start):

    visited = set()
    queue = deque([start])

    visited.add(start)

    while queue:

        current = queue.popleft()

        print(current, end=" ")

        for neighbor in graph[current]:

            if neighbor not in visited:
                visited.add(neighbor)
                queue.append(neighbor)


def main():

    graph = {
        0: [1, 2],
        1: [0, 3],
        2: [0, 4],
        3: [1],
        4: [2]
    }

    bfs(graph, 0)


main()
