// Class for the Ford-Fulkerson algorithm
class FordFulkerson {
    // Helper method to perform Depth-First Search (DFS) to find a path from source to sink
    private boolean dfs(int[][] residualGraph, int source, int sink, boolean[] visited, int[] parent) {
        if (source == sink) return true;

        visited[source] = true;

        for (int v = 0; v < residualGraph.length; v++) {
            if (!visited[v] && residualGraph[source][v] > 0) {
                parent[v] = source;
                if (dfs(residualGraph, v, sink, visited, parent)) {
                    return true;
                }
            }
        }

        return false;
    }

    // Implementation of the Ford-Fulkerson algorithm
    public int maxFlow(int[][] capacity, int source, int sink) {
        int n = capacity.length;
        int[][] residualGraph = new int[n][n];

        // Initialize residual graph with given capacities
        for (int u = 0; u < n; u++) {
            for (int v = 0; v < n; v++) {
                residualGraph[u][v] = capacity[u][v];
            }
        }

        int maxFlow = 0;
        int[] parent = new int[n]; // Array to store the path

        // Augment the flow while there is a path from source to sink
        boolean[] visited = new boolean[n];
        while (dfs(residualGraph, source, sink, visited, parent)) {
            // Find the minimum residual capacity in the path found by DFS
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

            // Reset visited array for the next iteration
            visited = new boolean[n];
        }

        return maxFlow;
    }
}



public class MaxFlowAlgorithmsDemo {
    public static void main(String[] args) {

        System.out.println("\nFord-Fulkerson Example:");
        int[][] capacityFordFulkerson = {
            {0, 16, 13, 0, 0, 0},
            {0, 0, 10, 12, 0, 0},
            {0, 4, 0, 0, 14, 0},
            {0, 0, 9, 0, 0, 20},
            {0, 0, 0, 7, 0, 4},
            {0, 0, 0, 0, 0, 0}
        };
        int sourceFordFulkerson = 0;
        int sinkFordFulkerson = 5;

        FordFulkerson ff = new FordFulkerson();
        System.out.println("Maximum Flow using Ford-Fulkerson: " + ff.maxFlow(capacityFordFulkerson, sourceFordFulkerson, sinkFordFulkerson));
    }
}


