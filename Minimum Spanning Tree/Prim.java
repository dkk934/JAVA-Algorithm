import java.util.*;

public class PrimAlgorithm {

    // Class to represent an edge in the graph, containing two nodes and a weight.
    static class Edge {
        String node1, node2;
        int weight;

        Edge(String node1, String node2, int weight) {
            this.node1 = node1;
            this.node2 = node2;
            this.weight = weight;
        }
    }

    public static List<Edge> prim(Map<String, List<Edge>> graph, String start) {
        // PriorityQueue to store edges by their weight (min-heap).
        PriorityQueue<Edge> pq = new PriorityQueue<>(Comparator.comparingInt(edge -> edge.weight));

        // Set to track visited nodes.
        Set<String> visited = new HashSet<>();
        visited.add(start); // Mark the start node as visited.

        // Add all edges of the start node to the priority queue.
        pq.addAll(graph.get(start));

        List<Edge> mst = new ArrayList<>(); // List to store edges of the MST.
        int totalWeight = 0; // Variable to store the total weight of the MST.

        // While there are edges in the priority queue.
        while (!pq.isEmpty()) {
            Edge edge = pq.poll(); // Get the edge with the smallest weight.

            // Check if the edge connects to an unvisited node.
            if (!visited.contains(edge.node2)) {
                visited.add(edge.node2); // Mark the node as visited.
                mst.add(edge); // Add the edge to the MST.
                totalWeight += edge.weight; // Add the weight to the total.

                // Add all edges of the newly visited node to the priority queue.
                for (Edge nextEdge : graph.get(edge.node2)) {
                    if (!visited.contains(nextEdge.node2)) { // Avoid revisiting nodes.
                        pq.add(nextEdge);
                    }
                }
            }
        }

        // Output total weight for verification.
        System.out.println("Total Weight of MST: " + totalWeight);
        return mst; // Return the edges in the MST.
    }

    public static void main(String[] args) {
        // Define the graph as an adjacency list.
        Map<String, List<Edge>> graph = new HashMap<>();
        graph.put("A", Arrays.asList(new Edge("A", "B", 1), new Edge("A", "C", 5)));
        graph.put("B", Arrays.asList(new Edge("B", "A", 1), new Edge("B", "C", 4), new Edge("B", "D", 2)));
        graph.put("C", Arrays.asList(new Edge("C", "A", 5), new Edge("C", "B", 4), new Edge("C", "D", 6)));
        graph.put("D", Arrays.asList(new Edge("D", "B", 2), new Edge("D", "C", 6), new Edge("D", "E", 3)));
        graph.put("E", Arrays.asList(new Edge("E", "D", 3)));

        // Call Prim's algorithm and get the MST starting from node "A".
        List<Edge> mst = prim(graph, "A");

        // Print the MST edges.
        System.out.println("Prim's MST:");
        for (Edge edge : mst) {
            System.out.println(edge.node1 + " - " + edge.node2 + " (" + edge.weight + ")");
        }
    }
}
