import java.util.*;

public class KruskalAlgorithm {

    // Class to represent an edge in the graph, containing two nodes and a weight.
    static class Edge implements Comparable<Edge> {
        String node1, node2;
        int weight;

        Edge(String node1, String node2, int weight) {
            this.node1 = node1;
            this.node2 = node2;
            this.weight = weight;
        }

        // Override compareTo to allow sorting edges by weight in ascending order.
        @Override
        public int compareTo(Edge other) {
            return Integer.compare(this.weight, other.weight);
        }
    }

    // Union-Find structure to manage connected components.
    static class UnionFind {
        private Map<String, String> parent = new HashMap<>(); // Parent map for each node.
        private Map<String, Integer> rank = new HashMap<>();  // Rank map to optimize unions.

        // Initialize each node as its own parent (disjoint set).
        public void makeSet(String node) {
            parent.put(node, node);  // Initially, a node is its own parent.
            rank.put(node, 0);      // Rank starts at 0 for all nodes.
        }

        // Find the root of the set containing the node, with path compression.
        public String find(String node) {
            if (!parent.get(node).equals(node)) {
                parent.put(node, find(parent.get(node))); // Recursively find root and compress path.
            }
            return parent.get(node);
        }

        // Union two sets, based on rank to keep the tree balanced.
        public void union(String node1, String node2) {
            String root1 = find(node1); // Find root of the first node.
            String root2 = find(node2); // Find root of the second node.

            if (!root1.equals(root2)) { // Only union if they are in different sets.
                if (rank.get(root1) > rank.get(root2)) {
                    parent.put(root2, root1); // Attach smaller tree under larger tree.
                } else if (rank.get(root1) < rank.get(root2)) {
                    parent.put(root1, root2);
                } else {
                    parent.put(root2, root1); // If ranks are equal, choose one as root.
                    rank.put(root1, rank.get(root1) + 1); // Increase rank of the new root.
                }
            }
        }
    }

    public static List<Edge> kruskal(List<Edge> edges, List<String> nodes) {
        // Initialize Union-Find structure for all nodes.
        UnionFind uf = new UnionFind();
        for (String node : nodes) {
            uf.makeSet(node); // Create a set for each node.
        }

        // Sort all edges by weight in ascending order.
        Collections.sort(edges);

        List<Edge> mst = new ArrayList<>(); // List to store edges of the MST.
        int totalWeight = 0; // Keep track of the total weight of the MST.

        // Iterate over sorted edges.
        for (Edge edge : edges) {
            // Check if the current edge forms a cycle using Union-Find.
            if (!uf.find(edge.node1).equals(uf.find(edge.node2))) {
                mst.add(edge); // Add edge to the MST.
                totalWeight += edge.weight; // Add its weight to the total.
                uf.union(edge.node1, edge.node2); // Union the two sets.
            }
        }

        // Output total weight for verification.
        System.out.println("Total Weight of MST: " + totalWeight);
        return mst; // Return the edges in the MST.
    }

    public static void main(String[] args) {
        // Define the graph as a list of edges.
        List<Edge> edges = Arrays.asList(
            new Edge("A", "B", 1),
            new Edge("A", "C", 5),
            new Edge("B", "C", 4),
            new Edge("B", "D", 2),
            new Edge("C", "D", 6),
            new Edge("D", "E", 3)
        );

        // List of all nodes in the graph.
        List<String> nodes = Arrays.asList("A", "B", "C", "D", "E");

        // Call Kruskal's algorithm and get the MST.
        List<Edge> mst = kruskal(edges, nodes);

        // Print the MST edges.
        System.out.println("Kruskal's MST:");
        for (Edge edge : mst) {
            System.out.println(edge.node1 + " - " + edge.node2 + " (" + edge.weight + ")");
        }
    }
}
