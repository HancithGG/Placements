import java.util.*;

public class DijkstraExample {

    // Edge class
    static class Edge {

        int destination;
        int weight;

        Edge(int destination, int weight) {
            this.destination = destination;
            this.weight = weight;
        }
    }

    // Dijkstra Function
    public static void dijkstra(ArrayList<ArrayList<Edge>> graph, int source) {

        int vertices = graph.size();

        int[] distance = new int[vertices];

        Arrays.fill(distance, Integer.MAX_VALUE);

        distance[source] = 0;

        PriorityQueue<Edge> pq =
                new PriorityQueue<>((a, b) -> a.weight - b.weight);

        pq.offer(new Edge(source, 0));

        while (!pq.isEmpty()) {

            Edge current = pq.poll();

            int currentNode = current.destination;

            int currentDistance = current.weight;

            // Ignore outdated entries
            if (currentDistance > distance[currentNode]) {
                continue;
            }

            for (Edge neighbor : graph.get(currentNode)) {

                int newDistance =
                        currentDistance + neighbor.weight;

                if (newDistance < distance[neighbor.destination]) {

                    distance[neighbor.destination] = newDistance;

                    pq.offer(new Edge(neighbor.destination,
                                      newDistance));
                }
            }
        }

        System.out.println("Shortest Distance from Node " + source);

        for (int i = 0; i < vertices; i++) {

            System.out.println(
                    source + " -> " + i + " = " + distance[i]);
        }
    }

    public static void main(String[] args) {

        int vertices = 4;

        ArrayList<ArrayList<Edge>> graph =
                new ArrayList<>();

        for (int i = 0; i < vertices; i++) {

            graph.add(new ArrayList<>());
        }

        // Undirected Graph

        graph.get(0).add(new Edge(1, 4));
        graph.get(1).add(new Edge(0, 4));

        graph.get(0).add(new Edge(2, 1));
        graph.get(2).add(new Edge(0, 1));

        graph.get(1).add(new Edge(3, 2));
        graph.get(3).add(new Edge(1, 2));

        graph.get(2).add(new Edge(3, 5));
        graph.get(3).add(new Edge(2, 5));

        dijkstra(graph, 0);
    }
}
