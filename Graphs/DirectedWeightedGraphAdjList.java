import java.util.*;

class DirectedWeightedGraphAdjList {
    // Map to store adjacency list where each vertex maps to a list of destination and weight
    private Map<Integer, List<int[]>> adjList;

    public DirectedWeightedGraphAdjList() {
        // Initialize the adjacency list as an empty HashMap
        adjList = new HashMap<>();
    }

    // Method to add a vertex to the graph
    public void addVertex(int vertex) {
        adjList.putIfAbsent(vertex, new ArrayList<>()); // Add vertex with an empty edge list
    }

    // Method to add a weighted edge from source to destination
    public void addEdge(int source, int destination, int weight) {
        adjList.get(source).add(new int[]{destination, weight}); // Add destination and weight as an array
    }

    // Method to print the adjacency list
    public void printGraph() {
        for (var entry : adjList.entrySet()) {
            System.out.print(entry.getKey() + " -> ");
            for (var edge : entry.getValue()) {
                // Print each destination and its weight
                System.out.print("[" + edge[0] + ", " + edge[1] + "] ");
            }
            System.out.println();
        }
    }
}
