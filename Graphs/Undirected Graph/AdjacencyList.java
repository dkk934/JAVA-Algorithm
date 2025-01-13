import java.util.*;

class UndirectedGraphAdjList {
    // Map to store adjacency list where each vertex maps to a list of connected vertices
    private Map<Integer, List<Integer>> adjList;

    public UndirectedGraphAdjList() {
        // Initialize the adjacency list as an empty HashMap
        adjList = new HashMap<>();
    }

    // Method to add a vertex to the graph
    public void addVertex(int vertex) {
        adjList.putIfAbsent(vertex, new ArrayList<>()); // Add vertex with an empty edge list
    }

    // Method to add an undirected edge between source and destination
    public void addEdge(int source, int destination) {
        adjList.get(source).add(destination); // Add destination to source's adjacency list
        adjList.get(destination).add(source); // Add source to destination's adjacency list
    }

    // Method to print the adjacency list
    public void printGraph() {
        for (var entry : adjList.entrySet()) {
            System.out.println(entry.getKey() + " -> " + entry.getValue()); // Print each vertex and its neighbors
        }
    }
}
