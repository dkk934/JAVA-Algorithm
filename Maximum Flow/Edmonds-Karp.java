import java.util.LinkedList;
import java.util.Queue;

// Class for the Edmonds-Karp algorithm
class EdmondsKarp {
    // Helper method to perform Breadth-First Search (BFS) to find a path from source to sink
    private boolean bfs(int[][] residualGraph, int source, int sink, int[] parent) {
        int n = residualGraph.length;
        boolean[] visited = new boolean[n]; // Array to track visited nodes
        Queue<Integer> queue = new LinkedList<>(); // Queue for BFS
        
        queue.add(source);
        visited[source] = true;
        parent[source] = -1; // Source has no parent

        while (!queue.isEmpty()) {
            int u = queue.poll();

            for (int v = 0; v < n; v++) {
                // Check if v is reachable from u and not yet visited
                if (!visited[v] && residualGraph[u][v] > 0) {
                    queue.add(v);
                    parent[v] = u; // Track the path
                    visited[v] = true;

                    // If we reach the sink, return true
                    if (v == sink) {
                        return true;
                    }
                }
            }
        }
        return false; // No path found
    }

    // Implementation of the Edmonds-Karp algorithm
    public int maxFlow(int[][] capacity, int source, int sink) {
        int n = capacity.length;
        int[][] residualGraph = new int[n][n]; // Residual graph to track capacities
        
        // Initialize residual graph with given capacities
        for (int u = 0; u < n; u++) {
            for (int v = 0; v < n; v++) {
                residualGraph[u][v] = capacity[u][v];
            }
        }

        int maxFlow = 0; // Initialize maximum flow
        int[] parent = new int[n]; // Array to store the path

        // Augment the flow while there is a path from source to sink
        while (bfs(residualGraph, source, sink, parent)) {
            // Find the minimum residual capacity in the path found by BFS
            int pathFlow = Integer.MAX_VALUE;
            for (int v = sink; v != source; v = parent[v]) {
                int u = parent[v];
                pathFlow = Math.min(pathFlow, residualGraph[u][v]);
            }

            // Update residual capacities along the path
            for (int v = sink; v != source; v = parent[v]) {
                int u = parent[v];
                residualGraph[u][v] -= pathFlow;
                residualGraph[v][u] += pathFlow;
            }

            maxFlow += pathFlow; // Add path flow to overall flow
        }

        return maxFlow;
    }
}


public class MaxFlowAlgorithmsDemo {
    public static void main(String[] args) {
        System.out.println("Edmonds-Karp Example:");
        int[][] capacityEdmondsKarp = {
            {0, 16, 13, 0, 0, 0},
            {0, 0, 10, 12, 0, 0},
            {0, 4, 0, 0, 14, 0},
            {0, 0, 9, 0, 0, 20},
            {0, 0, 0, 7, 0, 4},
            {0, 0, 0, 0, 0, 0}
        };
        int sourceEdmondsKarp = 0;
        int sinkEdmondsKarp = 5;

        EdmondsKarp ek = new EdmondsKarp();
        System.out.println("Maximum Flow using Edmonds-Karp: " + ek.maxFlow(capacityEdmondsKarp, sourceEdmondsKarp, sinkEdmondsKarp));

     }
}
