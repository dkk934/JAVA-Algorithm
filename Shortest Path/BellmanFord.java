import java.util.*;

public class BellmanFord {

    /**
     * Implements the Bellman-Ford algorithm to find the shortest paths
     * from a start node to all other nodes in a graph.
     *
     * @param graph A map representing the graph as an adjacency list.
     *              Keys are nodes, and values are lists of pairs (neighbor, weight).
     * @param start The starting node for the algorithm.
     * @return A pair containing a map of shortest distances and a boolean indicating
     * if a negative cycle exists.
     */
    public static Pair<Map<String, Integer>, Boolean> bellmanFord(Map<String, List<Edge>> graph, String start) {
        // Initialize distances from the start node to all other nodes as infinity.
        Map<String, Integer> distances = new HashMap<>();
        for (String node : graph.keySet()) {
            distances.put(node, Integer.MAX_VALUE);
        }
        distances.put(start, 0); // Distance to the start node is 0.

        // Number of nodes in the graph.
        int numNodes = graph.size();

        // Relax edges up to (numNodes - 1) times.
        for (int i = 0; i < numNodes - 1; i++) {
            for (String node : graph.keySet()) {
                for (Edge edge : graph.get(node)) {
                    // Relax the edge if a shorter path is found.
                    if (distances.get(node) != Integer.MAX_VALUE &&
                        distances.get(node) + edge.weight < distances.get(edge.neighbor)) {
                        distances.put(edge.neighbor, distances.get(node) + edge.weight);
                    }
                }
            }
        }

        // Check for negative-weight cycles.
        for (String node : graph.keySet()) {
            for (Edge edge : graph.get(node)) {
                if (distances.get(node) != Integer.MAX_VALUE &&
                    distances.get(node) + edge.weight < distances.get(edge.neighbor)) {
                    return new Pair<>(distances, true); // Negative cycle detected.
                }
            }
        }

        return new Pair<>(distances, false); // No negative cycle detected.
    }

    public static void main(String[] args) {
        // Graph represented as an adjacency list.
        Map<String, List<Edge>> graph = new HashMap<>();
        graph.put("A", Arrays.asList(new Edge("B", 1), new Edge("C", 4)));
        graph.put("B", Arrays.asList(new Edge("C", -3), new Edge("D", 2)));
        graph.put("C", Arrays.asList(new Edge("D", 3)));
        graph.put("D", new ArrayList<>());

        // Find the shortest paths from node 'A'.
        String startNode = "A";
        Pair<Map<String, Integer>, Boolean> result = bellmanFord(graph, startNode);

        Map<String, Integer> shortestDistances = result.first;
        boolean hasNegativeCycle = result.second;

        if (hasNegativeCycle) {
            System.out.println("The graph contains a negative-weight cycle.");
        } else {
            System.out.println("Shortest distances from node " + startNode + ": " + shortestDistances);
        }
    }

    // Helper class to represent an edge with a neighbor and weight.
    static class Edge {
        String neighbor;
        int weight;

        Edge(String neighbor, int weight) {
            this.neighbor = neighbor;
            this.weight = weight;
        }
    }

    // Helper class to return a pair of values.
    static class Pair<F, S> {
        F first;
        S second;

        Pair(F first, S second) {
            this.first = first;
            this.second = second;
        }
    }
}
