import heapq

def dijkstra(graph, start):
    # graph: adjacency list {u: [(v, weight), ...]}
    # start: source node
    # returns: shortest distance dict

    # Initialize distances
    dist = {node: float('inf') for node in graph}
    dist[start] = 0

    # Min-heap priority queue
    pq = [(start, 0)]  # (distance, node)

    while pq:
        u, current_dist = heapq.heappop(pq)

        # Skip if we already found a better path
        if current_dist > dist[u]:
            continue

        # Relax edges
        for v, weight in graph[u]:
            if dist[u] + weight < dist[v]:
                dist[v] = dist[u] + weight
                heapq.heappush(pq, (v, dist[v]))

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
