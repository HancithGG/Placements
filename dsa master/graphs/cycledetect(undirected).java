import java.util.*;

public class CycleDetection {

    static boolean dfs(
            ArrayList<ArrayList<Integer>> graph,
            int current,
            int parent,
            boolean[] visited) {

        visited[current] = true;

        for (int neighbor : graph.get(current)) {

            // If neighbor is not visited,
            // continue DFS
            if (!visited[neighbor]) {

                if (dfs(graph, neighbor, current, visited)) {
                    return true;
                }

            }
            // Already visited and not our parent
            else if (neighbor != parent) {

                return true;
            }
        }

        return false;
    }

    static boolean hasCycle(
            ArrayList<ArrayList<Integer>> graph) {

        int n = graph.size();

        boolean[] visited = new boolean[n];

        // Handles disconnected graphs
        for (int i = 0; i < n; i++) {

            if (!visited[i]) {

                if (dfs(graph, i, -1, visited)) {
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

        for (int i = 0; i < n; i++) {
            graph.add(new ArrayList<>());
        }

        // 0 -- 1
        graph.get(0).add(1);
        graph.get(1).add(0);

        // 1 -- 2
        graph.get(1).add(2);
        graph.get(2).add(1);

        // 2 -- 0  → creates cycle
        graph.get(2).add(0);
        graph.get(0).add(2);

        // 2 -- 3
        graph.get(2).add(3);
        graph.get(3).add(2);

        if (hasCycle(graph)) {
            System.out.println("Cycle exists");
        } else {
            System.out.println("No cycle");
        }
    }
}
