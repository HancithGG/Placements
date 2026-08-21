import heapq

def dijkstra(graph, start):
    # graph: adjacency list {node: [(neighbor, weight), ...]}
    # start: source node
    # returns: shortest distance dict

    # Initialize distances
    dist = {node: float('inf') for node in graph}
    dist[start] = 0

    # Min-heap priority queue
    pq = [(0, start)]  # (distance, node)

    while pq:
        current_dist, current_node = heapq.heappop(pq)

        # Skip if we already found a better path
        if current_dist > dist[current_node]:
            continue

        # Relax edges
        for neighbor, weight in graph[current_node]:
            if current_dist + weight < dist[neighbor]:
                dist[neighbor] = current_dist + weight
                heapq.heappush(pq, (dist[neighbor], neighbor))

    return dist


# Example usage
graph = {
    0: [(1, 4), (2, 1)],
    1: [(3, 1)],
    2: [(1, 2), (3, 5)],
    3: []
}

print(dijkstra(graph, 0))
# → {0: 0, 1: 3, 2: 1, 3: 4}


print(dijkstra(graph, 0))
# → {0: 0, 1: 3, 2: 1, 3: 4}
