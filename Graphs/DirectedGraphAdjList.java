import java.util.*;

class DirectedGraphAdjList {
    // Map to store adjacency list where each vertex maps to a list of connected vertices
    private Map<Integer, List<Integer>> adjList;

    public DirectedGraphAdjList() {
        // Initialize the adjacency list as an empty HashMap
        adjList = new HashMap<>();
    }

    // Method to add a vertex to the graph
    public void addVertex(int vertex) {
        // Add a vertex with an empty list of edges if it doesn't already exist
        adjList.putIfAbsent(vertex, new ArrayList<>());
    }

    // Method to add a directed edge from source to destination
    public void addEdge(int source, int destination) {
        adjList.get(source).add(destination); // Add destination to the source's adjacency list
    }

    // Method to print the adjacency list
    public void printGraph() {
        for (var entry : adjList.entrySet()) {
            // Print each vertex and its corresponding list of neighbors
            System.out.println(entry.getKey() + " -> " + entry.getValue());
        }
    }
}
