import java.util.*;

public class DirectedCycleDetection {

    // DFS function
    static boolean dfs(
            ArrayList<ArrayList<Integer>> graph,
            int current,
            boolean[] visited,
            boolean[] inPath) {

        // Mark current node as visited
        visited[current] = true;

        // Mark current node as part of current DFS path
        inPath[current] = true;

        // Visit all neighbors
        for (int neighbor : graph.get(current)) {

            // If neighbor has not been visited
            if (!visited[neighbor]) {

                if (dfs(graph, neighbor, visited, inPath)) {
                    return true;
                }

            }

            // If neighbor is already in current DFS path
            else if (inPath[neighbor]) {

                return true;
            }
        }

        // Backtrack:
        // current node is no longer in the current DFS path
        inPath[current] = false;

        return false;
    }

    // Function to check the entire graph
    static boolean hasCycle(
            ArrayList<ArrayList<Integer>> graph) {

        int n = graph.size();

        boolean[] visited = new boolean[n];
        boolean[] inPath = new boolean[n];

        // Important: handles disconnected graphs
        for (int i = 0; i < n; i++) {

            if (!visited[i]) {

                if (dfs(graph, i, visited, inPath)) {
                    return true;
                }
            }
        }

        return false;
    }

    public static void main(String[] args) {

        int n = 4;

        ArrayList<ArrayList<Integer>> graph =
                new ArrayList<>();

        // Create empty list for every vertex
        for (int i = 0; i < n; i++) {
            graph.add(new ArrayList<>());
        }

        /*
                0
                ↓
                1
                ↓
                2
               ↙
              3

            1 → 2 → 3
                ↑   ↓
                └───┘

            Cycle: 2 → 3 → 2
        */

        // 0 → 1
        graph.get(0).add(1);

        // 1 → 2
        graph.get(1).add(2);

        // 2 → 3
        graph.get(2).add(3);

        // 3 → 2
        graph.get(3).add(2);

        // Check for cycle
        if (hasCycle(graph)) {
            System.out.println("Cycle exists");
        } else {
            System.out.println("No cycle");
        }
    }
}
