import java.util.*;

public class DFSExample {

    static void dfs(ArrayList<ArrayList<Integer>> graph,
                    int current,
                    boolean[] visited) {

        visited[current] = true;

        System.out.print(current + " ");

        for (int neighbor : graph.get(current)) {

            if (!visited[neighbor]) {

                dfs(graph, neighbor, visited);
            }
        }
    }

    public static void main(String[] args) {

        int vertices = 5;

        ArrayList<ArrayList<Integer>> graph =
                new ArrayList<>();

        for (int i = 0; i < vertices; i++) {

            graph.add(new ArrayList<>());
        }

        graph.get(0).add(1);
        graph.get(1).add(0);

        graph.get(0).add(2);
        graph.get(2).add(0);

        graph.get(1).add(3);
        graph.get(3).add(1);

        graph.get(2).add(4);
        graph.get(4).add(2);

        boolean[] visited =
                new boolean[vertices];

        dfs(graph, 0, visited);
    }
}


// iterative dfs same as preorder in tree traversal

static void dfsIterative(ArrayList<ArrayList<Integer>> graph, int start){
        boolean[] visited = new boolean[graph.size()];
        Stack<Integer> stack = new Stack<>();
        visited[start] = true;
        stack.push(start);

        while (!stack.isEmpty()) {
            int current = stack.pop();
            System.out.print(current + " ");

            for(int i=graph.get(current).size() - 1; i>=0; i--){
                int neighbour = graph.get(current).get(i);

                if(!visited[neighbour]){
                    visited[neighbour] = true;
                    stack.push(neighbour);
                }
            }
        }
    }

// in main method call
dfs(graph,0);
