import java.util.*;

public class UndirectedGraphCycleDetection {
    private int vertices;
    private LinkedList<Integer>[] adjacencyList;

    // Constructor
    public UndirectedGraphCycleDetection(int vertices) {
        this.vertices = vertices;
        adjacencyList = new LinkedList[vertices];
        for (int i = 0; i < vertices; i++) {
            adjacencyList[i] = new LinkedList<>();
        }
    }

    // Add an edge to the graph
    public void addEdge(int source, int destination) {
        adjacencyList[source].add(destination);
        adjacencyList[destination].add(source);
    }

    // Detect cycle using DFS
    public boolean hasCycle() {
        boolean[] visited = new boolean[vertices];
        for (int i = 0; i < vertices; i++) {
            if (!visited[i]) {
                if (dfs(i, visited, -1)) {
                    return true;
                }
            }
        }
        return false;
    }

    // DFS to detect a cycle
    private boolean dfs(int current, boolean[] visited, int parent) {
        visited[current] = true;

        for (int neighbor : adjacencyList[current]) {
            // If neighbor is not visited, recurse
            if (!visited[neighbor]) {
                if (dfs(neighbor, visited, current)) {
                    return true;
                }
            }
            // If visited and not parent, a cycle is found
            else if (neighbor != parent) {
                return true;
            }
        }
        return false;
    }

    // Main method to test the implementation
    public static void execute() {
        UndirectedGraphCycleDetection graph = new UndirectedGraphCycleDetection(5);

        // Add edges
        graph.addEdge(0, 1);
        graph.addEdge(1, 2);
        graph.addEdge(2, 3);
        graph.addEdge(3, 0); // Adding this edge creates a cycle

        System.out.println("Does the graph contain a cycle? " + graph.hasCycle());
    }
}
