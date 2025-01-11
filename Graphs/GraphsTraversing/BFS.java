import java.util.*;

// Graph class to represent the graph structure
class Graph {
    private int vertices; // Number of vertices
    private LinkedList<Integer>[] adjacencyList; // Adjacency list

    // Constructor
    public Graph(int vertices) {
        this.vertices = vertices;
        adjacencyList = new LinkedList[vertices];
        for (int i = 0; i < vertices; i++) {
            adjacencyList[i] = new LinkedList<>();
        }
    }

    // Add an edge to the graph
    public void addEdge(int source, int destination) {
        adjacencyList[source].add(destination); // Add edge from source to destination
        adjacencyList[destination].add(source); // Add edge from destination to source (for undirected graph)
    }

    // Perform DFS starting from a given vertex
    public void dfs(int startVertex) {
        boolean[] visited = new boolean[vertices]; // Track visited nodes
        System.out.println("DFS starting from vertex " + startVertex + ":");
        dfsHelper(startVertex, visited); // Call the helper method for DFS
    }

    // Helper method for recursive DFS
    private void dfsHelper(int vertex, boolean[] visited) {
        visited[vertex] = true; // Mark the current node as visited
        System.out.print(vertex + " "); // Print the current node

        // Recursively visit all adjacent nodes
        for (int adjacent : adjacencyList[vertex]) {
            if (!visited[adjacent]) { // Check if the adjacent node is not visited
                dfsHelper(adjacent, visited);
            }
        }
    }

    // Main method to test the DFS implementation
    public static void main(String[] args) {
        Graph graph = new Graph(6); // Create a graph with 6 vertices (0 to 5)

        // Add edges to the graph
        graph.addEdge(0, 1);
        graph.addEdge(0, 2);
        graph.addEdge(1, 3);
        graph.addEdge(1, 4);
        graph.addEdge(2, 5);

        // Perform DFS starting from vertex 0
        graph.dfs(0);
    }
}
